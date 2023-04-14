package prueba.prueba_apis.Servicio;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import prueba.prueba_apis.Modelo.Producto;
import prueba.prueba_apis.Repositorio.Repositorio;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ServicioProductoimp implements ServicoProducto{




    private final Repositorio repositorio;

    @Override
    public Producto guardarProducto(Producto producto) {
        return repositorio.save(producto);
    }

    @Override
    public List<Producto> findAll() {
        return repositorio.findAll();
    }


    @Override
    public Producto obtenerProducto(long pid) {
        return repositorio.findById(pid).orElseThrow(() -> {throw new RuntimeException(); });
    }

    @Override
    public Producto productoModificar(long pid, Producto productoModificar) {
        Producto productoBuscado=repositorio.findById(pid).get();
        productoBuscado.setDescription(productoModificar.getDescription());
        productoBuscado.setPrice(productoModificar.getPrice());
        productoBuscado.setTitle(productoModificar.getTitle());
        productoBuscado.setImage(productoModificar.getImage());




        return repositorio.save(productoBuscado);
    }

    @Override
    public boolean eliminarProducto(long pid) {
        try {
            repositorio.deleteById(pid);
            return true;
        }catch (Exception e){
            return false;

        }
    }
}
