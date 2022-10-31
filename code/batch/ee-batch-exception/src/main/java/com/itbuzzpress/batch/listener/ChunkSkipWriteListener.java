

package com.itbuzzpress.batch.listener;

import com.itbuzzpress.batch.exception.IllegalItemException;
import jakarta.batch.api.chunk.listener.SkipWriteListener;
import jakarta.batch.runtime.context.JobContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.util.List;

@Named
public class ChunkSkipWriteListener implements SkipWriteListener {
	@Inject
	JobContext jobContext;

	@Override
	public void onSkipWriteItem(List list, Exception e) throws Exception {
		 if (e instanceof IllegalItemException) {
			int item = ((IllegalItemException) e).getItem();
			list.remove(item);
			System.out.println("Purged illegal item from the list! "+item);
		} 

		System.out.println("MySkipWriteListener.onSkipWriteItem: "
						+ list + ", " + e.getMessage());

	}

}
