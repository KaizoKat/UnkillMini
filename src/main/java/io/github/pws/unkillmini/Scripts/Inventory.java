package io.github.pws.unkillmini.Scripts;

import io.github.pws.unkillmini.Assets.Sprites.spr_inventory;
import io.github.pws.unkillmini.Program.backbone.Input;
import io.github.pws.unkillmini.Program.backbone.Item;
import io.github.pws.unkillmini.Program.rendering.Color;
import io.github.pws.unkillmini.Program.rendering.Window;
import io.github.pws.unkillmini.Program.backbone.ScriptableNode;
import io.github.pws.unkillmini.Program.backbone.Sprite;
import io.github.pws.unkillmini.Assets.Items;
import java.util.ArrayList;
import java.util.List;

public class Inventory implements ScriptableNode
{
    public static boolean open = false;
    int itemPage = 0;
    String[][] ray;
    
    public static List<Item> items = new ArrayList<>();
    
    @Override
    public void start() 
    {
        items = Items.list;
    }

    @Override
    public void update() 
    {
        if(Input.check(Commands.inventory)) 
        {
            if(Input.line.split(" ").length == 1)
                open = !open;
            
            for (int i = 0; i < items.toArray().length; i++)
            {
                Item it = items.get(i);
                if(Input.check(Commands.use) && Input.check(it.name) && it.stats.count > 0)
                {
                    if(items.get(i).stats.equipmentSlots.equals(""))
                    {
                        it.runner.update();
                        it.stats.count--;
                        items.set(i, it);
                    }
                    else
                    {
                        Window.print(it.name + " equipped!");

                        boolean replace = false;
                        Item toReplace = null;
                        for(String slot : it.stats.equipmentSlots.split(" "))
                        {
                            if(Equipment.equippedItems[Integer.parseInt(slot)] == null)
                            {
                                Equipment.equippedItems[Integer.parseInt(slot)] = it;
                                it.stats.count = 0;
                            }
                            else 
                            {
                                toReplace = Equipment.equippedItems[Integer.parseInt(slot)];
                                replace = true;
                                break;
                            }
                        }
                        
                        if(replace)
                        {
                            for(String slot : toReplace.stats.equipmentSlots.split(" "))
                                Equipment.equippedItems[Integer.parseInt(slot)] = null;
                            
                            for(String slot : it.stats.equipmentSlots.split(" "))
                                Equipment.equippedItems[Integer.parseInt(slot)] = it;
                            
                            it.stats.count = 0;
                            AddItem(toReplace);
                        }
                        
                        items.set(i, it);
                    }
                    break;
                }
                else if(Input.check(Commands.check) && Input.check(it.name))
                {
                    Window.print("-Description " + items.get(i).name + "---");
                    Window.print(items.get(i).name + ": " + items.get(i).description);
                    break;
                }
            }
        }
        
        int pageCount = items.toArray().length/12;
        
        if(pageCount > 0)
        {
            if(open && Input.check(Commands.inv_Next))
            {
                itemPage++;
            }
            else if(open && Input.check(Commands.inv_Prev))
            {
                itemPage--;
            }
            else if(Input.check(Commands.inventory) && Input.line.split(" ").length == 2)
            {
                open = true;
                try { itemPage = Integer.parseInt(Input.line.split(" ")[1]);
                } catch (NumberFormatException e) {}
            }
        }
        
        if(pageCount > 0)
        {
            if(itemPage > pageCount -1) itemPage = pageCount -1;
            else if(itemPage < 0) itemPage = 0;
        }
        
        List<Item> temp = items;
        
        for (int i = 0; i < temp.toArray().length; i++)
            if(temp.get(i).stats.count == 0)
                temp.remove(i);
        
        items = temp;
        
        spr_inventory.x = 1;
        spr_inventory.y = 28;
        spr_inventory.background = Color.rgbBG(126, 167, 168);
        
        if(open)
        {
            spr_inventory.pixels = spr_inventory.buttonPressed;
            spr_inventory.foregorund = Color.rgbFG(255, 255, 255);
            spr_inventory.populate();
            
            spr_inventory.y = 12;
            spr_inventory.pixels = spr_inventory.invBoder;
            spr_inventory.populate();
            
            fillInventory();
        }
        else 
        {
            spr_inventory.pixels = spr_inventory.button;
            spr_inventory.foregorund = Color.rgbFG(0, 0, 0);
            spr_inventory.populate();
        }
    }

    @Override
    public void end() 
    {
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
            ray = Sprite.PopulateWith(items.get((itemPage * 12) + i).stats.count + " " + items.get((itemPage * 12) + i).name);
            Window.populateWithPixels(ray, 3, 14 + i);
        }
        
        if (pageCount < 1)
            return;
        
        if (itemPage == 0)
        {
            ray = Sprite.PopulateWith("|      page  "+ (itemPage + 1) +"    >> |");
        }
        else if(itemPage < pageCount -1)
        {
            ray = Sprite.PopulateWith("| <<   page  "+ (itemPage + 1) +"    >> |");
        }
        else 
        {
            ray = Sprite.PopulateWith("| <<   page  "+ (itemPage + 1) +"       |");
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
                it.stats.count += i.stats.count;
            }
        }
        
        items = temp;
    }
}
