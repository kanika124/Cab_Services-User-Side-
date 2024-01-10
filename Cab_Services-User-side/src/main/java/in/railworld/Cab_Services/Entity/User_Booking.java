package in.railworld.Cab_Services.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User_Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private String bookingId;
    private Date bookingDate;
    private String pickupPoint;
    private String dropOff;
    private double totalFair;
    @ManyToOne
    @JoinColumn
    private int userId;

}
