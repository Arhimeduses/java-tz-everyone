package tz.proj.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tz.proj.Models.Customer;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Optional<Customer> findByName(String name);
}
