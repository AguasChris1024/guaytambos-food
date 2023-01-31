package com.example.guaytambofood;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;

import java.lang.reflect.Type;
import java.util.List;

public class ListaMenuBackup extends AppCompatActivity {
    private Button btnRegistro;
    private ImageView imageView4;
    List<MenuP> listaS;
    private static String URL_CARGAR="http://alexis247-001-site1.btempurl.com/ApiwcfJson.svc/car";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_menu);
      //  imageView4 = findViewById(R.id.imageView4);

    CargarMenu();
    }

    private void CargarMenu() {


        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(URL_CARGAR, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                Toast.makeText(getApplicationContext(),"Se cargo la URL", Toast.LENGTH_SHORT).show();

                //try {
                    //JSONArray array = null;
                    //for (int i = 0; i < array.length(); i++) {
                    //String p ="";

                        //JSONObject jsonObject = array.getJSONObject(0);

                       // p = jsonObject.getString("fotoSegundo");

                    //byte [] encodeByte = android.util.Base64.decode(p, Base64.URL_SAFE);
                    //Bitmap bitmap = BitmapFactory.decodeByteArray(encodeByte, 0, encodeByte.length);
                   // imageView4.setImageResource(R.drawable.fon2);
                   Gson gson = new Gson();
                     //List<MenuP> listaS = gson.fromJson(response,MenuP.class);



                    List<MenuP> contacts;
                    Type listType = new TypeToken<List<MenuP>>() {
                    }.getType();
                    contacts= new Gson().fromJson(String.valueOf(response), listType);
                    MenuP efe = contacts.get(0);
                    //Toast.makeText(getApplicationContext(),"Menu"+efe.bebida, Toast.LENGTH_SHORT).show();
                   // byte[] blob = efe.fotoSegundo;
                    //Bitmap bmp=BitmapFactory.decodeByteArray(blob,0,blob.length);
                    //ImageView image=new ImageView(this);
                   // image.setImageBitmap(bmp);
                    //Toast.makeText(getApplicationContext(),"Cargado"+efe.fotoSegundo.toString(), Toast.LENGTH_SHORT).show();
                   // imageView4.setImageBitmap(bmp);

               // Toast.makeText(getApplicationContext(),"Fecha"+efe.fecha, Toast.LENGTH_SHORT).show();
                   // imageView4.setImageBitmap(BitmapFactory.decodeFile(bitmap));



                        //listaSe.add(new Sopa(

                        //));
                    //}

                    //MenuAdapter adapter = new MenuAdapter(Consulta.this, listaSe);
                    //res.setAdapter(adapter);

               // } catch (Exception e) {
                 //   e.printStackTrace();
                //}

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