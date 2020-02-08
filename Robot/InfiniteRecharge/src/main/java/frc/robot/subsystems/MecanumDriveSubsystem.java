package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import com.ctre.phoenix.motorcontrol.can.*;
import frc.robot.Constants;

public class MecanumDriveSubsystem extends SubsystemBase {
  private MecanumDrive m_robotDrive;
  private boolean driveMethodCartesian = true;

  /**
   * Creates a new MecanumDriveSubsystem.
   */
  public MecanumDriveSubsystem() {
    WPI_TalonFX frontLeft = new WPI_TalonFX(Constants.kFrontLeftChannel);
    WPI_TalonFX rearLeft = new WPI_TalonFX(Constants.kRearLeftChannel);
    WPI_TalonFX frontRight = new WPI_TalonFX(Constants.kFrontRightChannel);
    WPI_TalonFX rearRight = new WPI_TalonFX(Constants.kRearRightChannel);

    m_robotDrive = new MecanumDrive(frontLeft, rearLeft, frontRight, rearRight);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run

  }
  public void driveCartesian(double xval, double yval, double zval, double gyroval)
  {
    m_robotDrive.driveCartesian(xval,-yval, zval, gyroval);
  }

  public void drivePolar(double magval, double angleval, double zrotval)
  {
    m_robotDrive.drivePolar(magval, angleval, zrotval);
  }

  public boolean getDriveMethodCartesian(){
    return this.driveMethodCartesian;
  }
  
  public void setDriveMethodCartesian(boolean driveMethod){
    this.driveMethodCartesian = driveMethod;
  }
}
