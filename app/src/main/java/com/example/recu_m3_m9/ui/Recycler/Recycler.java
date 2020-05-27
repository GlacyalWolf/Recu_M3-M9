package com.example.recu_m3_m9.ui.Recycler;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.recu_m3_m9.Data.Cliente;
import com.example.recu_m3_m9.R;

import java.util.ArrayList;


public class Recycler extends Fragment {
    private RecyclerViewModel recyclerVM;
    private RecyclerView miRecycler;
    private RecyclerAdapter miAdapter;
    private ArrayList<Cliente> listacli= new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        recyclerVM = new ViewModelProvider(requireActivity()).get(RecyclerViewModel.class);
        View root=inflater.inflate(R.layout.fragment_recycler, container, false);
        miRecycler= root.findViewById(R.id.RecyclerPersona);
        miRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        miAdapter= new RecyclerAdapter(listacli);
        miRecycler.setAdapter(miAdapter);

        recyclerVM.getListlivedatacli().observe(getViewLifecycleOwner(), new Observer<ArrayList<Cliente>>() {
            @Override
            public void onChanged(ArrayList<Cliente> clientes) {
                miAdapter.setClientes(clientes);
                miAdapter.notifyDataSetChanged();
            }
        });







        return root;
    }
}
