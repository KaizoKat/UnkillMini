package io.github.pws.unkillmini.Scripts.UI;

import io.github.pws.unkillmini.Assets.Sprites.spr_inventory;
import io.github.pws.unkillmini.Program.Manager;
import io.github.pws.unkillmini.Program.backbone.Input;
import io.github.pws.unkillmini.Program.backbone.Item;
import io.github.pws.unkillmini.Program.backbone.MiniUtils;
import io.github.pws.unkillmini.Program.rendering.Color;
import io.github.pws.unkillmini.Program.rendering.UI;
import io.github.pws.unkillmini.Program.rendering.Window;
import io.github.pws.unkillmini.Program.backbone.Sprite;
import io.github.pws.unkillmini.Assets.Items;

import java.util.ArrayList;
import java.util.List;

public class Inventory extends UI
{
    private static int itemPage = 0;
    private static int itemCursor = 0;
    private static String[][] ray;
    private static spr_inventory spr = new spr_inventory();
    
    public static List<Item> items = new ArrayList<>();
    
    public Inventory()
    {
        Manager.addScript(this);
    }

    @Override
    public void start() 
    {
        items = Items.list;
    }


    int tempEnterCount;
    @Override
    public void update() 
    {
        int pageCount = (items.toArray().length/12) + 1;
        int max = items.toArray().length - (itemPage * 12);
        if (itemPage < pageCount -1) max = 12;
        if(max == 1 && itemPage > 0) itemPage--;
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
        */

        if(Input.getPressedKey("e"))
        {
            open = !open;
            if(open) addNewFocus("inv");
        }

        if(open && prevFocused[0] == "inv")
        {
            switch (Input.getPressedKey()) 
            {
                case Input.UP ->
                {
                    itemCursor--;
                }
                case Input.DOWN ->
                {
                    itemCursor++;
                }
                case Input.LEFT ->
                {
                    itemPage--;
                }
                case Input.RIGHT ->
                {
                    itemPage++;
                }
                case Input.ENTER ->
                {
                    if(items.toArray().length == 0)
                        break;

                    int itemIndex = (itemPage * 12) + itemCursor;
                    Item it = items.get(itemIndex);
                    if(it.stats.equipmentSlots.equals(""))
                    {
                        it.runner.update();
                        it.stats.count--;
                        items.set(itemIndex, it);
                    }
                    else
                    {
                        boolean replace = false;
                        Item toReplace = null;

                        Window.print(it.name + " equipped!");

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
                    }
                    
                    items.set(itemIndex, it);
                }

                default ->
                {
                    
                }
            }
        }

        List<Item> temp = items;
        
        for (int i = 0; i < temp.toArray().length; i++)
            if(temp.get(i).stats.count == 0)
                temp.remove(i);
        
        items = temp;

        itemPage = MiniUtils.ClampInt(itemPage, 0, pageCount);
        itemCursor = MiniUtils.ClampInt(itemCursor, 0, max);
        
        spr.x = 1;
        spr.y = 28;
        spr.background = Color.rgbBG(126, 167, 168);
        
        if(open)
        {
            spr.pixels = spr_inventory.buttonPressed;
            spr.foreground = Color.rgbFG(255, 255, 255);
            spr.populate();
            
            spr.y = 12;
            spr.pixels = spr_inventory.invBoder;
            spr.populate();
            
            fillInventory();
        }
        else 
        {
            spr.pixels = spr_inventory.button;
            spr.foreground = Color.rgbFG(0, 0, 0);
            spr.populate();
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
        if (itemPage < pageCount)max = 12;
        
        for (int i = 0; i < max; i++)
        {
            Item item = items.get((itemPage * 12) + i);
            ray = Sprite.PopulateWith(item.stats.count + " " + item.name);

            String select = "                    ";
            if(i == itemCursor)
                Window.setPopulateBackground(Sprite.PopulateWith(select), 2, 14 + i, Color.rgbBG(139, 195, 196));

            Window.populateWithPixels(ray, 3, 14 + i);
        }
        
        if (pageCount == 0) 
            return;
        
        if (itemPage == 0)
        {
            ray = Sprite.PopulateWith("|      page  "+ (itemPage + 1) +"    >> |");
        }
        else if (itemPage == pageCount)
        {
            ray = Sprite.PopulateWith("| <<   page  "+ (itemPage + 1) +"       |");
        }
        else 
        {
            ray = Sprite.PopulateWith("| <<   page  "+ (itemPage + 1) +"    >> |");
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
