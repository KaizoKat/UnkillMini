/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.pws.unkillmini.Scripts;

import io.github.pws.unkillmini.Assets.Sprites.spr_equipment;
import io.github.pws.unkillmini.Program.backbone.Input;
import io.github.pws.unkillmini.Program.backbone.Item;
import io.github.pws.unkillmini.Program.backbone.ScriptableNode;
import io.github.pws.unkillmini.Program.rendering.ConsoleColors;
import io.github.pws.unkillmini.Program.rendering.Window;

public class Equipment extends ScriptableNode
{
    public static boolean open = true;
    
    public static Item[] equippedItems = new Item[5];
    
    @Override
    public void start() 
    {
    }

    @Override
    public void update() 
    {
        boolean inspector = true, larm = true, rarm = false, legs = false, torso = false, head = false;
        
        if(Input.Contains(Commands.equipment))
        {
            if(Input.line.split(" ").length == 1)
                open = !open;
            
            if(open && Input.Contains(Commands.check) && Input.line.toUpperCase().contains("LEFT ARM"))
            {
                inspector = true;
                larm = true;
            }
                        
            else if(open && Input.Contains(Commands.check) && Input.line.toUpperCase().contains("RIGHT ARM"))
            {
                inspector = true;
                rarm = true;
            }
       
            else if(open && Input.Contains(Commands.check) && Input.line.toUpperCase().contains("LEGS"))
            {
                inspector = true;
                legs = true;
            }
                        
            else if(open && Input.Contains(Commands.check) && Input.line.toUpperCase().contains("TORSO"))
            {
                inspector = true;
                torso = true;
            }
            
            else if(open && Input.Contains(Commands.check) && Input.line.toUpperCase().contains("HEAD"))
            {
                inspector = true;
                head = true;
            }
            else if(open && Input.Contains(Commands.check))
            {
                Window.appendToSuffix("-Checks------------");
                Window.appendToSuffix("left arm");
                Window.appendToSuffix("right arm");
                Window.appendToSuffix("legs");
                Window.appendToSuffix("torso");
                Window.appendToSuffix("head");
            }
        }
        
        spr_equipment.x = 23;
        spr_equipment.y = 28;
        spr_equipment.background = ConsoleColors.Background.GREEN;
        
        if(open)
        {
            
            spr_equipment.pixels = spr_equipment.buttonPressed;
            spr_equipment.foregorund = ConsoleColors.Foreground.WHITE;
            spr_equipment.populate();
            
            spr_equipment.y = 4;
            spr_equipment.pixels = spr_equipment.box;
            spr_equipment.populate();
        }
        else 
        {
            spr_equipment.pixels = spr_equipment.button;
            spr_equipment.foregorund = ConsoleColors.Foreground.BLACK;
            spr_equipment.populate();
        }
        
        if(inspector)
        {
            if(larm)
            {
                String area =
                "*%@@@@@@@@@@&/\n"+
                "*%@@@@@@@@@@&/\n"+
                "*%@@@@@@@@@@&/\n";
                
                spr_equipment.x = 65;
                spr_equipment.y = 12;
                spr_equipment.pixels = area;
                spr_equipment.background = ConsoleColors.Background.GREEN_BRIGHT;
                spr_equipment.populate();
                
                if(equippedItems[0] == null)
                {
                    Window.appendToSuffix("There are no currently equiped items on the left arm.");
                }
            }
            else if(rarm)
            {
                String area =
                ".(@@@@@@@@@@@#,\n"+
                ".(@@@@@@@@@@@#,\n"+
                ".(@@@@@@@@@@@#,\n";
                
                spr_equipment.x = 27;
                spr_equipment.y = 12;
                spr_equipment.pixels = area;
                spr_equipment.background = ConsoleColors.Background.GREEN_BRIGHT;
                spr_equipment.populate();
                
                if(equippedItems[1] == null)
                {
                    Window.appendToSuffix("There are no currently equiped items on the right arm.");
                }
            }
            else if(legs)
            {
                String area =
                "*%@@@#,   *%@@@#,\n"+
                "*%@@@#,   *%@@@#,\n"+
                "*%@@@#,   *%@@@#,\n"+
                "*%@@@#,   *%@@@#,\n"+
                "*%@@@#,   *%@@@#,\n"+
                "*%@@@#,   *%@@@#,\n";
                
                spr_equipment.x = 45;
                spr_equipment.y = 21;
                spr_equipment.pixels = area;
                spr_equipment.background = ConsoleColors.Background.GREEN_BRIGHT;
                spr_equipment.populate();
                
                if(equippedItems[2] == null)
                {
                    Window.appendToSuffix("There are no currently equiped items on the left arm.");
                }
            }
            else if(torso)
            {
                String area =
                "*%@@@@@@@@@@@@@#,\n"+
                "*%@@@@@@@@@@@@@#,\n"+
                "*%@@@@@@@@@@@@@#,\n"+
                "*%@@@@@@@@@@@@@#,\n"+
                "*%@@@@@@@@@@@@@#,\n"+
                "*%@@@@@@@@@@@@@#,\n"+
                "*%@@@@@@@@@@@@@#,\n"+
                "*%@@@@@@@@@@@@@#,\n";
                
                spr_equipment.x = 45;
                spr_equipment.y = 12;
                spr_equipment.pixels = area;
                spr_equipment.background = ConsoleColors.Background.GREEN_BRIGHT;
                spr_equipment.populate();
                
                if(equippedItems[3] == null)
                {
                    Window.appendToSuffix("There are no currently equiped items on the left arm.");
                }
            }
            else if(head)
            {
                String area =
                ".(@@@@@@@@&/\n"+
                ".(@@@@@@@@&/\n"+
                ".(@@@@@@@@&/\n"+
                ".(@@@@@@@@&/\n";
                
                spr_equipment.x = 47;
                spr_equipment.y = 6;
                spr_equipment.pixels = area;
                spr_equipment.background = ConsoleColors.Background.GREEN_BRIGHT;
                spr_equipment.populate();
                
                if(equippedItems[4] == null)
                {
                    Window.appendToSuffix("There are no currently equiped items on the left arm.");
                }
            }
        }
    }

    @Override
    public void end() 
    {
    }
}
