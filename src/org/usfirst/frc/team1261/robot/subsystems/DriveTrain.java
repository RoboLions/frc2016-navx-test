package org.usfirst.frc.team1261.robot.subsystems;

import org.usfirst.frc.team1261.robot.RobotMap;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveTrain extends Subsystem {

	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	CANTalon leftMotor = RobotMap.leftMotor;
	CANTalon rightMotor = RobotMap.rightMotor;
	Encoder leftEncoder = RobotMap.leftEncoder;
	Encoder rightEncoder = RobotMap.rightEncoder;
	RobotDrive robotDrive = RobotMap.driveTrain;
	AHRS navX = RobotMap.navX;

	public void initDefaultCommand() {
	}

	public double distanceTraveled() {
		return (leftDistanceTraveled() + rightDistanceTraveled()) / 2;
	}

	public double leftDistanceTraveled() {
		return leftEncoder.getDistance();
	}

	public double rightDistanceTraveled() {
		return rightEncoder.getDistance();
	}

	public void resetDistanceTraveled() {
		leftEncoder.reset();
		rightEncoder.reset();
	}

	public RobotDrive getRobotDrive() {
		return robotDrive;
	}
	
	public AHRS getNavX() {
		return navX;
	}
}
