package com.example.recu_m3_m9.Data;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Repository {
    private static String driverLocation = "org.postgresql.Driver";
    private static String postgresConnection = "jdbc:postgresql://37.14.19.57:5432/";
    private static String postgresUsername = "postgres";
    private static String postgresPassword = "postgres";
    private static Connection connection = null;
    private MutableLiveData<ArrayList<Cliente>> listacont;



    private static Repository srepository;
    private Context context;

    private Repository(Context context){
        this.context = context;
        listacont = new MutableLiveData<>();

    }

    public static Repository get(Context context){
        if(srepository == null){
            srepository = new Repository(context);
        }
        return srepository;
    }
    public static Repository getRepository(){return srepository;}

    public static Connection openPostgresConnection(){
        try {
            Class.forName(driverLocation);

            connection = DriverManager.getConnection(postgresConnection,postgresUsername,
                    postgresPassword);

            if (connection != null){
                Log.d("PostgreSQL","Connected to the postgres server successfully");
            } else {
                Log.d("PostgreSQL","Failed to connect");
            }

        } catch (SQLException e) {
            Log.d("PostgreSQL","Error connecting to PostgreSQL server");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }



    public static ArrayList<Cliente> getCliente(){
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
        return listac;


    }




}
