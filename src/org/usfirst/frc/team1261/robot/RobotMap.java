package org.usfirst.frc.team1261.robot;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.I2C;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.RobotDrive;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	// public static int leftMotor = 1;
	// public static int rightMotor = 2;

	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;

	public static CANTalon leftMotor;
	public static CANTalon rightMotor;
	public static Encoder leftEncoder;
	public static Encoder rightEncoder;
	public static RobotDrive driveTrain;
	public static AHRS navX;

	public static void init() {
		leftMotor = new CANTalon(1);
		rightMotor = new CANTalon(2);
		driveTrain = new RobotDrive(leftMotor, rightMotor);
		leftEncoder = new Encoder(6, 7);
		rightEncoder = new Encoder(8, 9);
		navX = new AHRS(I2C.Port.kMXP);
	}
}
