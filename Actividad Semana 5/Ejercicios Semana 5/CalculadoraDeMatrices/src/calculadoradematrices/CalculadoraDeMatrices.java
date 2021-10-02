/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadoradematrices;

import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author camil
 */
public class CalculadoraDeMatrices {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int tipo, columnas, filas, columnas_2, filas_2, salir = 0;
        
        while(salir != 1){
            Scanner leerDimensiones = new Scanner(System.in);
            System.out.println("Digite la cantidad de columnas para la matriz 1.");
            columnas = leerDimensiones.nextInt();
            System.out.println("Digite la cantidad de filas para la matriz 1.");
            filas = leerDimensiones.nextInt();
            Matriz matriz1 = new Matriz();
            matriz1.setColumnas(columnas);
            matriz1.setFilas(filas);
            matriz1.rellenarMatrizRandom();
            matriz1.imprimirMatriz();


            System.out.println("Ahora digite los valores para la matriz 2.");
            System.out.println("Digite la cantidad de columnas para la matriz 2.");
            columnas_2 = leerDimensiones.nextInt();
            System.out.println("Digite la cantidad de filas para la matriz 2.");
            filas_2 = leerDimensiones.nextInt();
            while(columnas_2 != columnas || filas_2 != filas){
                System.out.println("\n Las dimensiones de las matrices deben ser iguales..");
                System.out.println("Digite la cantidad de columnas para la matriz 2.");
                columnas_2 = leerDimensiones.nextInt();
                System.out.println("Digite la cantidad de filas para la matriz 2.");
                filas_2 = leerDimensiones.nextInt();
            }
            Matriz matriz2 = new Matriz();
            matriz2.setColumnas(columnas);
            matriz2.setFilas(filas);
            matriz2.rellenarMatrizRandom();
            matriz2.imprimirMatriz();

            int operacion;

            Scanner elegirOperacion = new Scanner(System.in);
            System.out.println("\nElija la operación: ");
            System.out.println("1. Suma");
            System.out.println("2. Resta");
            System.out.println("3. Traza (Matriz(a+b))");
            System.out.println("4. Determinante");
            System.out.println("5. Salir\n");
            operacion = elegirOperacion.nextInt();

            Calculadora_de_matrices operaciones = new Calculadora_de_matrices();

            switch(operacion){
                case 1:
                    System.out.println("La suma de las matrices es: ");
                    operaciones.suma(matriz1, matriz2);
                    operaciones.imprimirMatrizR(matriz1);
                break;
                case 2:
                    System.out.println("La resta de las matrices es: ");
                    operaciones.resta(matriz1, matriz2);
                    operaciones.imprimirMatrizR(matriz1);
                break;
                case 3:
                    System.out.println("La traza de la matriz A+B es: " + operaciones.traza(matriz1, matriz2));           
                break;
                case 4:
                    System.out.println("Función no disponible.");
                break;
                default:
                    
                break;
            }
            System.out.println("Desea salir? (1/0)");
            salir = elegirOperacion.nextInt();
        }       
    }  
}

