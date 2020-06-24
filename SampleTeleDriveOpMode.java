package org.firstinspires.ftc.teamcode; //set your package

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;
import org.firstinspires.ftc.teamcode.TeleDrive;

@TeleOp(name = "Your TeleOp Name", group = "TeleOpMode")
public class SampleTeleDriveOpMode extends TeleDrive {
    private ElapsedTime runtime = new ElapsedTime(ElapsedTime.Resolution.MILLISECONDS);

    @Override
    public void init() {
        super.init();
        //Init code here
    }

    public void init_loop() {
        super.init_loop();
        //Init Loop code here
    }

    @Override
    public void start() {
        super.start();
        //Start code here
        runtime.reset();
    }

    @Override
    public void loop() {
        super.loop();
        //Loop code here
    }

    @Override
    public void stop() {
        super.stop();
        //Stop code here
    }
}