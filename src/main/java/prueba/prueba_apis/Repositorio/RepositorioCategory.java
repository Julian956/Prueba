package prueba.prueba_apis.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import prueba.prueba_apis.Modelo.Categoria;

@Repository
public interface RepositorioCategory extends JpaRepository<Categoria,Long> {


}
