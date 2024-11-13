package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;


@TeleOp(name="TestProject with test Controls")
public class DrivechainTest extends LinearOpMode {

    DcMotor leftBack;
    DcMotor leftFront;
    DcMotor rightBack;
    DcMotor rightFront;
    double maxPower = 0.5;
    @Override
    public void runOpMode() {
        // Initialize the motors
       leftBack = hardwareMap.get(DcMotor.class, "leftback");
        leftFront = hardwareMap.get(DcMotor.class, "leftfront");
        rightBack = hardwareMap.get(DcMotor.class, "rightback");
        rightFront = hardwareMap.get(DcMotor.class, "rightfront");
        // Configure motor direction
        rightFront.setDirection(DcMotor.Direction.REVERSE);  // Left motor moves forward
        leftBack.setDirection(DcMotor.Direction.FORWARD);
        rightBack.setDirection(DcMotor.Direction.REVERSE);
        leftFront.setDirection(DcMotor.Direction.FORWARD);// Right motor moves in reverse

        // Wait for the start of the match
        waitForStart();

        // Game loop: runs until stop is press
        while (opModeIsActive()) {



            // Use gamepad joysticks to control motor power
         double y = -gamepad1.left_stick_y;  // Left joystick controls the left motor
         double x = gamepad1.left_stick_x *1.1;
         double rx = gamepad1.right_stick_x;

            double denominator = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(rx), 1);
            leftFront.setPower((y + x + rx) / denominator);
            leftBack.setPower((y - x + rx) / denominator);
            rightFront.setPower((y - x - rx) / denominator);
            rightBack.setPower((y + x - rx) / denominator);

            // Optional: Send telemetry data to the driver station
          //  telemetry.addData("Apha light",  color_sensor.alpha());
           // telemetry.update();
        }
    }
}
