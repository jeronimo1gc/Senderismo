
import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author DAW
 */
public class GestionRuta {
    Statement stmt = null;
    public ArrayList<Ruta> findPoblacion(String poblacion){
       ArrayList<Ruta> resultadoRutas = new ArrayList();
    
        try {
            stmt = Conexion.conexion.createStatement();
        } catch (SQLException ex) {
            System.out.print("Error de conexion");           
        }       
       
       String sql = "SELECT *"+ "FROM Ruta "+ "where(poblacion like '%"+poblacion+"%')";
       try {                
        ResultSet rs = stmt.executeQuery(sql);
          while (rs.next()) 
           {
                int id_ruta = rs.getInt("id_ruta");
                String nombreRuta = rs.getString("nombreRuta");
                String poblacionRuta = rs.getString("poblacion");
                int recorrido = rs.getInt("recorrido");
                int desnivel  = rs.getInt("poblacion");
                int tiempo  = rs.getInt("tiempo");
                String dificultad =  rs.getString("dificultad");
                Blob imagen = rs.getBlob("imagen");
                Ruta ruta = new Ruta (id_ruta, nombreRuta, poblacionRuta, 
                recorrido, desnivel, tiempo, dificultad, imagen );
                resultadoRutas.add(ruta);
            }
   
                  

        }catch (Exception e) {
            System.out.print("Error, no se pueden mostrar las rutas");
            System.out.print(sql);
            e.printStackTrace();
        }
       return resultadoRutas;
   } 
}
