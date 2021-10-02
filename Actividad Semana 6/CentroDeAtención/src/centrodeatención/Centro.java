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
public class Centro {
    private String nombre;
    private int codigo;
    private String direccion;

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
    
   
}
