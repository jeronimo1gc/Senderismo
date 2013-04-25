
import java.sql.Blob;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author DAW
 */
public class Ruta {
        
    int id_ruta;
    String nombreRuta;
    String poblacion;
    int recorrido;
    int desnivel;
    int tiempo;
    String dificultad;
    Blob imagen;

    public Ruta(int id_ruta, String nombreRuta, String poblacion,
           int recorrido, int desnivel, int tiempo, String dificultad, Blob imagen ) {
       this.id_ruta = id_ruta;
       this.nombreRuta= nombreRuta;
       this.poblacion=poblacion;
       this.recorrido=recorrido;
       this.desnivel=desnivel;
       this.tiempo=tiempo;
       this.dificultad=dificultad;
       this.imagen=imagen;
    }

    public int getId_ruta() {
        return id_ruta;
    }

    public void setId_ruta(int id_ruta) {
        this.id_ruta = id_ruta;
    }

    public String getNombreRuta() {
        return nombreRuta;
    }

    public void setNombreRuta(String nombreRuta) {
        this.nombreRuta = nombreRuta;
    }

    public String getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }

    

    public int getRecorrido() {
        return recorrido;
    }

    public void setRecorrido(int recorrido) {
        this.recorrido = recorrido;
    }

    public int getDesnivel() {
        return desnivel;
    }

    public void setDesnivel(int desnivel) {
        this.desnivel = desnivel;
    }

    public int getTiempo() {
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }

    public String getDificultad() {
        return dificultad;
    }

    public void setDificultad(String dificultad) {
        this.dificultad = dificultad;
    }

    public Blob getImagen() {
        return imagen;
    }

    public void setImagen(Blob imagen) {
        this.imagen = imagen;
    }
    

    
}
