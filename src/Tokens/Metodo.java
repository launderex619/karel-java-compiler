package Tokens;

import java.util.ArrayList;

public class Metodo {
    Nodo hoja;
    String nombre;
    String parametro;
    ArrayList<Instruccion> instrucciones;

    public Metodo(String nombre, String parametro, Nodo hoja) {
        this.nombre = nombre;
        this.parametro = parametro;
        this.hoja = hoja;
        instrucciones = new ArrayList<>();
    }

    public ArrayList<Instruccion> getInstrucciones() {
        return instrucciones;
    }

    public void agregarInstruccion(Instruccion instruccion){
        instrucciones.add(instruccion);
    }

    public Nodo getHoja() {
        return hoja;
    }

    public String getNombre() {
        return nombre;
    }

    public String getParametro() {
        return parametro;
    }
}
