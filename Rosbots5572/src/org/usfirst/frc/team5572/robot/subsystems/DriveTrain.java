

package org.usfirst.frc.team5572.robot.subsystems;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc.team5572.robot.RobotMap;

/**
 *
 */
public class DriveTrain extends Subsystem {
   
    Talon talon0 = RobotMap.driveTrainTalon0;
    Talon talon1 = RobotMap.driveTrainTalon1;
    RobotDrive robotDrive = RobotMap.driveTrainRobotDrive;

        
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
       setDefaultCommand(new AracadeDrive());

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
	
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    
    public void arcadeDrive(Joystick drivestick){
    	robotDrive.arcadeDrive(drivestick);
    }
    
    public void driveStraight(double speed){
    	robotDrive.tankDrive(speed, speed);
    }
    
    public void moveback(){
    	
    }
}

