package Tokens;

/**
 * TokenError
 */
public class TokenError {
    public String lexema, tipo, descripcion;
    int linea, columna;

    public TokenError(String lex, String tip, String desc, int li, int col){
        lexema = lex;
        tipo = tip;
        descripcion = desc;
        linea= li;
        columna= col;
    }

    
}