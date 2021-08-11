package gt.com.abisoft.peliculas.negocio;

public class CatalogoPeliculas implements ICatalogoPeliculasImpl{

    @Override
    public void agregarPelicula(String nombre) {
        System.out.println("Pelicula Agregada con exito");
    }
}
