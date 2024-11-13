package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;


@Autonomous(name = "Autotest", group = "Test")
public class Autotest extends LinearOpMode {

    // Declare any hardware components (like motors or sensors) here
    private DcMotor leftMotor;
    private DcMotor rightMotor;

    @Override
    public void runOpMode() {
        // Initialize hardware
        leftMotor = hardwareMap.get(DcMotor.class, "left");
        rightMotor = hardwareMap.get(DcMotor.class, "right");

        // Set the direction of the motors, if necessary
        leftMotor.setDirection(DcMotor.Direction.REVERSE);
        rightMotor.setDirection(DcMotor.Direction.FORWARD);

        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        // Autonomous actions
        if (opModeIsActive()) {
            // Example movement: Drive forward for 2 seconds(1);
            driveForward(1.0);
            sleep(2000);
            stopMotors();
            leftMotor.setPower(0.75);
            sleep(850); // Drive for 2 seconds
            stopMotors();
            driveForward(1.0);
            sleep(1000);
            stopMotors();
            rightMotor.setPower(0.75);
            sleep(850); // Drive for 2 seconds
            stopMotors();
            driveForward(5.0);
            sleep(3000);
            stopMotors();
            rightMotor.setPower(0.75);
            sleep(850); // Drive for 2 seconds
            stopMotors();
            driveForward(1.0);
            sleep(2000);
            stopMotors();






            // Add more movements as needed for your autonomous program
        }
    }

    // Helper methods for driving
    private void driveForward(double power) {
        leftMotor.setPower(power);
        rightMotor.setPower(power);
    }

    private void stopMotors() {
        leftMotor.setPower(0);
        rightMotor.setPower(0);
    }
}
