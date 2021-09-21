package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;

@TeleOp(name = "Hippo3 (Blocks to Java)", group = "")
public class Hippo3 extends LinearOpMode {

  private DcMotor RightFront;
  private DcMotor LeftBack;
  private DcMotor LeftFront;
  private DcMotor RightBack;

  /**
   * This function is executed when this Op Mode is selected from the Driver Station.
   */
  @Override
  public void runOpMode() {
    RightFront = hardwareMap.dcMotor.get("RightFront");
    LeftBack = hardwareMap.dcMotor.get("LeftBack");
    LeftFront = hardwareMap.dcMotor.get("LeftFront");
    RightBack = hardwareMap.dcMotor.get("RightBack");

    // Put initialization blocks here.
    waitForStart();
    if (opModeIsActive()) {
      // Put run blocks here.
      while (opModeIsActive()) {
        while (gamepad1.left_stick_y > 0 && gamepad1.left_stick_x > 0) {
          ((DcMotorEx) RightFront).setVelocity(gamepad1.left_stick_x * 20000 + gamepad1.left_stick_y * 20000);
          ((DcMotorEx) LeftBack).setVelocity(gamepad1.left_stick_x * 20000 + gamepad1.left_stick_y * 20000);
        }
        while (gamepad1.left_stick_y > 0 && gamepad1.left_stick_x < 0) {
          ((DcMotorEx) LeftFront).setVelocity(gamepad1.left_stick_x * -20000 + gamepad1.left_stick_y * 20000);
          ((DcMotorEx) RightBack).setVelocity(gamepad1.left_stick_x * -20000 + gamepad1.left_stick_y * 20000);
        }
        while (gamepad1.left_stick_y < 0 && gamepad1.left_stick_x > 0) {
          ((DcMotorEx) LeftFront).setVelocity(gamepad1.left_stick_x * 20000 + gamepad1.left_stick_y * -20000);
          ((DcMotorEx) RightBack).setVelocity(gamepad1.left_stick_x * 20000 + gamepad1.left_stick_y * -20000);
        }
        while (gamepad1.left_stick_y < 0 && gamepad1.left_stick_x < 0) {
          ((DcMotorEx) RightFront).setVelocity(gamepad1.left_stick_x * -20000 + gamepad1.left_stick_y * -20000);
          ((DcMotorEx) LeftBack).setVelocity(gamepad1.left_stick_x * -20000 + gamepad1.left_stick_y * -20000);
        }
        while (gamepad1.left_stick_y < 0 && gamepad1.left_stick_x == 0) {
          ((DcMotorEx) RightFront).setVelocity(gamepad1.left_stick_y * 20000);
          ((DcMotorEx) RightBack).setVelocity(gamepad1.left_stick_y * 20000);
          ((DcMotorEx) LeftFront).setVelocity(gamepad1.left_stick_y * -20000);
          ((DcMotorEx) LeftBack).setVelocity(gamepad1.left_stick_y * -20000);
        }
        while (gamepad1.left_stick_y > 0 && gamepad1.left_stick_x == 0) {
          ((DcMotorEx) RightFront).setVelocity(gamepad1.left_stick_y * 20000);
          ((DcMotorEx) RightBack).setVelocity(gamepad1.left_stick_y * 20000);
          ((DcMotorEx) LeftFront).setVelocity(gamepad1.left_stick_y * -20000);
          ((DcMotorEx) LeftBack).setVelocity(gamepad1.left_stick_y * -20000);
        }
        while (gamepad1.left_stick_x < 0 && gamepad1.left_stick_y == 0) {
          ((DcMotorEx) RightFront).setVelocity(gamepad1.left_stick_y * 20000);
          ((DcMotorEx) RightBack).setVelocity(gamepad1.left_stick_y * -20000);
          ((DcMotorEx) LeftFront).setVelocity(gamepad1.left_stick_y * 20000);
          ((DcMotorEx) LeftBack).setVelocity(gamepad1.left_stick_y * -20000);
        }
        while (gamepad1.left_stick_x > 0 && gamepad1.left_stick_y == 0) {
          ((DcMotorEx) RightFront).setVelocity(gamepad1.left_stick_y * 20000);
          ((DcMotorEx) RightBack).setVelocity(gamepad1.left_stick_y * -20000);
          ((DcMotorEx) LeftFront).setVelocity(gamepad1.left_stick_y * 20000);
          ((DcMotorEx) LeftBack).setVelocity(gamepad1.left_stick_y * -20000);
        }
        while (gamepad1.right_stick_x < 0) {
          ((DcMotorEx) RightFront).setVelocity(gamepad1.right_stick_y * -20000);
          ((DcMotorEx) RightBack).setVelocity(gamepad1.right_stick_y * -20000);
          ((DcMotorEx) LeftFront).setVelocity(gamepad1.right_stick_y * 20000);
          ((DcMotorEx) LeftBack).setVelocity(gamepad1.right_stick_y * 20000);
        }
        while (gamepad1.right_stick_x > 0) {
          ((DcMotorEx) RightFront).setVelocity(gamepad1.right_stick_y * 20000);
          ((DcMotorEx) RightBack).setVelocity(gamepad1.right_stick_y * 20000);
          ((DcMotorEx) LeftFront).setVelocity(gamepad1.right_stick_y * -20000);
          ((DcMotorEx) LeftBack).setVelocity(gamepad1.right_stick_y * -20000);
        }
          ((DcMotorEx) RightFront).setVelocity(0);
          ((DcMotorEx) RightBack).setVelocity(0);
          ((DcMotorEx) LeftFront).setVelocity(0);
          ((DcMotorEx) LeftBack).setVelocity(0);
      }
    }
  }
}
