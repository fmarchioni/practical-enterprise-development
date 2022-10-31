
package com.itbuzzpress.batch.batchlet;


import jakarta.batch.api.AbstractBatchlet;
import jakarta.batch.runtime.context.StepContext;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.inject.Named;



@Stateless
@Named

public class SimpleBatchlet extends AbstractBatchlet {

	@Inject StepContext stepContext;

	@Override
	public String process() {
		System.out.println("Called SimpleBatchlet from step " +stepContext.getStepName());
		return "COMPLETED";
	}

}
