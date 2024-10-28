/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.pws.unkillmini.Scripts;

import io.github.pws.unkillmini.Assets.Sprites.spr_inventory;
import io.github.pws.unkillmini.Program.backbone.Input;
import io.github.pws.unkillmini.Program.backbone.Item;
import io.github.pws.unkillmini.Program.backbone.SpriteFormatting;
import io.github.pws.unkillmini.Program.rendering.ConsoleColors;
import io.github.pws.unkillmini.Program.rendering.Window;
import io.github.pws.unkillmini.Program.backbone.ScriptableNode;
import io.github.pws.unkillmini.Scripts.Items.Apple;
import java.util.ArrayList;
import java.util.List;

public class Inventory extends ScriptableNode
{
    public static boolean open = false;
    int itemPage = 0;
    String[][] ray;
    
    public static List<Item> items = new ArrayList<>();
    
    @Override
    public void start() 
    {
        addInitialInventory();
    }

    @Override
    public void update() 
    {
        if(Input.Is(Commands.index[1])) 
        {
            open = !open;
        }
        if(items.toArray().length/12 != 0)
        {
            if(Input.Is(Commands.index[2]) || (open && Input.Is(Commands.index[4])))
            {
                itemPage++;
            }
            else if(Input.Is(Commands.index[3]) || (open && Input.Is(Commands.index[5])))
            {
                itemPage--;
            }
            else if(Input.Contains(Commands.index[1]) && Input.line.toCharArray().length > 3)
            {
                open = true;
                try { itemPage = Integer.parseInt(Input.line.substring(4));
                } catch (NumberFormatException e) {}
            }
        }
        
        if(itemPage > items.toArray().length/12) itemPage = items.toArray().length/12;
        else if(itemPage < 0) itemPage = 0;
        
        for (int i = 0; i < items.toArray().length; i++)
        {
            if(Input.Is(Commands.index[6] + " " + items.get(i).name))
            {
                if(items.get(i).count >= 1)
                {
                    Item it = items.get(i);
                    it.runner.update();
                    it.count--;
                    items.set(i, it);
                }
                break;
            }
            else if(Input.Is(Commands.index[7] + " " + items.get(i).name))
            {
                Window.appendToSuffix("-Description " + items.get(i).name + "---");
                Window.appendToSuffix(items.get(i).name + ": " + items.get(i).description);
                break;
            }
        }
        
        for (int i = 0; i < items.toArray().length; i++)
            if(items.get(i).count == 0)
                items.remove(i);
        
        spr_inventory.x = 1;
        spr_inventory.y = 28;
        spr_inventory.background = ConsoleColors.Background.GREEN;
        
        if(open)
        {
            
            spr_inventory.pixels = spr_inventory.buttonPressed;
            spr_inventory.foregorund = ConsoleColors.Foreground.WHITE;
            spr_inventory.populate();
            
            spr_inventory.y = 12;
            spr_inventory.pixels = spr_inventory.box;
            spr_inventory.populate();
            
            fillInventory();
        }
        else 
        {
            spr_inventory.pixels = spr_inventory.button;
            spr_inventory.foregorund = ConsoleColors.Foreground.BLACK;
            spr_inventory.populate();
        }
    }

    @Override
    public void end() 
    {
    }
    
    private void addInitialInventory()
    {
        items.add(new Item("Apple", "Just an apple", 3,new Apple()));
        items.add(new Item("Apple", "Just an apple", 4,new Apple()));
        items.add(new Item("Apple", "Just an apple", 1,new Apple()));
        items.add(new Item("Apple", "Just an apple", 12,new Apple()));
        items.add(new Item("Apple", "Just an apple", 5,new Apple()));
        items.add(new Item("Apple", "Just an apple", 31,new Apple()));
        items.add(new Item("Apple", "Just an apple", 12,new Apple()));
        items.add(new Item("Apple", "Just an apple", 5,new Apple()));
        items.add(new Item("Apple", "Just an apple", 8,new Apple()));
        items.add(new Item("Apple", "Just an apple", 10,new Apple()));
        items.add(new Item("Apple", "Just an apple", 7,new Apple()));
        items.add(new Item("Apple", "Just an apple", 1,new Apple()));
        items.add(new Item("Apple", "Just an apple", 3,new Apple()));
        items.add(new Item("Apple", "Just an apple", 4,new Apple()));
        items.add(new Item("Apple", "Just an apple", 5,new Apple()));
    }
    
    private void fillInventory()
    {
        int pageCount = items.toArray().length/12;
        int max = items.toArray().length - (itemPage * 12);
        
        if (itemPage < pageCount)
        {
            max = 12;
        }
        
        for (int i = 0; i < max; i++)
        {
            ray = SpriteFormatting.PopulateWith(items.get(i).count + " " + items.get(i).name);
            Window.populateWithPixels(ray, 3, 14 + i);
        }
        
        if (items.toArray().length < 12)
            return;
        
        if (itemPage == 0)
        {
            ray = SpriteFormatting.PopulateWith("|      page  "+ itemPage +"    >> |");
            
        }
        else if (itemPage == pageCount)
        {
            ray = SpriteFormatting.PopulateWith("| <<   page  "+ itemPage +"       |");
        }
        else 
        {
            ray = SpriteFormatting.PopulateWith("| <<   page  "+ itemPage +"    >> |");
        }
        
        Window.populateWithPixels(ray, 1, 26);
    }
    
    public static void AddItem(Item it)
    {
        List<Item> temp = items;
        for(Item i : temp)
        {
            if(i.equals(it) && i.runner == it.runner)
            {
                i.count += it.count;
            }
            else
            {
                items.add(it);
            }
        }
    }
}
