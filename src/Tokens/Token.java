package Tokens;

public class Token {
    private String clave;
    private String valor;

    public Token(String clav, String val){
        clave = clav;
        valor = val;
    }
    
    public Token(String c){
        clave = c;
        valor = "";
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
}