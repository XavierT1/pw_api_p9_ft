package uce.edu.web.api.sistema.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "vehiculo")
public class Vehiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String placa;

    private String marca;

    private String modelo;

    private String color;

    private String chasis;

    private java.time.LocalDate fechaFabricacion;

    private java.time.LocalDate fechaMatricula;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getChasis() {
        return chasis;
    }

    public void setChasis(String chasis) {
        this.chasis = chasis;
    }

    public java.time.LocalDate getFechaFabricacion() {
        return fechaFabricacion;
    }

    public void setFechaFabricacion(java.time.LocalDate fechaFabricacion) {
        this.fechaFabricacion = fechaFabricacion;
    }

    public java.time.LocalDate getFechaMatricula() {
        return fechaMatricula;
    }

    public void setFechaMatricula(java.time.LocalDate fechaMatricula) {
        this.fechaMatricula = fechaMatricula;
    }
}
