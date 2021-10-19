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
public class FuncionarioDesinfeccionBasica extends Funcionario {
    private static FuncionarioDesinfeccionBasica FuncionarioDB;
    
    private FuncionarioDesinfeccionBasica () {
        
    }
    
    public static FuncionarioDesinfeccionBasica getInstance() {
        if (FuncionarioDB == null) {
            FuncionarioDB = new FuncionarioDesinfeccionBasica();
            FuncionarioDB.setNombre("Pedro Castillo");
            FuncionarioDB.setCodigo(2);
            FuncionarioDB.setPrecioAuto(50);
            FuncionarioDB.setPrecioCamioneta(70);
            FuncionarioDB.setNombreFuncion("Desinfección básica");
        }
        return FuncionarioDB;
    }
    
    @Override
    public void realizarServicio() {
        System.out.println("Realizando desinfección básica..."
                + "\n Servicio realizado.\n");
    }
}
