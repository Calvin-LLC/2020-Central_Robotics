/*package org.firstinspires.ftc.teamcode;

import android.graphics.Color;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.TouchSensor;
import org.firstinspires.ftc.robotcore.external.JavaUtil;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

@Autonomous(name = "blue (Blocks to Java)", group = "19-20")
public class blue extends LinearOpMode {

  private DistanceSensor dist;
  private DcMotor frontLeft;
  private DcMotor frontRight;
  private DcMotor backLeft;
  private DcMotor backRight;
  private ColorSensor color;
  private ColorSensor color2;
  private DcMotor leftIntakeAsDcMotor;
  private DcMotor rightIntakeAsDcMotor;
  private TouchSensor touch;
  private TouchSensor touch2;

  /**
   * This function is executed when this Op Mode is selected from the Driver Station.
   *//*
  @Override
  public void runOpMode() {
    double dist;
    float val;
    int colorHSV;
    float sat;
    int colorHSV2;
    float hue;
    boolean but;
    boolean but2;
    // TODO: Enter the type for variable named time2
    UNKNOWN_TYPE time2;

    dist = hardwareMap.get(DistanceSensor.class, "dist");
    frontLeft = hardwareMap.dcMotor.get("frontLeft");
    frontRight = hardwareMap.dcMotor.get("frontRight");
    backLeft = hardwareMap.dcMotor.get("backLeft");
    backRight = hardwareMap.dcMotor.get("backRight");
    color = hardwareMap.colorSensor.get("color");
    color2 = hardwareMap.colorSensor.get("color2");
    leftIntakeAsDcMotor = hardwareMap.dcMotor.get("leftIntakeAsDcMotor");
    rightIntakeAsDcMotor = hardwareMap.dcMotor.get("rightIntakeAsDcMotor");
    touch = hardwareMap.touchSensor.get("touch");
    touch2 = hardwareMap.touchSensor.get("touch2");

    waitForStart();
    if (opModeIsActive()) {
      // Put run blocks here.
      while (opModeIsActive()) {
        dist = dist.getDistance(DistanceUnit.CM);
        if (dist > 19) {
          frontLeft.setPower(-0.5);
          frontRight.setPower(0.5);
          backLeft.setPower(-0.5);
          backRight.setPower(0.5);
        } else {
          frontLeft.setPower(-0.5);
          frontRight.setPower(-0.5);
          backLeft.setPower(0.5);
          backRight.setPower(0.5);
          colorHSV = Color.argb(color.alpha(), color.red(), color.green(), color.blue());
          colorHSV2 = Color.argb(color2.alpha(), color2.red(), color2.green(), color2.blue());
          val = JavaUtil.colorToValue(colorHSV);
          sat = JavaUtil.colorToSaturation(colorHSV);
          hue = JavaUtil.colorToHue(colorHSV2);
          but = false;
          but2 = false;
          if (val < 0.16) {
            while (true) {
              telemetry.addData("Check Val", "Is surface black?");
              telemetry.addData("nig", val);
              telemetry.update();
              frontLeft.setPower(-0.25);
              frontRight.setPower(0.25);
              backLeft.setPower(-0.25);
              backRight.setPower(0.25);
              leftIntakeAsDcMotor.setPower(0.5);
              rightIntakeAsDcMotor.setPower(-0.5);
              if (touch.isPressed()) {
                but = true;
              }
              while (but == true) {
                frontLeft.setPower(0.5);
                frontRight.setPower(-0.5);
                backLeft.setPower(0.5);
                backRight.setPower(-0.5);
                leftIntakeAsDcMotor.setPower(0);
                rightIntakeAsDcMotor.setPower(0);
                if (touch2.isPressed()) {
                  but2 = true;
                }
                while (but2 == true) {
                  frontLeft.setPower(0.25);
                  frontRight.setPower(0.25);
                  backLeft.setPower(-0.25);
                  backRight.setPower(-0.25);
                  time2 += getRuntime();
                  if (time2 > 24) {
                    frontLeft.setPower(0);
                    frontRight.setPower(0);
                    backLeft.setPower(0);
                    backRight.setPower(0);
                  }
                }
              }
            }
          }
        }
        telemetry.update();
        telemetry.addData("bruh", dist);
      }
    }
  }
}*/
