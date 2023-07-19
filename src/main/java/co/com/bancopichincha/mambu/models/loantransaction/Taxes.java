package co.com.bancopichincha.mambu.models.loantransaction;

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
public class Taxes{
	private int taxOnInterestFromArrearsAmount;
	private int taxOnFeesAmount;
	private int taxOnInterestAmount;
	private int taxOnPenaltyAmount;
	private int deferredTaxOnInterestAmount;
}
