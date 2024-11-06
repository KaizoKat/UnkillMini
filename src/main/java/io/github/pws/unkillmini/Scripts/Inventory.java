package io.github.pws.unkillmini.Scripts;

import io.github.pws.unkillmini.Assets.Sprites.spr_inventory;
import io.github.pws.unkillmini.Program.backbone.Input;
import io.github.pws.unkillmini.Program.backbone.Item;
import io.github.pws.unkillmini.Program.backbone.MiniUtils;
import io.github.pws.unkillmini.Program.rendering.Color;
import io.github.pws.unkillmini.Program.rendering.Window;
import io.github.pws.unkillmini.Program.backbone.Sprite;
import io.github.pws.unkillmini.Program.backbone.UI;
import io.github.pws.unkillmini.Assets.Items;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

<<<<<<< Updated upstream
import com.googlecode.lanterna.input.KeyType;

public class Inventory implements ScriptableNode
=======
public class Inventory extends UI
>>>>>>> Stashed changes
{
    private static int itemPage = 0;
    private static int itemCursor = 0; 
    String[][] ray;
    
    public static List<Item> items = new ArrayList<>();
    private static int cursor = 0;
    @Override
    public void start() 
    {
        items = Items.list;
    }

    @Override
    public void update() 
    {
        int pageCount = items.toArray().length/12;
<<<<<<< Updated upstream
=======
        int max = items.toArray().length - (itemPage * 12);
        List<Item> temp = items;
        if (itemPage < pageCount) max = 12;
        /*
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
>>>>>>> Stashed changes

        if(Input.isKeyPressed(KeyType.Enter))
        {
            open = !open;
        }

        if(Input.isKeyPressed(KeyType.ArrowDown))
        {
            cursor++;
            cursor = Helpers.clampBetween(cursor, 0, 11);
        }
        else if(Input.isKeyPressed(KeyType.ArrowUp))
        {
            cursor--;
            cursor = Helpers.clampBetween(cursor, 0, 11);
        }
        else if(Input.isKeyPressed(KeyType.ArrowRight))
        {
            itemPage++;
            itemPage = Helpers.clampBetween(cursor, 0, pageCount - 1);
        }
        else if(Input.isKeyPressed(KeyType.ArrowLeft))
        {
            itemPage--;
            itemPage = Helpers.clampBetween(cursor, 0, pageCount - 1);
        }
        else if(Input.isKeyPressed(KeyType.Enter))
        {
            Item it = items.get(cursor);
            if(items.get(cursor).stats.equipmentSlots.equals(""))
            {
                it.runner.update();
                it.stats.count--;
                items.set(cursor, it);
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
                
                items.set(cursor, it);
            }
        }
        else
        {

        }

        /*
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
        
<<<<<<< Updated upstream
        if(pageCount > 0)
=======
        if(Input.isPressed("e"))
>>>>>>> Stashed changes
        {
            open = !open;
            focused = !focused;
            Equipment.focused = false;
            
        }
<<<<<<< Updated upstream
        */
        
        List<Item> temp = items;
=======

        if(open)
        {
            if(Input.isPressed(72))
            {
                itemCursor--;
            }
            else if(Input.isPressed(80))
            {
                itemCursor++;
            }
            else if(Input.isPressed("left"))
            {
                itemPage--;
            }
            else if(Input.isPressed("right"))
            {
                itemPage++;
            }
            else if(Input.isPressed("enter"))
            {
                int itemIndex = (itemPage * 12) + itemCursor;
                Item it = items.get(itemIndex);
                System.out.println(itemIndex);
                if(it.stats.equipmentSlots.equals(""))
                {
                    it.runner.update();
                    it.stats.count--;
                    items.set(itemIndex, it);
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
                    
                    items.set(itemIndex, it);
                }
            }
            else
            {

            }
        }

        itemPage = MiniUtils.ClampInt(itemPage, 0, pageCount);
        itemCursor = MiniUtils.ClampInt(itemCursor, 0, max);
>>>>>>> Stashed changes
        
        for (int i = 0; i < temp.toArray().length; i++)
            if(temp.get(i).stats.count == 0)
                temp.remove(i);
        
        items = temp;

        spr_inventory.x = 1;
        spr_inventory.y = 28;
<<<<<<< Updated upstream
        spr_inventory.background = Color.rgb(126, 167, 168);
        
=======
        spr_inventory.background = Color.rgbBG(126, 167, 168);

>>>>>>> Stashed changes
        if(open)
        {
            spr_inventory.pixels = spr_inventory.buttonPressed;
            spr_inventory.foregorund = Color.rgb(255, 255, 255);
            spr_inventory.populate();
            
            spr_inventory.y = 12;
            spr_inventory.pixels = spr_inventory.invBoder;
            spr_inventory.populate();
            
            fillInventory(pageCount, max);
        }
        else 
        {
            spr_inventory.pixels = spr_inventory.button;
            spr_inventory.foregorund = Color.rgb(0, 0, 0);
            spr_inventory.populate();
        }
    }

    @Override
    public void end() 
    {
    }
    
    private void fillInventory(int pageCount, int max)
    {
        for (int i = 0; i < max; i++)
        {
            ray = Sprite.PopulateWith(items.get((itemPage * 12) + i).stats.count + " " + items.get((itemPage * 12) + i).name);
            String select = "                    ";
            if(i == itemCursor)
                Window.setPopulatorBackground(Sprite.PopulateWith(select), 2, 14 + i, Color.rgbBG(139, 195, 196));

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
