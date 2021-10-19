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
public class FuncionarioCombo3 extends Funcionario {
    private static FuncionarioCombo3 FuncionarioC3;
    
    private FuncionarioCombo3 () {
        
    }
    
    public static FuncionarioCombo3 getInstance() {
        if (FuncionarioC3 == null) {
            FuncionarioC3 = new FuncionarioCombo3();
            FuncionarioC3.setNombre("Raul Alvarez");
            FuncionarioC3.setCodigo(7);
            FuncionarioC3.setPrecioAuto(130);
            FuncionarioC3.setPrecioCamioneta(150);
            FuncionarioC3.setNombreFuncion("Combo 3");
        }
        return FuncionarioC3;
    }
    
    @Override
    public void realizarServicio() {
        System.out.println("Realizando combo 3...\n" + "Realizando combo 2... \n" + "Realizando combo 1...\n" + "Finalizando combo 2...\n" + "Finalizando combo 3...\n" + "Servicio Realizado"); 
    }
}
