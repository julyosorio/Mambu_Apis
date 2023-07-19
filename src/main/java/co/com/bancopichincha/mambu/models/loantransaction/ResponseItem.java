package co.com.bancopichincha.mambu.models.loantransaction;

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
public class ResponseItem{
	private TransactionDetails transactionDetails;
	private double amount;
	private List<Object> fees;
	private String notes;
	private AffectedAmounts affectedAmounts;
	private Taxes taxes;
	private String valueDate;
	private String creationDate;
	private String type;
	private String userKey;
	private String parentAccountKey;
	private AccountBalances accountBalances;
	private Terms terms;
	private String encodedKey;
	private Currency currency;
	private String id;
}