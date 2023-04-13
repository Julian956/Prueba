package prueba.prueba_apis.Modelo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.awt.*;
import java.io.Serializable;

@Entity(name = "Producto")
@Table(name = "product")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Producto implements Serializable {


    @Id
    @Column(name = "pid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long pid;

    @Column(name = "title")
    private String title;

    @Column(name="price")
    private String price;
    @Column(name = "description")
    private String Description;
    @ManyToOne
    @JoinColumn(name = "category_id",nullable = false)
    private  Categoria categoria;
    @Column(name = "imagen")
    private String image;










}
