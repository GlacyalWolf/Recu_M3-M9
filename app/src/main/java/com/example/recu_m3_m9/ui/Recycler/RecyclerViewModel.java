package com.example.recu_m3_m9.ui.Recycler;

import android.os.AsyncTask;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.recu_m3_m9.Data.Cliente;
import com.example.recu_m3_m9.Data.Repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import static com.example.recu_m3_m9.Data.Repository.getCliente;

public class RecyclerViewModel extends ViewModel {

    private MutableLiveData<ArrayList<Cliente>> listacli;

    public MutableLiveData<ArrayList<Cliente>> getListacli() {
        return listacli;
    }



    public class threadGetCli extends AsyncTask<String,Void,
            ArrayList<Cliente>>{

        @Override
        protected ArrayList<Cliente> doInBackground(String... strings) {
            Repository.openPostgresConnection();


            return Repository.getCliente();

        }

        @Override
        protected void onPostExecute(ArrayList<Cliente> clientes) {
            super.onPostExecute(clientes);
            ArrayList<Cliente> listacli= new ArrayList<>();

        }
    }
}
