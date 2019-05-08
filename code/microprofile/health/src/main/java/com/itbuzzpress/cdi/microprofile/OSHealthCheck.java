package com.itbuzzpress.cdi.microprofile;

import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.health.Health;
import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.HealthCheckResponseBuilder;


@Health
@ApplicationScoped
public class OSHealthCheck implements HealthCheck {

	@Inject @ConfigProperty(name = "health.system.load.max", defaultValue = "0.75")
	private double maxLoad;

	@Override
	public HealthCheckResponse call() {
		OperatingSystemMXBean operatingSystemMXBean = ManagementFactory.getOperatingSystemMXBean();

		String architecture = operatingSystemMXBean.getArch();
		String osName = operatingSystemMXBean.getName();
		String osVersion = operatingSystemMXBean.getVersion();
		int availableProcessors = operatingSystemMXBean.getAvailableProcessors();

		double osLoadAverage = operatingSystemMXBean.getSystemLoadAverage();
		double osLoadAveragePerProcessors = osLoadAverage / availableProcessors;

		HealthCheckResponseBuilder responseBuilder = HealthCheckResponse.named("system-load")
				.withData("name", osName)
				.withData("version", osVersion)
				.withData("architecture", architecture)
				.withData("processors", availableProcessors)
				.withData("loadAverage", String.valueOf(osLoadAverage))
				.withData("loadAverage per processor", String.valueOf(osLoadAveragePerProcessors))
				.withData("loadAverage max", String.valueOf(maxLoad));

		if(osLoadAverage>0){
			boolean status = osLoadAveragePerProcessors < maxLoad;
			return responseBuilder.state(status).build();
		}else{
			// Load average not available
			return responseBuilder.up().build();
		}

	}
}