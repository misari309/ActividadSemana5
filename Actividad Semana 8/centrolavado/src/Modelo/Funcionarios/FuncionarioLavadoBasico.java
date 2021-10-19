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
public class FuncionarioLavadoBasico extends Funcionario {
    private static FuncionarioLavadoBasico FuncionarioLB;
    
    private FuncionarioLavadoBasico () {
        
    }
    
    public static FuncionarioLavadoBasico getInstance() {
        if (FuncionarioLB == null) {
            FuncionarioLB = new FuncionarioLavadoBasico();
            FuncionarioLB.setNombre("Andres Gutierrez");
            FuncionarioLB.setCodigo(3);
            FuncionarioLB.setPrecioAuto(60);
            FuncionarioLB.setPrecioCamioneta(80);
            FuncionarioLB.setNombreFuncion("Lavado básico");
        }
        return FuncionarioLB;
    }
    
    @Override
    public void realizarServicio() {
        System.out.println("Realizando lavado básico..."
                + "\n Servicio realizado.");
    }
}
