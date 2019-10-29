package org.firstinspires.ftc.teamcode.team.fluxion15883.opmode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
@Autonomous(name="drive test")
public class autoDriveTest extends LinearOpMode {
    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor leftDrive = null;
    private DcMotor rightDrive = null;
    static final double finalSpeed = 0.6;

    @Override
    public void runOpMode() {

        telemetry.addData("Status", "Initialized");

        leftDrive = hardwareMap.get(DcMotor.class, "left_drive");
        rightDrive = hardwareMap.get(DcMotor.class, "right_drive");
        telemetry.update();

        waitForStart();

        leftDrive.setPower(finalSpeed);
        rightDrive.setPower(-finalSpeed);

        runtime.reset();
        while (opModeIsActive() && (runtime.seconds() < 2.2)) {
            telemetry.addData("Path", "Leg 1: %2.5f S Elapsed", runtime.seconds());
            telemetry.update();
            idle();
        }
    }
}
