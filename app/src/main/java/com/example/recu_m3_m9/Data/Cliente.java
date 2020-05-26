package com.example.recu_m3_m9.Data;

import java.sql.Date;

public class Cliente {
    String Nombre;
    int ID;
    String DNaixement;

    public Cliente(String nombre, int ID, String DNaixement) {
        Nombre = nombre;

        this.DNaixement = DNaixement;
    }
    public Cliente(){}

    public String getNombre() {
        return Nombre;
    }

    public int getID() {
        return ID;
    }

    public String getDNaixement() {
        return DNaixement;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setDNaixement(String DNaixement) {
        this.DNaixement = DNaixement;
    }
}
