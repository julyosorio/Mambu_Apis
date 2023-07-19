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
public class ScheduleSettings{
	private int principalRepaymentInterval;
	private int gracePeriod;
	private boolean hasCustomSchedule;
	private int periodicPayment;
	private String repaymentPeriodUnit;
	private String repaymentScheduleMethod;
	private int repaymentInstallments;
	private String scheduleDueDatesMethod;
	private String gracePeriodType;
	private int repaymentPeriodCount;
	private int defaultFirstRepaymentDueDateOffset;
}
