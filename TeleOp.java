  /* Copyright (c) 2017 FIRST. All rights reserved.
   *
   * Redistribution and use in source and binary forms, with or without modification,
   * are permitted (subject to the limitations in the disclaimer below) provided that
   * the following conditions are met:
   *
   * Redistributions of source code must retain the above copyright notice, this list
   * of conditions and the following disclaimer.
   *
   * Redistributions in binary form must reproduce the above copyright notice, this
   * list of conditions and the following disclaimer in the documentation and/or
   * other materials provided with the distribution.
   *
   * Neither the name of FIRST nor the names of its contributors may be used to endorse or
   * promote products derived from this software without specific prior written permission.
   *
   * NO EXPRESS OR IMPLIED LICENSES TO ANY PARTY'S PATENT RIGHTS ARE GRANTED BY THIS
   * LICENSE. THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
   * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
   * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
   * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE
   * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
   * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
   * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
   * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
   * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
   * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
   */
  
  package org.firstinspires.ftc.teamcode.TeleOp;
  
  import com.qualcomm.robotcore.eventloop.opmode.Disabled;
  import com.qualcomm.robotcore.eventloop.opmode.OpMode;
  import com.qualcomm.robotcore.hardware.DcMotor;
  import com.qualcomm.robotcore.hardware.DcMotorSimple;
  import com.qualcomm.robotcore.hardware.Servo;
  import com.qualcomm.robotcore.util.ElapsedTime;
  
  /**
   * Demonstrates empty OpMode
   */
  @com.qualcomm.robotcore.eventloop.opmode.TeleOp(name = "Concept: NullOp", group = "Concept")
  
  public class TeleOp<oldServoButton, servoButton> extends OpMode {

    DcMotor frontLeft, frontRight, backLeft, backRight, duckMotor, rackMotor;

    Servo leftRackClaw, rightRackClaw;

    private double servoPos;
    private boolean oldServoButton;
    private ElapsedTime runtime = new ElapsedTime();
    private Object Servo;

    @Override
    public void init() {
      telemetry.addData("Status", "Initialized");
      frontLeft = hardwareMap.get(DcMotor.class, "frontLeft");
      frontRight = hardwareMap.get(DcMotor.class, "frontRight");
      backLeft = hardwareMap.get(DcMotor.class, "backLeft");
      backRight = hardwareMap.get(DcMotor.class, "backRight");
      duckMotor = hardwareMap.get(DcMotor.class, "duckMotor");
      leftRackClaw = hardwareMap.get(Servo.class, "leftRackClaw");
      rightRackClaw = hardwareMap.get(Servo.class, "rightRackClaw");
      rackMotor = hardwareMap.get(DcMotor.class, "rackMotor");


      servoPos = 0;
      oldServoButton = false;
    }

    @Override
    public void start() {
      runtime.reset();
    }

    /*
     * This method will be called repeatedly in a loop
     * @see com.qualcomm.robotcore.eventloop.opmode.OpMode#loop()
     */
    @Override
    public void loop() {
      telemetry.addData("Status", "Run Time: " + runtime.toString());
      double y = gamepad1.right_trigger - gamepad1.left_trigger;
      double x = gamepad1.left_stick_x;
      double a = gamepad1.right_stick_x;

      boolean servoButton = gamepad1.x;


      double fl = y - x + a;
      double fr = y + x - a;
      double bl = y + x + a;
      double br = y - x - a;

      frontRight.setPower(fr);
      frontLeft.setPower(fl);
      backLeft.setPower(bl);
      backRight.setPower(br);

      if (gamepad1.x) {
        duckMotor.setPower(-0.4);
      } else if (gamepad1.b) {
        duckMotor.setPower(0.4);
      }
      else duckMotor.setPower(0);

      if (gamepad1.dpad_left) {
        leftRackClaw.setPosition(0);
        rightRackClaw.setPosition(1);
      }


      if (gamepad1.left_bumper) {
        rackMotor.setPower(0.5);
      } else if (gamepad1.right_bumper) {
        rackMotor.setPower(-0.5);
      } else {
        rackMotor.setPower(0);
      }

      if (gamepad1.y) {
        leftRackClaw.setPosition(0.5);
        rightRackClaw.setPosition(0);
      }

      if (gamepad1.a) {
        leftRackClaw.setPosition(0);
        rightRackClaw.setPosition(0.5);
      }


      /*
      if (servoButton && !oldServoButton) {


        if (servoPos == 0) {

          servoPos = 1;
        } else {
          leftRackClaw.setPosition(0.5);
          rightRackClaw.setPosition(0.5);
          servoPos = 0;
        }


       }

       */
    }
  }

