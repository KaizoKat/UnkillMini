package io.github.pws.unkillmini;

import io.github.pws.unkillmini.Program.backbone.Input;
import io.github.pws.unkillmini.Scripts.Entities.*;
import io.github.pws.unkillmini.Scripts.Tools.DefaultMappings;
import io.github.pws.unkillmini.Scripts.UI.*;
import io.github.pws.unkillmini.Program.Manager;
import io.github.pws.unkillmini.Program.rendering.Window;
        
public class Application
{
    private static final String version = "0.1.7";

    private static final MakeDisclaimer disclaimer = new MakeDisclaimer();
    public static Input input= new Input();
    
    public static void main(String[] args)
    {
        Window.create();
        Window.compose();
        disclaimer.build();
        Window.clear();

        new DefaultMappings();
        new Player();
        new MakeBorder();

        new Inventory();
        new Equipment();
        new Options();
        new Help();
        Manager.loop();
    }
}
