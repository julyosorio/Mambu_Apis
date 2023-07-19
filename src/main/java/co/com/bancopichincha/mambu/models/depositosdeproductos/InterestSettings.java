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
public class InterestSettings {

	private Boolean interestPaidIntoAccount;
	private InterestRateSettings interestRateSettings;
	private String interestCalculationBalance;
	private Float maximumBalance;
	private InterestPaymentSettings interestPaymentSettings;
	private Boolean collectInterestWhenLocked;
	private String daysInYear;

}
