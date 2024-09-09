package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table (name = "departments")
public class Department {

    @Id
    @Column (name = "department_id", nullable = false, length = 4)
    private Integer id;

    @Column (name = "department_name", nullable = false, length = 30)
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location id_locationn;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Location getId_locationn() {
        return id_locationn;
    }

    public void setId_locationn(Location id_locationn) {
        this.id_locationn = id_locationn;
    }
}
