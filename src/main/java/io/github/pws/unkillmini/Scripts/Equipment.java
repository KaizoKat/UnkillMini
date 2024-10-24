/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.pws.unkillmini.Scripts;

import io.github.pws.unkillmini.assets.Items;
import io.github.pws.unkillmini.backbone.Input;
import io.github.pws.unkillmini.backbone.Item;
import io.github.pws.unkillmini.backbone.SpriteFormatting;
import io.github.pws.unkillmini.rendering.ConsoleColors;
import io.github.pws.unkillmini.rendering.Window;
import io.github.pws.unkillmini.run.Aplication;

public class Equipment extends Aplication
{
    private String button =
    """
    #--------------------#
    #      Inventory     #
    #--------------------#
    """;
    
    public String buttonPressed =
    """
    |                    |
    >>     Inventory    <<
    >>==================<<
    """;
    
    public String box =
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
    static boolean openInv = false;
    int itemPage = 0;
    String[][] ray;
    
    @Override
    public void start() 
    {
    }

    @Override
    public void update() 
    {
        if(Input.Is(Commands.index[1])) 
        {
            openInv = !openInv;
        }
        
        if(Items.list().length/12 != 0)
        {
            if(Input.Is(Commands.index[2]) || (openInv && Input.Is(Commands.index[4])))
            {
                itemPage++;
            }
            else if(Input.Is(Commands.index[3]) || (openInv && Input.Is(Commands.index[5])))
            {
                itemPage--;
            }
            else if(Input.Contains(Commands.index[1]))
            {
                openInv = true;
                try { itemPage = Integer.parseInt(Input.line.substring(4));
                } catch (NumberFormatException e) {}
            }
        }
        
        if(itemPage > (Items.list().length/12)+1) itemPage = (Items.list().length/12)+1;
        else if(itemPage < 0) itemPage = 0;
        
        for (Item item : Items.list())
        {
            if(Input.Is(Commands.index[6] + " " + item.name))
            {
                item.runner.start();
                item.count--;
                break;
            }
            else if(Input.Is(Commands.index[7] + " " + item.name))
            {
                Window.appendToSuffix("-Description " + item.name + "---");
                Window.appendToSuffix(item.name + ": " + item.description);
                break;
            }
        }
        
        if(openInv)
        {
            ray = SpriteFormatting.PopulateWith(box);
            Window.populateWithPixels(ray, 1, 12);
            Window.setPopulatorBackground(ray, 1, 12, ConsoleColors.Background.GREEN);
            Window.setPopulatorColor(ray, 1, 12, ConsoleColors.Foreground.WHITE);
            
            ray = SpriteFormatting.PopulateWith(buttonPressed);
            Window.populateWithPixels(ray, 1, 28);
            Window.setPopulatorBackground(ray, 1, 28, ConsoleColors.Background.GREEN);
            Window.setPopulatorColor(ray, 1, 28, ConsoleColors.Foreground.WHITE);

            fillInventory(Items.list(), itemPage);
        }
        else 
        {
            ray = SpriteFormatting.PopulateWith(button);
            Window.populateWithPixels(ray, 1, 28);
            Window.setPopulatorBackground(ray, 1, 28, ConsoleColors.Background.GREEN);
            Window.setPopulatorColor(ray, 1, 28, ConsoleColors.Foreground.BLACK);
        }
    }

    @Override
    public void end() 
    {
    }
    
    
    private void fillInventory(Item[] items, int itemPage)
    {
        int pageCount = (items.length/12)+1;
        int max = items.length - (itemPage * 12);
            Window.populateWithPixels(ray, 1, 28);
        if (itemPage < pageCount -1)
        {
            max = 12;
        }
        
        for (int i = 0; i < max; i++)
        {
            ray = SpriteFormatting.PopulateWith(items[i].count + " " + items[i].name);
            Window.populateWithPixels(ray, 3, 14 + i);
        }
        
        if (items.length < 12) 
            return;
        
        if (itemPage == 0)
        {
            ray = SpriteFormatting.PopulateWith("|      page  "+ itemPage +"    >> |");
            
        }
        else if (itemPage == pageCount -1)
        {
            ray = SpriteFormatting.PopulateWith("| <<   page  "+ itemPage +"       |");
        }
        else 
        {
            ray = SpriteFormatting.PopulateWith("| <<   page  "+ itemPage +"    >> |");
        }
        
        Window.populateWithPixels(ray, 1, 26);
    }
}
