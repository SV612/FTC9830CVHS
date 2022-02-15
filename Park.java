package org.firstinspires.ftc.teamcode.auton;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous
public class Park extends LinearOpMode {


    DcMotor frontLeft, frontRight, backLeft, backRight,duckMotor;

    private final ElapsedTime timer = new ElapsedTime();

    @Override
    public void runOpMode() throws InterruptedException {

        frontLeft = hardwareMap.get(DcMotor.class, "frontLeft");
        frontRight = hardwareMap.get(DcMotor.class, "frontRight");
        backLeft = hardwareMap.get(DcMotor.class, "backLeft");
        backRight = hardwareMap.get(DcMotor.class, "backRight");
        duckMotor = hardwareMap.get(DcMotor.class, "duckMotor");

        waitForStart();

        timer.reset();

        while (timer.seconds() < 3);

        while (timer.seconds() < 4.5) {
            frontLeft.setPower(0.8);
            frontRight.setPower(0.8);
            backLeft.setPower(0.8);
            backRight.setPower(0.8);
        }

        frontLeft.setPower(0);
        frontRight.setPower(0);
        backLeft.setPower(0);
        backRight.setPower(0);


    }



}
