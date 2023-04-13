package prueba.prueba_apis.Servicio;

import prueba.prueba_apis.Modelo.Producto;

import java.util.List;

public interface ServicoProducto {

    Producto guardarProducto(Producto producto);

    public List<Producto> findAll();

    Producto obtenerProducto(long pid);

    Producto productoModificar(long pid,Producto productoModificar);

    boolean eliminarProducto(long pid);
}
