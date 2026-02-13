package uce.edu.web.api.sistema.infrastructure;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import uce.edu.web.api.sistema.domain.Vehiculo;

@ApplicationScoped
public class VehiculoRepository implements PanacheRepository<Vehiculo> {

    public Vehiculo findByPlaca(String placa) {
        return find("placa", placa).firstResult();
    }
}
