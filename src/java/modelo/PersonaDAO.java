package modelo;

import config.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Candy Nohemi
 */
public class PersonaDAO {
    private PreparedStatement pstm;
    private ResultSet rs;
    private String query = "";
     
    public List<Persona> lista() {
        List<Persona> personas = new ArrayList<>();
        query = "SELECT * FROM users;";

        try {
            pstm = Conexion.StartCon().prepareStatement(query);
            rs = pstm.executeQuery();

            while (rs.next()) {
                Persona persona = new Persona();

                persona.setId(rs.getInt(1));
                persona.setNombre(rs.getString(2));
                persona.setApellido(rs.getString(3));
                personas.add(persona);
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e);
        }
        return personas;
    }
    
    public int Agregar(Persona p){
        int r = 0;
        query = "insert into users(nombre, apellido) values (?, ?)";
        try{
            pstm = Conexion.StartCon().prepareStatement(query);
            pstm.setString(1,p.getNombre());
            pstm.setString(2, p.getApellido());
            r = pstm.executeUpdate();
        }catch(SQLException e){
            System.err.println("No se agrego cliente "+e.toString());
        }
        return r;
    }
    
    public int Actualizar(Persona p){
        int r = 0;
        query = "update users set nombre=?, apellido=? where id=?";
        try{
            pstm = Conexion.StartCon().prepareStatement(query);
            pstm.setString(1, p.getNombre());
            pstm.setString(2, p.getApellido());
            pstm.setInt(3, p.getId());
            r = pstm.executeUpdate();
        }catch(SQLException e){
            System.out.println("No se actualizo cliente "+e.toString());
        }
        return r;
    }
    
    public int Delete(int id){
        int r = 0;
        query = "DELETE FROM users WHERE id=?";
        try{
            pstm = Conexion.StartCon().prepareStatement(query);
            pstm.setInt(1, id);
            r = pstm.executeUpdate();
        }catch(SQLException e){
            System.err.println("No se borro cliente "+e.toString());
        }
        return r;
    }
    
    public List<Persona> buscar(int id) {
        String sql = "SELECT * FROM users WHERE id=?";
        List<Persona> personas = new ArrayList<>();

        try {
            pstm = Conexion.StartCon().prepareStatement(sql);

            pstm.setInt(1, id);
            rs = pstm.executeQuery();

            while (rs.next()) {
                Persona persona = new Persona();

                persona.setId(rs.getInt(1));
                persona.setNombre(rs.getString(2));
                persona.setApellido(rs.getString(3));
                personas.add(persona);
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e);
        }
        return personas;
    }
}