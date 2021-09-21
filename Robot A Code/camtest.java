/*package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import java.util.List;
import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaSkyStone;
import org.firstinspires.ftc.robotcore.external.tfod.Recognition;
import org.firstinspires.ftc.robotcore.external.tfod.TfodSkyStone;

@TeleOp(name = "camtest (Blocks to Java)", group = "")
public class camtest extends LinearOpMode {

  private VuforiaSkyStone vuforiaSkyStone;
  private TfodSkyStone tfodSkyStone;

  
  @Override
  public void runOpMode() {
    double index;
    List<Recognition> recognitions;

    vuforiaSkyStone = new VuforiaSkyStone();
    tfodSkyStone = new TfodSkyStone();

    // Sample TFOD Op Mode
    // Initialize Vuforia.
    vuforiaSkyStone.initialize(
        "", // vuforiaLicenseKey
        hardwareMap.get(WebcamName.class, "Webcam 1"), // cameraName
        "", // webcamCalibrationFilename
        true, // useExtendedTracking
        true, // enableCameraMonitoring
        VuforiaLocalizer.Parameters.CameraMonitorFeedback.AXES, // cameraMonitorFeedback
        0, // dx
        0, // dy
        0, // dz
        0, // xAngle
        0, // yAngle
        0, // zAngle
        true); // useCompetitionFieldTargetLocations
    // Set min confidence threshold to 0.7
    tfodSkyStone.initialize(vuforiaSkyStone, 0.7F, true, true);
    // Initialize TFOD before waitForStart.
    // Init TFOD here so the object detection labels are visible
    // in the Camera Stream preview window on the Driver Station.
    tfodSkyStone.activate();
    telemetry.addData(">", "Press Play to start");
    telemetry.update();
    // Wait for start command from Driver Station.
    waitForStart();
    if (opModeIsActive()) {
      // Put run blocks here.
      while (opModeIsActive()) {
        // Put loop blocks here.
        // Get a list of recognitions from TFOD.
        recognitions = tfodSkyStone.getRecognitions();
        // If list is empty, inform the user. Otherwise, go
        // through list and display info for each recognition.
        if (recognitions.size() == 0) {
          telemetry.addData("TFOD", "No items detected.");
        } else {
          index = 0;
          // Iterate through list and call a function to
          // display info for each recognized object.
          for (Recognition recognition : recognitions) {
            // Display info.
            displayInfo(index);
            // Increment index.
            index = index + 1;
          }
        }
        telemetry.update();
      }
    }
    // Deactivate TFOD.
    tfodSkyStone.deactivate();

    vuforiaSkyStone.close();
    tfodSkyStone.close();
  }

  
  private void displayInfo(double i) {
    Recognition recognition;

    // Display label info.
    // Display the label and index number for the recognition.
    telemetry.addData("label " + i, recognition.getLabel());
    // Display upper corner info.
    // Display the location of the top left corner
    // of the detection boundary for the recognition
    telemetry.addData("Left, Top " + i, recognition.getLeft() + ", " + recognition.getTop());
    // Display lower corner info.
    // Display the location of the bottom right corner
    // of the detection boundary for the recognition
    telemetry.addData("Right, Bottom " + i, recognition.getRight() + ", " + recognition.getBottom());
  }
}
*/