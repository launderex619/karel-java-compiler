package Tokens;

public class Instruccion {
    String nombre;
    String valorStr;
    int valorInt;
    boolean valorBol;
    
    public Instruccion(String nombre){
        this.nombre = nombre;
        valorInt = 0;
        valorStr = "";
        valorBol = false;
    }



    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getValorStr() {
        return valorStr;
    }

    public void setValorStr(String valorStr) {
        this.valorStr = valorStr;
    }

    public int getValorInt() {
        return valorInt;
    }

    public void setValorInt(int valorInt) {
        this.valorInt = valorInt;
    }

    public boolean getValorBol() {
        return valorBol;
    }

    public void setValorBol(boolean valorBol) {
        this.valorBol = valorBol;
    }
}
