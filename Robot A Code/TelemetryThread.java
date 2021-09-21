package org.firstinspires.ftc.teamcode;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import org.firstinspires.ftc.robotcore.external.Telemetry;


public class TelemetryThread implements Runnable {

    private double front, back, left, right;
    private long direction, spin_power;
    private int red, green, blue;
    private Telemetry telemetry;
    
    public void run() {
        telemetry.addData("Front", front);
        telemetry.addData("Back", back);
        telemetry.addData("Left", left);
        telemetry.addData("Right", right);
        telemetry.addData("Orientation", direction);
        telemetry.addData("Color_R", red);
        telemetry.addData("Color_G", green);
        telemetry.addData("Color_B", blue);
        telemetry.addData("Spin Power", Math.round(spin_power * 100));
        telemetry.update();
    }
    
    public TelemetryThread(Telemetry telem, double front, double back, double left, double right, long direction, long spin_power, int red, int green, int blue) {
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
}
