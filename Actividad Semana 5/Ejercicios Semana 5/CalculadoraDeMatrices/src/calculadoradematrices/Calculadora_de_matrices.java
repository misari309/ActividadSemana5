/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadoradematrices;

/**
 *
 * @author camil
 */
public class Calculadora_de_matrices extends Matriz{
    private int matrizR[][];
    
    public void suma(Matriz matriz1, Matriz matriz2){
        matrizR = new int [matriz1.getColumnas()][matriz1.getFilas()];
        for(int i=0; i<matriz1.getColumnas();i++){
            for(int j=0; j<matriz1.getFilas();j++){
                matrizR[i][j] = matriz1.getMatriz()[i][j]+matriz2.getMatriz()[i][j];
            }
        }
    }
    public void resta(Matriz matriz1, Matriz matriz2){
        matrizR = new int [matriz1.getColumnas()][matriz1.getFilas()];
        for(int i=0; i<matriz1.getColumnas();i++){
            for(int j=0; j<matriz1.getFilas();j++){
                matrizR[i][j] = matriz1.getMatriz()[i][j]-matriz2.getMatriz()[i][j];
            }
        }
    }

    public void imprimirMatrizR(Matriz matriz1){
        System.out.println();
        for(int i=0; i<matriz1.getColumnas(); i++){
            for(int j=0; j<matriz1.getFilas(); j++){  
                System.out.print(matrizR[i][j] + "       ");
            }
            System.out.println();
        }
    }
    
    public int traza(Matriz matriz1, Matriz matriz2){
        int traza1 = 0, traza2 = 0, trazaT;
        matrizR = new int [matriz1.getColumnas()][matriz1.getFilas()];
        for(int i=0; i<matriz1.getColumnas();i++){
            for(int j=0; j<matriz1.getFilas();j++){
                if(i == j){
                    traza1 = traza1 + matriz1.getMatriz()[i][j];
                    traza2 = traza2 + matriz2.getMatriz()[i][j];
                }
            }
        }
        trazaT = traza1 + traza2;
        return trazaT;
    }
    public void determinante(){
        //hace falta esta operación
    }
}

