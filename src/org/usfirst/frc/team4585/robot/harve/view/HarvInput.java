package org.usfirst.frc.team4585.robot.harve.view;

public class HarvInput {
	
	FlightstickInput flightstick;
	GamepadInput gamepad;
	
	public HarvInput(short flightstickPort){
		
		flightstick = new FlightstickInput(flightstickPort);
		
	}
	
	public boolean getButtonPressed(int button){
		return flightstick.buttonGetOutput(button);
	}
	
	public double getAngle(){ // get the angle of the input
		double angle = 0;
		angle = Math.toDegrees(Math.atan2(flightstick.getOutput(Axsis.Y), flightstick.getOutput(Axsis.X)));
		return angle;
	}
	
	public double getMagX() {
		
		//Create variables
		double magX = flightstick.getOutput(Axsis.X);
		double magY = flightstick.getOutput(Axsis.Y);
		double angle = 0;
		
		//Find the angle
		angle = Math.toDegrees(Math.atan2(magX, magY));
		
		//Based on the angle, find the x value on the unit circle, then multiply it by the actual magnitude to get the correct x-value
		magX = Math.cos(angle) * Math.abs(magX);
		
		return magX;
		
	}
	
	public double getMagY() {
		
		//Create variables
		double magX = flightstick.getOutput(Axsis.X);
		double magY = flightstick.getOutput(Axsis.Y);
		double angle = 0;
		
		//Find the angle
		angle = Math.toDegrees(Math.atan2(magX, magY));
		
		//Based on the angle, find the x value on the unit circle, then multiply it by the actual magnitude to get the correct x-value
		magY = Math.cos(angle) * Math.abs(magY);
		
		return magY;
		
	}
	
	public double getMagRot() {
		
		double magX = this.getMagX();
		double magY = this.getMagY();
		double magRot = flightstick.getOutput(Axsis.Z);
		
		if(!(Math.abs(magRot) <= 1 - (Math.abs(magX) + Math.abs(magY)))) {
			
			magRot = Math.copySign(1 - (Math.abs(magX) + Math.abs(magY)), magRot);
			
		}
		
		return magRot;
		
	}
	
}
