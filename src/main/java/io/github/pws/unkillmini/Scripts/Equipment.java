/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.pws.unkillmini.Scripts;

import io.github.pws.unkillmini.Assets.Sprites.spr_equipment;
import io.github.pws.unkillmini.Program.backbone.Input;
import io.github.pws.unkillmini.Program.backbone.ScriptableNode;
import io.github.pws.unkillmini.Program.rendering.ConsoleColors;
import io.github.pws.unkillmini.Program.rendering.Window;

public class Equipment extends ScriptableNode
{
    public static boolean open = false;
    String[][] ray;
    
    @Override
    public void start() 
    {
    }

    @Override
    public void update() 
    {
        if(Input.Contains(Commands.equipment))
        {
            open = !open;
        }

        if(Input.Contains(Commands.use + " " + "debug"))
        {
            Window.appendToSuffix("No functionality.");
        }
        
        spr_equipment.x = 23;
        spr_equipment.y = 28;
        spr_equipment.background = ConsoleColors.Background.GREEN;
        
        if(open)
        {
            
            spr_equipment.pixels = spr_equipment.buttonPressed;
            spr_equipment.foregorund = ConsoleColors.Foreground.WHITE;
            spr_equipment.populate();
            
            spr_equipment.y = 12;
            spr_equipment.pixels = spr_equipment.box;
            spr_equipment.populate();
        }
        else 
        {
            spr_equipment.pixels = spr_equipment.button;
            spr_equipment.foregorund = ConsoleColors.Foreground.BLACK;
            spr_equipment.populate();
        }
    }

    @Override
    public void end() 
    {
    }
}
