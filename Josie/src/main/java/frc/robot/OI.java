package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
//import edu.wpi.first.wpilibj.buttons.JoystickButton;
//import frc.robot.commands.CargoMechanismClose;
//import frc.robot.commands.CargoMechanismOpen;

public class OI {

    public Joystick leftJoystick;
    public Joystick rightJoystick;
    
    public OI() {
        leftJoystick = new Joystick(0);
        rightJoystick = new Joystick(1);
        //rightTrigger = new JoystickButton(rightJoystick, 0);

        //leftJoystick.setYChannel(1);
        //rightJoystick.setYChannel(1);

        //rightTrigger.whenPressed(new CargoMechanismOpen());
        //rightTrigger.whenReleased(new CargoMechanismClose());
    }
}