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
public class Pacientes extends Persona {


   private String lugar_atencion;
   private String motivo_atencion;
   private String medico_atencion;
   private String fecha;

    public String getLugar_atencion() {
        return lugar_atencion;
    }

    public void setLugar_atencion(String lugar_atencion) {
        this.lugar_atencion = lugar_atencion;
    }

    public String getMotivo_atencion() {
        return motivo_atencion;
    }

    public void setMotivo_atencion(String motivo_atencion) {
        this.motivo_atencion = motivo_atencion;
    }

    public String getMedico_atencion() {
        return medico_atencion;
    }

    public void setMedico_atencion(String medico_atencion) {
        this.medico_atencion = medico_atencion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    void add(Pacientes paciente_aux_1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
