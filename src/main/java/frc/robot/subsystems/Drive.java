package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.SpeedController;
import frc.robot.config.RobotMap;
import frc.robot.lib.KvLib;

public class Drive {
    private WPI_TalonSRX m_leftDriveBack, m_leftDriveFront, m_rightDriveBack, m_rightDriveFront;

    //subsystems
    private KvLib kvLib;

    

    public Drive() {

        kvLib = new KvLib(); 

        m_leftDriveBack = new WPI_TalonSRX(RobotMap.m_leftDriveBack);
        m_leftDriveFront = new WPI_TalonSRX(RobotMap.m_leftDriveFront);
        m_rightDriveBack = new WPI_TalonSRX(RobotMap.m_rightDriveBack);
        m_rightDriveFront = new WPI_TalonSRX(RobotMap.m_rightDriveFront);

        


    }
}
