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
public class ResponseItem{
	private String accountState;
	private int arrearsTolerancePeriod;
	private PrepaymentSettings prepaymentSettings;
	private String lastInterestAppliedDate;
	private String notes;
	private DisbursementDetails disbursementDetails;
	private String activationTransactionKey;
	private String accountSubState;
	private String loanName;
	private Balances balances;
	private InterestSettings interestSettings;
	private String encodedKey;
	private Currency currency;
	private String id;
	private String lastAccountAppraisalDate;
	private PenaltySettings penaltySettings;
	private String futurePaymentsAcceptance;
	private String lastModifiedDate;
	private int accruedInterest;
	private int accruedPenalty;
	private String creationDate;
	private double loanAmount;
	private String approvedDate;
	private int interestFromArrearsAccrued;
	private String closedDate;
	private ScheduleSettings scheduleSettings;
	private String paymentMethod;
	private String accountHolderKey;
	private String productTypeKey;
	private boolean allowOffset;
	private String latePaymentsRecalculationMethod;
	private String accountHolderType;
	private AccountArrearsSettings accountArrearsSettings;
}
