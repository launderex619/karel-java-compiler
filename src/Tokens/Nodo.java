package Tokens;

import java.util.ArrayList;

public class Nodo {
    private Nodo padre;
    private String etiqueta;
    private ArrayList<Nodo> hijos;
    private String valor;
    private int idNodo;

    public Nodo() {
        hijos = new ArrayList<>();
    }

    public String getEtiqueta() {
        return etiqueta;
    }

    public void setEtiqueta(String etiqueta) {
        this.etiqueta = etiqueta;
    }

    public ArrayList<Nodo> getHijos() {
        return hijos;
    }

    public void addHijo(Nodo hijo){
        hijos.add(hijo);
    }

    public void setPadre(Nodo padre){
        this.padre = padre;
    }

    public Nodo getPadre() {
        return padre;
    }

    public void setHijos(ArrayList<Nodo> hijos) {
        this.hijos = hijos;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public int getIdNodo() {
        return idNodo;
    }

    public void setIdNodo(int idNodo) {
        this.idNodo = idNodo;
    }
}
