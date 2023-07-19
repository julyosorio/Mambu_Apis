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
public class ResponseDeposit {

    private String encodedKey;
	private String id;
	private String creationDate;
	private String lastModifiedDate;
	private String name;
	private String notes;
	private String type;
	private String category;
	private String state;
	private NewAccountSettings newAccountSettings;
	private InterestSettings interestSettings;
	private OverdraftInterestSettings overdraftInterestSettings;
	private OverdraftSettings overdraftSettings;
	private FeesSettings feesSettings;
	private AccountingSettings accountingSettings;
	private InternalControls internalControls;
	private MaturitySettings maturitySettings;
	private CreditArrangementSettings creditArrangementSettings;
	private AvailabilitySettings availabilitySettings;
	private OffsetSettings offsetSettings;
	private TaxSettings taxSettings;
	private CurrencySettings currencySettings;
	private List<Object> templates = null;

}
