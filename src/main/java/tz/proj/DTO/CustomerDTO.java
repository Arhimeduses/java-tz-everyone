package tz.proj.DTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CustomerDTO {
    //customers info
    private Long id;
    private String surname;
    private String name;
    private String secondName;
    private String familyState;
    private String phoneNumber;
    private Integer creditSum;

    //passport data
    private String series;
    private Integer number;

    //address data
    private String city;
    private String street;
    private Integer building;
    private String apartment;

    //work data
    private Integer periodWork;
    private String position;
    private String organization;
}
