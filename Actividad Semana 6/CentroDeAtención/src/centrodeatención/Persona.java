/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package centrodeatención;

import static java.lang.String.valueOf;

/**
 *
 * @author camil
 */
public class Persona{
    private String nombres;
    private String apellidos;
    private int codigo;
    private String direccion_residencia;
    private String sexo;

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getCodigoInt() {
        return codigo;
    }
    public String getCodigoString(){
        return valueOf(codigo);
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDireccion_residencia() {
        return direccion_residencia;
    }

    public void setDireccion_residencia(String direccion_residencia) {
        this.direccion_residencia = direccion_residencia;
    }
    
}
