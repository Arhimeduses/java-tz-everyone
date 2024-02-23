package tz.proj.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Long userId;

    @NotBlank(message = "Surname is required")
    private String surname;

    @NotBlank(message = "Name if required")
    private String name;


    @Column(name = "second_name")
    private String secondName;

    @Column(name = "family_state")
    @NotBlank(message = "Family state is required")
    private String familyState;

    @Column(name = "phone_number")
    @Pattern(regexp = "^([+][7]\\d{10})$", message = "Phone number is required")
    private String phoneNumber;

    @OneToOne(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Passport passport;

    @OneToOne(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Work work;

    @OneToOne(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Address address;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<CreditRequest> requests = new HashSet<>();

    @Min(20000)
    private Integer creditSum;
}
