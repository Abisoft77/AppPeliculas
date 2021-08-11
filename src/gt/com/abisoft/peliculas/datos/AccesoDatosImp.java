package gt.com.abisoft.peliculas.datos;
import gt.com.abisoft.peliculas.domain.Pelicula;
import gt.com.abisoft.peliculas.excepciones.*;
import java.io.*;
import java.util.*;


public class AccesoDatosImp implements IAccesoDatos {

    public AccesoDatosImp() {

    }

    @Override
    public boolean existe(String nombreArchivo) {
        var file = new File(nombreArchivo);
        return file.exists();
    }

    @Override
    public List<String> listar(String nombre) throws LecturaDatosEx {
        List<String> pelis = new ArrayList<>();
        var file = new File(nombre);
        try {
            var entrada = new BufferedReader(new FileReader(file));
            var lectura = entrada.readLine();
            while (lectura != null){
                pelis.add(lectura);
                lectura = entrada.readLine();
            }entrada.close();
        }catch (IOException er){
            er.printStackTrace();
            throw new LecturaDatosEx("Excepciones al listar pelicula " + er.getMessage());
        }
        return pelis;
    }

    @Override
    public void escribirPelicula(Pelicula pelicula, String nombreArchivo, boolean anexar) throws EscrituraDatosEx {
        var file = new File(nombreArchivo);
        try {
            var entrada = new PrintWriter(new FileWriter(file,anexar));
            entrada.println(pelicula.getNombre());
            entrada.close();
        }catch (IOException ex){
            ex.printStackTrace();
            throw new EscrituraDatosEx("Excepcion al escribir pelicula " + ex.getMessage());

        }
        System.out.println("Agregada con exito");
    }

    @Override
    public String buscar(String buscar, String nombreArchivo) throws LecturaDatosEx{
        String result="Pelicula NO Disponible";
        var file = new File(nombreArchivo);
        try {
            var entrada = new BufferedReader(new FileReader(file));
            var lectura = entrada.readLine();
            while (lectura != null){
                if (lectura.equalsIgnoreCase(buscar)){
                    result = "Pelicula Disponible: " + lectura;
                }
                lectura = entrada.readLine();
            }
            entrada.close();//cerramos el archivo
        }catch (IOException er){
            er.printStackTrace();
            throw new LecturaDatosEx("Excepcion al biscar en el archivo");
        }
        return result;
    }

    @Override
    public void crear(String nombreArchivo) throws AccesoDatosEx {
        var file = new File(nombreArchivo);
        try {
            var salida = new PrintWriter(new FileWriter(file));
            salida.close();
        }catch (IOException er){
            er.printStackTrace();
            throw new AccesoDatosEx("Excepcion al crear el archivo" + er.getMessage());
        }

    }

    @Override
    public void borrar(String nombreArchivo) {
        var file = new File(nombreArchivo);
        if(file.exists()){
            System.out.println("Archivo eliminado con exito..." + file.delete());
        }
    }
}
