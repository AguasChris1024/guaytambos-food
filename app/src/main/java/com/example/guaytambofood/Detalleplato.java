package com.example.guaytambofood;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class Detalleplato extends AppCompatActivity {
    private static String URL_PEDIDO="http://alexis247-001-site1.btempurl.com/ApiwcfJson.svc/ped/";
    private Button btnRegresarAgregar;
    private EditText edtNombrePlato, edtDescripcion,edtDetalleStock,edtCantidad;
    public String usuario, fecha;
    public  int menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalleplato);
        edtNombrePlato=findViewById(R.id.edtNombrePlato);
        String valor =getIntent().getExtras().getString("sopa").toString();
        edtNombrePlato.setText(valor);
        edtNombrePlato.setEnabled(false);
        edtDescripcion=findViewById(R.id.edtDescripcion);
        String valor2 =getIntent().getExtras().getString("segundo").toString();
        edtDescripcion.setText(valor2);
        edtDescripcion.setEnabled(false);
        edtDetalleStock=findViewById(R.id.edtDetalleStock);
        float valor3 =getIntent().getExtras().getFloat("precio");
        edtDetalleStock.setText(String.valueOf(valor3));
        edtDetalleStock.setEnabled(false);
        edtCantidad=findViewById(R.id.edtCantidad);
        btnRegresarAgregar=findViewById(R.id.btnRegresarAgregar);
        btnRegresarAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerPedido();

             finish();
            }


        });

    }

    private void registerPedido() {
//"ped/{usuario}/{menu}/{cantidad}/{fecha}/{precio}",
        //http://alexis247-001-site1.btempurl.com/ApiwcfJson.svc/ped/1/97/3/30/7.40
        usuario =getIntent().getExtras().getString("usuario").toString();
        menu =getIntent().getExtras().getInt("menu");
        fecha =getIntent().getExtras().getString("fecha").toString();

        System.out.println("Comprobaciin"+ URL_PEDIDO+usuario+"/"+menu+"/"+edtCantidad.getText().toString()
                +"/"+fecha+"/"+edtDetalleStock.getText().toString());
        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL_PEDIDO+usuario+"/"+menu+"/"+edtCantidad.getText().toString()
                +"/"+fecha+"/"+edtDetalleStock.getText().toString(), new Response.Listener<String>() {
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