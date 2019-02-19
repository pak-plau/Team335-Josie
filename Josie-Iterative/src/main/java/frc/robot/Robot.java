/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends TimedRobot {
  private static final String kDefaultAuto = "Default";
  private static final String kCustomAuto = "My Auto";
  private String m_autoSelected;
  private final SendableChooser<String> m_chooser = new SendableChooser<>();

  private WPI_TalonSRX leftMotor;
  private WPI_TalonSRX rightMotor;

  private DifferentialDrive differentialDrive;

  private Joystick leftJoystick;
  private Joystick rightJoystick;

  private Servo servo;

  @Override
  public void robotInit() {
    m_chooser.setDefaultOption("Default Auto", kDefaultAuto);
    m_chooser.addOption("My Auto", kCustomAuto);
    SmartDashboard.putData("Auto choices", m_chooser);

    leftMotor = new WPI_TalonSRX(1);
    rightMotor = new WPI_TalonSRX(0);

    leftMotor.setInverted(true);
    rightMotor.setInverted(false);

    differentialDrive = new DifferentialDrive(leftMotor, rightMotor);

    leftJoystick = new Joystick(0);
    rightJoystick = new Joystick(1);

    leftJoystick.setYChannel(1);
    rightJoystick.setYChannel(1);

    servo = new Servo(2);
  }

  @Override
  public void robotPeriodic() {
  }

  @Override
  public void autonomousInit() {
    m_autoSelected = m_chooser.getSelected();
    // autoSelected = SmartDashboard.getString("Auto Selector",
    // defaultAuto);
    System.out.println("Auto selected: " + m_autoSelected);
  }

  @Override
  public void autonomousPeriodic() {
  }

  @Override
  public void teleopPeriodic() {
    differentialDrive.tankDrive(leftJoystick.getY(), rightJoystick.getY());
    System.out.println("left joystick: " + leftJoystick.getY());
    System.out.println("right joystick: " + rightJoystick.getY());
    if (rightJoystick.getTrigger()) {
      servo.setAngle(90);
    } else {
      servo.setAngle(0);
    }
  }

  @Override
  public void testPeriodic() {
  }
}