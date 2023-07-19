package co.com.bancopichincha.mambu.models.update;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Address {
    private String city;
    private String country;
    private int indexInList;
    private float latitude;
    private String line1;
    private String line2;
    private float longitude;
    private String postcode;
    private String region;
}
