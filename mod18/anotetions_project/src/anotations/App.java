package anotations;

import anotations.MyAnotation;
import anotations.MyAnotationForField;

public class App {

    @MyAnotationForField(value = "variavel tipo Number")
    private Number num;

    @MyAnotationForField(value = "String", maisInfo = "Novo valor")
    private String letras;

    public Number numbers() {
        return 10;
    }

    @MyAnotation(value = "Valor")
    public String myMethod() {
            return "";
    }

    public static void main(String[] args) throws Exception {

    }
}
