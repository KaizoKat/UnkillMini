package io.github.pws.unkillmini.Program;

import io.github.pws.unkillmini.Scripts.Rooms.SmallRoom;
import io.github.pws.unkillmini.Scripts.UI.Equipment;
import io.github.pws.unkillmini.Scripts.UI.Help;
import io.github.pws.unkillmini.Scripts.UI.Inventory;
import io.github.pws.unkillmini.Scripts.UI.MakeBorder;
import io.github.pws.unkillmini.Scripts.UI.MakeDisclaimer;
import io.github.pws.unkillmini.Program.backbone.Input;
import io.github.pws.unkillmini.Program.rendering.Window;
        
public class Aplication
{
    public static boolean run = true;
    
    private static final MakeDisclaimer disclaimer = new MakeDisclaimer();
    private static final MakeBorder border = new MakeBorder();
    private static final Inventory inv = new Inventory();
    private static final Equipment equ = new Equipment();
    private static final Help help = new Help();
    private static final SmallRoom room = new SmallRoom();
    
    public static void main(String[] args)
    {
        Window.compose();
        disclaimer.start();
        Window.clear();

        START();
        
        while(true)
        {
            if(run)
            {
                UPDATE();
            }
            else
            {
                END();
                break;
            }
        }
    }
    
    private static void START()
    {
        Window.compose();
        border.start();
        room.start();
        equ.start();
        inv.start();
        Window.fillBlanks();
        Window.draw();
        Window.hideCursor();
    }
    
    private static void UPDATE()
    {
        Window.compose();
        Input.scanInput();
        //game
        room.update();
        //ui
        border.update();
        help.update();
        inv.update();
        equ.update();
        try {Thread.sleep(1);} catch (Exception e) {}
        Window.fillBlanks();
        Window.draw();
    }
    
    private static void END()
    {
        
    }
}
