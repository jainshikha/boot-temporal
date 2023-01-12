package com.kk;
//https://github.com/ThinkOnceCodeAnywhere/Temporal_SpringBoot
// TTF Tech Travel Food - UT
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.kk.temporal.Activity;
import com.kk.temporal.WorkFlow;
import com.kk.temporal.WorkflowImpl;

import io.temporal.worker.Worker;
import io.temporal.worker.WorkerFactory;

@SpringBootApplication
public class BootTemporalApplication {

	public static void main(String[] args) {
		
		ConfigurableApplicationContext appContext = SpringApplication.run(BootTemporalApplication.class, args);
		WorkerFactory factory = appContext.getBean(WorkerFactory.class);
		Activity signUpActivity = appContext.getBean(Activity.class);
		Worker worker = factory.newWorker(WorkFlow.QUEUE_NAME);
		worker.registerWorkflowImplementationTypes(WorkflowImpl.class);
		worker.registerActivitiesImplementations(signUpActivity);
		factory.start();
		
		
	}

}
