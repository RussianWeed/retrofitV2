package com.devking.retrofitv2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements ClickListner{
     private ArrayList<retrofit_model> data;
     public String url = "https://jsonplaceholder.typicode.com/";

    RecylerViewAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiCall api_call = retrofit.create(ApiCall.class);

        Call<ArrayList<retrofit_model>> call = api_call.get_model();

        call.enqueue(new Callback<ArrayList<retrofit_model>>() {

            @Override
            public void onResponse(Call<ArrayList<retrofit_model>> call, Response<ArrayList<retrofit_model>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    data = response.body();
                    updateAdapter(); // Call the method to update the adapter
                } else {
                    Log.e("MainActivity", "Response not successful or body is null");
                }
            }

            @Override
            public void onFailure(Call<ArrayList<retrofit_model>> call, Throwable t) {

            }
        });

    }

    private void updateAdapter() {
        RecyclerView recylerview = findViewById(R.id.recyler_view);
        recylerview.setLayoutManager(new LinearLayoutManager(this));
        RecylerViewAdapter adapter = new RecylerViewAdapter(data, this);
        recylerview.setAdapter(adapter);
        adapter.notifyDataSetChanged(); // Add this line
    }


    @Override
    public void onItemCLick(int position) {
            if (position != RecyclerView.NO_POSITION) {
                retrofit_model clickedItem = data.get(position);
                Intent intent = new Intent(this,MainActivity2.class);
                intent.putExtra("email",clickedItem.getEmail());
                intent.putExtra("body",clickedItem.getBody());
                startActivity(intent);

            }
    }


}