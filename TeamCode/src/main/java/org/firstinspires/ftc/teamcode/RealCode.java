package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;


@TeleOp(name="RealCode")
public class RealCode extends LinearOpMode {

    DcMotor leftBack;
    DcMotor leftFront;
    DcMotor rightBack;
    DcMotor rightFront;
    DcMotor intakeArm;
    DcMotor intakeExtend;
    DcMotor intakeHand;
    DcMotor intakePulh;
    double maxPower = 0.5;
    @Override
    public void runOpMode() {
        // Initialize the motors
      // leftBack = hardwareMap.get(DcMotor.class, "leftback");
       // leftFront = hardwareMap.get(DcMotor.class, "leftfront");
        //rightBack = hardwareMap.get(DcMotor.class, "rightback");
       // rightFront = hardwareMap.get(DcMotor.class, "rightfront");
      //  intakeArm = hardwareMap.get(DcMotor.class, "intakeArm");
        intakeExtend = hardwareMap.get(DcMotor.class, "intakeExtend");
     //   intakeHand = hardwareMap.get(DcMotor.class, "intakeHand");
       // intakePulh = hardwareMap.get(DcMotor.class, "intakePulh");
        // Configure motor direction
        //rightFront.setDirection(DcMotor.Direction.REVERSE);  // Left motor moves forward
        //leftBack.setDirection(DcMotor.Direction.FORWARD);
        //rightBack.setDirection(DcMotor.Direction.REVERSE);
        //leftFront.setDirection(DcMotor.Direction.FORWARD);// Right motor moves in reverse
      //  intakeArm.setDirection(DcMotor.Direction.FORWARD);
        intakeExtend.setDirection(DcMotor.Direction.FORWARD);
       // intakeHand.setDirection(DcMotor.Direction.FORWARD);
       // intakePulh.setDirection(DcMotor.Direction.FORWARD);

        // Wait for the start of the match
        waitForStart();
        double intakeStat = 0;




        // Game loop: runs until stop is press
        while (opModeIsActive()) {

            long currentTime = System.currentTimeMillis();            // Use gamepad joysticks to control motor power
         double yp = -gamepad1.left_stick_y;  // Left joystick controls the left motor
         double xp = gamepad1.left_stick_x *1.1;
         double rxp = gamepad1.right_stick_x;

            double denominator = Math.max(Math.abs(yp) + Math.abs(xp) + Math.abs(rxp), 1);
           // leftFront.setPower((yp + xp + rxp) / denominator);
           // leftBack.setPower((yp - xp + rxp) / denominator);
            //rightFront.setPower((yp - xp - rxp) / denominator);
            //rightBack.setPower((yp + xp - rxp) / denominator);


         double yac = -gamepad2.right_stick_y;
         double xhc = -gamepad2.left_stick_x;
       //  intakeArm.setPower(yac);
        // intakeHand.setPower(xhc);
         if (gamepad2.left_stick_button) {
             if (intakeStat==0) {
                 intakeStat = -1;
             }else{
                 if (intakeStat==1) {
                     intakeStat = -1;
                 }else{
                     intakeStat =0;
                 }
             }
         }

         if (gamepad2.right_stick_button) {
             if (intakeStat==0) {
                 intakeStat = 1;
             }else{
                 if (intakeStat==-1) {
                     intakeStat = 1;
                 }else{
                    intakeStat =0;
                 }
             }
         }

         //intakePulh.setPower(intakeStat);
            if (gamepad2.right_bumper) {
                intakeExtend.setPower(0.5);
            }else{
                if (gamepad2.left_bumper) {
                    intakeExtend.setPower(-0.5);
                }else {
                    intakeExtend.setPower(0);
                }
            }

            telemetry.addData("left bumper being pressed", gamepad2.left_bumper);
            telemetry.update();

        }
    }
}
