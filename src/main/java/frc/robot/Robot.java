/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.config.RobotMap;
import frc.robot.lib.KvLib;
import frc.robot.subsystems.Drive;

/**
 * This is a demo program showing the use of the RobotDrive class, specifically
 * it contains the code necessary to operate a robot with tank drive.
 */
public class Robot extends TimedRobot {

  // subclasses
  private Drive drive;
  private KvLib kvLib;

  // Xbox Controller
  private XboxController driver;

  @Override
  public void robotInit() {
    drive = new Drive();
    kvLib = new KvLib();
    driver = new XboxController(RobotMap.driverPort);
  }

  @Override
  public void teleopPeriodic() {

    double linearSpeed = kvLib.driveDeadband(-driver.getRawAxis(1));
    double curveSpeed = kvLib.driveDeadband(-driver.getRawAxis(4));

    drive.move(linearSpeed, curveSpeed, driver.getRawButton(6));
  }
}
