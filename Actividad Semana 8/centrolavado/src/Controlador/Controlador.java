/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.CentroDeLavado;
import Modelo.Registro;
import Modelo.Vehiculo;
import Vista.Principal_frame;
import Vista.Registros_frame;
import Vista.Servicios_frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.String.valueOf;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;


/**
 *
 * @author camil
 */
public class Controlador implements ActionListener{
    private final Registros_frame registros_frame;
    private final Servicios_frame servicios_frame;
    private final CentroDeLavado centrodelavado_model;
    private final Principal_frame principal_frame;
    
    public Controlador (Registros_frame registros_frame, Servicios_frame servicios_frame, CentroDeLavado centrodelavado_model, Principal_frame principal_frame) {
        this.registros_frame = registros_frame;
        this.servicios_frame = servicios_frame;
        this.centrodelavado_model = centrodelavado_model;
        this.principal_frame = principal_frame;
        this.servicios_frame.btnAceptarPeticion.addActionListener((ActionEvent e) -> {
            enviarSolicitudServicio();
            limpiarCasillas();
            rellenarTabla();
        });
        this.principal_frame.btn_iniciar_servicio.addActionListener((ActionEvent e) -> {
            iniciarServicios();
        });
        this.principal_frame.btn_iniciar_registros.addActionListener((ActionEvent e) -> {
            iniciarRegistros();
        });
        
    }    
    
    public void iniciarPrincipal_frame () {
        principal_frame.setVisible(true);
        registros_frame.setResizable(false);
    }
    
    public void iniciarServicios(){
        servicios_frame.setVisible(true);
        registros_frame.setResizable(false);
    }
    
    public void iniciarRegistros(){
        registros_frame.setVisible(true);
        registros_frame.setResizable(false);
    }
  
    public void enviarSolicitudServicio() {
        try {
            Vehiculo vehiculo = centrodelavado_model.crearVehiculo(servicios_frame.txtMarca.getText(), 
                                           servicios_frame.txtLinea.getText(), 
                                           servicios_frame.txtAgnio.getText(), 
                                           Integer.parseInt(servicios_frame.txtCodigo.getText()), 
                                           valueOf(servicios_frame.comboBoxTipo.getSelectedItem()));
        
            String servicio = valueOf(servicios_frame.comboBox_servicio.getSelectedItem());
            String tipo = valueOf(servicios_frame.comboBoxTipo.getSelectedItem());
            float precio = centrodelavado_model.establecerPrecio(tipo, servicio);
            String funcionario = centrodelavado_model.getNombreFuncionario(servicio);
            String fecha1 = centrodelavado_model.fecha();
            Registro registro = centrodelavado_model.crearRegistro(servicio, fecha1, precio, vehiculo, funcionario);
            centrodelavado_model.agregarRegistro(registro);
            System.out.println("Enviando solicitud de servicio...");
            System.out.println("Agregando vehiculo...\n");
            System.out.println("Vehiculo: " + vehiculo.getMarca() + " " + vehiculo.getLinea() + " " + vehiculo.getAgnio() + " " + tipo + "\n");
            System.out.println("Asignando funcionario de servicio...\n");
            System.out.println("Servicio: " + servicio);
            System.out.println("Funcionario asignado: " + centrodelavado_model.getNombreFuncionario(servicio));
            centrodelavado_model.realizarServicio(servicio);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Rellene todos los campos. ");
	}
        
    }
    
    public void rellenarTabla(){
        String matriz [][] = centrodelavado_model.rellenarTabla();
        registros_frame.table_registros.setModel(new javax.swing.table.DefaultTableModel(
            matriz,
            new String [] {
                "Fecha", "Servicio", "Funcionario", "Código", "Marca", "Linea", "Año", "Precio"
            } 
            
        ){
            
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            };
            
        });
        
        TableRowSorter<TableModel> elQueOrdena = new TableRowSorter<>(
        new javax.swing.table.DefaultTableModel(
            matriz,
            new String [] {
                "Fecha", "Servicio", "Funcionario", "Código", "Marca", "Linea", "Año", "Precio"
            } 
            
        ){
            
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            };
            
        }
        );
        registros_frame.table_registros.setRowSorter(elQueOrdena);
    }
    
    public void limpiarCasillas(){
        servicios_frame.txtMarca.setText("");
        servicios_frame.txtLinea.setText("");
        servicios_frame.txtAgnio.setText("");
        servicios_frame.txtCodigo.setText("");  
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
