package com.example.guaytambofood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class menuprincipal extends AppCompatActivity {
    private Button btnListaMenu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menuprincipal);
        btnListaMenu=findViewById(R.id.btnListaMenu);
        btnListaMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), ListaMenu.class);
                String id = getIntent().getExtras().getString("id");
                Toast.makeText(getApplicationContext(), "IdUsuario" + id, Toast.LENGTH_SHORT).show();
                intent.putExtra("id",id);
                startActivityForResult(intent, 0);
            }
        });
    }
}