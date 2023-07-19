package co.com.bancopichincha.mambu.models;

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
public class ResponseProduct {

    private String encodedKey;
    private String creationDate;
    private String lastModifiedDate;
    private String id;
    private String name;
    private String notes;
    private String type;
    private String category;
    private String state;

}
