package uce.edu.web.api.sistema.interfaces;

import java.util.ArrayList;
import java.util.List;
import uce.edu.web.api.sistema.domain.Vehiculo;

public class VehiculoRepresentation {
    public Long id;
    public String placa;
    public String marca;
    public String modelo;
    public String color;
    public String chasis;
    public java.time.LocalDate fechaFabricacion;
    public java.time.LocalDate fechaMatricula;
    public List<Link> links = new ArrayList<>();

    public static VehiculoRepresentation from(Vehiculo vehiculo) {
        VehiculoRepresentation rep = new VehiculoRepresentation();
        rep.id = vehiculo.getId();
        rep.placa = vehiculo.getPlaca();
        rep.marca = vehiculo.getMarca();
        rep.modelo = vehiculo.getModelo();
        rep.color = vehiculo.getColor();
        rep.chasis = vehiculo.getChasis();
        rep.fechaFabricacion = vehiculo.getFechaFabricacion();
        rep.fechaMatricula = vehiculo.getFechaMatricula();
        return rep;
    }

    public void addLink(String rel, String href) {
        this.links.add(new Link(rel, href));
    }
}
