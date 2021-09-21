package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "RemasteredMovement (Java)", group = "20-21")
public class RemasteredMovement extends LinearOpMode {

  private DcMotor w_fl;
  private DcMotor w_fr;
  private DcMotor w_bl;
  private DcMotor w_br;
  private DcMotor belt;
  private DcMotor fw_r;
  private DcMotor fw_l;
  
  @Override
  public void runOpMode() {
    float Pwr;
    float PivotL;
    float PivotR;
    float strafe;
    
    /* Basic syntax
      before underscore -- wheel (w), flywheel (fw), etc
      after underscore --  side it's on, (front (f), back (b), left (l), right (r))
    */
    
    w_fl = hardwareMap.dcMotor.get("frontLeft");
    w_fr = hardwareMap.dcMotor.get("frontRight");
    w_bl = hardwareMap.dcMotor.get("backLeft");
    w_br = hardwareMap.dcMotor.get("backRight");
    belt = hardwareMap.dcMotor.get("belt");
    fw_r = hardwareMap.dcMotor.get("spinR");
    fw_l = hardwareMap.dcMotor.get("spinL");

    PivotL = gamepad1.left_trigger;
    PivotR = gamepad1.right_trigger;
    Pwr = -gamepad1.left_stick_y;
    strafe = -gamepad1.left_stick_x;
    // Put initialization blocks here.
    waitForStart();
    
    while (opModeIsActive()) {
      if (Pwr != 0) {
        w_fl.setPower(Pwr);
        w_fr.setPower(-Pwr);
        w_bl.setPower(Pwr);
        w_br.setPower(-Pwr);
      }
      if (strafe != 0) {
        w_fr.setPower(-strafe);
        w_bl.setPower(strafe);
        w_fl.setPower(-strafe);
        w_br.setPower(strafe);
      }
      if (PivotL != 0) {
        w_fl.setPower(PivotL);
        w_fr.setPower(PivotL);
        w_bl.setPower(PivotL);
        w_br.setPower(PivotL);
      }
      if (PivotR != 0) {
        w_fl.setPower(-PivotR);
        w_fr.setPower(-PivotR);
        w_bl.setPower(-PivotR);
        w_br.setPower(-PivotR);
      }
      if (gamepad1.b) {
        fw_l.setPower(0.36);
        fw_r.setPower(-0.36);
      }
      if (gamepad1.a) {
        belt.setPower(-0.8);
      }
      w_fl.setPower(0);
      w_fr.setPower(0);
      w_bl.setPower(0);
      w_br.setPower(0);
      belt.setPower(0);
      fw_l.setPower(0);
      fw_r.setPower(0);
    }
  }
}
