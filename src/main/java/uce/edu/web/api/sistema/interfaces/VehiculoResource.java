package uce.edu.web.api.sistema.interfaces;

import java.util.ArrayList;
import java.util.List;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;
import uce.edu.web.api.sistema.application.VehiculoService;
import uce.edu.web.api.sistema.domain.Vehiculo;
import org.jboss.logging.Logger;

@Path("/vehiculos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class VehiculoResource {

    private static final Logger LOG = Logger.getLogger(VehiculoResource.class);

    @Inject
    VehiculoService vehiculoService;

    @GET
    @RolesAllowed({ "user", "admin" })
    public Response listar(@Context UriInfo uriInfo) {
        LOG.info("Consultando todos los vehiculos");
        List<Vehiculo> vehiculos = vehiculoService.listarTodos();
        List<VehiculoRepresentation> representaciones = new ArrayList<>();

        for (Vehiculo v : vehiculos) {
            VehiculoRepresentation rep = VehiculoRepresentation.from(v);
            String placa = v.getPlaca();
            // Build absolute path to self
            String selfLink = uriInfo.getBaseUriBuilder()
                    .path(VehiculoResource.class)
                    .path(placa)
                    .build()
                    .toString();

            rep.addLink("self", selfLink);
            representaciones.add(rep);
        }
        return Response.ok(representaciones).build();
    }

    @GET
    @Path("/{placa}")
    @RolesAllowed({ "user", "admin" })
    public Response buscarPorPlaca(@PathParam("placa") String placa, @Context UriInfo uriInfo) {
        LOG.info("Consultando vehiculo por placa: " + placa);
        Vehiculo v = vehiculoService.buscarPorPlaca(placa);
        if (v == null) {
            LOG.warn("Vehiculo no encontrado con placa: " + placa);
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        VehiculoRepresentation rep = VehiculoRepresentation.from(v);
        String selfLink = uriInfo.getAbsolutePath().toString();
        rep.addLink("self", selfLink);

        // Add link to collection
        String collectionLink = uriInfo.getBaseUriBuilder()
                .path(VehiculoResource.class)
                .build()
                .toString();
        rep.addLink("collection", collectionLink);

        return Response.ok(rep).build();
    }

    // Optional: Create method for testing/seeding
    @POST
    @RolesAllowed("admin")
    public Response crear(Vehiculo vehiculo) {
        LOG.info("Creando vehiculo");
        vehiculoService.crear(vehiculo);
        return Response.status(Response.Status.CREATED).entity(vehiculo).build();
    }

    @jakarta.ws.rs.DELETE
    @Path("/{placa}")
    @RolesAllowed("admin")
    public Response eliminar(@PathParam("placa") String placa) {
        LOG.info("Eliminando vehiculo con placa: " + placa);
        Vehiculo v = vehiculoService.buscarPorPlaca(placa);
        if (v == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        vehiculoService.eliminar(placa);
        return Response.noContent().build();
    }
}
