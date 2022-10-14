/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Santiago
 */
public class Conexion {
    String url = "jdbc:oracle:thin:@localhost:1521:xe";
    // --- El usuario y contraseña es el creado en el oracle con acceso a una base datos. 
    String user = "EJEMPLOCRUD";
    String pass = "EJEMPLOCRUD";
    
    Connection con; //Conectarnos con la bd
    Statement st; //Establce la conexion
    ResultSet rs; //Resultados de las consultas
    PreparedStatement ps; //Enviar consultas
    
    public void Conectar() {
        try {
            //--- Utilizamos el driver de jdbc
            Class.forName("oracle.jdbc.driver.OracleDriver");
            try {
                //--- Establecemos conexion y mandamos los parametros
                con = DriverManager.getConnection(url, user, pass);
                System.out.println("Se conecto");
            } catch (SQLException ex) {
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ArrayList listar_usuarios() throws SQLException {
        ArrayList<Usuario> lista = new ArrayList<>();
        st = con.createStatement();
        String consulta = "SELECT * FROM USUARIO";
        rs = st.executeQuery(consulta);
        while (rs.next()) {
            Usuario persona = new Usuario();
                persona.setId(rs.getInt(1));
                persona.setNombre(rs.getString(2));
                persona.setApellidos(rs.getString(3));
                persona.setEdad(rs.getInt(4));
                persona.setTelefono(rs.getString(5));
                persona.setCorreo(rs.getString(6));
                System.out.println(persona.toString());
                lista.add(persona);
        }
        return lista;
    }
    
    public int agregar(Usuario p){
        int r = 0;
        String sql = "INSERT INTO USUARIO(ID, NOMBRE, APELLIDOS ,EDAD, TELEFONO,CORREO) VALUES (?,?,?,?,?,?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, p.getId());
            ps.setString(2, p.getNombre());
            ps.setString(3, p.getApellidos());
            ps.setInt(4, p.getEdad());
            ps.setString(5, p.getTelefono());
            ps.setString(6, p.getCorreo());
            r = ps.executeUpdate(); //Ejecuta la consulta.
            if (r==1){
                r=1;
            } else{
                r = 0;
            }
        } catch (Exception e) {
        }
        return r;
    }
    
    
    public Usuario listarId(int id){
        String sql = "SELECT * FROM USUARIO WHERE ID="+id;
        Usuario u = new Usuario();
        try{
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                u.setId(rs.getInt(1));
                u.setNombre(rs.getString(2));
                u.setApellidos(rs.getString(3));
                u.setEdad(rs.getInt(4));
                u.setTelefono(rs.getString(5));
                u.setCorreo(rs.getString(6));
            }
            
        } catch (Exception e){
            System.out.println("Error al buscar por id");
        }
        return u;
    }
    public void actualizar (Usuario usuario){
        String sql = "UPDATE USUARIO SET NOMBRE=?, APELLIDOS=?, EDAD=?, CORREO=?, TELEFONO=? WHERE ID = ?";
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getApellidos());
            ps.setInt(3, usuario.getEdad());
            ps.setString(4, usuario.getCorreo());
            ps.setString(5, usuario.getTelefono());
            ps.setInt(6, usuario.getId());
            ps.executeUpdate();
            
        } catch(Exception e){
            System.out.println("Error al modificar el usuario.");
        }
    }
    public void eliminar (int id){
        String sql = "DELETE FROM USUARIO WHERE ID="+id;
        try{
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        }catch(Exception e){
            System.out.println("Error al eliminar la persona de la BD.");
        }
    }
}
