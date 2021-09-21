package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "spinny (Blocks to Java)", group = "20-21")
public class spinny extends LinearOpMode {

  private DcMotor belt;
  private DcMotor spinR;
  private DcMotor spinL;

  /**
   * This function is executed when this Op Mode is selected from the Driver Station.
   */
  @Override
  public void runOpMode() {
    float trig;

    belt = hardwareMap.dcMotor.get("belt");
    spinR = hardwareMap.dcMotor.get("spinR");
    spinL = hardwareMap.dcMotor.get("spinL");

    // Put initialization blocks here.
    waitForStart();
    if (opModeIsActive()) {
      while (opModeIsActive()) {
        while (gamepad1.a) {
          belt.setPower(-0.5);
        }
        while (gamepad1.b) {
          spinR.setPower(-0.5);
          spinL.setPower(0.5);
        }
        trig = gamepad1.left_trigger;
        spinL.setPower(trig);
        spinR.setPower(-trig);
      }
    }
  }
}
