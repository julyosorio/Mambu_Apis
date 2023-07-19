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
public class InterestPaymentSettings {

	private String interestPaymentPoint;
	private List<InterestPaymentDate> interestPaymentDates = null;

}
