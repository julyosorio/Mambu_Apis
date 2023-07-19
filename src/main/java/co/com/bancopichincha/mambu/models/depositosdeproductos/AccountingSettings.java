package co.com.bancopichincha.mambu.models.depositosdeproductos;

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
public class AccountingSettings {

   private String accountingMethod;
	private String interestAccruedAccountingMethod;
	private List<Object> accountingRules = null;

}
