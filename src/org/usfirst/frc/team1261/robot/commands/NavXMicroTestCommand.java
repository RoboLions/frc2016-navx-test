package org.usfirst.frc.team1261.robot.commands;

import org.usfirst.frc.team1261.robot.Robot;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.PIDCommand;

/**
 *
 */
public class NavXMicroTestCommand extends PIDCommand {

	private static final double kP = 0.01;
	private static final double kI = 0;
	private static final double kD = 0;
	private static final double TOLERANCE = 5.0;

	private static final double SETPOINT = 90.0;
	
	RobotDrive robotDrive;
	AHRS navX;
	float targetHeading;
	
    public NavXMicroTestCommand() {
    	super("NavXMicroTestCommand", kP, kI, kD);
    	
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.driveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	robotDrive = Robot.driveTrain.getRobotDrive();
    	navX = Robot.driveTrain.getNavX();
    	getPIDController().setAbsoluteTolerance(TOLERANCE);
    	navX.zeroYaw();
    	setSetpoint(SETPOINT);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return getPIDController().onTarget();
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }

	protected double returnPIDInput() {
		return navX.getYaw();
	}

	protected void usePIDOutput(double output) {
		robotDrive.setLeftRightMotorOutputs(output, -output);
	}
}
