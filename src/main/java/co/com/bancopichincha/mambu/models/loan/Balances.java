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
public class Balances{
	private int interestFromArrearsPaid;
	private int principalDue;
	private int interestBalance;
	private int holdBalance;
	private int principalPaid;
	private int penaltyDue;
	private int feesBalance;
	private int penaltyBalance;
	private int redrawBalance;
	private int interestFromArrearsBalance;
	private int principalBalance;
	private int interestDue;
	private int penaltyPaid;
	private int feesPaid;
	private int interestFromArrearsDue;
	private int feesDue;
	private int interestPaid;
}
