package it.corona.Sakila.repository;

import it.corona.Sakila.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    boolean existsByEmail(String email);
    @Query("SELECT customer from Customer customer JOIN customer.address address JOIN address.city city ON city.name = :city")
    List<Customer> findByCity(@Param(value = "city") String city);

    @Query("SELECT customer FROM Customer customer JOIN customer.payments payment GROUP BY customer HAVING COUNT(payment.id) > :number")
    List<Customer> findByNumberOfPayments(@Param(value = "number") long number);
}

