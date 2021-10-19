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
public class FuncionarioLavadoEspecial extends Funcionario {
    private static FuncionarioLavadoEspecial FuncionarioLE;
    
    private FuncionarioLavadoEspecial () {
        
    }
    
    public static FuncionarioLavadoEspecial getInstance() {
        if (FuncionarioLE == null) {
            FuncionarioLE = new FuncionarioLavadoEspecial();
            FuncionarioLE.setNombre("Steven Jimenez");
            FuncionarioLE.setCodigo(4);
            FuncionarioLE.setPrecioAuto(100);
            FuncionarioLE.setPrecioCamioneta(120);
            FuncionarioLE.setNombreFuncion("Lavado especial");
        }
        return FuncionarioLE;
   }

    @Override
    public void realizarServicio() {
        System.out.println("Realizando lavado especial..."
                + "\n Servicio realizado.\n");
    }
}
