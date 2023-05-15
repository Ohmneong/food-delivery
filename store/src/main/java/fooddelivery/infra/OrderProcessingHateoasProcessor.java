package fooddelivery.infra;

import fooddelivery.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class OrderProcessingHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<OrderProcessing>> {

    @Override
    public EntityModel<OrderProcessing> process(
        EntityModel<OrderProcessing> model
    ) {
        return model;
    }
}
