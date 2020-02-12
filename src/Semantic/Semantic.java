package Semantic;

import Tokens.Instruccion;
import Tokens.Metodo;
import Tokens.Nodo;

import java.awt.*;
import java.util.ArrayList;
import java.util.Objects;

public class Semantic {
    private Nodo raiz;
    private ArrayList<Metodo> metodos;
    private ArrayList<Instruccion> pila;
    private Point pos;
    private int mochila;

    public Semantic(Nodo raiz) {
        pos = new Point(0,0);
        mochila = 0;
        metodos = new ArrayList<>();
        pila = new ArrayList<>();
        this.raiz = raiz;
    }


    public void analizar() throws Exception{
        crearMetodos(raiz);
        System.out.println("metodos creados");
        for (Metodo m: metodos) {
            System.out.println("\t" + m.getNombre());
            crearAmbitos(m);
        }
        System.out.println("ambitos creados:");
        analizarAmbitos();
        crearPilaDeEjecucion();
        System.out.println("pila creada:");
        for (Instruccion ins: pila) {
            System.out.println("\t" + ins.getNombre());
        }
    }

    private void crearPilaDeEjecucion() throws Exception{
        if(metodos.size() < 1){
            throw new Exception("This is not a valid program, not methods in there");
        }
        Metodo main = metodos.get(metodos.size()-1);
        if(!Objects.equals(main.getNombre(), "program")){
            throw new Exception("This is not a valid program, not program method found!");
        }

        apilarInstrucciones(main);
    }

    private int damePosicionDeMetodo(String nombre){
        int i = 0;
        for (Metodo m: metodos) {
            if(Objects.equals(m.getNombre(), nombre)){
                return i;
            }
            i++;
        }
        return -1;
    }

    private void apilarInstrucciones(Metodo metodo){
        for (Instruccion ins: metodo.getInstrucciones()) {
            if(Objects.equals(ins.getNombre(), "Expresion de llamada")){
                int posMet = damePosicionDeMetodo(ins.getValorStr());
                pila.add(ins);
                apilarInstrucciones(metodos.get(posMet));
            }
            else
                pila.add(ins);
        }
    }

    private void analizarAmbitos() throws Exception{
        for (Metodo m: metodos) {
            for (Instruccion ins: m.getInstrucciones()) {
                System.out.println("\t"+ ins.getNombre() + "->" + ins.getValorStr());
                if(Objects.equals(m.getNombre(), "Expresion de llamada")){
                    String nombreLlamadaAMetodo = ins.getValorStr();
                    boolean metodoEncontrado = false;
                    for (Metodo met: metodos) {
                        if (Objects.equals(met.getNombre(), nombreLlamadaAMetodo)){
                            metodoEncontrado = true;
                            break;
                        }
                    }
                    if (!metodoEncontrado){
                        throw new Exception("not found method call: " + nombreLlamadaAMetodo);
                    }
                }
            }
        }
        System.out.println("Ambitos correctos");
    }

    private void crearAmbitos(Metodo metodo) {
        Nodo hoja = metodo.getHoja().getPadre();
        Nodo bloque = null;
        for(Nodo p: hoja.getHijos()){
            if(Objects.equals(p.getEtiqueta(), "Bloque")){
                bloque = p;
            }
        }
        metodo.agregarInstruccion(new Instruccion("llaveA"));
        agregarInstrucciones(metodo, bloque);
        metodo.agregarInstruccion(new Instruccion("llaveC"));
    }

    private void agregarInstrucciones(Metodo metodo, Nodo bloque) {
        if(bloque == null)
            return;
        if(Objects.equals(bloque.getEtiqueta(), "{")){
            metodo.agregarInstruccion(new Instruccion("llaveA"));
        }
        if(Objects.equals(bloque.getEtiqueta(), "}")){
            metodo.agregarInstruccion(new Instruccion("llaveC"));
        }
        if(bloque.getEtiqueta() != null){
            if(bloque.getEtiqueta().contains("Expresion")) {
                if (bloque.getValor() != null) {
                    Instruccion instruccion = new Instruccion(bloque.getEtiqueta());
                    instruccion.setValorStr(bloque.getValor());
                    if(instruccion.getNombre().contains("if")){
                        instruccion.setValorBol(Boolean.parseBoolean(bloque.getValor()));
                    }
                    else if(instruccion.getNombre().contains("llamada")){
                        String arg = bloque.getHijos().get(0).getValor();
                        if(arg != null) {
                            instruccion.setValorInt(Integer.parseInt(arg));
                        }
                    }
                    else {
                        try {
                            instruccion.setValorInt(Integer.parseInt(bloque.getValor()));
                        }catch (Exception e){
                            // no necesito imprimir nada en consola en este caso, yo se que no todos son numeros
                        }
                    }
                    metodo.agregarInstruccion(instruccion);
                }
            }
        }
        for (Nodo n: bloque.getHijos()) {
            agregarInstrucciones(metodo, n);
        }
    }

    private void crearMetodos(Nodo hoja) throws Exception{
        for (Nodo l: hoja.getHijos()) {
            if (Objects.equals(l.getEtiqueta(), "Firma de metodo")){
                String valor = l.getHijos().get(0).getValor();
                String metodo = l.getValor();
                Metodo m = new Metodo(metodo, valor, l);

                for (Metodo met: metodos) {
                   if(Objects.equals(met.getNombre(), m.getNombre()))
                       throw new Exception("Method already defined: " + m.getNombre());
                }
                metodos.add(m);
            }
            else if (Objects.equals(l.getEtiqueta(), "FIN")){
                String valor = null;
                String metodo = l.getHijos().get(0).getValor();
                Metodo m = new Metodo(metodo, valor, l.getHijos().get(2));

                for (Metodo met: metodos) {
                    if(Objects.equals(met.getNombre(), m.getNombre()))
                        throw new Exception("Method already defined: " + m.getNombre());
                }
                metodos.add(m);
            }
            else {
                crearMetodos(l);
            }
        }
    }

    public ArrayList<Instruccion> getPila() {
        return pila;
    }

    public ArrayList<Metodo> getMetodos() {
        return metodos;
    }
}
