package prueba.prueba_apis.Controlador;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import prueba.prueba_apis.Modelo.Categoria;


import prueba.prueba_apis.Modelo.Producto;
import prueba.prueba_apis.Servicio.ServicioCategoria;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/nexsys/v1/categorie/")
public class ControladorCategoria {


    private final ServicioCategoria servicioCategoria;


   @PostMapping
   public ResponseEntity<Categoria> guardarCategoria(@RequestBody Categoria categoria) {
       try {
           Categoria categoriaGuardada = servicioCategoria.guardarCategoria(categoria);
           return new ResponseEntity<>(categoriaGuardada, HttpStatus.CREATED);
       } catch (Exception e) {

           return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
       }
   }
    @GetMapping
    public List<Categoria> findAll(){
        return servicioCategoria.findAll();
    }



    @GetMapping("/{id}")
    public ResponseEntity<Categoria> obtenerCategoria(@PathVariable("id") long idcategoria) {
        try {
            Categoria categoria = servicioCategoria.obtenerCategoria(idcategoria);
            return new ResponseEntity<>(categoria, HttpStatus.OK);
        } catch (Exception e) {

            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PutMapping("/{id}")
    public ResponseEntity<Categoria> categoriaModificar(@PathVariable("id") long idcategoria, @RequestBody Categoria categoria) {
        try {
            Categoria categoriaModificada = servicioCategoria.categoriaModificar(idcategoria, categoria);
            return new ResponseEntity<>(categoriaModificada, HttpStatus.OK);
        } catch (Exception e) {

            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Categoria> eliminarProducto(@PathVariable("id") Long idCategoria) {
        try {
            boolean respuesta = servicioCategoria.eliminarCategoria(idCategoria);
            if (respuesta ) {
                return new ResponseEntity<>(HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            // Manejo de excepciones
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    }


