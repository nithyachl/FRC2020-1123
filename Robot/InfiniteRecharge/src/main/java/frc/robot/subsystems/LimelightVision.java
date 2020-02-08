package frc.robot.subsystems;

import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class LimelightVision extends SubsystemBase {
    // static boolean ledState = true;

    /**
     * Creates a new MecanumDriveSubsystem.
     */
    public LimelightVision() {

    }

    public static void checkVal() {
        Double xval = NetworkTableInstance.getDefault().getTable("limelight").getEntry("tx").getDouble(0.0);
        Double yval = NetworkTableInstance.getDefault().getTable("limelight").getEntry("ty").getDouble(0.0);
        SmartDashboard.putNumber("Xval", xval);
        SmartDashboard.putNumber("Yval", yval);
    }

    public static void getArea() {
        Double area = NetworkTableInstance.getDefault().getTable("limelight").getEntry("ta").getDouble(0.0);
        SmartDashboard.putNumber("Area", area);
    }

    public static void switchLEDState() {
        System.out.println("In setLED()");
        Number ledState = NetworkTableInstance.getDefault().getTable("limelight").getEntry("ledMode").getNumber(1);
        System.out.println("Current LED state is : " + ledState.intValue());
        if (ledState.intValue() == 1) {
            NetworkTableInstance.getDefault().getTable("limelight").getEntry("ledMode").setNumber(3);
        }
        else if (ledState.intValue() == 3) {
            NetworkTableInstance.getDefault().getTable("limelight").getEntry("ledMode").setNumber(1);
        }
    }
}