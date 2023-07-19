package co.com.bancopichincha.mambu.models.loan;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class DisbursementDetails{
	private TransactionDetails transactionDetails;
	private String expectedDisbursementDate;
	private List<Object> fees;
	private String firstRepaymentDate;
	private String disbursementDate;
	private String encodedKey;
}