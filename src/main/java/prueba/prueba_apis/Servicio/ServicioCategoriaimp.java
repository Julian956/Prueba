package prueba.prueba_apis.Servicio;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import prueba.prueba_apis.Modelo.Categoria;

import prueba.prueba_apis.Repositorio.RepositorioCategory;

import java.util.List;


@Service
@AllArgsConstructor
public class ServicioCategoriaimp  implements ServicioCategoria{

    private final RepositorioCategory repositorioCategory;


    @Override
    public List<Categoria> findAll() {
        return repositorioCategory.findAll();
    }

    @Override
    public Categoria guardarCategoria(Categoria categoria) {
        return repositorioCategory.save(categoria);
    }

    @Override
    public Categoria obtenerCategoria(long id) {
        return repositorioCategory.findById(id).orElseThrow(() -> {throw new RuntimeException(); });

    }

    @Override
    public Categoria categoriaModificar(long id,  Categoria categoriaModificar) {
        Categoria categoriaBuscada=repositorioCategory.findById(id).get();
        categoriaBuscada.setName(categoriaBuscada.getName());
        return repositorioCategory.save(categoriaBuscada);
    }

    @Override
    public boolean eliminarCategoria(long id) {
        try {
            repositorioCategory.deleteById((id));
            return true;
        }catch (Exception e){
            return false;
        }
    }
}



