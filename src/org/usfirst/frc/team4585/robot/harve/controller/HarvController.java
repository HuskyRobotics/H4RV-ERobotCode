package org.usfirst.frc.team4585.robot.harve.controller;

import edu.wpi.first.wpilibj.SampleRobot;
import org.usfirst.frc.team4585.robot.harve.model.*;
import org.usfirst.frc.team4585.robot.harve.model.autonomaus.HarvAutonomous;
import org.usfirst.frc.team4585.robot.harve.view.*;

public class HarvController extends SampleRobot{
	
	HarvDrive drive;
	HarvInput input;
	HarvAutonomous autonomous;
	
	public HarvController(){
		drive = new HarvDrive(0,1,2,3);
		input = new HarvInput((short)1 );
		autonomous = new HarvAutonomous();
	}
	
	public void robotinit(){
		
	}
	
	public void disabled(){
		
	}
	
	public void autonomous(){
		while(isAutonomous() && isEnabled()){
			//put auto operation code here.
			
		}
	}
	
	public void operatorControl(){
		while(isOperatorControl()&& isEnabled() ){
			//put human operation code here.
			ConservationVonMomentumDriveMode(); // this is ment to mess wiht castleton
			//drive.updateSpeed(input.getMagX(), input.getMagY(), input.getMagRot());
			
		}
		
	}
	
	public void test(){
		while(isTest() && isEnabled()){
			
		}
	}
	
	void ConservationVonMomentumDriveMode(){
		double xMotion = 0, yMotion = 0, zMotion = 0, acceleration;
		acceleration = .025;
		xMotion += input.getMagX() * acceleration;
		yMotion += input.getMagY() * acceleration;
		zMotion += input.getMagRot() * acceleration;
		drive.updateSpeed(xMotion, yMotion, zMotion);
	}
}
