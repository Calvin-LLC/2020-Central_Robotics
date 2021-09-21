package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;

@TeleOp(name = "Xx_Spacex_xX", group = "")
public class Xx_Spacex_xX extends LinearOpMode {
  private DcMotor Left;
  private DcMotor Right;
  private DcMotor RollerLeft;
  private DcMotor RollerRight;
  private DcMotor belt;
  
  
  @Override
  public void runOpMode() {
    
    Left = (DcMotor)hardwareMap.get("left");
    Right = (DcMotor)hardwareMap.get("right");
    RollerLeft = (DcMotor)hardwareMap.get("RollerLeft");
    RollerRight = (DcMotor)hardwareMap.get("RollerRight");
    belt = (DcMotor)hardwareMap.get("belt");
    
    double spin_power = 0.5;
    boolean spin_on = false;
    boolean dpad = false;
    double belt_power = 0.0;
    
    waitForStart();
    if (opModeIsActive()) {
      //long time = System.currentTimeMillis();
      while(opModeIsActive()) {
        //Left.setPower(Math.pow(gamepad1.left_trigger, 2));
        Right.setPower(-gamepad1.right_stick_y * 0.5);//Math.pow(gamepad1.right_stick_y, 2));
        Left.setPower(gamepad1.left_stick_y * 0.5);//-Math.pow(gamepad1.left_stick_y, 2));
        //RollerLeft.setPower(Math.pow(gamepad1.left_stick_y, 3));
        //RollerRight.setPower(Math.pow(gamepad1.left_stick_y, 3));
        if(spin_on) {
          RollerLeft.setPower(spin_power);
          RollerRight.setPower(-spin_power);
        } else {
          RollerLeft.setPower(0.0);
          RollerRight.setPower(0.0);
        }
        
        if(gamepad1.right_trigger > 0.0) spin_on = true;
        else if(gamepad1.left_trigger > 0.0) spin_on = false;
        
        if (gamepad1.y) belt_power = 1.0;
        else if(gamepad1.a) belt_power = -1.0;
        else if(gamepad1.b) belt_power = 0.0;
        belt.setPower(belt_power);
        /*telemetry.addData("Message", "hi");
        telemetry.addData("Time", (System.currentTimeMillis() - time)% 100000 / 1000.0);
        telemetry.update();*/
        
        /* Set spin power using dpad */
        if(gamepad1.dpad_up) {
          if(!dpad) {
            spin_power += 0.01f;
            dpad = true;
          }
        } else if(gamepad1.dpad_down) {
          if(!dpad) {
            spin_power -= 0.01f;
            dpad = true;
          }
        } else {
          dpad = false;
        }
        /*****************************/
        telemetry.addData("Spin Power",Math.round(spin_power * 100));
        telemetry.update();
      }
    }
  }
}
