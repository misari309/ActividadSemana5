/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Modelo.Funcionarios.FuncionarioCombo1;
import Modelo.Funcionarios.FuncionarioCombo2;
import Modelo.Funcionarios.FuncionarioCombo3;
import Modelo.Funcionarios.FuncionarioDesinfeccionAvanzada;
import Modelo.Funcionarios.FuncionarioDesinfeccionBasica;
import Modelo.Funcionarios.FuncionarioLavadoBasico;
import Modelo.Funcionarios.FuncionarioLavadoEspecial;
import static java.lang.String.valueOf;
import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;

/**
 *
 * @author camil
 */
public class CentroDeLavado {
    
    public static ArrayList<Registro> lista_registros = new ArrayList<>();

    public void agregarRegistro(Registro registro) {
        lista_registros.add(registro);
    }
    
    public static String fecha() {
        Date fecha = new Date();
        SimpleDateFormat formatofecha = new SimpleDateFormat("dd/MM/YYYY");
        return formatofecha.format(fecha);
    }

    public Vehiculo crearVehiculo(String marca, String linea, String agnio, int codigo, String tipo) {

        Vehiculo vehiculo_aux = new Vehiculo();
        vehiculo_aux.setMarca(marca);
        vehiculo_aux.setLinea(linea);
        vehiculo_aux.setAgnio(agnio);
        vehiculo_aux.setCodigo(codigo);
        vehiculo_aux.setTipo(tipo);

        return vehiculo_aux;
    }
    
    public Registro crearRegistro (String servicios, String fecha, float precio, Vehiculo vehiculo_aux, String funcionario) {
        
        Registro registro_aux = new Registro();
        registro_aux.setServicios(servicios);
        registro_aux.setFecha(fecha);
        registro_aux.setPrecio(precio);
        registro_aux.setVehiculo(vehiculo_aux);
        registro_aux.setFuncionario(funcionario);
        
        return registro_aux;
    }
    
    public float establecerPrecio (String tipo, String servicio) {
        
        float precio = 0;
        if (tipo.equals("Auto")) {
            if (servicio.equals(FuncionarioDesinfeccionAvanzada.getInstance().getNombreFuncion())) {
                precio = FuncionarioDesinfeccionAvanzada.getInstance().getPrecioAuto();
            } else {
                if (servicio.equals(FuncionarioDesinfeccionBasica.getInstance().getNombreFuncion())) {
                    precio = FuncionarioDesinfeccionBasica.getInstance().getPrecioAuto();
                } else {
                    if (servicio.equals(FuncionarioLavadoBasico.getInstance().getNombreFuncion())) {
                        precio = FuncionarioLavadoBasico.getInstance().getPrecioAuto();
                    } else {
                        if (servicio.equals(FuncionarioCombo1.getInstance().getNombreFuncion())) {
                            precio = FuncionarioCombo1.getInstance().getPrecioAuto();
                        } else {
                            if (servicio.equals(FuncionarioCombo2.getInstance().getNombreFuncion())) {
                                precio = FuncionarioCombo2.getInstance().getPrecioAuto();
                            } else {
                                if (servicio.equals(FuncionarioCombo3.getInstance().getNombreFuncion())) {
                                    precio = FuncionarioCombo3.getInstance().getPrecioAuto();
                                } else {
                                    precio = FuncionarioLavadoEspecial.getInstance().getPrecioAuto();
                                }
                            }
                        }
                    }
                }
            }
        } else {
            if (servicio.equals(FuncionarioDesinfeccionAvanzada.getInstance().getNombreFuncion())) {
                precio = FuncionarioDesinfeccionAvanzada.getInstance().getPrecioCamioneta();
            } else {
                if (servicio.equals(FuncionarioDesinfeccionBasica.getInstance().getNombreFuncion())) {
                    precio = FuncionarioDesinfeccionBasica.getInstance().getPrecioCamioneta();
                } else {
                    if (servicio.equals(FuncionarioLavadoBasico.getInstance().getNombreFuncion())) {
                        precio = FuncionarioLavadoBasico.getInstance().getPrecioCamioneta();
                    } else {
                        if (servicio.equals(FuncionarioCombo1.getInstance().getNombreFuncion())) {
                            precio = FuncionarioCombo1.getInstance().getPrecioCamioneta();
                        } else {
                            if (servicio.equals(FuncionarioCombo2.getInstance().getNombreFuncion())) {
                                precio = FuncionarioCombo2.getInstance().getPrecioCamioneta();
                            } else {
                                if (servicio.equals(FuncionarioCombo3.getInstance().getNombreFuncion())) {
                                    precio = FuncionarioCombo3.getInstance().getPrecioCamioneta();
                                } else {
                                    precio = FuncionarioLavadoEspecial.getInstance().getPrecioCamioneta();
                                }
                            }
                        }
                    }
                }
            }
        }
        return precio;
        
    }
    
    public String getNombreFuncionario(String servicio){
        String nombre;
        if (servicio.equals(FuncionarioDesinfeccionAvanzada.getInstance().getNombreFuncion())) {
            nombre = FuncionarioDesinfeccionAvanzada.getInstance().getNombre();
        } else {
            if (servicio.equals(FuncionarioDesinfeccionBasica.getInstance().getNombreFuncion())) {
                nombre = FuncionarioDesinfeccionBasica.getInstance().getNombre();
            } else {
                if (servicio.equals(FuncionarioLavadoBasico.getInstance().getNombreFuncion())) {
                    nombre = FuncionarioLavadoBasico.getInstance().getNombre();
                } else {
                    if (servicio.equals(FuncionarioCombo1.getInstance().getNombreFuncion())) {
                        nombre = FuncionarioCombo1.getInstance().getNombre();
                    } else {
                        if (servicio.equals(FuncionarioCombo2.getInstance().getNombreFuncion())) {
                            nombre = FuncionarioCombo2.getInstance().getNombre();
                        } else {
                            if (servicio.equals(FuncionarioCombo3.getInstance().getNombreFuncion())) {
                                nombre = FuncionarioCombo3.getInstance().getNombre();
                            } else {
                                nombre = FuncionarioLavadoEspecial.getInstance().getNombre();
                            }
                        }
                    }
                }
            }
        }
        return nombre;
    }
    
    public String[][] rellenarTabla() {
        String matriz[][] = new String[lista_registros.size()][10];
        for(int i=0; i<lista_registros.size();i++){
            matriz[i][0]=valueOf(lista_registros.get(i).getFecha());
            matriz[i][1]=valueOf(lista_registros.get(i).getServicios());
            matriz[i][2]=valueOf(lista_registros.get(i).getFuncionario());
            matriz[i][3]=valueOf(lista_registros.get(i).getVehiculo().getCodigo());
            matriz[i][4]=valueOf(lista_registros.get(i).getVehiculo().getMarca());
            matriz[i][5]=valueOf(lista_registros.get(i).getVehiculo().getLinea());
            matriz[i][6]=valueOf(lista_registros.get(i).getVehiculo().getAgnio());
            matriz[i][7]=valueOf(lista_registros.get(i).getPrecio());
        }
        return matriz;
        
    }
    
    public void realizarServicio(String servicio){

        if (servicio.equals(FuncionarioDesinfeccionAvanzada.getInstance().getNombreFuncion())) {
            FuncionarioDesinfeccionAvanzada.getInstance().realizarServicio();
        } else {
            if (servicio.equals(FuncionarioDesinfeccionBasica.getInstance().getNombreFuncion())) {
                FuncionarioDesinfeccionBasica.getInstance().realizarServicio();
            } else {
                if (servicio.equals(FuncionarioLavadoBasico.getInstance().getNombreFuncion())) {
                    FuncionarioLavadoBasico.getInstance().realizarServicio();
                } else {
                    if (servicio.equals(FuncionarioCombo1.getInstance().getNombreFuncion())) {
                        FuncionarioCombo1.getInstance().realizarServicio();
                    } else {
                        if (servicio.equals(FuncionarioCombo2.getInstance().getNombreFuncion())) {
                            FuncionarioCombo2.getInstance().realizarServicio();
                        } else {
                            if (servicio.equals(FuncionarioCombo3.getInstance().getNombreFuncion())) {
                                FuncionarioCombo3.getInstance().realizarServicio();
                            } else {
                                FuncionarioLavadoEspecial.getInstance().realizarServicio();
                            }
                        }
                    }
                }
            }
        }

    }
    
    
    

}
