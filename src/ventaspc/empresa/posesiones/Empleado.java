/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ventaspc.empresa.posesiones;

/**
 *
 * @author Ivan
 */
public class Empleado implements java.io.Serializable{
    private String usuario;
    private String contrasena;
    private String puesto;
    
    public Empleado(String usuario, String contrasena, String puesto){
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.puesto = puesto;
    }
    
    public String getUsuario(){
        return this.usuario;
    }
    
    public String getContrasena(){
        return this.contrasena;
    }
    
    public String getPuesto(){
        return this.puesto;
    }
}
