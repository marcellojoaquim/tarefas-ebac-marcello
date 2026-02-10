package principal;

/*
* Classe reponsável por executar as operações básicas de uma calculadora
* Cada método recebe dois parametros que são usados na operação.
* O método dividir lança uma excetion caso haja uma operação de divisão por zero
*
* @Method: adicionar() retorna a soma de dois números inteiros.
* @Method: subtrair() retorna a subtração de dois números inteiros.
* @Method: multiplicar() retorna a multiplicacao de dois números inteiros.
* @Method: dividir() retorna a divisão de dois números inteiros, sendo o segunto parametro obrigatoriamente
* maior que zero, caso não, uma exception é lancada.
 */
public class Calculadora {

    public int adicionar(int a, int b){
        return a + b;
    }

    public int subtrair(int a, int b){
        return a - b;
    }
    public int multiplicar(int a, int b) {
        return a * b;
    }
    public int dividir (int a, int b) {
        if(b == 0){
            throw new IllegalArgumentException("Divisão por zero");
        }
        return a / b;
    }
}
