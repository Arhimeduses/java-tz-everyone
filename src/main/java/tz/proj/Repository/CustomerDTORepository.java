package tz.proj.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tz.proj.DTO.CustomerDTO;

import java.util.Optional;

public interface CustomerDTORepository extends JpaRepository<CustomerDTO, Long> {
    Optional<CustomerDTO> findCustomerDTOByFIO();
}
