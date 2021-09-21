package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executor;
import com.qualcomm.robotcore.hardware.Servo;
import java.util.Locale;
import org.firstinspires.ftc.robotcore.external.android.AndroidTextToSpeech;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import org.firstinspires.ftc.robotcore.external.android.AndroidOrientation;
import org.firstinspires.ftc.robotcore.external.navigation.*;
import com.qualcomm.robotcore.hardware.ColorSensor;
import org.firstinspires.ftc.robotcore.external.Telemetry;
import com.qualcomm.robotcore.util.RobotLog;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "bruyh xtreme edition remastered", group = "Best Opmodes (20-21)") 
// ^^^^^^^^^^^^^^^^^^^^ Identifies this as a TeleOp and gives its name and group


public class BruyhXtremeEditionRemastered extends LinearOpMode {

  private DcMotor frontLeft;          // Front left wheel motor
  private DcMotor frontRight;         // Front right wheel motor
  private DcMotor backLeft;           // Back left wheel motor
  private DcMotor backRight;          // Back right wheel motor
  private DcMotor belt;               // Belt motor
  private DcMotor spinR;              // Right spinner motor
  private DcMotor spinL;              // Left spinner motor
  private DcMotor arm;                // Arm motor
  private DistanceSensor front;       // Front facing distance sensor
  private DistanceSensor back;        // Back facing distance sensor
  private DistanceSensor left;        // Left facing distance sensor
  private DistanceSensor right;       // Right facing distance sensor
  private ColorSensor color;          // Color sensor
  private AndroidTextToSpeech tts;    // Text to speech
  private AndroidOrientation compass; // Compass
  private Servo grabber;              // Grabber Servo
  //private TelemetryThreadX telem;
  
  @Override
  public void runOpMode() {     // The opmode function
  
  
    float Pwr;                // The joystick Y input, used as the forward and backward power
    float PivotL;             // The left trigger input, used to spin CCW
    float PivotR;             // The right trigger input, used to spin CW
    float strafe;             // The joystick X input, used to strafe side to side
    float spin_power = 0.30f; // The spin power
    boolean dpad = false;     // A boolean used to indicate wether the dpad has been pressed used for the changing of spin power
    double pwr_cntr = 0.8;    // The amount of power on the up of the arm
    
    
    /* Setting all of the motors and sensors to their connection in the hardware configuration */
    frontLeft = hardwareMap.dcMotor.get("frontLeft");
    frontRight = hardwareMap.dcMotor.get("frontRight");
    backLeft = hardwareMap.dcMotor.get("backLeft");
    backRight = hardwareMap.dcMotor.get("backRight");
    belt = hardwareMap.dcMotor.get("belt");
    spinR = hardwareMap.dcMotor.get("spinR");
    spinL = hardwareMap.dcMotor.get("spinL");
    arm = hardwareMap.dcMotor.get("arm");
    grabber = hardwareMap.get(Servo.class, "grabber");
    /*front = hardwareMap.get(DistanceSensor.class, "front");
    back = hardwareMap.get(DistanceSensor.class, "back");
    left = hardwareMap.get(DistanceSensor.class, "left");
    right = hardwareMap.get(DistanceSensor.class, "right");
    color = hardwareMap.get(ColorSensor.class, "color");*/
    /*tts = new AndroidTextToSpeech();
    tts.initialize();
    tts.setLanguage("English");*/
    /*compass = new AndroidOrientation();
    compass.startListening();
    compass.setAngleUnit(AngleUnit.DEGREES);*/
    
    //ExecutorService telemetryThread = Executors.newSingleThreadExecutor();
    //TelemetryThreadX task = new TelemetryThreadX(front.getDistance(DistanceUnit.CM), back.getDistance(DistanceUnit.CM), left.getDistance(DistanceUnit.CM), right.getDistance(DistanceUnit.CM), );
    
    /*******************************************************************************************/
    

    // Put initialization blocks here.  <--- A comment made by the person who wrote the boilerplate code, mine aren't that nice
    //grabber.scaleRange(-1.0, 1.0);
    
    waitForStart();
    if (opModeIsActive()) {
      while (opModeIsActive()) {
        
        
        /* Take semi-quadratic curve input from stick and trigger*/
        PivotL = gamepad1.left_trigger * Math.abs(gamepad1.left_trigger) * Math.abs(gamepad1.left_trigger) * 0.85f;
        PivotR = gamepad1.right_trigger * Math.abs(gamepad1.right_trigger) * Math.abs(gamepad1.right_trigger) * 0.85f;
        Pwr = -gamepad1.left_stick_y * Math.abs(gamepad1.left_stick_y) * Math.abs(gamepad1.left_stick_y);
        strafe = gamepad1.left_stick_x * Math.abs(gamepad1.left_stick_x) * Math.abs(gamepad1.left_stick_x);
        /*********************************************************/
        
        
        /* Set wheel power based on stick and trigger input */
        frontLeft.setPower(Pwr - strafe + PivotL - PivotR);
        frontRight.setPower(-Pwr - strafe + PivotL - PivotR);
        backLeft.setPower(Pwr + strafe + PivotL - PivotR);
        backRight.setPower(-Pwr + strafe + PivotL - PivotR);
        /****************************************************/
        
        
        /* Turn spinners when B is pressed */
        if (gamepad2.b) {
          spinL.setPower(spin_power);
          spinR.setPower(-spin_power);
        } else {
          spinL.setPower(0);
          spinR.setPower(0);
        }
        /***********************************/
        
        
        /* Set spin power using dpad */
        if(gamepad2.dpad_up) {
          if (!dpad) {
            spin_power += 0.02f;
            dpad = true;
          }
        } else if(gamepad2.dpad_down) {
          if (!dpad) {
            spin_power -= 0.02f;
            dpad = true;
          }
        } else dpad = false;
        /*****************************/
        
        
        /* Open and close grabber */
        if(gamepad1.y) {
          /*if (!y) {
            grabber.setPosition(-grabber.getPosition());
            y = true;
          }*/
          grabber.setPosition(0.0);
        } else {
          //y = false;
          grabber.setPosition(1.0);
        }
        /**************************/
        
        
        
        /*********************************************/
        if (gamepad2.a) belt.setPower(-2);      // Turn belt forward when A is pressed
        else if (gamepad2.x) belt.setPower(2);  // Turn belt backward when X is pressed
        else belt.setPower(0);                  // Stop belt when neither A or X is pressed
        /*********************************************/
        
        /*if(gamepad2.dpad_up) arm.setPower(-0.8);
        
        else if (gamepad2.dpad_down) arm.setPower(0.4);
        else arm.setPower(0);*/
        
        
        /* Move arm */
        arm.setPower(gamepad2.right_stick_y * gamepad2.right_stick_y * gamepad2.right_stick_y * 0.8);
        /************/
        
        
        /* Adding Telemetry Data */
        telemetry.addData("Servo Pos", grabber.getPosition());
        telemetry.addData("Spin Power", Math.round(spin_power * 100));
        telemetry.update();
        /*************************/
      }
    }
  }
}