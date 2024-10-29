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
    public static boolean open = true;
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
        if(Input.Contains(Commands.inventory)) 
        {
            open = !open;
        }
        
        if(items.toArray().length/12 != 0)
        {
            if(open && Input.Contains(Commands.inv_Next))
            {
                itemPage++;
            }
            else if(open && Input.Contains(Commands.inv_Prev))
            {
                itemPage--;
            }
            else if(Input.Contains(Commands.inventory) && Input.line.split(" ").length == 2)
            {
                open = true;
                try { itemPage = Integer.parseInt(Input.line.split(" ")[1]);
                } catch (NumberFormatException e) {}
            }
        }
        
        if(itemPage > (items.toArray().length/12) -1) itemPage = (items.toArray().length/12) -1;
        else if(itemPage < 0) itemPage = 0;
        
        for (int i = 0; i < items.toArray().length; i++)
        {
            if(Input.Contains(Commands.use + " " + items.get(i).name))
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
            else if(Input.Contains(Commands.description + " " + items.get(i).name))
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
        items.add(new Item("Bean", "Just an apple", 4,new Apple()));
        items.add(new Item("Crab", "Just an apple", 1,new Apple()));
        items.add(new Item("Dust", "Just an apple", 12,new Apple()));
        items.add(new Item("Elephant", "Just an apple", 5,new Apple()));
        items.add(new Item("Fork", "Just an apple", 31,new Apple()));
        items.add(new Item("Ghost", "Just an apple", 7,new Apple()));
        items.add(new Item("Horse", "Just an apple", 19,new Apple()));
        items.add(new Item("Isaac", "Just an apple", 12,new Apple()));
        items.add(new Item("Jumper", "Just an apple", 5,new Apple()));
        items.add(new Item("Kale", "Just an apple", 8,new Apple()));
        items.add(new Item("Light", "Just an apple", 10,new Apple()));
        items.add(new Item("Mutton", "Just an apple", 7,new Apple()));
        items.add(new Item("Note", "Just an apple", 1,new Apple()));
        items.add(new Item("Orange", "Just an apple", 29,new Apple()));
        items.add(new Item("Piano", "Just an apple", 15,new Apple()));
        items.add(new Item("Qween", "Just an apple", 3,new Apple()));
        items.add(new Item("Rabbit", "Just an apple", 4,new Apple()));
        items.add(new Item("Saber", "Just an apple", 1,new Apple()));
        items.add(new Item("Telephone", "Just an apple", 12,new Apple()));
        items.add(new Item("Ubercharge", "Just an apple", 5,new Apple()));
        items.add(new Item("Vat of acid", "Just an apple", 31,new Apple()));
        items.add(new Item("Word", "Just an apple", 12,new Apple()));
        items.add(new Item("X coordinate", "Just an apple", 5,new Apple()));
    }
    
    private void fillInventory()
    {
        int pageCount = (items.toArray().length/12) -1;
        int max = items.toArray().length - (itemPage * 12);
        
        if (itemPage < pageCount)
        {
            max = 12;
        }
        
        for (int i = 0; i < max; i++)
        {
            ray = SpriteFormatting.PopulateWith(items.get((itemPage * 12) + i).count + " " + items.get((itemPage * 12) + i).name);
            Window.populateWithPixels(ray, 3, 14 + i);
        }
        
        if (pageCount == 0) 
            return;
        
        if (itemPage == 0)
        {
            ray = SpriteFormatting.PopulateWith("|      page  "+ (itemPage + 1) +"    >> |");
        }
        else if (itemPage == pageCount)
        {
            ray = SpriteFormatting.PopulateWith("| <<   page  "+ (itemPage + 1) +"       |");
        }
        else 
        {
            ray = SpriteFormatting.PopulateWith("| <<   page  "+ (itemPage + 1) +"    >> |");
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
