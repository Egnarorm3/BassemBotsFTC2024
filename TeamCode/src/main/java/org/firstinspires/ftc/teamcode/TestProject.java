package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareDevice;


@TeleOp(name="TestProject with test Controls")
public class TestProject extends LinearOpMode {

    DcMotor motorLeft;
    DcMotor motorRight;
    DcMotor railLeft;
    DcMotor railRight;
    ColorSensor color_sensor;
    double maxPower = 0.5;
    @Override
    public void runOpMode() {
        // Initialize the motors
       motorLeft = hardwareMap.get(DcMotor.class, "left");
        motorRight = hardwareMap.get(DcMotor.class, "right");
        railLeft = hardwareMap.get(DcMotor.class, "railleft");
        railRight = hardwareMap.get(DcMotor.class, "railright");
       // color_sensor = hardwareMap.get(ColorSensor.class, "color_sensor");
        // Configure motor direction
        motorLeft.setDirection(DcMotor.Direction.REVERSE);  // Left motor moves forward
        motorRight.setDirection(DcMotor.Direction.FORWARD);
        railLeft.setDirection(DcMotor.Direction.REVERSE);
        railRight.setDirection(DcMotor.Direction.REVERSE);// Right motor moves in reverse

        // Optional: Set zero power behavior
        motorLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);   // Brake when power is 0
        motorRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        railRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        railLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);// Brake when power is 0

        // Wait for the start of the match
        waitForStart();

        // Game loop: runs until stop is pressed
        double power1 = 0;
        double power2 = 0;
        while (opModeIsActive()) {



            if (gamepad1.dpad_up && maxPower < 1.0){
                maxPower += 0.1;
                sleep(200);
            }
            if (gamepad1.dpad_down && maxPower > 0.1){
                maxPower -= 0.1;
                sleep(200);
            }
            // Use gamepad joysticks to control motor power
         double drive = -gamepad2.left_stick_y;  // Left joystick controls the left motor
            double turn = -gamepad2.left_stick_x;

           double leftPower = (drive+turn) * maxPower;
           double rightPower = (drive-turn) * maxPower;


           double maxInput = Math.max(Math.abs(leftPower), Math.abs(rightPower));
            if (maxInput > 1.0) {
              leftPower /= maxPower;
                rightPower /= maxPower;
            }
           motorLeft.setPower(leftPower);
           motorRight.setPower(rightPower);
           railLeft.setPower(-gamepad1.left_stick_y);
           railRight.setPower(-gamepad1.right_stick_y);

            // Optional: Send telemetry data to the driver station
            telemetry.addData(" coool Power", power2);
           telemetry.update();

          //  if (color_sensor.alpha()>6500) {
          //      motorArm.setPower(0.5);
           // }else{
          //      motorArm.setPower(-0.5);

         //   }

          //  telemetry.addData("Apha light",  color_sensor.alpha());
           // telemetry.update();
        }
    }
}
