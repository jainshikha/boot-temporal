package com.kk.temporal;

import java.time.Duration;

import io.temporal.activity.ActivityOptions;
import io.temporal.common.RetryOptions;
import io.temporal.workflow.Workflow;

public class WorkflowImpl implements WorkFlow {

	private final RetryOptions retryoptions = RetryOptions.newBuilder().setInitialInterval(Duration.ofSeconds(1))
			.setMaximumInterval(Duration.ofSeconds(100)).setBackoffCoefficient(2).setMaximumAttempts(50000).build();
	private final ActivityOptions options = ActivityOptions.newBuilder().setStartToCloseTimeout(Duration.ofSeconds(30))
			.setRetryOptions(retryoptions).build();

	private final Activity activity = Workflow.newActivityStub(Activity.class, options);

	public boolean isQualityGate1Approved = false;

	public boolean isQualityGate2Approved = false;

	public boolean isQualityGate3Approved = false;

	public boolean isQualityGate4Approved = false;

	@Override
	public void startReleaseApprovalWorkflow() {

		activity.qualityGate1();

		System.out.println("***** Waiting for approval QG1");
		Workflow.await(() -> isQualityGate1Approved);

		System.out.println("***** QG1 is approved, starting QG2");

		System.out.println("***** ***** Waiting for approval QG2");
		Workflow.await(() -> isQualityGate2Approved);

		System.out.println("***** QG2 is approved, starting QG3");

		System.out.println("***** ***** Waiting for approval QG3");
		Workflow.await(() -> isQualityGate3Approved);

		System.out.println("***** QG3 is approved, starting QG4");

		System.out.println("***** ***** Waiting for approval QG4");
		Workflow.await(() -> isQualityGate4Approved);

		System.out.println("***** QG4 is approved, READY FOR RELEASE");

		// return "READY FOR RELEASE";

	}

	@Override
	public void signalQG2() {
		this.isQualityGate1Approved = true;
		activity.qualityGate2();
	}

	@Override
	public void signalQG3() {
		this.isQualityGate2Approved = true;
		activity.qualityGate3();
	}

	@Override
	public void signalQG4() {
		this.isQualityGate3Approved = true;
		activity.qualityGate4();
	}
	
	@Override
	public void finalsignal() {
		this.isQualityGate4Approved = true;
	}

}
