package io.github.pws.unkillmini.Program;

import java.util.ArrayList;
import java.util.List;

import io.github.pws.unkillmini.Application;
import io.github.pws.unkillmini.Program.backbone.*;
import io.github.pws.unkillmini.Program.rendering.Window;

public class Manager 
{
    public static List<Script> scripts = new ArrayList<>();

    public static final boolean displayFramerate = true;
    public static final int targetFps = 120;

    public static int framerate = 0;
    public static final long optimalTime = 1_000_000_000 / targetFps;

    public static boolean run = true;
    public static double delta;

    public static void addScript(Script script)
    {
        scripts.add(script);
    }

    public static void startAll()
    {
        for (Script s : scripts)
        {
            s.start();
        }
    }

    public static void endAll()
    {
        for (Script s : scripts)
        {
            s.end();
        }
    }

    private static void updateAll()
    {
        for (Script s : scripts)
        {
            s.update();
        }
    }

    public static void loop()
    {   
        Window.compose();
        startAll();

        Window.fillBlanks();
        Window.draw();

        staticSettings();
        long lastLoopTime = System.nanoTime();

        while (true)
        {
            if (run)
            {
                long now = System.nanoTime();
                long updateLength = now - lastLoopTime;
                lastLoopTime = now;
                delta = updateLength / ((double) optimalTime);


                Window.compose();
                Application.input.processInputQueue();

                FPSCounter.countFrame();
                framerate = FPSCounter.getCurrentFrameCount();
                if(displayFramerate) displayFPS();

                updateAll();

                Window.draw();
                Application.input.updateStates();
                try {

                    long gameTime = (lastLoopTime - System.nanoTime() + optimalTime) / 1_000_000;
                    if (gameTime > 0) Thread.sleep(gameTime);
                } catch (InterruptedException e) { e.printStackTrace(); }
            }
            else
            {
                endAll();
                break;
            }
        }
    }

    private static void staticSettings()
    {
        Window.hideCursor();
    }

    private static void displayFPS()
    {
        int currentRate = FPSCounter.getCurrentFrameCount();
        String output = "FPS: N / A";
        if(currentRate != 0)
            output = "FPS: " + currentRate + " / " + targetFps;

        Window.populateWithPixels(Sprite.PopulateWith(output),new Vector2(2,1));
    }
}
