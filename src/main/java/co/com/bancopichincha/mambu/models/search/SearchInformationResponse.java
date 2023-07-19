package co.com.bancopichincha.mambu.models.search;

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
public class SearchInformationResponse {

	private String encodedKey;
	private String id;
	private String state;
	private String creationDate;
	private String lastModifiedDate;
	private String activationDate;
	private String approvedDate;
	private String firstName;
	private String lastName;
	private String preferredLanguage;
	private String gender;
	private String clientRoleKey;
	private Integer loanCycle;
	private Integer groupLoanCycle;

}
