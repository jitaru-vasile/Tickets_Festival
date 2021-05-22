package ro.sd.a2.DTO;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddressDto {
    private String id;
    private String houseHoldNumber;
    private String street;
    private String city;
    private String apartment;
    private String building;
    private String floor;


    public String getPrettyAddress() {
        return city + ", str. " + street + ", nr:" + houseHoldNumber;
    }
}