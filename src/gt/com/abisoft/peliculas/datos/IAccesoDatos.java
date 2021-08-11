package gt.com.abisoft.peliculas.datos;
import gt.com.abisoft.peliculas.domain.Pelicula;
import gt.com.abisoft.peliculas.excepciones.*;
import java.util.List;

public interface IAccesoDatos {
    boolean existe(String nombreArchivo) throws AccesoDatosEx;
    List<String> listar(String nombre) throws LecturaDatosEx;
    void escribirPelicula(Pelicula pelicula, String nombreArchivo, boolean anexar) throws EscrituraDatosEx;
    String buscar(String buscar, String nombreArchivo) throws LecturaDatosEx;
    void crear(String nombreArchivo) throws AccesoDatosEx;
    void borrar(String nombreArchivo) throws AccesoDatosEx;


}
