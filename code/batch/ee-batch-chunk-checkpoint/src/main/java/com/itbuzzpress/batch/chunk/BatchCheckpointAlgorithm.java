package com.itbuzzpress.batch.chunk;

import com.itbuzzpress.batch.ejb.EJBSingleton;
import jakarta.batch.api.chunk.AbstractCheckpointAlgorithm;
import jakarta.batch.runtime.context.JobContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;

 
@Named
public class BatchCheckpointAlgorithm extends AbstractCheckpointAlgorithm {

	@Inject
	private JobContext jobContext; 

	@Inject
	private EJBSingleton ejb; 

	@Override
	public boolean isReadyToCheckpoint() throws Exception {
		Integer counter = ejb.getCounter(jobContext.getExecutionId());
		return counter % 3 == 0;
	}

}
