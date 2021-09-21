package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import org.firstinspires.ftc.robotcore.external.Telemetry;
import com.qualcomm.robotcore.util.RobotLog;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "bruyh xtreme edition", group = "Best Opmodes (20-21)")
public class bruyh extends LinearOpMode {

  private DcMotor frontLeft;
  private DcMotor frontRight;
  private DcMotor backLeft;
  private DcMotor backRight;
  private DcMotor belt;
  private DcMotor spinR;
  private DcMotor spinL;
  
  @Override
  public void runOpMode() {
    float Pwr;
    float PivotL;
    float PivotR;
    float strafe;
    float spin_power = 0.45f;
    boolean dpad = false;

    frontLeft = hardwareMap.dcMotor.get("frontLeft");
    frontRight = hardwareMap.dcMotor.get("frontRight");
    backLeft = hardwareMap.dcMotor.get("backLeft");
    backRight = hardwareMap.dcMotor.get("backRight");
    belt = hardwareMap.dcMotor.get("belt");
    spinR = hardwareMap.dcMotor.get("spinR");
    spinL = hardwareMap.dcMotor.get("spinL");

    // Put initialization blocks here.
    waitForStart();
    if (opModeIsActive()) {
      while (opModeIsActive()) {
        
        PivotL = gamepad1.left_trigger * Math.abs(gamepad1.left_trigger) * Math.abs(gamepad1.left_trigger) * 0.5f;
        PivotR = gamepad1.right_trigger * Math.abs(gamepad1.right_trigger) * Math.abs(gamepad1.right_trigger) * 0.5f;
        Pwr = -gamepad1.left_stick_y * Math.abs(gamepad1.left_stick_y) * Math.abs(gamepad1.left_stick_y);
        strafe = -gamepad1.left_stick_x * Math.abs(gamepad1.left_stick_x) * Math.abs(gamepad1.left_stick_x);
        
        frontLeft.setPower(Pwr - strafe + PivotL - PivotR);
        frontRight.setPower(-Pwr - strafe + PivotL - PivotR);
        backLeft.setPower(Pwr + strafe + PivotL - PivotR);
        backRight.setPower(-Pwr + strafe + PivotL - PivotR);
        
        
        if (gamepad1.b) {
          spinL.setPower(spin_power);
          spinR.setPower(-spin_power);
        } else {
          spinL.setPower(0);
          spinR.setPower(0);
        }
        
        if(gamepad1.dpad_up) {
          if (!dpad) {
            spin_power += 0.01f;
            dpad = true;
          }
        } else if(gamepad1.dpad_down) {
          if (!dpad) {
            spin_power -= 0.01f;
            dpad = true;
          }
        } else dpad = false;
        
        if (gamepad1.a) belt.setPower(-2);
        else if (gamepad1.x) belt.setPower(2);
        else belt.setPower(0);
        
        telemetry.addData("Spin Power", Math.round(spin_power * 100));
        telemetry.update();
      }
    }
  }
}