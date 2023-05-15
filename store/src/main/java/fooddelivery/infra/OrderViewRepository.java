package fooddelivery.infra;

import fooddelivery.domain.*;
import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(
    collectionResourceRel = "orderViews",
    path = "orderViews"
)
public interface OrderViewRepository
    extends PagingAndSortingRepository<OrderView, Long> {
    List<OrderView> findByOrderId(Long orderId);
}
