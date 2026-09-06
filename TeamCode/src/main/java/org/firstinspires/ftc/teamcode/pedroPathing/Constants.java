package org.firstinspires.ftc.teamcode.pedroPathing;

import com.pedropathing.follower.Follower;
import com.pedropathing.follower.FollowerConstants;
import com.pedropathing.ftc.FollowerBuilder;
import com.pedropathing.paths.PathConstraints;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.pedropathing.control.PIDFCoefficients;
import com.pedropathing.control.FilteredPIDFCoefficients;
import com.pedropathing.ftc.drivetrains.MecanumConstants;
import com.pedropathing.ftc.localization.Encoder;
import com.pedropathing.ftc.localization.constants.DriveEncoderConstants;
import com.pedropathing.ftc.localization.constants.PinpointConstants;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.teamcode.GoBildaPinpointDriver;

public class Constants {
    // Tuning Needed
    public static FollowerConstants followerConstants = new FollowerConstants()
            .mass(10.0)
            .forwardZeroPowerAcceleration(-31.308)
            .lateralZeroPowerAcceleration(-68.952)
            .useSecondaryTranslationalPIDF(true)
            .useSecondaryHeadingPIDF(true)
            .useSecondaryDrivePIDF(true)
            .centripetalScaling(0.0007)
            .translationalPIDFCoefficients(new PIDFCoefficients(0.1, 0, 0.01, 0.01))
            .headingPIDFCoefficients(new PIDFCoefficients(1.25, 0, 0.005, 0.01))
            .drivePIDFCoefficients(new FilteredPIDFCoefficients(0.005, 0, 0.001, 0.6, 0))
            .secondaryTranslationalPIDFCoefficients(new PIDFCoefficients(0.2, 0, 0.02, 0.01))
            .secondaryHeadingPIDFCoefficients(new PIDFCoefficients(2.75, 0, 0.003, 0))
            .secondaryDrivePIDFCoefficients(new FilteredPIDFCoefficients(.05, 0, 0.001, 0.6, 0))
            .headingPIDFSwitch(0.07)
            .translationalPIDFSwitch(10);

    // Tuning Needed
    public static DriveEncoderConstants robotConstants = new DriveEncoderConstants()
            .robotWidth(12.5)
            .robotLength(10.125);

    // Tuning Needed
    public static MecanumConstants driveConstants = new MecanumConstants()
            .leftFrontMotorName("leftFront")
            .leftRearMotorName("leftRear")
            .rightFrontMotorName("rightFront")
            .rightRearMotorName("rightRear")
            .leftFrontMotorDirection(DcMotorEx.Direction.REVERSE)
            .leftRearMotorDirection(DcMotorEx.Direction.REVERSE)
            .rightFrontMotorDirection(DcMotorEx.Direction.FORWARD)
            .rightRearMotorDirection(DcMotorEx.Direction.FORWARD)
            .xVelocity(62.922) //63.3, 62.9, 63.3, 62.09, 63.02
            .yVelocity(50.732) //50.73, 50.4, 50.91, 50.66, 50.97
            .useVoltageCompensation(true)
            .useBrakeModeInTeleOp(true);

    // Tuned for Test Chassis
    public static PinpointConstants localizerConstants = new PinpointConstants()
            .forwardPodY(90.49)
            .strafePodX(76.20)
            .distanceUnit(DistanceUnit.MM)
            .hardwareMapName("pinpoint")
            .yawScalar(1.0)
            .encoderResolution(com.qualcomm.hardware.gobilda.GoBildaPinpointDriver.GoBildaOdometryPods.goBILDA_4_BAR_POD)
            .forwardEncoderDirection(com.qualcomm.hardware.gobilda.GoBildaPinpointDriver.EncoderDirection.FORWARD)
            .strafeEncoderDirection(com.qualcomm.hardware.gobilda.GoBildaPinpointDriver.EncoderDirection.REVERSED);

    // Tuning Needed
    public static PathConstraints pathConstraints = new PathConstraints(
            0.99,
            100,
            1,
            1);

    public static Follower createFollower(HardwareMap hardwareMap) {
        return new FollowerBuilder(followerConstants, hardwareMap)
                .mecanumDrivetrain(driveConstants)
                .driveEncoderLocalizer(robotConstants)
                .pinpointLocalizer(localizerConstants)
                .pathConstraints(pathConstraints)
                .build();
    }
}
