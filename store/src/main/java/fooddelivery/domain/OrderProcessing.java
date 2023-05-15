package fooddelivery.domain;

import fooddelivery.StoreApplication;
import fooddelivery.domain.CouponGenerated;
import fooddelivery.domain.DeliveryCancelled;
import fooddelivery.domain.DeliveryStarted;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "OrderProcessing_table")
@Data
public class OrderProcessing {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long orderId;

    private String foodId;

    private String address;

    @PostPersist
    public void onPostPersist() {
        DeliveryStarted deliveryStarted = new DeliveryStarted(this);
        deliveryStarted.publishAfterCommit();

        CouponGenerated couponGenerated = new CouponGenerated(this);
        couponGenerated.publishAfterCommit();

        DeliveryCancelled deliveryCancelled = new DeliveryCancelled(this);
        deliveryCancelled.publishAfterCommit();
    }

    public static OrderProcessingRepository repository() {
        OrderProcessingRepository orderProcessingRepository = StoreApplication.applicationContext.getBean(
            OrderProcessingRepository.class
        );
        return orderProcessingRepository;
    }

    public static void cancelOrder(PaymentCancelled paymentCancelled) {
        /** Example 1:  new item 
        OrderProcessing orderProcessing = new OrderProcessing();
        repository().save(orderProcessing);

        */

        /** Example 2:  finding and process
        
        repository().findById(paymentCancelled.get???()).ifPresent(orderProcessing->{
            
            orderProcessing // do something
            repository().save(orderProcessing);


         });
        */

    }

    public static void copyOrderInfo(Paid paid) {
        /** Example 1:  new item 
        OrderProcessing orderProcessing = new OrderProcessing();
        repository().save(orderProcessing);

        */

        /** Example 2:  finding and process
        
        repository().findById(paid.get???()).ifPresent(orderProcessing->{
            
            orderProcessing // do something
            repository().save(orderProcessing);


         });
        */

    }
}
