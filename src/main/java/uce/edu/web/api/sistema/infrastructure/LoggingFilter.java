package uce.edu.web.api.sistema.infrastructure;

import java.io.IOException;

import org.jboss.logging.Logger;

import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.container.ContainerResponseContext;
import jakarta.ws.rs.container.ContainerResponseFilter;
import jakarta.ws.rs.ext.Provider;

@Provider
public class LoggingFilter implements ContainerRequestFilter, ContainerResponseFilter {

    private static final Logger LOG = Logger.getLogger(LoggingFilter.class);

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        LOG.infof("Request: %s %s", requestContext.getMethod(), requestContext.getUriInfo().getPath());
    }

    @Override
    public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext)
            throws IOException {
        LOG.infof("Response: status=%d", responseContext.getStatus());
    }
}
