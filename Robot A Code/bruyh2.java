package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "bruyh2 (Blocks to Java)", group = "20-21")
public class bruyh2 extends LinearOpMode {

  private DcMotor frontLeft;
  private DcMotor frontRight;
  private DcMotor backLeft;
  private DcMotor backRight;
  private DcMotor spinL;
  private DcMotor spinR;
  private DcMotor belt;

  /**
   * This function is executed when this Op Mode is selected from the Driver Station.
   */
  @Override
  public void runOpMode() {
    float Pwr;
    float PivotL;
    float PivotR;
    float strafe;

    frontLeft = hardwareMap.dcMotor.get("frontLeft");
    frontRight = hardwareMap.dcMotor.get("frontRight");
    backLeft = hardwareMap.dcMotor.get("backLeft");
    backRight = hardwareMap.dcMotor.get("backRight");
    spinL = hardwareMap.dcMotor.get("spinL");
    spinR = hardwareMap.dcMotor.get("spinR");
    belt = hardwareMap.dcMotor.get("belt");

    // Put initialization blocks here.
    waitForStart();
    if (opModeIsActive()) {
      while (opModeIsActive()) {
        PivotL = gamepad1.left_trigger;
        PivotR = gamepad1.right_trigger;
        Pwr = gamepad1.left_stick_y;
        strafe = gamepad1.left_stick_x;
        if (Pwr != 0) {
          frontLeft.setPower(-Pwr);
          frontRight.setPower(Pwr);
          backLeft.setPower(-Pwr);
          backRight.setPower(Pwr);
        } else {
          frontLeft.setPower(0);
          frontRight.setPower(0);
          backLeft.setPower(0);
          backRight.setPower(0);
        }
        if (strafe != 0) {
          frontRight.setPower(strafe);
          backLeft.setPower(-strafe);
          frontLeft.setPower(strafe);
          backRight.setPower(-strafe);
        } else {
          frontRight.setPower(0);
          backLeft.setPower(0);
          frontLeft.setPower(0);
          backRight.setPower(0);
        }
        if (PivotL != 0) {
          frontLeft.setPower(PivotL);
          frontRight.setPower(PivotL);
          backLeft.setPower(PivotL);
          backRight.setPower(PivotL);
        } else {
          frontLeft.setPower(0);
          frontRight.setPower(0);
          backLeft.setPower(0);
          backRight.setPower(0);
        }
        if (PivotR != 0) {
          frontLeft.setPower(-PivotR);
          frontRight.setPower(-PivotR);
          backLeft.setPower(-PivotR);
          backRight.setPower(-PivotR);
        } else {
          frontLeft.setPower(0);
          frontRight.setPower(0);
          backLeft.setPower(0);
          backRight.setPower(0);
        }
        if (gamepad1.a) {
          spinL.setPower(0.36);
          spinR.setPower(-0.36);
        } else {
          spinL.setPower(0);
          spinR.setPower(0);
        }
        if (gamepad1.b) {
          belt.setPower(1);
        } else {
          belt.setPower(0);
        }
      }
    }
  }
}
