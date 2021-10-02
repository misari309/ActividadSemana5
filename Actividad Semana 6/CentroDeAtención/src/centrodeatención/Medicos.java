/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package centrodeatención;

/**
 *
 * @author camil
 */
public class Medicos extends Persona {
    private String centro;
    
    public void setCentro(String centro){
        this.centro = centro;
    }
    public String getCentro(){
        return centro;
    }
}
