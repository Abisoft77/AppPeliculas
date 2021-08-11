import gt.com.abisoft.peliculas.excepciones.*;
import gt.com.abisoft.peliculas.negocio.*;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws AccesoDatosEx{
        Scanner entrada = new Scanner(System.in);
        var nombreArchivo = "src\\gt\\com\\abisoft\\peliculas\\datos\\datoscatalogo.txt";
        var catalogo = new CatalogoPeliculasImpl();

        //Menu de opciones
        var opcion = true;
        while (opcion){
            System.out.println("Elige Opcion:");
            System.out.println("1.- Iniciar catalogo péliculas");
            System.out.println("2.- Agregar Pelicula");
            System.out.println("3.- Listar Peliculas");
            System.out.println("4.- Buscar Pelicula");
            System.out.println("0.- Salir");

            switch (entrada.nextInt()){
                case 1:
                    catalogo.iniciarArchivo(nombreArchivo);
                    System.out.println("Archivo Creado con exito");
                    break;
                case 2:
                    System.out.println("Nombre de la pelicula a agregar: ");
                    catalogo.agregarPelicualas(entrada.next(),nombreArchivo);
                    break;
                case 3:
                    System.out.println("Listando peliculas...");
                    catalogo.listarPelicula(nombreArchivo);
                    break;
                case 4 :
                    System.out.println("Ingrese la pelicula a buscar");
                    catalogo.buscarPelicula(entrada.next(),nombreArchivo);
                    break;
                case 0:
                    opcion = false;
                    break;
                default:
                    System.out.println("Opcion no valida");
            }
        }
    }
}
