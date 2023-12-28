package it.corona.Sakila.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id", nullable = false)
    private Long addressId;

    @Column(length = 50, nullable = false)
    private String address;

    @Column(length = 50)
    private String address2;

    @Column(length = 20, nullable = false)
    private String district;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "city_id", nullable = false, unique = true)
    private City city;

    @Column(length = 10)
    private String postalCode;

    @Column(length = 20, nullable = false)
    private String phone;

    @Column(nullable = false)
    private Date lastUpdate;
}
