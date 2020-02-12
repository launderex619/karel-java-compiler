package CodeGeneration;

import Tokens.Instruccion;
import Tokens.Metodo;

import java.io.*;
import java.util.ArrayList;

public class CodeGeneration {
    private ArrayList<Instruccion> instruccionesOrdenadas;
    private String codigo;

    public CodeGeneration(ArrayList<Instruccion> metodos) {
        int ultimoValorMetodo = 0;
        int mirada = 0;
        ArrayList<Boolean> llaveNecesaria = new ArrayList<>();
        codigo = "";
        instruccionesOrdenadas = metodos;
        crearCabeceraDeCodigo();
        for (Instruccion i: instruccionesOrdenadas) {
            System.out.println(i.getNombre() + " " + i.getValorStr() + " " + i.getValorInt() + " " +
                    i.getValorBol());
            if (i.getNombre().equals("Expresion de llamada")){
                if(i.getValorInt() != 0){
                    ultimoValorMetodo = i.getValorInt();
                }
            }
            else if(i.getNombre().equals("Expresion entera")){
                ultimoValorMetodo = i.getValorInt();
            }
            if(i.getValorStr().contains("turnleft") || i.getNombre().contains("turnleft") ) {
                codigo += "\tmirada = (++mirada % 4);\n";
                mirada = (++mirada % 4);
            }
            else if(i.getValorStr().contains("turnoff") || i.getNombre().contains("turnoff") ) {
                codigo += "\treturn 0;\n";
            }
            else if(i.getValorStr().contains("move") || i.getNombre().contains("move") ) {
                if (mirada == 0) {
                    codigo += "\tposicionX++;\n";
                } else if (mirada == 1) {
                    codigo += "\tposicionY++;\n";
                } else if (mirada == 2) {
                    codigo += "\tposicionX--;\n";
                } else if (mirada == 3) {
                    codigo += "\tposicionY--;\n";
                }
            }
            else if(i.getValorStr().contains("pickbeeper") || i.getNombre().contains("pickbeeper") ) {
                codigo += "\tmochila++;\n";
            }
            else if(i.getValorStr().contains("putbeeper") || i.getNombre().contains("putbeeper") ){
                codigo += "\tmochila--;\n";
            }
            else if(i.getValorStr().contains("iterate") || i.getNombre().contains("iterate") ||
                    i.getValorStr().contains("while") || i.getNombre().contains("while")) {
                codigo += "\tfor(int i = 0; i < " + ultimoValorMetodo + "; i++) {\n";
                llaveNecesaria.add(true);
            }
            else if(i.getValorStr().contains("if") || i.getNombre().contains("if") ){
                codigo += "\tif(" + Boolean.toString(i.getValorBol()) + ") {\n";
                llaveNecesaria.add(true);
            }
            else if(i.getValorStr().contains("else") || i.getNombre().contains("else") ){
                codigo += "else {\n";
                llaveNecesaria.add(true);
            }
            else if(i.getValorStr().contains("llaveC") || i.getNombre().contains("llaveC") ){
                if (llaveNecesaria.size() > 0) {
                    codigo += "}\n";
                    llaveNecesaria.remove(llaveNecesaria.size() - 1);
                }
            }
        }
        codigo+="}";
    }

    private void crearCabeceraDeCodigo() {
        codigo += "#include <iostream> \n" +
                "int main(){\n" +
                "   int posicionX = 0;\n" +
                "   int posicionY = 0;\n" +
                "   int mirada = 0;\n" +
                "   int mochila = 0;\n";
    }

    public String mostrarCodigo() {
        StringBuffer output = new StringBuffer();
        Process p;
        try {
            p = Runtime.getRuntime().exec("g++ -save-temps -fverbose-asm code.cpp");
            p = Runtime.getRuntime().exec("rm code.o && rm code.ii && rm code.cpp && rm a.out");
            p = Runtime.getRuntime().exec("cat code.s");
            InputStreamReader in = new InputStreamReader(p.getInputStream());
            BufferedReader reader = new BufferedReader(in);
            String line = "";
            while ((line = reader.readLine()) != null) {
                output.append(line + "\n");
            }
            p.destroy();
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return output.toString();
        /*File archivo = new File("code.");
        try {
            FileWriter fileWriter = new FileWriter(archivo);
            fileWriter.write(codigo);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }

    public void guardarCodigo() {
        File archivo = new File("code.cpp");
        try {
            FileWriter fileWriter = new FileWriter(archivo);
            fileWriter.write(codigo);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
