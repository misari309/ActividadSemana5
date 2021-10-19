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
public class FuncionarioCombo2 extends Funcionario{
    private static FuncionarioCombo2 FuncionarioC2;
    
    private FuncionarioCombo2 () {
        
    }
    
    public static FuncionarioCombo2 getInstance() {
        if (FuncionarioC2 == null) {
            FuncionarioC2 = new FuncionarioCombo2();
            FuncionarioC2.setNombre("Gilberto Antonio");
            FuncionarioC2.setCodigo(6);
            FuncionarioC2.setPrecioAuto(100);
            FuncionarioC2.setPrecioCamioneta(130);
            FuncionarioC2.setNombreFuncion("Combo 2");
        }
        return FuncionarioC2;
    }
    
    @Override
    public void realizarServicio() {
        System.out.println("Realizando combo 2...\n" + "Realizando combo 1... \n" + "Finalizando combo 2...\n" + "Servicio Realizado"); 
    }
}
