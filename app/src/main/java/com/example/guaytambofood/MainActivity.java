package com.example.guaytambofood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    private EditText edtUsuario, edtPassword;
    private Button btnRegistro;
    private static String URL_LOGIN="http://alexis247-001-site1.btempurl.com/ApiwcfJson.svc/login/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtUsuario=findViewById(R.id.edtUsuario);
        edtPassword=findViewById(R.id.edtApellido);
        btnRegistro=findViewById(R.id.btnRegistro);
        btnRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usuario = edtUsuario.getText().toString().trim();
                String contrasenia = edtPassword.getText().toString().trim();
                if (!usuario.isEmpty() && !contrasenia.isEmpty()){
                    login(usuario, contrasenia);
                    //Toast.makeText(getApplicationContext(), "Bienvenido", Toast.LENGTH_SHORT).show();


                }else{
                    Toast.makeText(getApplicationContext(), "ERROR, Campos Vacios", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

    private void login(String usuario, String contrasenia) {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL_LOGIN+usuario+"/"+contrasenia, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                //Toast.makeText(getApplicationContext(),"cargando", Toast.LENGTH_SHORT).show();

                try {
                    JSONObject jsonObject = new JSONObject(response);



                        Toast.makeText(getApplicationContext(), "Bienvenido " + jsonObject.getString("email"), Toast.LENGTH_SHORT).show();
                    //Toast.makeText(getApplicationContext(), "Bienvenido " + jsonObject.getString("id"), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent (getBaseContext(), menuprincipal.class);
                    intent.putExtra("id",jsonObject.getString("id"));
                    startActivityForResult(intent, 0);








                } catch (JSONException e) {

                    Toast.makeText(getApplicationContext(), "Crdeciales Incorrectas" , Toast.LENGTH_SHORT).show();


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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_superior, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected( MenuItem item) {
        if (item.getItemId() == R.id.mnRegistrar) {
            startActivity(new Intent(getBaseContext(), ResgistroUsuario.class));
            return(true);
        }
        return(super.onOptionsItemSelected(item));


        }
}