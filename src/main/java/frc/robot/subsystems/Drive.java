package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.config.RobotMap;
import frc.robot.lib.KvLib;

public class Drive {
    private WPI_TalonSRX m_leftDriveBack, m_leftDriveFront, m_rightDriveBack, m_rightDriveFront;

    //subsystems
    private KvLib kvLib;

    //Motor Speed Controllers
    SpeedController leftDriveFrontController = new WPI_TalonSRX(RobotMap.m_leftDriveBack);
    SpeedController leftDriveBackController = new WPI_TalonSRX(RobotMap.m_leftDriveFront);
    SpeedController rightDriveFrontController = new WPI_TalonSRX(RobotMap.m_rightDriveFront);
    SpeedController rigthDriveBackController = new WPI_TalonSRX(RobotMap.m_rightDriveBack);

    private SpeedControllerGroup leftDrive = new SpeedControllerGroup(leftDriveFrontController, leftDriveBackController);
    private SpeedControllerGroup rightDrive = new SpeedControllerGroup(rightDriveFrontController, rigthDriveBackController);

    private DifferentialDrive testdrive;

    public Drive() {

        kvLib = new KvLib(); 

        kvLib.setDriveTrainCurrentLimiting(m_leftDriveBack);
        kvLib.setDriveTrainCurrentLimiting(m_leftDriveFront);
        kvLib.setDriveTrainCurrentLimiting(m_rightDriveBack);
        kvLib.setDriveTrainCurrentLimiting(m_rightDriveFront);
    
        testdrive = new DifferentialDrive(leftDrive, rightDrive);

        


    }

    public void move(double linearSpeed, double curveSpeed, boolean quickT) {

        testdrive.curvatureDrive(linearSpeed, curveSpeed, quickT);
    }
}

