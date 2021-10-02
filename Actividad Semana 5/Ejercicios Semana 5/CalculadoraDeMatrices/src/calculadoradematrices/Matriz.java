/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadoradematrices;

import java.util.Scanner;

/**
 *
 * @author camil
 */
public class Matriz {
    private int columnas;
    private int filas;
    int [][] matriz;
    
    public void setColumnas(int columnas){
        this.columnas = columnas;
    }
    
    public void setFilas(int filas){
        this.filas = filas;
    }
    
    public int getColumnas(){
        return this.columnas;
    }
    
    public int getFilas(){
        return this.filas;
    }
    

    
    public void rellenarMatriz(){
        Scanner leerValor = new Scanner(System.in);
        for(int i=0; i<=columnas; i++){
            for(int j=0;j<=filas; j++){
                int valor = 0;
                System.out.println("Digite un valor para la fila " + i + " y la columna " + j + ": ");
                valor = leerValor.nextInt();         
                matriz[i][j] = valor;
            }
        }
    }
    
    public void rellenarMatrizRandom(){
        matriz = new int[columnas][filas];
        for(int i=0; i<columnas; i++){
            for(int j=0;j<filas; j++){ 
                matriz[i][j] = (int) (Math.random()*50+1);
            }
        }
    }
    
    public int [][] getMatriz(){
        return this.matriz;
    }
    
    public void imprimirMatriz(){
        System.out.println();
        for(int i=0; i<columnas; i++){
            for(int j=0; j<filas; j++){  
                System.out.print(matriz[i][j] + "       ");
            }
            System.out.println();
        }
    }
}
