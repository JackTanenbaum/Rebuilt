package frc.robot.subystem.feeder;


import edu.wpi.first.units.measure.AngularVelocity;
import edu.wpi.first.units.measure.Velocity;

public interface FeederIO {

    public void setVelocity(AngularVelocity velocity);
    public void readPeriodic();
    public void writePeriodic();
}
