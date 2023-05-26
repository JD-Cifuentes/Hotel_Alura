package com.hotel_alura.models;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;

@SuppressWarnings("all")
@Entity
@Table(name="guests")
/*@NamedQuery(name = "Producto.consultaDePrecio",
        query = "SELECT G.precio FROM Guest AS G WHERE G.nombre=:nombre" )*/
public class Guest {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    private long document;
    private String name;
    private String lastName;
    private Date birthDate;
    private String nationality;
    private long telephoneNum;
    @OneToMany(mappedBy = "guests")
    private ArrayList<Reserve> reserves;



    public Guest() {
    }
}
