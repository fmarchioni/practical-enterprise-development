package com.itbuzzpress.batch.chunk;

import javax.batch.api.chunk.AbstractCheckpointAlgorithm;
import javax.batch.runtime.context.JobContext;
import javax.inject.Inject;
import javax.inject.Named;

import com.itbuzzpress.batch.ejb.EJBSingleton;

 
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
