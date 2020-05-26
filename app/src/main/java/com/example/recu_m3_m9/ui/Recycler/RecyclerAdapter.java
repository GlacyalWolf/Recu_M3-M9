package com.example.recu_m3_m9.ui.Recycler;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recu_m3_m9.Data.Cliente;
import com.example.recu_m3_m9.R;

import java.sql.Date;
import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    ArrayList<Cliente> listcli = new ArrayList<>();

    public RecyclerAdapter(ArrayList<Cliente> listcli) {
        this.listcli = listcli;
    }
    public void setClientes(ArrayList<Cliente> cli){
        this.listcli=cli;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_adapter,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String nom= listcli.get(position).getNombre();
        int ID= listcli.get(position).getID();
        String nacimiento= listcli.get(position).getDNaixement().toString();

        holder.nom.setText(nom);
        holder.ID.setText(ID);
        holder.nacimiento.setText(nacimiento);



    }

    @Override
    public int getItemCount() {
        return listcli.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView nom,ID,nacimiento;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nom= itemView.findViewById(R.id.TextV_Nom);
            ID = itemView.findViewById(R.id.TextV_ID);
            nacimiento= itemView.findViewById(R.id.TextV_DNeix);

        }
    }
}
