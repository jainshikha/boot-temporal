package com.kk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kk.temporal.WorkFlow;

import io.temporal.client.WorkflowClient;
import io.temporal.client.WorkflowOptions;
import io.temporal.serviceclient.WorkflowServiceStubs;

@Service
public class ReleaseService {

	@Autowired
	WorkflowServiceStubs workflowServiceStubs;

	@Autowired
	WorkflowClient workflowClient;

	public String startQG1(String workflowId) {
		WorkFlow workflow = createWorkFlowConnection(workflowId);
		WorkflowClient.start(workflow::startReleaseApprovalWorkflow);
		// run campaign - success
		// email trigger - approval

		workflow.startReleaseApprovalWorkflow();
		return "release running";
	}

	public String signalGate2(String workflowId) {
		WorkFlow workflow = workflowClient.newWorkflowStub(WorkFlow.class, "DCO_" + workflowId);
		workflow.signalQG2();
		return "QG1 approved";
	}

	public String signalQG3(String workflowId) {
		WorkFlow workflow = workflowClient.newWorkflowStub(WorkFlow.class, "DCO_" + workflowId);
		workflow.signalQG3();
		return "QG2 approved";
	}

	public String signalQG4(String workflowId) {
		WorkFlow workflow = workflowClient.newWorkflowStub(WorkFlow.class, "DCO_" + workflowId);
		workflow.signalQG4();
		return "QG3 approved";
	}

	public String finalSignal(String workflowId) {
		WorkFlow workflow = workflowClient.newWorkflowStub(WorkFlow.class, "DCO_" + workflowId);
		workflow.finalsignal();
		return "READY FOR RELEASE";
	}
	
	public WorkFlow createWorkFlowConnection(String id) {
		WorkflowOptions options = WorkflowOptions.newBuilder().setTaskQueue(WorkFlow.QUEUE_NAME)
				.setWorkflowId("DCO_" + id).build();
		return workflowClient.newWorkflowStub(WorkFlow.class, options);
	}

}
