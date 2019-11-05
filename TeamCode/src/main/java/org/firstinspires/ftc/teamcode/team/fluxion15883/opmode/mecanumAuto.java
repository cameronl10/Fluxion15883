package org.firstinspires.ftc.teamcode.team.fluxion15883.opmode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name="meacnumAuto")
public class mecanumAuto extends LinearOpMode
{
    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor backLeftDrive = null;
    private DcMotor backRightDrive = null;
    private DcMotor frontLeftDrive = null;
    private DcMotor frontRightDrive = null;
    private DcMotor armMotor = null;
    private Servo leftServo = null;
    private Servo rightServo = null;
    static final double speed = 0.6;
    public void runOpMode(){

        backLeftDrive = hardwareMap.get(DcMotor.class,"back_left_drive");
        backRightDrive = hardwareMap.get(DcMotor.class,"back_right_drive");
        frontLeftDrive = hardwareMap.get(DcMotor.class,"front_left_drive");
        frontRightDrive = hardwareMap.get(DcMotor.class,"front_right_drive");

        armMotor = hardwareMap.get(DcMotor.class,"arm_motor");
        leftServo = hardwareMap.get(Servo.class,"left_servo");
        rightServo = hardwareMap.get(Servo.class,"right_servo");

        waitForStart();

        runtime.reset();

        forward(2);
        runtime.reset();

        backward(2);
        runtime.reset();

        rightShift(2);
        runtime.reset();

        leftShift(2);
        runtime.reset();

        cwTurn(2);
        runtime.reset();

        ccwTurn(2);
        runtime.reset();
    }
    public void forward(int x){
        backLeftDrive.setPower(speed);
        frontLeftDrive.setPower(speed);
        frontRightDrive.setPower(speed);
        backRightDrive.setPower(speed);

        while (opModeIsActive() && (runtime.seconds() < x)) {
            telemetry.addData("Path", "Forward", runtime.seconds());
            telemetry.update();
            idle();
        }
    }
    public void backward(int x){
        backLeftDrive.setPower(-speed);
        frontLeftDrive.setPower(-speed);
        frontRightDrive.setPower(-speed);
        backRightDrive.setPower(-speed);

        while (opModeIsActive() && (runtime.seconds() < x)) {
            telemetry.addData("Path", "Backward", runtime.seconds());
            telemetry.update();
            idle();
        }
    }

    public void rightShift(int x){
        backLeftDrive.setPower(-speed);
        backRightDrive.setPower(speed);
        frontLeftDrive.setPower(speed);
        frontRightDrive.setPower(-speed);

        while (opModeIsActive() && (runtime.seconds() < x)) {
            telemetry.addData("Path", "right shift", runtime.seconds());
            telemetry.update();
            idle();
        }
    }
    public void leftShift(int x){
        frontRightDrive.setPower(speed);
        backRightDrive.setPower(speed);
        frontLeftDrive.setPower(-speed);
        backLeftDrive.setPower(-speed);

        while (opModeIsActive() && (runtime.seconds() < x)) {
            telemetry.addData("Path", "left shift", runtime.seconds());
            telemetry.update();
            idle();
        }
    }

    public void cwTurn(int x){
        frontLeftDrive.setPower(speed);
        backRightDrive.setPower(speed);
        frontRightDrive.setPower(-speed);
        backRightDrive.setPower(-speed);

        while (opModeIsActive() && (runtime.seconds() < x)) {
            telemetry.addData("Path", "clockwise turn", runtime.seconds());
            telemetry.update();
            idle();
        }
    }

    public void ccwTurn(int x){
        frontLeftDrive.setPower(-speed);
        backRightDrive.setPower(-speed);
        frontRightDrive.setPower(speed);
        backRightDrive.setPower(speed);

        while (opModeIsActive() && (runtime.seconds() < x)) {
            telemetry.addData("Path", "counterclockwise turn", runtime.seconds());
            telemetry.update();
            idle();
        }
    }
}
