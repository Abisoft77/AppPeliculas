import gt.com.abisoft.peliculas.domain.Pelicula;
import gt.com.abisoft.peliculas.negocio.CatalogoPeliculas;
import gt.com.abisoft.peliculas.negocio.ICatalogoPeliculasImpl;

public class App {
    public static void main(String[] args) {
        ICatalogoPeliculasImpl peli = new CatalogoPeliculas();
        peli.agregarPelicula("Batman");


    }
}
