/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package centrolavado;

import Controlador.Controlador;
import Modelo.CentroDeLavado;
import Modelo.Funcionarios.FuncionarioDesinfeccionAvanzada;
import Vista.*;

/**
 *
 * @author camil
 */
public class Centrolavado {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        CentroDeLavado centrodelavado_model = new CentroDeLavado();
        Servicios_frame servicios_frame = new Servicios_frame();
        Registros_frame registros_frame = new Registros_frame();
        Principal_frame principal_frame = new Principal_frame();
        
        Controlador controlador = new Controlador(registros_frame, servicios_frame, centrodelavado_model, principal_frame);
        
        controlador.iniciarPrincipal_frame();


    }
    
}
