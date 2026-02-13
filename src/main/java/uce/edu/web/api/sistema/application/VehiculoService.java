package uce.edu.web.api.sistema.application;

import java.util.List;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import uce.edu.web.api.sistema.domain.Vehiculo;
import uce.edu.web.api.sistema.infrastructure.VehiculoRepository;

@ApplicationScoped
public class VehiculoService {

    @Inject
    VehiculoRepository vehiculoRepository;

    public List<Vehiculo> listarTodos() {
        return vehiculoRepository.listAll();
    }

    public Vehiculo buscarPorPlaca(String placa) {
        return vehiculoRepository.findByPlaca(placa);
    }

    @Transactional
    public void crear(Vehiculo vehiculo) {
        vehiculoRepository.persist(vehiculo);
    }

    @Transactional
    public void eliminar(String placa) {
        vehiculoRepository.delete("placa", placa);
    }
}
