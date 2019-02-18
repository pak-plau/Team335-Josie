package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;

public class CargoMechanism extends Subsystem {

    Servo servo;

    public CargoMechanism() {
        servo = new Servo(2);
    }

    public void open() {
        servo.setAngle(90);
    }

    public void close() {
        servo.setAngle(0);
    }
    @Override
    protected void initDefaultCommand() {

    }

}