package co.com.bancopichincha.mambu.models.depositosdeproductos;

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
public class InterestRateSettings {

	private InterestRate interestRate;
	private String interestRateSource;
	private String interestRateTerms;
	private String interestChargeFrequency;
	private Integer interestChargeFrequencyCount;
	private String encodedKey;
	private Boolean accrueInterestAfterMaturity;
	private Boolean allowNegativeInterestRate;

}
