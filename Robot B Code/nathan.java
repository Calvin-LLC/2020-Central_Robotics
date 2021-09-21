package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp(name = "nathan (Blocks to Java)", group = "")
public class nathan extends LinearOpMode {

  private DcMotor RightBack;
  private DcMotor LeftBack;

  /**
   * This function is executed when this Op Mode is selected from the Driver Station.
   */
  @Override
  public void runOpMode() {
    RightBack = hardwareMap.get(DcMotor.class, "RightBack");
    LeftBack = hardwareMap.get(DcMotor.class, "LeftBack");

    waitForStart();
    while (opModeIsActive()) {
      telemetry.update();
    }
    if (false) {
      return;
    }
  }
}
