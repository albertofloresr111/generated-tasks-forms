package org.camunda.bpm;

import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.engine.delegate.DelegateExecution;

public class CalculateTaxesDelagate implements JavaDelegate {

	public void execute(DelegateExecution execution) throws Exception {
		Long amount = (Long)execution.getVariable("amount");
		Double taxRate = (Double)execution.getVariable("taxRate");

		double taxes = amount * taxRate;
		execution.setVariable("payment", (amount + taxes) );
	}

}