package com.example.guaytambofood;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;

import java.lang.reflect.Type;
import java.util.List;

public class ListaMenu extends AppCompatActivity {
    private ImageView imageView4;
    List<MenuP> listaS;
    public String id;
    public static int p =0;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    private static String URL_CARGAR = "http://alexis247-001-site1.btempurl.com/ApiwcfJson.svc/car";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_menu);
        recyclerView = findViewById(R.id.rvMenu);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        CargarMenu();
        id = getIntent().getExtras().getString("id");
        Toast.makeText(getApplicationContext(), "Capturo la ID " +id , Toast.LENGTH_SHORT).show();
    }

    private void CargarMenu() {
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(URL_CARGAR, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                Toast.makeText(getApplicationContext(), "Se cargo la URL", Toast.LENGTH_SHORT).show();
                Gson gson = new Gson();
                List<MenuP> listaMenu;
                Type listType = new TypeToken<List<MenuP>>() {}.getType();
                listaMenu = new Gson().fromJson(String.valueOf(response), listType);
                MenuAdapter adapter = new MenuAdapter(ListaMenu.this, listaMenu,id);
                recyclerView.setAdapter(adapter);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_SHORT).show();
            }
        });
        Volley.newRequestQueue(this).add(jsonArrayRequest);
    }


}