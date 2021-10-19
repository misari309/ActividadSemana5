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
public class Funcionario {
    private String nombre;
    private String nombreFuncion;

    public String getNombreFuncion() {
        return nombreFuncion;
    }

    public void setNombreFuncion(String nombreFuncion) {
        this.nombreFuncion = nombreFuncion;
    }
    private int codigo;
    private float precioAuto;
    private float precioCamioneta;

    public float getPrecioAuto() {
        return precioAuto;
    }

    public void setPrecioAuto(float precioAuto) {
        this.precioAuto = precioAuto;
    }

    public float getPrecioCamioneta() {
        return precioCamioneta;
    }

    public void setPrecioCamioneta(float precioCamioneta) {
        this.precioCamioneta = precioCamioneta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    public void realizarServicio() {
        System.out.println("Realizando servicio.");
    }
    
    public float getPrecio (String tipo) {
        if (tipo.equals("Auto")){
            return precioAuto;
        } else {
            return precioCamioneta;
        }
    }
}
