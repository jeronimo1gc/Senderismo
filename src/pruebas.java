
import java.sql.Connection;
import java.util.ArrayList;
import javax.swing.DefaultListModel;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author DAW
 */
public class pruebas {
       Connection conexion = null;
       GestionRuta gestRuta = new GestionRuta();
       Conexion.conectar("localhost","root","");
        

        
        ArrayList<Ruta> ruta = gestRuta.findPoblacion("Ubrique");
        DefaultListModel listModel = new DefaultListModel();
        
      
        for (i=0; i < ruta.size(); i++) {
    
            listModel.add(i, ruta.get(i));
            
            System.out.print(listModel);
        }
        
        
        
    
}
