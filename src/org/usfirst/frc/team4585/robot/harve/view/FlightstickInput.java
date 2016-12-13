package org.usfirst.frc.team4585.robot.harve.view;

import edu.wpi.first.wpilibj.Joystick;
import java.lang.Math;

public class FlightstickInput {
	
	private double coeffX;
	private double coeffY;
	private double coeffZ;

	private double deadzoneX;
	private double deadzoneY;
	private double deadzoneZ;

	private double curveX;
	private double curveY;
	private double curveZ;
	
	Joystick joystick;
	
	public FlightstickInput(short port){
		this.coeffX = 1.0;
		this.coeffY = 1.0;
		this.coeffZ = 1.0;
		
		this.deadzoneX = 0.15;
		this.deadzoneY = 0.15;
		this.deadzoneZ = 0.15;
		
		this.curveX = 2;
		this.curveY = 2;
		this.curveZ = 2;
		
		joystick = new Joystick(port);
	}
	
	public double joyGetOutput(Axsis axsis){
		double number = 0;
		switch(axsis){
		case X: 
			number = joystick.getX();
			if(number <= deadzoneX && number>= - deadzoneX) number = 0;
			else{
			number = Math.copySign((Math.abs(number) - deadzoneX) *coeffX , number);
			number = Math.copySign(Math.pow(number, curveX), number);
			}
			break;
		case Y:
			number = joystick.getY();
			if(number <= deadzoneY && number>= - deadzoneY) number = 0;
			else{
			number = Math.copySign((Math.abs(number) - deadzoneY) *coeffY,number);
			number = Math.copySign(Math.pow(number, curveY), number);
			}
			break;
		case Z:
			number = joystick.getZ();
			if(number <= deadzoneZ && number>= - deadzoneZ) number = 0;
			else{
			number = Math.copySign((Math.abs(number) - deadzoneZ) *coeffZ,number);
			number = Math.copySign(Math.pow(number, curveZ), number);
			}
			break;
		default:
			break;
		}
		return number;
	}
	
	public boolean buttonGetOutput(int button){ 
		return joystick.getRawButton(button);
	}
	
	public void setCoefficiants(double coeffX, double coeffY,double coeffZ){
		this.coeffX = coeffX;
		this.coeffY = coeffY;
		this.coeffZ = coeffZ;
	}
	
	public void setDeadzones(double zoneX, double zoneY,double zoneZ){
		this.deadzoneX = zoneX;
		this.deadzoneY = zoneY;
		this.deadzoneZ = zoneZ;
	}
	
	public void setCurves(double curveX, double curveY, double curveZ){
		this.curveX = curveX;
		this.curveY = curveY;
		this.curveZ = curveZ;
	}

	public double getCoeffX() {
		return coeffX;
	}

	public void setCoeffX(double coeffX) {
		this.coeffX = coeffX;
	}

	public double getCoeffY() {
		return coeffY;
	}

	public void setCoeffY(double coeffY) {
		this.coeffY = coeffY;
	}

	public double getCoeffZ() {
		return coeffZ;
	}

	public void setCoeffZ(double coeffZ) {
		this.coeffZ = coeffZ;
	}

	public double getDeadzoneX() {
		return deadzoneX;
	}

	public void setDeadzoneX(double deadzoneX) {
		this.deadzoneX = deadzoneX;
	}

	public double getDeadzoneY() {
		return deadzoneY;
	}

	public void setDeadzoneY(double deadzoneY) {
		this.deadzoneY = deadzoneY;
	}

	public double getDeadzoneZ() {
		return deadzoneZ;
	}

	public void setDeadzoneZ(double deadzoneZ) {
		this.deadzoneZ = deadzoneZ;
	}

	public double getCurveX() {
		return curveX;
	}

	public void setCurveX(double curveX) {
		this.curveX = curveX;
	}

	public double getCurveY() {
		return curveY;
	}

	public void setCurveY(double curveY) {
		this.curveY = curveY;
	}

	public double getCurveZ() {
		return curveZ;
	}

	public void setCurveZ(double curveZ) {
		this.curveZ = curveZ;
	}

	public Joystick getJoystick() {
		return joystick;
	}

	public void setJoystick(Joystick joystick) {
		this.joystick = joystick;
	}
}
