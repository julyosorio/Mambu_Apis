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
public class AffectedAmounts{
	private int feesAmount;
	private int fundersInterestAmount;
	private int organizationCommissionAmount;
	private int deferredInterestAmount;
	private double interestAmount;
	private int penaltyAmount;
	private double principalAmount;
	private int interestFromArrearsAmount;
}
