package io.github.pws.unkillmini.Scripts.UI;

import io.github.pws.unkillmini.Program.backbone.Input;
import io.github.pws.unkillmini.Program.rendering.UI;
import io.github.pws.unkillmini.Program.backbone.ScriptableNode;

public class Help implements ScriptableNode
{ 
    
    @Override
    public void start()
    {
        
    }

    @Override
    public void update()
    {
        String focus = UI.prevFocused[0];
        if(Input.getPressedKey() == Input.TAB)
        {
            UI.addNewFocus(UI.prevFocused[1]);

            switch (focus)
            {
                case "inv" ->
                {
                    Inventory.open = true;
                }
                case "equ" ->
                {
                    Equipment.open = true;
                }
                default -> {}
            }
        }

        if(Inventory.open && !Equipment.open && focus != "inv")
            UI.addNewFocus("inv");
        else if(!Inventory.open && Equipment.open && focus != "equ")
            UI.addNewFocus("equ");

        /*
        if(Input.check(Commands.help))
        {
            Window.print("-HELP-------------");
            String[] broken = Input.line.split(" ");
            
            if(broken.length == 1)
            {
                Window.print("Displays all the commands. jsut write 'help' followed by the command that you want to check.");
                Window.print("Write help commands to display all the commands that you can write. (at the moment this doesnt work.)");
                return;
            }
            
            if(Commands.inventory.contains(broken[1])) // inventory
            {
                if(broken.length == 2)
                    Window.print("Opens the invenrory");
                else
                {
                    if(broken[3].equals(">>"))
                        Window.print("Goes to the next page in the inventory if it exists.");
                    else if(broken[3].equals("<<"))
                        Window.print("Goes to the previous page in the inventory if it exists.");
                }
            }
            else if(Commands.inv_Next.contains(broken[1])) // >>
            {
                Window.print("Goes to the next page in the inventory if it exists and if the inventory is open");
            }
            else if(Commands.inv_Prev.contains(broken[1])) // <<
            {
                Window.print("Goes to the previous pabge in the inventory if it exists and if the inventory is open.");
            }
            else if(Commands.use.contains(broken[1])) // use
            {
                Window.print( "Uses the item specified. Just write 'use' + the name of the item.");
            }
            else if(Commands.check.contains(broken[1])) // description
            {
                Window.print("Displays the description of the specified item. Just write 'desc' + the name of the item.");
            }
            else if(Commands.commands.contains(broken[1])) // commands
            {
                Window.print("not implemented");
            }
            else
            {
                Window.print("Displays all the commands. jsut write 'help' followed by the command that you want to check.");
                Window.print("Write help commands to display all the commands that you can write. (at the moment this doesnt work.)");
            }
        }
        else if(Input.check(Commands.tab))
        {
            if(Inventory.open == true && Equipment.open == true)
            {
                Inventory.open = false;
                Equipment.open = false;
            } 
            else if(Inventory.open == false && Equipment.open == false)
            {
                Inventory.open = true;
                Equipment.open = true;
            }
            else if(!Inventory.open) 
                Inventory.open = true;
            else if(!Equipment.open)
                Equipment.open = true;
        }
        else if(Input.check(Commands.end))
        {
            Aplication.run = false;
        */
    }

    @Override
    public void end()
    {
        
    }
}
