/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package numero;

/**
 *
 * @author camil
 */
public class Numero {
    private float valor=0;
    
    public float getValor(){
        return valor;
    }
    public float sumar(float n){
        valor = valor + n;
        return valor;
    }
    public float resta(float n){
        valor = valor - n;
        return valor;
    }
    public float multiplicar(float n){
        valor = valor*n;
        return valor;
    }
    public float division(float n){
        valor = valor/n;
        return valor;
    }
}
