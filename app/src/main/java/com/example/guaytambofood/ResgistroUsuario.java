package com.example.guaytambofood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class ResgistroUsuario extends AppCompatActivity {
    private Button btnUser ;
    private EditText edtUsuario,edtContraseña,edtNombre,edtApellido,edtCorreo;
    private static String URL_REGISTRO="http://alexis247-001-site1.btempurl.com/ApiwcfJson.svc/re/";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resgistro_usuario);
        edtUsuario=findViewById(R.id.edtReUse);
        edtContraseña=findViewById(R.id.edtRegPass);
        edtNombre=findViewById(R.id.edtNombre);
        edtApellido=findViewById(R.id.edtApellido);
        edtCorreo=findViewById(R.id.edtCorreo);
        btnUser=findViewById(R.id.btnUser);
        btnUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerUser();

                finish();
            }


        });




    }

    public  void  registerUser(){

//{usuario}/{contraseña}/{nombre}/{apellido}/{email}
        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL_REGISTRO+edtUsuario.getText().toString()+"/"
                +edtContraseña.getText().toString()+"/"+
                edtNombre.getText().toString()+"/"+
                edtApellido.getText().toString()+"/"+
                edtCorreo.getText().toString(), new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {


                if (response.equals("true")){
                    Toast.makeText(getApplicationContext(),"Guardado con exito "+ response, Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(getApplicationContext(),"ERROR, No se Guardo"+ response, Toast.LENGTH_LONG).show();
                }




            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_SHORT).show();
            }
        });

        Volley.newRequestQueue(this).add(stringRequest);

    }
}