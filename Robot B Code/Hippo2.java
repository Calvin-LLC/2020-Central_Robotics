package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name = "Hippo 2", group = "")
public class Hippo2 extends LinearOpMode {

  private Servo LeftLift;
  private Servo RightLift;
  private DcMotor RightFront;
  private DcMotor LeftFront;
  private DcMotor LeftBack;
  private DcMotor RightBack;
  

  /**
   * This function is executed when this Op Mode is selected from the Driver Station.
   */
  @Override
  public void runOpMode() {
    LeftLift = hardwareMap.servo.get("LeftLift");
    RightLift = hardwareMap.servo.get("RightLift");
    RightFront = hardwareMap.dcMotor.get("RightFront");
    LeftFront = hardwareMap.dcMotor.get("LeftFront");
    LeftBack = hardwareMap.dcMotor.get("LeftBack");
    RightBack = hardwareMap.dcMotor.get("RightBack");

    // Put initialization blocks here.
    waitForStart();
    if (opModeIsActive()) {
      while (opModeIsActive()) {
        while (gamepad1.left_bumper) {
          LeftLift.setPosition(0.05);
          RightLift.setPosition(0.95);
        }
        while (gamepad1.right_bumper) {
          LeftLift.setPosition(1);
          RightLift.setPosition(0);
        }
        while (gamepad1.dpad_up) {
          ((DcMotorEx) RightFront).setVelocity(2000);
          ((DcMotorEx) LeftBack).setVelocity(2000);
          ((DcMotorEx) LeftFront).setVelocity(-2000);
          ((DcMotorEx) RightBack).setVelocity(-2000);
        }
        while (gamepad1.dpad_down) {
          ((DcMotorEx) RightFront).setVelocity(-2000);
          ((DcMotorEx) LeftBack).setVelocity(-2000);
          ((DcMotorEx) LeftFront).setVelocity(2000);
          ((DcMotorEx) RightBack).setVelocity(2000);
        }
        while (gamepad1.dpad_right) {
          ((DcMotorEx) RightFront).setVelocity(2000);
          ((DcMotorEx) LeftBack).setVelocity(-2000);
          ((DcMotorEx) LeftFront).setVelocity(2000);
          ((DcMotorEx) RightBack).setVelocity(-2000);
        }
        while (gamepad1.dpad_left) {
          ((DcMotorEx) RightFront).setVelocity(-2000);
          ((DcMotorEx) LeftBack).setVelocity(2000);
          ((DcMotorEx) LeftFront).setVelocity(-2000);
          ((DcMotorEx) RightBack).setVelocity(2000);
        }
        while (gamepad1.b) {
          ((DcMotorEx) RightFront).setVelocity(2000);
          ((DcMotorEx) LeftBack).setVelocity(2000);
          ((DcMotorEx) LeftFront).setVelocity(2000);
          ((DcMotorEx) RightBack).setVelocity(2000);
        }
        while (gamepad1.x) {
          ((DcMotorEx) RightFront).setVelocity(-2000);
          ((DcMotorEx) LeftBack).setVelocity(-2000);
          ((DcMotorEx) LeftFront).setVelocity(-2000);
          ((DcMotorEx) RightBack).setVelocity(-2000);
        }
          ((DcMotorEx) RightFront).setVelocity(0);
          ((DcMotorEx) LeftBack).setVelocity(0);
          ((DcMotorEx) LeftFront).setVelocity(0);
          ((DcMotorEx) RightBack).setVelocity(0);
      }
    }
  }
}