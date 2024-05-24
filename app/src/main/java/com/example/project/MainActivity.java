package com.example.project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

@SuppressWarnings("FieldCanBeLocal")
public class MainActivity extends AppCompatActivity implements JsonTask.JsonTaskListener {

    private final String JSON_URL = "https://mobprog.webug.se/json-api?login=a23thefo";
    private final String JSON_FILE = "mountains.json";

    ArrayList<Lizards> lizards = new ArrayList<>();

    Gson gson = new Gson();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new JsonTask(this).execute(JSON_URL);
        mainAc2();
    }

    private void mainAc2(){
        Button click = (Button) findViewById(R.id.button);
        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("msg", "Hej på dig!");
                startActivity(intent);
            }
        });
    }

    @Override
    public void onPostExecute(String json) {
        Type type = new TypeToken<ArrayList<Lizards>>() {}.getType();
        ArrayList<Lizards> listOfLizards = gson.fromJson(json, type);

        RecyclerView view = findViewById(R.id.recyclerView);
        recyclerviewadapter adapter = new recyclerviewadapter (this, listOfLizards);
        view.setAdapter(adapter);
        view.setLayoutManager(new LinearLayoutManager(this));
        adapter.notifyDataSetChanged();

    }
}