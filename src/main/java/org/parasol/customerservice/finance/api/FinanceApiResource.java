package org.parasol.customerservice.finance.api;

import io.smallrye.mutiny.Uni;
import io.smallrye.mutiny.infrastructure.Infrastructure;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.parasol.customerservice.finance.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("finance/v1")
public class FinanceApiResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(FinanceApiResource.class);

    @Inject
    OrderService orderService;

    @GET
    @Path("/order/{customerId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<Response> getCustomerOrderHistory(@PathParam("customerId") String customerId) {
        return Uni.createFrom().voidItem().emitOn(Infrastructure.getDefaultWorkerPool())
                .onItem().transform(v -> orderService.getOrdersByCustomerId(customerId))
                .onItem().transform(list -> Response.ok(list).build())
                .onFailure().recoverWithItem(throwable -> {
                    LOGGER.error("Exception while fetching orders by customerId", throwable);
                    return Response.serverError().build();
        });
    }

}
