package co.com.bancopichincha.mambu.models.update;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ClientsUpdate {
    private String id;
    private String encodedKey;
    private String firstName;
    private String lastName;
    private String gender;
    private String state;
    private String preferredLanguage;
    private ArrayList<Address> addresses;
	@JsonProperty("_personalizados")
	private Personalizados personalizados;

	}
