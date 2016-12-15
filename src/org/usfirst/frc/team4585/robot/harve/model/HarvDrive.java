package org.usfirst.frc.team4585.robot.harve.model;

public class HarvDrive {
	MecanumDrive mecanumDrive;
	
	public HarvDrive(int frontLeft, int backLeft, int frontRight, int backRight){
		mecanumDrive = new MecanumDrive(frontLeft, backLeft, frontRight, backRight);
	}
}
