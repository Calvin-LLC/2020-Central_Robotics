package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import org.firstinspires.ftc.robotcore.external.navigation.Position;
import com.qualcomm.robotcore.hardware.ServoImplEx;
import com.qualcomm.robotcore.hardware.ServoImpl;
import com.qualcomm.robotcore.hardware.ServoControllerEx;
import com.qualcomm.robotcore.hardware.ServoController;
import com.qualcomm.robotcore.hardware.Servo;
import java.util.concurrent.TimeUnit;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import java.util.Timer;
import java.util.TimerTask;

@TeleOp(name = "Hippo32 (Blocks to Java)", group = "19-20")
public class Hippo32 extends LinearOpMode {
  Timer pause = new Timer();
  TimerTask task = new TimerTask() {
    public void run(){
      ((DcMotorEx) RightFront).setVelocity(10000);
      ((DcMotorEx) RightBack).setVelocity(10000);
      ((DcMotorEx) LeftFront).setVelocity(-10000);
      ((DcMotorEx) LeftBack).setVelocity(-10000);
    }
  };
  
  DcMotor RightFront;
  DcMotor LeftBack;
  DcMotor LeftFront;
  DcMotor RightBack;
  DcMotor ArmRotate;
  DcMotor ArmExtend;
  
  Servo LeftArm;
  Servo RightArm;
  Servo Claw;
  
  

  /**
   * This function is executed when this Op Mode is selected from the Driver Station.
   */
  @Override
  public void runOpMode() {
      RightFront = hardwareMap.dcMotor.get("RightFront");
      LeftBack = hardwareMap.dcMotor.get("LeftBack");
      LeftFront = hardwareMap.dcMotor.get("LeftFront");
      RightBack = hardwareMap.dcMotor.get("RightBack");
      ArmRotate = hardwareMap.dcMotor.get("ArmRotate");
      ArmRotate.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
      ArmExtend = hardwareMap.dcMotor.get("ArmExtend");
      ArmExtend.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
      LeftArm = hardwareMap.servo.get("LeftArm");
      RightArm = hardwareMap.servo.get("RightArm");
      Claw = hardwareMap.servo.get("Claw");
      // Put initialization blocks here.
      waitForStart();
      if (opModeIsActive()) {
        // Put run blocks here.
       while (opModeIsActive()) {
            /*if (gamepad1.a){
              ((DcMotorEx) RightFront).setVelocity(10000);
              ((DcMotorEx) RightBack).setVelocity(10000);
              ((DcMotorEx) LeftFront).setVelocity(-10000);
              ((DcMotorEx) LeftBack).setVelocity(-10000);
              pause.scheduleAtFixedRate(task,1000,1000);
              ((DcMotorEx) RightFront).setVelocity(0);
              ((DcMotorEx) RightBack).setVelocity(0);
              ((DcMotorEx) LeftFront).setVelocity(0);
              ((DcMotorEx) LeftBack).setVelocity(0);
              break;
              }
            else {
              ((DcMotorEx) RightFront).setVelocity(0);
              ((DcMotorEx) RightBack).setVelocity(0);
              ((DcMotorEx) LeftFront).setVelocity(0);
              ((DcMotorEx) LeftBack).setVelocity(0);
            }*/
        if (gamepad1.left_stick_y > 0 && gamepad1.left_stick_x > 0) {
          ((DcMotorEx) RightFront).setVelocity(gamepad1.left_stick_x * 5000 + gamepad1.left_stick_y * 5000);
          ((DcMotorEx) LeftBack).setVelocity(gamepad1.left_stick_x * 5000 + gamepad1.left_stick_y * 5000);
        }
        if (gamepad1.left_stick_y > 0 && gamepad1.left_stick_x < 0) {
          ((DcMotorEx) LeftFront).setVelocity(gamepad1.left_stick_x * -5000 + gamepad1.left_stick_y * 5000);
          ((DcMotorEx) RightBack).setVelocity(gamepad1.left_stick_x * -5000 + gamepad1.left_stick_y * 5000);
        }
        if (gamepad1.left_stick_y < 0 && gamepad1.left_stick_x > 0) {
          ((DcMotorEx) LeftFront).setVelocity(gamepad1.left_stick_x * 5000 + gamepad1.left_stick_y * -5000);
          ((DcMotorEx) RightBack).setVelocity(gamepad1.left_stick_x * 5000 + gamepad1.left_stick_y * -5000);
        }
        if (gamepad1.left_stick_y < 0 && gamepad1.left_stick_x < 0) {
          ((DcMotorEx) RightFront).setVelocity(gamepad1.left_stick_x * -5000 + gamepad1.left_stick_y * -5000);
          ((DcMotorEx) LeftBack).setVelocity(gamepad1.left_stick_x * -5000 + gamepad1.left_stick_y * -5000);
        }
        if(gamepad1.left_stick_y < 0 && gamepad1.left_stick_x == 0) {
          ((DcMotorEx) RightFront).setVelocity(gamepad1.left_stick_y * 5000);
          ((DcMotorEx) RightBack).setVelocity(gamepad1.left_stick_y * 5000);
          ((DcMotorEx) LeftFront).setVelocity(gamepad1.left_stick_y * -5000);
          ((DcMotorEx) LeftBack).setVelocity(gamepad1.left_stick_y * -5000);
        }
        if (gamepad1.left_stick_y > 0 && gamepad1.left_stick_x == 0) {
          ((DcMotorEx) RightFront).setVelocity(gamepad1.left_stick_y * 5000);
          ((DcMotorEx) RightBack).setVelocity(gamepad1.left_stick_y * 5000);
          ((DcMotorEx) LeftFront).setVelocity(gamepad1.left_stick_y * -5000);
          ((DcMotorEx) LeftBack).setVelocity(gamepad1.left_stick_y * -5000);
        }
        if (gamepad1.left_stick_x > 0 && gamepad1.left_stick_y == 0) {
          ((DcMotorEx) RightFront).setVelocity(gamepad1.left_stick_x * 5000);
          ((DcMotorEx) RightBack).setVelocity(gamepad1.left_stick_x * -5000);
          ((DcMotorEx) LeftFront).setVelocity(gamepad1.left_stick_x * 5000);
          ((DcMotorEx) LeftBack).setVelocity(gamepad1.left_stick_x * -5000);
        }
        if (gamepad1.left_stick_x < 0 && gamepad1.left_stick_y == 0) {
          ((DcMotorEx) RightFront).setVelocity(gamepad1.left_stick_x * 5000);
          ((DcMotorEx) RightBack).setVelocity(gamepad1.left_stick_x * -5000);
          ((DcMotorEx) LeftFront).setVelocity(gamepad1.left_stick_x * 5000);
          ((DcMotorEx) LeftBack).setVelocity(gamepad1.left_stick_x * -5000);
        }
        if (gamepad1.right_trigger > 0) {
          ((DcMotorEx) RightFront).setVelocity(gamepad1.right_trigger * 5000);
          ((DcMotorEx) RightBack).setVelocity(gamepad1.right_trigger * 5000);
          ((DcMotorEx) LeftFront).setVelocity(gamepad1.right_trigger * 5000);
          ((DcMotorEx) LeftBack).setVelocity(gamepad1.right_trigger * 5000);
        }
        if (gamepad1.left_trigger > 0) {
          ((DcMotorEx) RightFront).setVelocity(gamepad1.left_trigger * -5000);
          ((DcMotorEx) RightBack).setVelocity(gamepad1.left_trigger * -5000);
          ((DcMotorEx) LeftFront).setVelocity(gamepad1.left_trigger * -5000);
          ((DcMotorEx) LeftBack).setVelocity(gamepad1.left_trigger * -5000);
        }
        if (gamepad2.dpad_up){
          RightArm.setPosition(1.0);
          LeftArm.setPosition(1.0);
          
        }
        if (gamepad2.dpad_down){
          RightArm.setPosition(0.0);
          LeftArm.setPosition(0.0);
        }
        if (gamepad2.dpad_left){
          Claw.setPosition(1.0);
        }
        if (gamepad2.dpad_right){
          Claw.setPosition(0.0);
        }
        if (gamepad2.y){
          ((DcMotorEx) ArmExtend).setVelocity(375);
        }
        if (gamepad2.a){
          ((DcMotorEx) ArmExtend).setVelocity(-375);
        }
        if (gamepad2.x){
          ((DcMotorEx) ArmRotate).setVelocity(125);
        }
        if (gamepad2.b){
          ((DcMotorEx) ArmRotate).setVelocity(-125);
        }
        ((DcMotorEx) RightFront).setVelocity(0);
        ((DcMotorEx) RightBack).setVelocity(0);
        ((DcMotorEx) LeftFront).setVelocity(0);
        ((DcMotorEx) LeftBack).setVelocity(0);
        ((DcMotorEx) ArmExtend).setVelocity(0);
        ((DcMotorEx) ArmRotate).setVelocity(0);
     }
    }
  }
}
