package com.example.recu_m3_m9.ui.Recycler;

import android.os.AsyncTask;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recu_m3_m9.Data.Cliente;
import com.example.recu_m3_m9.Data.Repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;



public class RecyclerViewModel extends ViewModel {
    MutableLiveData<ArrayList<Cliente>> listlivedatacli;
    ArrayList<Cliente> listacli= new ArrayList<>();
    Repository repo;

    public RecyclerViewModel(){
        listlivedatacli= new MutableLiveData<>();

    }

    public MutableLiveData<ArrayList<Cliente>> getListlivedatacli() {
        return listlivedatacli;
    }

    public class threadgetclientes extends AsyncTask<String, Void, ArrayList<Cliente>>{

        @Override
        protected ArrayList<Cliente> doInBackground(String... strings) {
            Connection connection= Repository.openPostgresConnection();
            ArrayList<Cliente> listac= new ArrayList<>();
            Cliente cliente= new Cliente();
            ResultSet rs= null;


            try {
                Statement stmt = null;
                stmt = connection.createStatement();
                String query= "select * from cliente;";
                rs= stmt.executeQuery(query);
                while (rs.next()){
                    cliente.setID(rs.getInt("id"));
                    cliente.setNombre(rs.getString("nombre"));
                    cliente.setNombre(rs.getDate("edad").toString());
                    listac.add(cliente);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            if(connection!=null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            return listac;


        }

        @Override
        protected void onPostExecute(ArrayList<Cliente> clientes) {
            super.onPostExecute(clientes);
            listlivedatacli.postValue(clientes);

        }
    }




}
