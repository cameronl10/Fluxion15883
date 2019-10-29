package org.firstinspires.ftc.teamcode.team.fluxion15883.opmode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;

@TeleOp(name = "drive")
public class mecanumDriveTeleOp extends OpMode {
    private DcMotor backLeftDrive = null;
    private DcMotor backRightDrive = null;
    private DcMotor frontLeftDrive = null;
    private DcMotor frontRightDrive = null;
    private DcMotor armMotor = null;
    private Servo leftServo = null;
    private Servo rightServo = null;
    static final double finalSpeed = 0.6;
    @Override
    public void init(){
        backLeftDrive = hardwareMap.get(DcMotor.class,"back_left_drive");
        backRightDrive = hardwareMap.get(DcMotor.class,"back_right_drive");
        frontLeftDrive = hardwareMap.get(DcMotor.class,"front_left_drive");
        frontRightDrive = hardwareMap.get(DcMotor.class,"front_right_drive");
        armMotor = hardwareMap.get(DcMotor.class,"arm_motor");
        leftServo = hardwareMap.get(Servo.class,"left_servo");
        rightServo = hardwareMap.get(Servo.class,"right_servo");
    }
    @Override
    public void start(){

    }
    @Override
    public void loop(){
        //driving code
        float gamepad1LeftY = -gamepad1.left_stick_y;
        float gamepad1LeftX = gamepad1.left_stick_x;
        float gamepad1RightX = gamepad1.right_stick_x;

        float FrontLeft = gamepad1LeftY + gamepad1LeftX + gamepad1RightX;
        float FrontRight = -gamepad1LeftY + gamepad1LeftX + gamepad1RightX;
        float BackRight = -gamepad1LeftY - gamepad1LeftX + gamepad1RightX;
        float BackLeft = gamepad1LeftY - gamepad1LeftX + gamepad1RightX;

        FrontRight = Range.clip(FrontRight, -1, 1);
        FrontLeft = Range.clip(FrontLeft, -1, 1);
        BackLeft = Range.clip(BackLeft, -1, 1);
        BackRight = Range.clip(BackRight, -1, 1);

        frontRightDrive.setPower(FrontRight);
        frontLeftDrive.setPower(FrontLeft);
        backLeftDrive.setPower(BackLeft);
        backRightDrive.setPower(BackRight);

        telemetry.addData("Text", "*** Robot Data***");
        telemetry.addData("Joy XL YL XR",  String.format("%.2f", gamepad1LeftX) + " " +  String.format("%.2f", gamepad1LeftY) + " " +  String.format("%.2f", gamepad1RightX));
        telemetry.addData("f left pwr",  "front left  pwr: " + String.format("%.2f", FrontLeft));
        telemetry.addData("f right pwr", "front right pwr: " + String.format("%.2f", FrontRight));
        telemetry.addData("b right pwr", "back right pwr: " + String.format("%.2f", BackRight));
        telemetry.addData("b left pwr", "back left pwr: " + String.format("%.2f", BackLeft));

        //arm code
        if(gamepad2.y){
            armMotor.setPower(1 * 0.2);
        }
        if(gamepad2.a){
            armMotor.setPower(-1 * 0.2);
        }
        if(gamepad2.left_bumper){
            leftServo.setPosition(-0.5);
            rightServo.setPosition(0.5);
        }
        if(gamepad2.right_bumper){
            rightServo.setPosition(-0.5);
            leftServo.setPosition(0.5);
        }

        telemetry.addData("arm motor","arm motor power" + String.format("%.2f",armMotor.getPower()));
        telemetry.addData("r servo psn","right servo position" + String.format("%.2f",rightServo.getPosition()));
        telemetry.addData("l servo psn","left servo position" + String.format("%.2f",leftServo.getPosition()));
    }
    @Override
    public void stop(){

    }

}
