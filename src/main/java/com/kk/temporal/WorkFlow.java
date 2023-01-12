package com.kk.temporal;

import io.temporal.workflow.SignalMethod;
import io.temporal.workflow.WorkflowInterface;
import io.temporal.workflow.WorkflowMethod;

@WorkflowInterface
public interface WorkFlow {

	public static final String QUEUE_NAME = "release";

	@WorkflowMethod
	void startReleaseApprovalWorkflow();

	//@QueryMethod
	@SignalMethod
	void signalQG2();

	@SignalMethod
	void signalQG3();
	
	@SignalMethod
	void signalQG4();
	
	@SignalMethod
	void finalsignal();
	
}