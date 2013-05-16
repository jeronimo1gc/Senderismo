
import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

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
       
       String sql = "SELECT *"+ "FROM ruta "+ "where(poblacion like '%"+poblacion+"%')";
       try {                
        ResultSet rs = stmt.executeQuery(sql);
          while (rs.next()) 
           {
                int id_ruta = rs.getInt("id_ruta");
                String nombreRuta = rs.getString("nombreRuta");
                String poblacionRuta = rs.getString("poblacion");
                int recorrido = rs.getInt("recorrido");
                int desnivel  = rs.getInt("desnivel");
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
     protected static ArrayList<Ruta> leerRutas() {
        ArrayList<Ruta> listaRutas = new ArrayList();
        ResultSet resultados = null;
        try {
            Statement sentenciaSQL = Conexion.conexion.createStatement();
            String textoSQL = "SELECT * FROM ruta ";
            
            
            resultados = sentenciaSQL.executeQuery(textoSQL);
            while (resultados.next()) {
                int id_ruta = resultados.getInt("id_ruta");
                String nombreRuta = resultados.getString("nombreRuta");
                String poblacion = resultados.getString("poblacion");
                int recorrido = resultados.getInt("recorrido");
                int desnivel = resultados.getInt("desnivel");
                int tiempo = resultados.getInt("tiempo");
                String dificultad = resultados.getString("dificultad");
                Blob imagen = resultados.getBlob("imagen");
                //Crear un objeto Contacto con los datos obtenidos
                Ruta ruta = new Ruta(
                        id_ruta, nombreRuta, poblacion,
           recorrido, desnivel, tiempo, dificultad, imagen );
                //Guardar el contacto en la lista que se retornará
                listaRutas.add(ruta);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "No se han podido leer los datos de contactos\n"
                    + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);;
            e.printStackTrace();
        }
        return listaRutas;
    }

    /**
     * Obtiene el contacto cuyo identificador coincide con el indicado por parámetro.
     * 
     * @param idContacto Identificador del contacto del que se quieren obtener los datos.
     * 
     * @return Objeto de tipo Contacto con todos los datos del contacto cuyo
     * identificador coincide con el indicado por parámetro. En caso de que no 
     * se encuentre ningún contacto con el identificador indicado retorna null.
     */
    protected static Ruta leerRuta(int id_ruta) {
        Ruta ruta = null;
        
        
        try {
            Statement sentenciaSQL = Conexion.conexion.createStatement();
            ResultSet resultados = sentenciaSQL.executeQuery(
                    "SELECT * FROM ruta WHERE id_ruta = " + id_ruta);
            if (resultados.next()) {
                int id_ruta1 = resultados.getInt("id_ruta");
                String nombreRuta1 = resultados.getString("nombreRuta");
                String poblacion1 = resultados.getString("poblacion");
                int recorrido1 = resultados.getInt("recorrido");
                int desnivel1 = resultados.getInt("desnivel");
                int tiempo1 = resultados.getInt("tiempo");
                String dificultad1 = resultados.getString("dificultad");
                Blob imagen1 = resultados.getBlob("imagen");
                //Crear un objeto Contacto con los datos obtenidos
                ruta = new Ruta(
                        id_ruta1, nombreRuta1, poblacion1,
           recorrido1, desnivel1, tiempo1, dificultad1, imagen1 );
                //Guardar el contacto en la lista que se retornará
                } 
            
            else {
                JOptionPane.showMessageDialog(null,
                        "No se ha encontrado el contacto en la base de datos",
                        "Error", JOptionPane.ERROR_MESSAGE);;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,
                    "No se han podido leer los datos del contacto\n"
                    + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);;
            e.printStackTrace();
        }
        return ruta;
    }

    /** 
     * Permite actualizar en la base de datos el contacto que se pase por 
     * parámetro, sustituyendo los datos del contacto cuyo identificador 
     * coincide con el del contacto pasado por parámetro.
     * 
     * @param contacto Objeto Contacto que contiene los datos que se van a
     * actualizar en la base de datos.
     */
    protected static void guardarContacto(Ruta ruta) {
        try {
            Statement sentenciaSQL = Conexion.conexion.createStatement();
            sentenciaSQL.executeUpdate("UPDATE ruta SET "
                    + "id_ruta = '" + ruta.getId_ruta() + "', "
                    + "nombreRuta = '" + ruta.getNombreRuta() + "', "
                    + "poblacion = '" + ruta.getPoblacion() + "', "
                    + "recorrido = '" + ruta.getRecorrido() + "', "
                    + "desnivel = '" + ruta.getDesnivel() + "' "
                    + "tiempo = '" + ruta.getTiempo() + "' "
                    + "dificultad = '" + ruta.getDificultad() + "' "
                    + "imagen = '" + ruta.getImagen() + "' "
                    + "WHERE id_ruta = " + ruta.getId_ruta());
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,
                    "No se han podido actualizar los datos del contacto\n"
                    + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);;
            e.printStackTrace();
        }
    }
    
    protected static void añadirContacto(Ruta ruta) {
        try {
            Statement sentenciaSQL = Conexion.conexion.createStatement();
            sentenciaSQL.executeUpdate("INSERT INTO ruta "
                    + "(id_ruta, nombreRuta, poblacion, recorrido, desnivel, tiempo, dificultad, imagen ) VALUES ("
                    + "'" + ruta.getId_ruta() + "', "
                    + "'" + ruta.getNombreRuta() + "', "
                    + "'" + ruta.getPoblacion() + "', "
                    + "'" + ruta.getRecorrido() + "')"
                    + "'" + ruta.getDesnivel() + "')"
                    + "'" + ruta.getTiempo() + "')"
                    + "'" + ruta.getDificultad() + "')"
                    + "'" + ruta.getImagen() + "')");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,
                    "No se han podido añadir los datos del nuevo contacto\n"
                    + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);;
            e.printStackTrace();
        }
    }
    
    /**
     * Suprime de la base de datos el contacto cuyo identificador coindice conç
     * el del contacto pasado por parámetro
     * 
     * @param contacto Objeto Contacto que contiene los datos del contacto que
     * se desea eliminar
     */
    protected static void suprimirContacto(Ruta ruta) {
        try {
            Statement sentenciaSQL = Conexion.conexion.createStatement();
            sentenciaSQL.executeUpdate("DELETE FROM contactos "
                    + "WHERE id_ruta = " + ruta.getId_ruta());
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,
                    "No se ha podido eliminar el contacto\n"
                    + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);;
            e.printStackTrace();
        }
    
       
    }
    
    
    
    
    
    
}
