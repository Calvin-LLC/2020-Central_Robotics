package org.firstinspires.ftc.teamcode;

import java.util.Timer;
import com.qualcomm.robotcore.hardware.DcMotor;
import java.util.TimerTask;



public class StopMotors extends TimerTask {
    private DcMotor fr, fl, br, bl, belt, spinL, spinR;
    
    public StopMotors(DcMotor fr, DcMotor fl, DcMotor br, DcMotor bl, DcMotor belt, DcMotor spinL, DcMotor spinR) {
        this.fr = fr;
        this.fl = fl;
        this.br = br;
        this.bl = bl;
        this.belt = belt;
        this.spinL = spinL;
        this.spinR = spinR;
    }
    
    public void run() {
        fr.setPower(0.0);
        fl.setPower(0.0);
        br.setPower(0.0);
        bl.setPower(0.0);
        belt.setPower(0.0);
        spinL.setPower(0.0);
        spinR.setPower(0.0);
    }
}