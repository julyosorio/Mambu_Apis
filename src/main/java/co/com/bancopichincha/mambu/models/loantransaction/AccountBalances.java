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
public class AccountBalances{
	private int redrawBalance;
	private double principalBalance;
	private double totalBalance;
	private int expectedPrincipalRedraw;
	private int advancePosition;
	private int arrearsPosition;
}
