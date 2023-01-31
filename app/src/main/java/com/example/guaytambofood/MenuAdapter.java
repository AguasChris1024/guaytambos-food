package com.example.guaytambofood;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.ViewHolder> {

    Context context;
    List<MenuP> menup;
    public String id;

    public MenuAdapter(Context context, List<MenuP> menup, String id) {
       this.context = context;
        this.menup = menup;
        this.id= id;
    }
    @Override
    public ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.menu_item, null);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
       MenuP menu = menup.get(position) ;
        holder.txtSopa.setText(menu.getSopaApp());
        holder.txtFuerte.setText(menu.getPlatoFuerteApp());
        if (menu.fotoSegundoApp !=null){
            byte[] blob = menu.fotoSegundoApp;
            Bitmap bmp= BitmapFactory.decodeByteArray(blob,0,blob.length);
            holder.imgSopa.setImageBitmap(bmp);
        }else{
            holder.imgSopa.setImageResource( R.drawable.plav);
        }
        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(),"item "+menu.getFechaApp(),Toast.LENGTH_LONG).show();
                AlertDialog.Builder dialogo = new AlertDialog.Builder(context);
                dialogo.setTitle("Alerta");
                dialogo.setMessage("Desea agregar pedidos de este Menu?");
                dialogo.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent (context, Detalleplato.class);
                        intent.putExtra("usuario",id);
                        intent.putExtra("menu",menu.idApp);
                        intent.putExtra("fecha",menu.fechaApp);
                        intent.putExtra("sopa",menu.sopaApp);
                        intent.putExtra("segundo",menu.platoFuerteApp);
                        intent.putExtra("precio",menu.precioApp);
                        context.startActivity(intent);
                    }

                });
                dialogo.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(context, "Cancelando..", Toast.LENGTH_SHORT).show();

                    }
                });
            dialogo.show();
            }

        });
    }
    @Override
    public int getItemCount() { return menup.size();}
    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView txtSopa,txtFuerte;
        public ImageView imgSopa;
        public ConstraintLayout relativeLayout;
        public ViewHolder(View itemView) {
            super(itemView);
            txtSopa = itemView.findViewById(R.id.txtSopa);
            txtFuerte = itemView.findViewById(R.id.txtFuerte);
            imgSopa = itemView.findViewById(R.id.imgSopa);
          relativeLayout=itemView.findViewById(R.id.linearLayout);
        }
    }
}

