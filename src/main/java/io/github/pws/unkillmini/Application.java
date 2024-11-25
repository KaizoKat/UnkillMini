package io.github.pws.unkillmini;

import io.github.pws.unkillmini.Scenes.TestScene;
import io.github.pws.unkillmini.Scripts.UI.*;
import io.github.pws.unkillmini.Program.Manager;
import io.github.pws.unkillmini.Program.rendering.Window;


public class Application
{
    private static final String version = "0.1.8";

    private static final MakeDisclaimer disclaimer = new MakeDisclaimer();

    public static void main(String[] args)
    {
        Window.create();
        disclaimer.build();

        new TestScene(0);

        Manager.loop();
    }
}
