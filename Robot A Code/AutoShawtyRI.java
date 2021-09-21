package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import java.util.Timer;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.Servo;
import org.firstinspires.ftc.robotcore.external.Telemetry;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.android.AndroidTextToSpeech;
import org.firstinspires.ftc.robotcore.external.android.AndroidOrientation;
import com.qualcomm.robotcore.hardware.CompassSensor;
import com.qualcomm.robotcore.hardware.OpticalDistanceSensor;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import java.util.ArrayList;

@Autonomous(name = "AutoShawtyRI", group = "Best Opmodes (20-21)")

public class AutoShawtyRI extends LinearOpMode {
  
  private DcMotor frontLeft;
  private DcMotor frontRight;
  private DcMotor backLeft;
  private DcMotor backRight;
  private DcMotor belt;
  private DcMotor spinR;
  private DcMotor spinL;
  private DcMotor arm;
  private DistanceSensor front;
  private DistanceSensor back;
  private DistanceSensor left;
  private DistanceSensor right;
  private ColorSensor color;
  private AndroidOrientation compass; // Compass
  private long angleOffset;
  private float spin_power;
  public TelemetryThread task;
  private double avg_confidence;
  private double avg_confidence_deviation;
  private double max_confidence;
  private Servo grabber;
  
  @Override
  public void runOpMode() throws InterruptedException {
    
    spin_power = 0.63f;
    
    frontLeft = hardwareMap.dcMotor.get("frontLeft");
    frontRight = hardwareMap.dcMotor.get("frontRight");
    backLeft = hardwareMap.dcMotor.get("backLeft");
    backRight = hardwareMap.dcMotor.get("backRight");
    belt = hardwareMap.dcMotor.get("belt");
    spinR = hardwareMap.dcMotor.get("spinR");
    spinL = hardwareMap.dcMotor.get("spinL");
    front = hardwareMap.get(DistanceSensor.class, "front");
    back = hardwareMap.get(DistanceSensor.class, "back");
    left = hardwareMap.get(DistanceSensor.class, "left");
    right = hardwareMap.get(DistanceSensor.class, "right");
    color = hardwareMap.get(ColorSensor.class, "color");
    compass = new AndroidOrientation();
    compass.startListening();
    compass.setAngleUnit(AngleUnit.DEGREES);
    grabber = hardwareMap.servo.get("grabber");
    arm = hardwareMap.dcMotor.get("arm");
    
    angleOffset = Math.round(compass.getAzimuth()) + 180;
    ExecutorService telemetryThread = Executors.newSingleThreadExecutor();
    task = new TelemetryThread(telemetry, front.getDistance(DistanceUnit.CM), back.getDistance(DistanceUnit.CM), left.getDistance(DistanceUnit.CM), right.getDistance(DistanceUnit.CM), getDirection(), color.red(), color.green(), color.blue(), Math.round(spin_power * 100));

    StopMotors sm = new StopMotors(frontRight, frontLeft, backRight, backLeft, belt, spinL, spinR);
    Timer t = new Timer("StopMotors");
    
    // Put initialization blocks here.
    waitForStart(); 
    if (opModeIsActive()) {
      while (opModeIsActive()) {
        t.schedule(sm, 29900);
        //telemetryThread.submit(task);
        //taskUpdate();
        //getConfidenceVals();
        //int rings = countRings();
        grabRings();
        spin180();
        shootRings();
        //goToSpot(rings);
        //lowerArm();
        //openClaw();
      }
      color.enableLed(false);
    }
  }
  
  public void goToSpot(int rings) throws InterruptedException {
    switch(rings) {
      case 0: drive(22.75 * 2.54,3,0.3);
      return;
      case 1: drive(22.75 * 2.54,0,0.3);
      return;
      case 4: drive(22.75 * 2.54 * 2, 0, 0.3);
      drive(22.75 * 2.54, 3, 0.3);
      return;
    }
  }
  
  public void shootRings() throws InterruptedException {
    spinL.setPower((double)spin_power);
    spinR.setPower(-(double)spin_power);
    Thread.sleep(700);
    for(int i = 0; i < 4; i++) {
      belt.setPower(2.0);
      Thread.sleep(300);
    }
    spinL.setPower(0);
    spinR.setPower(0);
    belt.setPower(0);
  }
  
  public void getConfidenceVals() throws InterruptedException {
    ArrayList<Double> confidence_vals = new ArrayList<Double>();
    for (int i = 0; i < 3; i++) {
      confidence_vals.add((color.green() + color.red()) / 2.0 / (color.blue() + 1) / 3.0);
      drive(0.001,0,0.01);
    }
    double sum = 0;
    for(Double num : confidence_vals) {
      sum += num;
    }
    avg_confidence = sum / confidence_vals.size();
    ArrayList<Double> deviations = new ArrayList<Double>();
    for(Double num : confidence_vals) {
      deviations.add(Math.abs(num - avg_confidence));
    }
    sum = 0;
    for(Double num : deviations) {
      sum += num;
    }
    avg_confidence_deviation = sum / deviations.size();
    double max = confidence_vals.get(0);
    for(Double num : confidence_vals) {
      if(num > max) max = num;
    }
    max_confidence = max;
  }
  
  public void spin180() {
    turnTo(getDirection() + 180 % 360);
  }
  
  public void turnTo(int azimuth) {
    while(getDirection() != azimuth) {
      if(getDirection() < azimuth) {
        frontRight.setPower(0.2);
        backRight.setPower(0.2);
        frontLeft.setPower(0.2);
        backLeft.setPower(0.2);
      } else {
        frontRight.setPower(-0.2);
        backRight.setPower(-0.2);
        frontLeft.setPower(-0.2);
        backLeft.setPower(-0.2);
      }
      taskUpdate();
    }
    stopBot();
  }
  
  public int getDirection() {
    Long I = new Long((Math.round(compass.getAzimuth()) + angleOffset) % 360);
    return I.intValue();
  }
  
  /*
  public boolean redTeam() {
    return (right.getDistance(DistanceUnit.CM) > left.getDistance(DistanceUnit.CM));
  }
  */
  
  public void openClaw() {
    grabber.setPosition(-1.0);
  }
  
  public void closeClaw() {
    grabber.setPosition(1.3);
  }
  
  public void raiseArm()  throws InterruptedException {
    arm.setPower(0.8);
    Thread.sleep(1500);
  }
  
  public void lowerArm()  throws InterruptedException {
    arm.setPower(-0.8);
    Thread.sleep(1500);
  }
  
  public void grabRings()  throws InterruptedException {
    drive(33.0 * 2.54, 1, 0.3);
    belt.setPower(-2);
  }
  
  public void drive(int direction, double power) {
    switch(direction) {
      case 0: // Forwards
        frontRight.setPower(-power);
        backRight.setPower(-power);
        frontLeft.setPower(power);
        backLeft.setPower(power);
        return;
      case 1: // Backwards
        frontRight.setPower(power);
        backRight.setPower(power);
        frontLeft.setPower(-power);
        backLeft.setPower(-power);
        return;
      case 2: // Left
        frontRight.setPower(-power);
        backRight.setPower(power);
        frontLeft.setPower(-power);
        backLeft.setPower(power);
        return;
      case 3: // Right
        frontRight.setPower(power);
        backRight.setPower(-power);
        frontLeft.setPower(power);
        backLeft.setPower(-power);
        return;
    }
  }
  
  public void drive (double dist, int direction, double power) throws InterruptedException {
    double start;
    switch(direction) {
      case 0:
        start = front.getDistance(DistanceUnit.CM);
        while(front.getDistance(DistanceUnit.CM) > start - dist) {
          drive(direction, power);
          Thread.sleep(10);
          stopBot();
          //taskUpdate();
        }
        break;
      case 1:
        start = front.getDistance(DistanceUnit.CM);
        while(front.getDistance(DistanceUnit.CM) < start + dist) {
          drive(direction, power);
          Thread.sleep(10);
          stopBot();
          //taskUpdate();
        }
        break;
      case 2:
        start = right.getDistance(DistanceUnit.CM);
        while(right.getDistance(DistanceUnit.CM) < start + dist) {
          drive(direction, power);
          Thread.sleep(20);
          stopBot();
          //taskUpdate();
        }
        break;
      case 3:
        start = left.getDistance(DistanceUnit.CM);
        while(left.getDistance(DistanceUnit.CM) < start + dist) {
          drive(direction, power);
          Thread.sleep(20);
          stopBot();
          //taskUpdate();
        }
    }
  }
  
  public void stopBot() {
    frontLeft.setPower(0);
    frontRight.setPower(0);
    backLeft.setPower(0);
    backRight.setPower(0);
  }
  
  public boolean ringDetected() {
    double confidence = (color.green() + color.red()) / 2.0 / (color.blue() + 1) / 3.0;
    telemetry.addData("Confidence", confidence);
    return (confidence >= max_confidence + avg_confidence_deviation);
  }
  
  public int countRings() throws InterruptedException {
    drive(23.25 * 2.54, 1, 0.3);
    drive(10.0,3,0.5);
    if(!ringDetected()) {
      return 0;
    } else if (back.getDistance(DistanceUnit.CM) < 20) {
      return 4;
    } else return 3;
  }
  
  public void taskUpdate(){
    task.update(front.getDistance(DistanceUnit.CM), back.getDistance(DistanceUnit.CM), left.getDistance(DistanceUnit.CM), right.getDistance(DistanceUnit.CM), getDirection(), color.red(), color.green(), color.blue(), Math.round(spin_power * 100));
  }
}
