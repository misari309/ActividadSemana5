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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import static java.lang.String.valueOf;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
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
    TableRowSorter trs;
    
    public Controlador (Registros_frame registros_frame, Servicios_frame servicios_frame, CentroDeLavado centrodelavado_model, Principal_frame principal_frame) {
        this.registros_frame = registros_frame;
        this.servicios_frame = servicios_frame;
        this.centrodelavado_model = centrodelavado_model;
        this.principal_frame = principal_frame;
        this.servicios_frame.btnAceptarPeticion.addActionListener((ActionEvent e) -> {
            enviarSolicitudServicio();
            limpiarCasillas();
            rellenarTabla();
            rellenarTablaBusqueda(registros_frame.txt_buscar_funcionario.getText());
        });
        this.principal_frame.btn_iniciar_servicio.addActionListener((ActionEvent e) -> {
            iniciarServicios();
        });
        this.principal_frame.btn_iniciar_registros.addActionListener((ActionEvent e) -> {
            iniciarRegistros();
        });
        this.registros_frame.btn_buscar_funcionario.addActionListener((ActionEvent e) -> {
            cambiarBuscador(registros_frame.txt_buscar_funcionario.getText());
            rellenarTablaBusqueda(registros_frame.buscador.getText());
        });
        this.registros_frame.btn_buscar_fecha.addActionListener((ActionEvent e) -> {
            cambiarBuscador(registros_frame.txt_buscar_fecha.getText());
            rellenarTablaBusqueda(registros_frame.buscador.getText());
        });
        this.registros_frame.btn_buscar_servicio.addActionListener((ActionEvent e) -> {
            cambiarBuscador(registros_frame.txt_buscar_servicio.getText());
            rellenarTablaBusqueda(registros_frame.buscador.getText());
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
        String matriz[][] = new String[centrodelavado_model.getListaRegistros().size()][10];
        for(int i=0; i<centrodelavado_model.getListaRegistros().size();i++){
            matriz[i][0]=valueOf(centrodelavado_model.getListaRegistros().get(i).getFecha());
            matriz[i][1]=valueOf(centrodelavado_model.getListaRegistros().get(i).getServicios());
            matriz[i][2]=valueOf(centrodelavado_model.getListaRegistros().get(i).getFuncionario());
            matriz[i][3]=valueOf(centrodelavado_model.getListaRegistros().get(i).getVehiculo().getCodigo());
            matriz[i][4]=valueOf(centrodelavado_model.getListaRegistros().get(i).getVehiculo().getMarca());
            matriz[i][5]=valueOf(centrodelavado_model.getListaRegistros().get(i).getVehiculo().getLinea());
            matriz[i][6]=valueOf(centrodelavado_model.getListaRegistros().get(i).getVehiculo().getAgnio());
            matriz[i][7]=valueOf(centrodelavado_model.getListaRegistros().get(i).getPrecio());
        }
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
    
    public void cambiarBuscador(String buscador){
        registros_frame.buscador.setText(buscador);
    }
    
    public void rellenarTablaBusqueda(String busqueda){
        ArrayList<Registro> lista_busqueda = centrodelavado_model.getListaBusquedaFuncionario(busqueda);
                
        String matriz[][] = new String[lista_busqueda.size()][10];
        for(int i=0; i<lista_busqueda.size();i++){
            matriz[i][0]=valueOf(lista_busqueda.get(i).getFecha());
            matriz[i][1]=valueOf(lista_busqueda.get(i).getServicios());
            matriz[i][2]=valueOf(lista_busqueda.get(i).getFuncionario());
            matriz[i][3]=valueOf(lista_busqueda.get(i).getVehiculo().getCodigo());
            matriz[i][4]=valueOf(lista_busqueda.get(i).getVehiculo().getMarca());
            matriz[i][5]=valueOf(lista_busqueda.get(i).getVehiculo().getLinea());
            matriz[i][6]=valueOf(lista_busqueda.get(i).getVehiculo().getAgnio());
            matriz[i][7]=valueOf(lista_busqueda.get(i).getPrecio());
        }
        registros_frame.table_registros1.setModel(new javax.swing.table.DefaultTableModel(
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
        registros_frame.table_registros1.setRowSorter(elQueOrdena);
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
