package io.github.pws.unkillmini.Scripts;

import io.github.pws.unkillmini.Program.Aplication;
import io.github.pws.unkillmini.Program.backbone.Input;
import io.github.pws.unkillmini.Program.rendering.Window;
import io.github.pws.unkillmini.Program.backbone.ScriptableNode;

public class Help extends ScriptableNode
{ 
    
    @Override
    public void start()
    {
        
    }

    @Override
    public void update()
    {
        if(Input.Contains(Commands.help))
        {
            Window.appendToSuffix("-HELP-------------");
            String[] broken = Input.line.split(" ");
            
            if(broken.length == 1)
            {
                Window.appendToSuffix("Displays all the commands. jsut write 'help' followed by the command that you want to check.");
                Window.appendToSuffix("Write help commands to display all the commands that you can write. (at the moment this doesnt work.)");
                return;
            }
            
            if(Commands.inventory.contains(broken[1])) // inventory
            {
                if(broken.length == 2)
                    Window.appendToSuffix("Opens the invenrory");
                else
                {
                    if(broken[3].equals(">>"))
                        Window.appendToSuffix("Goes to the next page in the inventory if it exists.");
                    else if(broken[3].equals("<<"))
                        Window.appendToSuffix("Goes to the previous page in the inventory if it exists.");
                }
            }
            else if(Commands.inv_Next.contains(broken[1])) // >>
            {
                Window.appendToSuffix("Goes to the next page in the inventory if it exists and if the inventory is open");
            }
            else if(Commands.inv_Prev.contains(broken[1])) // <<
            {
                Window.appendToSuffix("Goes to the previous pabge in the inventory if it exists and if the inventory is open.");
            }
            else if(Commands.use.contains(broken[1])) // use
            {
                Window.appendToSuffix( "Uses the item specified. Just write 'use' + the name of the item.");
            }
            else if(Commands.check.contains(broken[1])) // description
            {
                Window.appendToSuffix("Displays the description of the specified item. Just write 'desc' + the name of the item.");
            }
            else if(Commands.commands.contains(broken[1])) // commands
            {
                Window.appendToSuffix("not implemented");
            }
            else
            {
                Window.appendToSuffix("Displays all the commands. jsut write 'help' followed by the command that you want to check.");
                Window.appendToSuffix("Write help commands to display all the commands that you can write. (at the moment this doesnt work.)");
            }
        }
        else if(Input.Contains(Commands.tab))
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
        else if(Input.Contains(Commands.end))
        {
            Aplication.run = false;
        }
    }

    @Override
    public void end()
    {
        
    }
}
