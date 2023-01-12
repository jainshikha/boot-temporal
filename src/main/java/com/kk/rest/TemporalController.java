package com.kk.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kk.redis.Release;
import com.kk.service.ReleaseService;

@RestController
public class TemporalController {
	@Autowired
	ReleaseService orderService;

	@GetMapping("/startReleaseWorkflow")
	public String startRelease(@RequestParam("id") String id) {
		return orderService.startQG1(id);
	}

	@GetMapping("/qg1Approved")
	// redis subs
	public String qg1Approved(@RequestParam("id") String id) {
		return orderService.signalGate2(id);
	}

	@GetMapping("/qg2Approved")
	public String qg2Approved(@RequestParam("id") String id) {
		return orderService.signalQG3(id);
	}

	@GetMapping("/qg3Approved")
	public String qg3Approved(@RequestParam("id") String id) {
		return orderService.signalQG4(id);
	}
	
	@GetMapping("/qg4Approved")
	public String qg4Approved(@RequestParam("id") String id) {
		return orderService.finalSignal(id);
	}
	
//	@Autowired
//	private MessagePublisher messagePublisher;
//
//
//    @PostMapping("/redis")
//    public void publishAMessage(@RequestBody Release release) {
//        messagePublisher.handleMessage(release);
//    }

}
