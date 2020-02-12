import CodeGeneration.CodeGeneration;
import Lexer.Lexer;
import Parser.parser;
import Semantic.Semantic;
import Tokens.Nodo;
import java_cup.runtime.Symbol;

import java.io.*;

public class Main {

    public static String recorrido(Nodo raiz) throws Exception{
        String cuerpo = "";
        for(Nodo hijo : raiz.getHijos()){
            hijo.setPadre(raiz);
            if(hijo != null) {
                //if (hijo.getValor() != null || hijo.getHijos().size() != 0 || hijo.getEtiqueta() != null) {
                    cuerpo += "\"" + raiz.getIdNodo() + "\"" + " [label=\"" + raiz.getEtiqueta() + "->" + raiz.getValor() + "\"]";
                    cuerpo += "\"" + hijo.getIdNodo() + "\"" + " [label=\"" + hijo.getEtiqueta() + "->" + hijo.getValor() + "\"]";
                    cuerpo += "\"" + raiz.getIdNodo() + "\" -> " + "\"" + hijo.getIdNodo() + "\"";
                    cuerpo += recorrido(hijo);
                //}
            }
        }
        return cuerpo;
    }

    public static void graficar(String cadena, String nombreArch){
        FileWriter fichero = null;
        PrintWriter pw = null;
        String archivo = nombreArch + ".dot";
        try {
            fichero = new FileWriter(archivo);
            pw = new PrintWriter(fichero);
            pw.println("digraph G {node[shape=oval, style=filled, color=\"#EEEEEE\"]; edge[color=\"#31CEF0\"]; rankdir=UD \n");
            pw.println(cadena);
            pw.println("\n}");
            fichero.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        try {
            ProcessBuilder processBuilder;
            processBuilder = new ProcessBuilder("dot", "-Tpng", nombreArch, ".dot -o",nombreArch, "png");
            processBuilder.redirectErrorStream(true);
            processBuilder.start();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.print("\n=======================Analizador lexico=======================\n");
        Lexer lexer = null;
        try {
            lexer = new Lexer( new BufferedReader(new FileReader(args[0])));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.print("\n=======================Analizador sintactico=======================\n");
        parser parser = new parser(lexer);
        Symbol parseTree = null;

        try {
            parseTree = parser.parse();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Nodo raiz = parser.raiz;
        try {
            graficar(recorrido(raiz), "parserTree");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.print("\n=======================Analizador semantico=======================\n");
        Semantic semantic = new Semantic(raiz);
        try {
            semantic.analizar();
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.print("\n=======================Generador de codigo=======================\n");
        CodeGeneration codeGeneration = new CodeGeneration(semantic.getPila());
        codeGeneration.guardarCodigo();
        System.out.println(codeGeneration.mostrarCodigo());
    }

}