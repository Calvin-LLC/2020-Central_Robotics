/*package org.firstinspires.ftc.teamcode;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import org.firstinspires.ftc.robotcore.external.Telemetry;


public class TelemetryThreadX implements Runnable {

    private double front, back, left, right, direction, spin_power, grabber_position;
    private Telemetry telemetry;
    
    public void run() {
        telemetry.addData("Front", front);
        telemetry.addData("Back", back);
        telemetry.addData("Left", left);
        telemetry.addData("Right", right);
        telemetry.addData("Direction", );
        telemetry.addData("Color_R", color.red());
        telemetry.addData("Color_G", color.green());
        telemetry.addData("Color_B", color.blue());

        telemetry.addData("Servo", grabber.getPosition());
        telemetry.update();
    }
    
    public TelemetryThreadX(Telemetry telem, double front, double back, double left, double right, long direction, long spin_power, int red, int green, int blue) {
        this.front = front;
        this.back = back;
        this.left = left;
        this.right = right;
        this.direction = direction;
        this.spin_power = spin_power;
        this.red = red;
        this.green = green;
        this.blue = blue;
        this.telemetry = telem;
    }
    
    public void update(double front, double back, double left, double right, long direction, long spin_power, int red, int green, int blue) {
        this.front = front;
        this.back = back;
        this.left = left;
        this.right = right;
        this.direction = direction;
        this.spin_power = spin_power;
        this.red = red;
        this.green = green;
        this.blue = blue;
    }
}*/
