package org.usfirst.frc.team4585.robot.harve.controller;

import edu.wpi.first.wpilibj.SampleRobot;
import org.usfirst.frc.team4585.robot.harve.model.*;
import org.usfirst.frc.team4585.robot.harve.view.*;

public class HarvController extends SampleRobot{
	
	HarvDrive drive;
	HarvInput input;
	HarvAutonomous autonomous;
	
	public HarvController(){
		drive = new HarvDrive(0,1,2,3);
		input = new HarvInput();
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
			
		}
		
	}
	
	public void test(){
		while(isTest() && isEnabled()){
			
		}
	}
}
