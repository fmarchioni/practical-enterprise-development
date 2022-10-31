
package com.itbuzzpress.batch.chunk;

import com.itbuzzpress.batch.exception.IllegalItemException;
import jakarta.batch.api.chunk.AbstractItemWriter;
import jakarta.batch.runtime.context.JobContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.json.JsonObject;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.List;

@Named
public class BatchItemWriter extends AbstractItemWriter {

	@Inject
	private JobContext jobContext;

	@Override
	public void writeItems(List list) {
		int id = checkItem(list);

		if (id > -1) {
			throw new IllegalItemException("User John allowed!", id);
		}

		String resourceName = (String) jobContext.getProperties().get(
				"output_file");

		try (PrintWriter pw = new PrintWriter(
				new FileWriter(resourceName, true))) {

			for (Object json : list) {
				System.out.println("Writer " + ((JsonObject) json).toString());
				pw.write(((JsonObject) json).toString());
			}
			pw.flush();

		} catch (Exception e) {
			System.err.println("Error: " + e);
		}
	}

	private int checkItem(List<JsonObject> list) {
		for (int i = 0; i < list.size(); i++) {
			JsonObject obj = list.get(i);
			if (obj.getString("firstName").equals("John")) {

				return i;
			}
		}
		return -1;
	}
}
