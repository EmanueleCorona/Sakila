package it.corona.Sakila.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_id", nullable = false)
    private Long paymentId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id", nullable = false, unique = true)
    private Customer customer;

    @Column
    private Double amount;

    @Column(nullable = false)
    private Date paymentDate;

    @Column(nullable = false)
    private Date lastUpdate;
}
