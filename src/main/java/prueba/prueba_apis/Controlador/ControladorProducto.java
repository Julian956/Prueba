package prueba.prueba_apis.Controlador;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import prueba.prueba_apis.Modelo.Producto;
import prueba.prueba_apis.Servicio.ServicoProducto;

import java.util.List;

@RestController
@RequestMapping("/nexsys/v1/products/")
@RequiredArgsConstructor
public class ControladorProducto {


    @Autowired
    private ServicoProducto servicoProducto;


    @PostMapping
    public ResponseEntity<Producto> guardarProducto(@RequestBody Producto producto) {
        try {
           Producto productoGuardado = servicoProducto.guardarProducto(producto);

            return new ResponseEntity<>(productoGuardado, HttpStatus.CREATED);
        } catch (Exception e) {

            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public List<Producto> findAll(){
        return servicoProducto.findAll();
    }


    @GetMapping("/{pid}")
    public ResponseEntity <Producto> obtenerProducto(@PathVariable("pid") long pidProducto) {
        try {
            Producto productoObtenido = servicoProducto.obtenerProducto(pidProducto);
            return new ResponseEntity<>(productoObtenido, HttpStatus.OK);
        } catch (Exception e) {

            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{pid}")
    public ResponseEntity <Producto>productoModificar(@PathVariable("pid") long pidProducto, @RequestBody Producto producto) {
        try {
            Producto productoModificado = servicoProducto.productoModificar(pidProducto, producto);
            return new ResponseEntity<>(productoModificado, HttpStatus.OK);
        } catch (Exception e) {

            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{pid}")
    public ResponseEntity <Producto> eliminarProducto(@PathVariable("pid") Long pidProducto) {
        try {
            boolean respuesta = servicoProducto.eliminarProducto(pidProducto);
            if (respuesta) {
                return new ResponseEntity<>(HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {

            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}

