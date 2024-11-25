package io.github.pws.unkillmini.Program;

import java.util.ArrayList;
import java.util.List;

import io.github.pws.unkillmini.Application;
import io.github.pws.unkillmini.Program.backbone.*;
import io.github.pws.unkillmini.Program.backbone.DataTypes.Vector2;
import io.github.pws.unkillmini.Program.rendering.Color;
import io.github.pws.unkillmini.Program.rendering.Window;
import io.github.pws.unkillmini.Scripts.UI.MakeBorder;

public class Manager 
{
    public static List<Script> scripts = new ArrayList<>();

    public static final boolean displayFramerate = true;
    public static final FramerateController time = new FramerateController();
    public static final Input input = new Input();

    public static boolean run = true;

    private static final MakeBorder border = new MakeBorder();

    public static void loop()
    {
        boolean start = true;

        while (true)
        {
            SceneManager.killProcessOnNoLoadedScene();
            if(SceneManager.switchSceneOnCurrentChange())
            {
                start = true;
                continue;
            }

            if(start)
            {
                SceneManager.startScene();
                Window.draw();
                staticSettings();
                start = false;
            }

            if (run)
            {
                input.processInputQueue();

                border.createBackgorund();
                SceneManager.updateScene();

                FramerateController.FPSCounter.countFrame();
                if (displayFramerate) displayFPS();

                border.createBorder();

                input.updateStates();
                Window.removeScaffolding();
                Window.draw();

                time.regulateFramerate();
            } else {
                SceneManager.endScene();
                break;
            }
        }
    }


    private static void staticSettings()
    {
        Window.hideCursor();
        int fps = 60;
        time.setTargetFramerate(fps);
        time.setVSync(false, fps);
    }

    private static void displayFPS()
    {
        int currentRate = FramerateController.FPSCounter.getCurrentFrameCount();
        String output = "FPS: N / A";
        if(currentRate != 0)
            output = "FPS: " + currentRate + " / " + time.targetFramerate;

        Window.populatePixels(Sprite.PopulateWith(output),new Vector2(2,1));
        Window.populateForeground(Color.rgbFG(255,255,255),new Vector2(2,1), new Vector2(output.length(),1));
        Window.populateBackground(Color.rgbBG(0,0,0),new Vector2(2,1), new Vector2(output.length(),1));
    }
}
