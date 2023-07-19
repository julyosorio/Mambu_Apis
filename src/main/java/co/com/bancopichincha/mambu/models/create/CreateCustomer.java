package co.com.bancopichincha.mambu.models.create;


import co.com.bancopichincha.mambu.models.update.Address;
import co.com.bancopichincha.mambu.models.update.Personalizados;
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
public class CreateCustomer {

	private  String id;
	private  String encodedKey;
	private  String firstName;
	private String lastName;
	private String gender;
	private int loanCycle;
	private int groupLoanCycle;
	private String state;
	private  String preferredLanguage;
	private  ArrayList<Address> addresses;

	@JsonProperty("_personalizados")
	private Personalizados personalizados;
}
