package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.commands.DrivetrainDriveCommand;

public class Drivetrain extends Subsystem {
    private WPI_VictorSPX leftMotor;
    private WPI_VictorSPX rightMotor;

    private DifferentialDrive differentialDrive;

public Drivetrain() {
    leftMotor = new WPI_VictorSPX(1);
    rightMotor = new WPI_VictorSPX(0);

    leftMotor.setInverted(true);
    rightMotor.setInverted(false);

    leftMotor.setNeutralMode(NeutralMode.Brake);
    rightMotor.setNeutralMode(NeutralMode.Brake);

    differentialDrive = new DifferentialDrive(leftMotor, rightMotor);
}

    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new DrivetrainDriveCommand());
    }

    public void tankDrive(double left, double right) {
        differentialDrive.tankDrive(left, right);
    }

    public void stop() {
        tankDrive(0, 0);
    }
}