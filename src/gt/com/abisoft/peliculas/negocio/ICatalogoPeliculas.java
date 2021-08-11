package gt.com.abisoft.peliculas.negocio;
import gt.com.abisoft.peliculas.excepciones.*;


public interface ICatalogoPeliculas {

    void agregarPelicualas(String nombrePelicula, String nombreArchivo) throws EscrituraDatosEx;
    void listarPelicula(String nombreArchivo) throws LecturaDatosEx;
    void buscarPelicula(String nombreArchivo, String buscar) throws LecturaDatosEx;
    void iniciarArchivo(String nombreArchivo) throws AccesoDatosEx;

}
