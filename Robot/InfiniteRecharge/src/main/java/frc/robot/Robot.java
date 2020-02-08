package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.subsystems.LimelightVision;

public class Robot extends TimedRobot {

  RobotContainer m_robotContainer;
  Command m_autonomousCommand;

  @Override
  public void robotInit() {
    m_robotContainer = new RobotContainer();
    m_autonomousCommand = m_robotContainer.getAutonomousCommand();

    CommandScheduler.getInstance().cancelAll();
    CommandScheduler.getInstance().disable();
    LiveWindow.disableAllTelemetry();
  }

  /**
   * This function is called every robot packet, no matter the mode. Use this for items like
   * diagnostics that you want ran during disabled, autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before
   * LiveWindow and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
    // Runs the Scheduler.  This is responsible for polling buttons, adding newly-scheduled
    // commands, running already-scheduled commands, removing finished or interrupted commands,
    // and running subsystem periodic() methods.  This must be called from the robot's periodic
    // block in order for anything in the Command-based framework to work.
    CommandScheduler.getInstance().enable();
    CommandScheduler.getInstance().run();
  }

  @Override
  public void teleopPeriodic() {
    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }

    CommandScheduler.getInstance().enable();
    CommandScheduler.getInstance().run();

    LimelightVision.checkVal();
    LimelightVision.getArea();
  }

  @Override
  public void autonomousInit(){
    Command m_autonomousCommand = m_robotContainer.getAutonomousCommand();

    // schedule the autonomous command
    if (m_autonomousCommand != null) {
      CommandScheduler.getInstance().enable();
      m_autonomousCommand.schedule();
    }
  }
}
