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

public class Equipment implements ScriptableNode
{
    public static boolean open = true;
    
    public static Item[] equippedItems = new Item[7];
    
    @Override
    public void start() 
    {
    }

    @Override
    public void update() 
    {
        boolean larm = false, rarm = false, legs = false, chest = false, head = false, weapon = false, totems = false;
        
        if(Input.Contains(Commands.equipment))
        {
            if(Input.line.split(" ").length == 1)
                open = !open;
            
            if(open && Input.Contains(Commands.check) && Input.line.toUpperCase().contains("LEFT ARM"))
                larm = true;
            else if(open && Input.Contains(Commands.check) && Input.line.toUpperCase().contains("RIGHT ARM"))
                rarm = true;
            else if(open && Input.Contains(Commands.check) && Input.line.toUpperCase().contains("LEGS"))
                legs = true;    
            else if(open && Input.Contains(Commands.check) && Input.line.toUpperCase().contains("CHEST"))
                chest = true;
            else if(open && Input.Contains(Commands.check) && Input.line.toUpperCase().contains("HEAD"))
                head = true;
            else if(open && Input.Contains(Commands.check) && Input.line.toUpperCase().contains("WEAPON"))
                weapon = true;
            else if(open && Input.Contains(Commands.check) && Input.line.toUpperCase().contains("TOTEMS"))
                totems = true;
            else if(open && Input.Contains(Commands.check))
            {
                Window.appendToSuffix("-Checks------------");
                Window.appendToSuffix("left arm, right arm, chest, legs, head, weapon and totems");
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
            
            spr_equipment.y = 5;
            spr_equipment.pixels = spr_equipment.box;
            spr_equipment.populate();
        }
        else 
        {
            spr_equipment.pixels = spr_equipment.button;
            spr_equipment.foregorund = ConsoleColors.Foreground.GREEN;
            spr_equipment.populate();
        }

        if(larm)
        {
            String area =     
            """
            *%@@@@@@@@@@&/
            *%@@@@@@@@@@&/
            *%@@@@@@@@@@&/
            """;

            selectArea(area, 65, 12, '*',
            ConsoleColors.Background.GREEN, ConsoleColors.Foreground.CYAN, 
            ConsoleColors.Background.CYAN, ConsoleColors.Foreground.WHITE);
            appendCheck(equippedItems[0], "left arm");
        }
        else if(rarm)
        {
            String area =
            """
            .(@@@@@@@@@@@#,
            .(@@@@@@@@@@@#,
            .(@@@@@@@@@@@#,
            """;

            selectArea(area, 27, 12, '*',
            ConsoleColors.Background.GREEN, ConsoleColors.Foreground.CYAN, 
            ConsoleColors.Background.CYAN, ConsoleColors.Foreground.WHITE);
            appendCheck(equippedItems[1], "right arm");
        }
        else if(legs)
        {
            String area =
            """
            *%@@@#,   *%@@@#,
            *%@@@#,   *%@@@#,
            *%@@@#,   *%@@@#,
            *%@@@#,   *%@@@#,
            *%@@@#,   *%@@@#,
            *%@@@#,   *%@@@#,
            """;
            
            selectArea(area, 45, 21, '*',
            ConsoleColors.Background.GREEN, ConsoleColors.Foreground.CYAN, 
            ConsoleColors.Background.CYAN, ConsoleColors.Foreground.WHITE);
            appendCheck(equippedItems[2], "legs");
        }
        else if(chest)
        {
            String area =
            """
            *%@@@@@@@@@@@@@#,
            *%@@@@@@@@@@@@@#,
            *%@@@@@@@@@@@@@#,
            *%@@@@@@@@@@@@@#,
            *%@@@@@@@@@@@@@#,
            *%@@@@@@@@@@@@@#,
            *%@@@@@@@@@@@@@#,
            *%@@@@@@@@@@@@@#,
            """;

            selectArea(area, 45, 12, '*',
            ConsoleColors.Background.GREEN, ConsoleColors.Foreground.CYAN, 
            ConsoleColors.Background.CYAN, ConsoleColors.Foreground.WHITE);
            appendCheck(equippedItems[3], "chest");
        }
        else if(head)
        {
            String area =
            """
            .(@@@@@@@@&/
            .(@@@@@@@@&/
            .(@@@@@@@@&/
            .(@@@@@@@@&/
            """;

            selectArea(area, 47, 7, '*',
            ConsoleColors.Background.GREEN, ConsoleColors.Foreground.CYAN, 
            ConsoleColors.Background.CYAN, ConsoleColors.Foreground.WHITE);
            appendCheck(equippedItems[4], "head");
        }

        else if(weapon)
        {
            String area =
            "           /&%*\n"+
            "           /&%*\n"+
            "        *%@@@%*\n"+
            ".(@#,.(@@@@@@%*\n"+
            ".(@@@@@@@@&/   \n"+
            "   *%@@@#,     \n"+
            ".(@#,.(@@@&/   \n";

            selectArea(area, 67, 18, '*',
            ConsoleColors.Background.GREEN, ConsoleColors.Foreground.CYAN, 
            ConsoleColors.Background.CYAN, ConsoleColors.Foreground.WHITE);
            appendCheck(equippedItems[5], "weapon");
        }

        else if(totems)
        {
            String area =
            "     *%&/     \n"+
            "  .(@#,.(@#,  \n"+
            "*%@@@#,.(@@@&/\n"+
            "*%&/ *%&/ *%&/\n"+
            "*%&/      *%&/\n"+
            "  .(@#,.(@#,  \n"+
            "     *%&/     \n";
            
            selectArea(area, 25, 18, '*',
            ConsoleColors.Background.GREEN, ConsoleColors.Foreground.CYAN, 
            ConsoleColors.Background.CYAN, ConsoleColors.Foreground.WHITE);
            appendTotem();
        }
    }

    @Override
    public void end() 
    {
    }
    
    private static void appendTotem()
    {
        if(equippedItems[6] == null)
        {
            Window.appendToSuffix("There are no currently equiped totems.");
        }
        else
        {
            String area = 
            """
            ######################
            |                    |
            |                    |
            |                    |
            |                    |
            |                    |
            |                    |
            |                    |
            |                    |
            |                    |
            |                    |
            |                    |
            |                    |
            |                    |
            |                    |
            ######################
            """;
            
            selectArea(area, 51, 8, ' ', 
            ConsoleColors.Background.BLACK, ConsoleColors.Foreground.BLACK, 
            ConsoleColors.Background.GREEN, ConsoleColors.Foreground.WHITE);
            /*
            it will add the item into an list of totems that works like the inventory items when the command is done.
            it will print an inventory right in the middle of the exquipment tab and will work just like the inventory,
            except with other commands and wi stay on as long as that command is not "eq. ch. totems" or another ch command
            */
        }
    }
    
    private static void appendCheck(Item it, String slot)
    {
        if(it == null)
        {
            Window.appendToSuffix("There is no currently equiped item on the " + slot);
        }
        else
        {
            Window.appendToSuffix(it.name + " | " + it.description);
        }
    }
    
    private static void selectArea(String area, int poX, int poY, char cBor, String borderBG, String borderFG, String selectBG, String selectFG)
    {
        String[] lamda = new String[area.split("\n").length + 2];
        String[] temp = area.split("\n");
        
        for(int s = 0; s < lamda.length; s++) 
        {
            if(s == 0 || s == lamda.length-1)
            {
                lamda[s] = String.valueOf(cBor);
                for(char c : temp[0].toCharArray())
                {
                    lamda[s] += String.valueOf(cBor);
                }
                lamda[s] += String.valueOf(cBor)+"\n";
            }
            else
            {
                lamda[s] = String.valueOf(cBor) + temp[s-1] + String.valueOf(cBor) + "\n";
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(String s : lamda) sb.append(s);
        
        spr_equipment.background = borderBG;
        spr_equipment.foregorund = borderFG;
        spr_equipment.x = poX-1;
        spr_equipment.y = poY-1;
        spr_equipment.pixels = sb.toString();
        spr_equipment.populate();
        
        spr_equipment.background = selectBG;
        spr_equipment.foregorund = selectFG;
        spr_equipment.x = poX;
        spr_equipment.y = poY;
        spr_equipment.pixels = area;
        spr_equipment.populate();
    }
}
