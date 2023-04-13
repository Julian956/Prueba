package prueba.prueba_apis.Servicio;

import prueba.prueba_apis.Modelo.Categoria;

import java.util.List;

public interface ServicioCategoria {


    public List<Categoria> findAll();


    Categoria guardarCategoria(Categoria categoria);


    Categoria obtenerCategoria(long id);


    Categoria categoriaModificar(long id, Categoria categoriaModificar);

    boolean eliminarCategoria(long id);
}
