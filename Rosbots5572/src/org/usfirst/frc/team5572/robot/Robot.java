/* Team# 5572 - ROSBOTS - 
 * 
 * Authors: Mr. Rosellini, Wilson .....
 * 
 * Version 0.01
 * 
 * Date January 17, 2015
 */

package org.usfirst.frc.team5572.robot;

import org.usfirst.frc.team5572.robot.OI;
import org.usfirst.frc.team5572.robot.RobotMap;
import org.usfirst.frc.team5572.robot.subsystems.DriveTrain;
import org.usfirst.frc.team5572.robot.commands.*;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SampleRobot;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;


/*The period of the iterative robot is synced to the driver station control packets, 
 * giving a periodic frequency of about 50Hz (50 times per second). - disabledPeriodic()
 *  - autonomousPeriodic() - teleopPeriodic() - testPeriodoc()
 */

public class Robot extends IterativeRobot { 

	Command autonomousCommand;
	public static OI oi;
	public static DriveTrain driveTrain;
	
    CameraServer server;

    public Robot() {
        server = CameraServer.getInstance();
        server.setQuality(50);
        //the camera name (ex "cam0") can be found through the roborio web interface
        server.startAutomaticCapture("cam1");
    }
    
    public void operatorControl() {

        while (isOperatorControl() && isEnabled()) {
            /** robot code here! **/
            Timer.delay(0.005);		// wait for a motor update time
        }
    }    
    
    public void robotInit() {
    	    	    
        RobotMap.init();
           
            driveTrain = new DriveTrain();
            // lift = new Lift();


            oi = new OI();

            autonomousCommand = new AutonomousCommand();

   }
    
    
    public void disabledInit(){

    }

    public void disabledPeriodic() {
        Scheduler.getInstance().run();
    }

    public void autonomousInit() {
        // schedule the autonomous command (example)
        if (autonomousCommand != null) autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
        // This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) autonomousCommand.cancel();
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }

    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
    

}