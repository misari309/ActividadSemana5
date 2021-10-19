/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Modelo.Funcionarios.Funcionario;
import java.util.Date;

/**
 *
 * @author camil
 */
public class Registro {
    private String servicios;
    private String fecha;
    private float precio;
    private Vehiculo vehiculo;
    private String funcionario;

    public String getServicios() {
        return servicios;
    }

    public void setServicios(String servicios) {
        this.servicios = servicios;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }
    
    public void setFuncionario(String funcionario) {
        this.funcionario = funcionario;
    }
    
    public String getFuncionario() {
        return funcionario;
    }
}
