package io.github.pws.unkillmini.Program;

import java.util.ArrayList;
import java.util.List;

import io.github.pws.unkillmini.Program.backbone.Input;
import io.github.pws.unkillmini.Program.backbone.Script;
import io.github.pws.unkillmini.Program.rendering.Window;

public class Manager 
{
    private static List<Script> scripts = new ArrayList<>();
    public static boolean run = true;

    private static final int TARGET_FPS = 60;
    private static final long OPTIMAL_TIME = 1000000000 / TARGET_FPS;
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
                delta = updateLength / ((double) OPTIMAL_TIME);
                Input.scanInput();

                FPSCounter.countFrame();

                Window.compose();

                for (Script s : scripts)
                {
                    s.update();
                }

                Window.fillBlanks();
                Window.draw();

                try {
                    long gameTime = (lastLoopTime - System.nanoTime() + OPTIMAL_TIME) / 1_000_000;
                    if (gameTime > 0) { Thread.sleep(gameTime);}
                } catch (InterruptedException e) { e.printStackTrace(); }
            }
            else
            {
                endAll();
                break;
            }
        }
    }

    private static final void staticSettings()
    {
        Window.hideCursor();
    }

    public class FPSCounter 
    {
        private static int frameCount = 0;
        private static long lastFPSCheck = System.nanoTime();
        
        public static void countFrame() 
        {
            frameCount++;
            if (System.nanoTime() - lastFPSCheck >= 1_000_000_000) 
            {
                Window.print("FPS: " + frameCount);
                frameCount = 0;
                lastFPSCheck = System.nanoTime();
            }
        }
    }
}
