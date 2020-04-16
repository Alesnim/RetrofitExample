package com.itschool.retrofitexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.telecom.Call;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.itschool.retrofitexample.Controllers.DnDAPI;
import com.itschool.retrofitexample.Services.NetworkDNDService;
import com.itschool.retrofitexample.models.Result;
import com.itschool.retrofitexample.models.Spells;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Callback;
import retrofit2.Response;

public class Main2Activity extends AppCompatActivity {

    EditText editText;
    Button button;
    SpellAdapter adapter;
    RecyclerView view;
    DnDAPI dnDAPI;

    NetworkDNDService networkService;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        editText = findViewById(R.id.editText);
        button   = findViewById(R.id.search);
        view     = findViewById(R.id.recycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);

        view.setLayoutManager(layoutManager);
        ArrayList spells = new ArrayList<Result>();
        adapter = new SpellAdapter(spells);
        view.setAdapter(adapter);
        networkService = NetworkDNDService.getInstance();
        dnDAPI = networkService.createDNDAPI();

        try {
            dnDAPI.getSpells().enqueue(new Callback<Spells>() {
                @Override
                public void onResponse(retrofit2.Call<Spells> call, Response<Spells> response) {


                    spells.addAll(response.body().getResults());
                    Log.d("TAG", "TT " + response.body().getResults().toString());
                    view.getAdapter().notifyDataSetChanged();
                }

                @Override
                public void onFailure(retrofit2.Call<Spells> call, Throwable t) {
                    Toast.makeText(getApplicationContext(), "UPS", Toast.LENGTH_SHORT).show();
                    Log.d("TAG", t.toString());
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
