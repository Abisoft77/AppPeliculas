package gt.com.abisoft.peliculas.negocio;
import gt.com.abisoft.peliculas.datos.*;
import gt.com.abisoft.peliculas.domain.Pelicula;
import gt.com.abisoft.peliculas.excepciones.*;


public class CatalogoPeliculasImpl implements ICatalogoPeliculas {
    IAccesoDatos datos = new AccesoDatosImp();

    @Override
    public void agregarPelicualas(String nombrePelicula, String nombreArchivo) throws EscrituraDatosEx {
        Pelicula pelicula = new Pelicula(nombrePelicula);
        try {
            if (datos.existe(nombreArchivo)){
                datos.escribirPelicula(pelicula,nombreArchivo,true);
            }else {
                System.out.println("Cree primero una base de datos");
            }
        } catch (AccesoDatosEx e) {
            e.printStackTrace();
            throw new EscrituraDatosEx("Excepcion al agregar peliculas");
        }
    }

    @Override
    public void listarPelicula(String nombreArchivo) throws LecturaDatosEx {
        for (String e : datos.listar(nombreArchivo)) {
            System.out.println(e);
        }

    }

    @Override
    public void buscarPelicula(String buscar,String nombreArchivo) throws LecturaDatosEx{
        var respuesta = "";
        respuesta = datos.buscar(buscar,nombreArchivo);
        System.out.println(respuesta);
    }

    @Override
    public void iniciarArchivo(String nombreArchivo) throws AccesoDatosEx{
        datos.crear(nombreArchivo);
    }
}