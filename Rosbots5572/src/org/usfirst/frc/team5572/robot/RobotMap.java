package org.usfirst.frc.team5572.robot;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.PIDSource.PIDSourceParameter;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */

public class RobotMap {
    public static Talon driveTrainTalon0;
    public static Talon driveTrainTalon1;
    public static RobotDrive driveTrainRobotDrive;
    public static Encoder liftEncoder1;
    public static Talon liftTalon2;
    
      public static void init() {
                
    	driveTrainTalon0 = new Talon(0);
        LiveWindow.addActuator("DriveTrain", "Talon0", (Talon) driveTrainTalon0);
        
        driveTrainTalon1 = new Talon(1);
        LiveWindow.addActuator("DriveTrain", "Talon1", (Talon) driveTrainTalon1);
        
        driveTrainRobotDrive = new RobotDrive(driveTrainTalon0, driveTrainTalon1);
        
        driveTrainRobotDrive.setSafetyEnabled(true);
        driveTrainRobotDrive.setExpiration(0.1);
        driveTrainRobotDrive.setSensitivity(0.5);
        driveTrainRobotDrive.setMaxOutput(1.0);
        

        liftEncoder1 = new Encoder(0, 1, false, EncodingType.k4X);
        LiveWindow.addSensor("Lift", "Encoder1", liftEncoder1);
        liftEncoder1.setDistancePerPulse(1.0);
        liftEncoder1.setPIDSourceParameter(PIDSourceParameter.kRate);
        liftTalon2 = new Talon(2);
        LiveWindow.addActuator("Lift", "Talon2", (Talon) liftTalon2);
        
    
    }
}
