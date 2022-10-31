package com.itbuzzpress.batch.decision;

import jakarta.batch.api.Decider;
import jakarta.batch.runtime.StepExecution;
import jakarta.batch.runtime.context.JobContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.File;
import java.util.Properties;

@Named
public class DecisionNode implements Decider {

	@Inject
	JobContext jobContext;

	@Override
	public String decide(StepExecution[] ses) throws Exception {
		Properties jobParameters = jobContext.getProperties();
		String fs = (String) jobParameters.get("filesystem");
 
		if (fs == null) {
			return "NOT_AVAILABLE";
		}
		
		File file = new File(fs);
		long totalSpace = file.getTotalSpace();
		if (totalSpace > 100000) {
			System.out.println("DecisionNode::Enough DiskSpace!");
			return "DSK_SPACE_OK";
		} else {
			System.out.println("DecisionNode::Not enough DiskSpace!");			
			return "DSK_SPACE_LOW";
		}	
	}

 
}