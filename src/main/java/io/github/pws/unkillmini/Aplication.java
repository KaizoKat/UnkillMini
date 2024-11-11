package io.github.pws.unkillmini;

import io.github.pws.unkillmini.Scripts.Entities.*;
import io.github.pws.unkillmini.Scripts.Rooms.*;
import io.github.pws.unkillmini.Scripts.UI.*;
import io.github.pws.unkillmini.Program.*;
import io.github.pws.unkillmini.Program.rendering.*;
        
public class Aplication
{
    @SuppressWarnings("unused")
    private static String version = "0.1.6";

    private static final MakeDisclaimer disclaimer = new MakeDisclaimer();
    
    public static void main(String[] args)
    {
        Window.create();
        Window.compose();
        disclaimer.build();
        Window.clear();

        new SmallRoom();
        new Player();
        new MakeBorder();
        new Help();
        new Inventory();
        new Equipment();
        new Options();

        Manager.loop();
    }
}
