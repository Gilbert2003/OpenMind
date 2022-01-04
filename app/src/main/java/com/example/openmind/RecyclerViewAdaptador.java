package com.example.openmind;

import android.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewAdaptador extends RecyclerView.Adapter<RecyclerViewAdaptador.ViewHolder> {
    public static class ViewHolder extends RecyclerView.ViewHolder{

        private TextView nombres, cedula;
        ImageView fotoClientes;

        public ViewHolder(View itemView) {
            super(itemView);

            nombres = itemView.findViewById(R.id.lblnombres);
            cedula = itemView.findViewById(R.id.lblcedula);
            fotoClientes = itemView.findViewById(R.id.fotoCliente);


        }
    }

    public List<obtenerClientes> clientesList;

        public RecyclerViewAdaptador(List<obtenerClientes>clientesList){
        this.clientesList = clientesList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cliente,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
            return viewHolder;

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.nombres.setText(clientesList.get(position).getNombres());
        holder.cedula.setText(clientesList.get(position).getCedula());
        holder.fotoClientes.setImageResource(clientesList.get(position).getImgClientes());

    }

    @Override
    public int getItemCount(){
            return clientesList.size();
    }

}


