package com.itbuzzpress.batch.listener;

 

import jakarta.batch.api.chunk.listener.AbstractItemProcessListener;
import jakarta.inject.Named;

@Named
public class BatchItemProcessListener extends AbstractItemProcessListener {
	@Override
    public void beforeProcess(Object item) throws Exception {
       
        System.out.println("BatchItemProcessListener.beforeProcess: " + item);
    }

    @Override
    public void afterProcess(Object item, Object result) throws Exception {
        
        System.out.println("BatchItemProcessListener.afterProcess: " + item + ", " + result);
    }

    @Override
    public void onProcessError(Object item, Exception ex) throws Exception {
     
        System.out.println("BatchItemProcessListener.onProcessError: " + item + ", " + ex.getLocalizedMessage());
    }
    
}