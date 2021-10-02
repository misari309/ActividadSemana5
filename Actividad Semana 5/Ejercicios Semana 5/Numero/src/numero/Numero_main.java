/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package numero;

import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author camil
 */
public class Numero_main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int salir = 0;
        float n;
        
        Scanner operacionE = new Scanner(System.in);
        Numero numero1 = new Numero();
        while(salir != 1){
            int operacion;
            System.out.println("El valor del número es: " + numero1.getValor());
            System.out.println("Elija la operación: \n 1. Sumar \n 2. Resta \n 3. Multiplicación \n 4. Dividir(n!=0) \n 5. Salir");
            operacion = operacionE.nextInt();
            switch(operacion){
                case 1:
                    System.out.println("Digite el valor a sumar: ");
                    n = operacionE.nextFloat();
                    numero1.sumar(n);
                break;
                case 2:
                    System.out.println("Digite el valor a restar: ");
                    n = operacionE.nextFloat();
                    numero1.resta(n);
                break;
                case 3:
                    System.out.println("Digite el valor a multiplicar: ");
                    n = operacionE.nextFloat();
                    numero1.multiplicar(n);
                break;
                case 4:
                    n = 0;
                    while(n == 0){
                        System.out.println("Digite el valor a dividir: ");
                        n = operacionE.nextFloat();
                        if(n == 0){
                            System.out.println("El valor debe ser diferente a cero.");
                        }else{
                            numero1.division(n);
                        }
                    }
                break;
                default:
                    System.exit(0);
                break;
            }
        }
    }
    
}
