package com.itschool.retrofitexample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.itschool.retrofitexample.Controllers.ShibeAPI;
import com.itschool.retrofitexample.Controllers.ShibeController;
import com.itschool.retrofitexample.Services.NetworkService;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements  IResourcePipe{
    Button butt,next;
    ImageView imageView;
    NetworkService networkService;
    String messag="", prev="";
    ShibeAPI shibeAPI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        butt = findViewById(R.id.button);
        imageView = findViewById(R.id.image);
        networkService = NetworkService.getInstance();
        shibeAPI = networkService.createShubyAPI();
        ShibeController shibeController = new ShibeController(this);
        Handler handler = new Handler() {
            @Override
            public void handleMessage(@NonNull Message msg) {
                String message = (String) msg.obj;

                Log.d("TAG", "Handler: " + messag);
            }
        };
        shibeController.setHandler(handler);
        Call call = shibeAPI.getUrlShibes();
        /*call.enqueue(shibeController);*/

        butt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (!messag.equals("") && !messag.equals(prev)) {
                    Toast.makeText(getApplicationContext(), "Сейчас загрузим", Toast.LENGTH_SHORT).show();
                    prev = messag;
                    imageLoad(messag, shibeAPI);
                }
                else if (prev.equals(messag) || messag.equals("")){
                    Toast.makeText(getApplicationContext(), "Спрашиваем следующее", Toast.LENGTH_SHORT).show();
                    call.clone().enqueue(shibeController);
                }
                /*else {
                    Toast.makeText(getApplicationContext(), "Ждем", Toast.LENGTH_SHORT).show();
                    call.enqueue(shibeController);
                }*/

            }
        });
    }

    public void setMessag(String messag) {
        this.messag = messag;
    }

    private void imageLoad(String message, ShibeAPI shibeAPI)  {
        Log.d("TAG", message + "- это ссылка");
        Call requestImage = shibeAPI.getImageShibu(message);
        requestImage.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.body() != null){
                    byte[] bytes = new byte[0];
                    Log.d("TAG", " not fail load image");
                    try {
                        bytes = response.body().bytes();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Bitmap imageResponse = BitmapFactory.decodeByteArray(bytes, 0 , bytes.length );
                    setImage(imageResponse);
                }
                else {
                    Log.d("TAG", "fail load image");
                }
            }

            @Override
            public void onFailure(Call call, Throwable t) {

            }
        });

    }

    private void setImage(Bitmap imageResponse) {
        imageView.setImageBitmap(imageResponse);
    }

    @Override
    public void getResource(String resource) {
        messag = resource;

    }
}
