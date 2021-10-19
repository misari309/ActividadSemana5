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
public class FuncionarioCombo1 extends Funcionario {
    private static FuncionarioCombo1 FuncionarioC1;
    
    private FuncionarioCombo1 () {
        
    }
    
    public static FuncionarioCombo1 getInstance() {
        if (FuncionarioC1 == null) {
            FuncionarioC1 = new FuncionarioCombo1();
            FuncionarioC1.setNombre("Felipe Rodriguez");
            FuncionarioC1.setCodigo(5);
            FuncionarioC1.setPrecioAuto(75);
            FuncionarioC1.setPrecioCamioneta(90);
            FuncionarioC1.setNombreFuncion("Combo 1");
        }
        return FuncionarioC1;
    }
    
    @Override
    public void realizarServicio() {
        System.out.println("Realizando combo 1..."
                + "\n Servicio realizado.");
    }
}
