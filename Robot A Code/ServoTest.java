package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import org.firstinspires.ftc.robotcore.external.Telemetry;

@TeleOp(name = "MotorTest", group = "MotorTest")

public class ServoTest extends LinearOpMode {
  
  private DcMotor motor;
  
  public void runOpMode() {
    
    motor = hardwareMap.dcMotor.get("motor");
    
    waitForStart();
    if(opModeIsActive()) {
      while(opModeIsActive()) {
        motor.setPower(gamepad1.left_stick_x * 0.5);
        telemetry.addData("Joystick",gamepad1.left_stick_x);
        telemetry.update();
      }
    }
  }
}