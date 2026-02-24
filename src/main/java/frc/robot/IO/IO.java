package frc.robot.IO;

import edu.wpi.first.wpilibj.XboxController;

import java.util.HashMap;
import java.util.function.BooleanSupplier;
import java.util.function.DoubleSupplier;

public class IO {
    private static final XboxController primary = new XboxController(0);
    private static final XboxController secondary = new XboxController(1);

    private static final HashMap<Controls, DoubleSupplier> controlsAnalog = new HashMap<>();
    private static final HashMap<Controls, BooleanSupplier> controlsDigital = new HashMap<>();

    public static void Init() {


    }

     public static DoubleSupplier getJoystick(Controls controls) {
        return controlsAnalog.get(controls);
     }

     public static BooleanSupplier getJoystickDigital(Controls controls) {
        return controlsDigital.get(controls);
     }
}
