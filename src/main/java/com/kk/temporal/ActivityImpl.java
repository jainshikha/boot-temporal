package com.kk.temporal;

public class ActivityImpl implements Activity{
	
	@Override
	public String qualityGate1() {
		System.out.println("***** qualityGate 1 campaign is success, waiting for approval");
		return "approved";
	}

	@Override
	public String qualityGate2() {
		System.out.println("***** qualityGate 2 campaign is success, waiting for approval");
		return "approved";
	}

	@Override
	public String qualityGate3() {
		System.out.println("***** qualityGate 3 campaign is success, waiting for approval");
		return "approved";
	}

	@Override
	public String qualityGate4() {
		System.out.println("***** qualityGate 4 campaign is success, waiting for approval");
		return "READY FOR RELEASE";
	}

}
