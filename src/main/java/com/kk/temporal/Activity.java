package com.kk.temporal;

import io.temporal.activity.ActivityInterface;
import io.temporal.activity.ActivityMethod;

@ActivityInterface
public interface Activity {

	@ActivityMethod
	String qualityGate1();

	@ActivityMethod
	String qualityGate2();

	@ActivityMethod
	String qualityGate3();

	@ActivityMethod
	String qualityGate4();
}