package org.usfirst.frc.team4500.robot.subsystems;

import org.usfirst.frc.team4500.robot.RobotMap;
import org.usfirst.frc.team4500.robot.commands.DriveWithJoystick;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.RobotDrive.MotorType;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Drivetrain extends Subsystem {
    
	//Drive Motors
	Talon flMotor = new Talon(RobotMap.flmotorPort);
	Talon frMotor = new Talon(RobotMap.frmotorPort);
	Talon blMotor = new Talon(RobotMap.blmotorPort);
	Talon brMotor = new Talon(RobotMap.brmotorPort);
	
	RobotDrive drive = new RobotDrive(flMotor,blMotor,frMotor,brMotor);
	
	public void driveWithJoystick(double x, double y, double rotation) {
		drive.mecanumDrive_Cartesian(x, y, rotation, 0);
	}
	
	public void invertDriveMotors(){
		drive.setInvertedMotor(MotorType.kFrontRight, true);
		drive.setInvertedMotor(MotorType.kRearRight, true);
	}
	
    public void initDefaultCommand() {
    	setDefaultCommand (new DriveWithJoystick());
    }
}

