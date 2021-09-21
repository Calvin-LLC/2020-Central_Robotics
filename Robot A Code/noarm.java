package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "noarm (Blocks to Java)", group = "19-20")
public class noarm extends LinearOpMode {

  private DcMotor frontLeft;
  private DcMotor frontRight;
  private DcMotor backLeft;
  private DcMotor backRight;

  /**
   * This function is executed when this Op Mode is selected from the Driver Station.
   */
  @Override
  public void runOpMode() {
    float strafe;
    float Pwr;

    frontLeft = hardwareMap.dcMotor.get("frontLeft");
    frontRight = hardwareMap.dcMotor.get("frontRight");
    backLeft = hardwareMap.dcMotor.get("backLeft");
    backRight = hardwareMap.dcMotor.get("backRight");

    // Put initialization blocks here.
    waitForStart();
    if (opModeIsActive()) {
      // Put run blocks here.
      while (opModeIsActive()) {
        Pwr = gamepad1.left_stick_y;
        strafe = gamepad1.left_stick_x;
        if (Pwr != 0) {
          frontLeft.setPower(Pwr);
          frontRight.setPower(-Pwr);
          backLeft.setPower(Pwr);
          backRight.setPower(-Pwr);
        } else {
          frontLeft.setPower(0);
          frontRight.setPower(0);
          backLeft.setPower(0);
          backRight.setPower(0);
        }
        if (strafe != 0) {
          frontRight.setPower(-strafe);
          backLeft.setPower(strafe);
          frontLeft.setPower(-strafe);
          backRight.setPower(strafe);
        } else {
          frontRight.setPower(0);
          backLeft.setPower(0);
          frontLeft.setPower(0);
          backRight.setPower(0);
        }
      }
    }
  }
}
