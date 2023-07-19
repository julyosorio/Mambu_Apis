package co.com.bancopichincha.mambu.models.search;

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

public class FilterCriterium {

	private String field;
	private String operator;
	private Object secondValue;
	private String value;
	private Object values;

}
