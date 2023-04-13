package prueba.prueba_apis.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import prueba.prueba_apis.Modelo.Producto;

@Repository
public interface Repositorio extends JpaRepository<Producto,Long> {

}
