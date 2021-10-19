/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Funcionarios;

/**
 *
 * @author camil
 */
public class FuncionarioDesinfeccionAvanzada extends Funcionario {
    
    private static FuncionarioDesinfeccionAvanzada FuncionarioDA;
    
    private FuncionarioDesinfeccionAvanzada () {
        
    }
    
    public static FuncionarioDesinfeccionAvanzada getInstance() {
        if (FuncionarioDA == null) {
            FuncionarioDA = new FuncionarioDesinfeccionAvanzada();
            FuncionarioDA.setNombre("Juan Martinez");
            FuncionarioDA.setCodigo(1);
            FuncionarioDA.setPrecioAuto(80);
            FuncionarioDA.setPrecioCamioneta(100);
            FuncionarioDA.setNombreFuncion("Desinfección avanzada");
        }
        return FuncionarioDA;
    }
    
    @Override
    public void realizarServicio() {
        System.out.println("Realizando desinfección avanzada..."
                + "\n Servicio realizado.\n");
    }
    
}
