package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;


@Autonomous(name="Drive Forward", group="Best Opmodes (20-21)")

public class DriveForward extends LinearOpMode {
  
  private DcMotor frontLeft;
  private DcMotor frontRight;
  private DcMotor backLeft;
  private DcMotor backRight;
  private DistanceSensor front;
  private DcMotor belt;
  private DcMotor spinR;
  private DcMotor spinL;
  
  @Override
  public void runOpMode() throws InterruptedException {
    
    frontLeft = hardwareMap.dcMotor.get("frontLeft");
    frontRight = hardwareMap.dcMotor.get("frontRight");
    backLeft = hardwareMap.dcMotor.get("backLeft");
    backRight = hardwareMap.dcMotor.get("backRight");
    front = hardwareMap.get(DistanceSensor.class, "front");
    belt = hardwareMap.dcMotor.get("belt");
    spinR = hardwareMap.dcMotor.get("spinR");
    spinL = hardwareMap.dcMotor.get("spinL");
    
    waitForStart();
    if(opModeIsActive()) {
      while(opModeIsActive()) {
        /*Thread.sleep(5000);
        double dist = front.getDistance(DistanceUnit.INCH);
        while(front.getDistance(DistanceUnit.INCH) > dist - 69) {*/
        frontLeft.setPower(0.3);
        backLeft.setPower(0.3);
        frontRight.setPower(-0.3);
        backRight.setPower(-0.3);
        Thread.sleep(3000);
          /*//telemetry.addData("Distance", front.getDistance(DistanceUnit.INCH));
          //telemetry.addData("Final Distance", dist - 69);
          //telemetry.update(); 
        }*/
        frontLeft.setPower(0.3);
        backLeft.setPower(-0.3);
        frontRight.setPower(0.3);
        backRight.setPower(-0.3);
        Thread.sleep(1000);
        
        frontLeft.setPower(0);
        backLeft.setPower(0);
        frontRight.setPower(0);
        backRight.setPower(0);
        spinL.setPower(0.35);
        spinR.setPower(-0.35);
        Thread.sleep(900);
        
        belt.setPower(-0.70);
        Thread.sleep(350);
        belt.setPower(0);
        Thread.sleep(900);
        belt.setPower(-0.70);
        Thread.sleep(1000);
        belt.setPower(0);
        spinL.setPower(0);
        spinR.setPower(0);
        
        frontLeft.setPower(0.28);
        backLeft.setPower(0.32);
        frontRight.setPower(-0.28);
        backRight.setPower(-0.32);
        Thread.sleep(900);
        frontLeft.setPower(0);
        backLeft.setPower(0);
        frontRight.setPower(0);
        backRight.setPower(0);
        stop();
      }
    }
  }
  
}