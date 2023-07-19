package co.com.bancopichincha.mambu.models.loan;

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
public class InterestSettings{
	private double interestRate;
	private String interestCalculationMethod;
	private String interestRateSource;
	private String interestApplicationMethod;
	private String interestChargeFrequency;
	private String interestType;
	private boolean accrueInterestAfterMaturity;
	private String interestBalanceCalculationMethod;
	private boolean accrueLateInterest;
}
