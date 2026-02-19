package frc.robot.subystem.drivetrain;

import com.ctre.phoenix6.StatusSignal;
import com.ctre.phoenix6.hardware.Pigeon2;
import edu.wpi.first.math.estimator.SwerveDrivePoseEstimator;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.kinematics.SwerveModulePosition;
import edu.wpi.first.units.Units;
import edu.wpi.first.units.measure.Angle;

public class Drivetrain {
    private static final Drivetrain instance = new Drivetrain();
    public static Drivetrain getInstance(){
        return instance;
    }
    private final Pigeon2 gyro;
    private final StatusSignal<Angle> yawSignal;

    private final SwerveModuleIO frontLeftModule;
    private final SwerveModuleIO frontRightModule;
    private final SwerveModuleIO backLeftModule;
    private final SwerveModuleIO backRightModule;

    private final SwerveDrivePoseEstimator estimator;

    private SwerveModuleIO control;

    private Drivetrain() {
        gyro = new Pigeon2(DrivetrainConstants.GYRO_ID, DrivetrainConstants.DRIVETRAIN_CANBUS);
        yawSignal = gyro.getYaw();
        yawSignal.setUpdateFrequency(250);

        frontLeftModule = new TalonFXSwerveModule(SwerveModule.FrontLeft);
        frontRightModule = new TalonFXSwerveModule(SwerveModule.FrontRight);
        backLeftModule = new TalonFXSwerveModule(SwerveModule.BackLeft);
        backRightModule = new TalonFXSwerveModule(SwerveModule.BackRight);

        estimator = new SwerveDrivePoseEstimator(
                DrivetrainConstants.SWERVE_KINEMATICS,
                Rotation2d.fromRotations(yawSignal.getValue().in(Units.Radians)),
                new SwerveModulePosition[]{
                        frontLeftModule.
                }
        )

    }

    public static Drivetrain getInstance(){
        return instance;
    }
}
