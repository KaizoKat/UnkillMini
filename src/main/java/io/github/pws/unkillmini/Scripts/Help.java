package io.github.pws.unkillmini.Scripts;

import io.github.pws.unkillmini.backbone.Input;
import io.github.pws.unkillmini.rendering.Window;
import io.github.pws.unkillmini.run.Aplication;

public class Help extends Aplication
{ 
    
    @Override
    public void start()
    {
        
    }

    @Override
    public void update()
    {
        if(Input.Contains(Commands.index[0]))
        {
            Window.appendToSuffix("-HELP-------------");
            String[] broken = Input.line.split(" ");
            
            if(broken.length == 1)
            {
                Window.appendToSuffix("Displays all the commands. jsut write 'help' followed by the command that you want to check.");
                Window.appendToSuffix("Write help commands to display all the commands that you can write. (at the moment this doesnt work.)");
                return;
            }
            
            switch (broken[1])
            {
                case "inv" ->
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
                case ">>" ->                
                {
                    Window.appendToSuffix("Goes to the next page in the inventory if it exists and if the inventory is open");
                }
                case "<<" ->                
                {
                    Window.appendToSuffix("Goes to the previous pabge in the inventory if it exists and if the inventory is open.");
                }
                case "use" ->                
                {
                    Window.appendToSuffix( "Uses the item specified. Just write 'use' + the name of the item.");
                }
                case "desc" ->
                {
                    Window.appendToSuffix("Displays the description of the specified item. Just write 'desc' + the name of the item.");
                }
                case "commands" ->
                {
                    for (String command : Commands.index)
                    {
                        Window.appendToSuffix(command);
                    }
                }
                default ->
                {
                    Window.appendToSuffix("Displays all the commands. jsut write 'help' followed by the command that you want to check.");
                    Window.appendToSuffix("Write help commands to display all the commands that you can write. (at the moment this doesnt work.)");
                }
            }
        }
    }

    @Override
    public void end()
    {
        
    }
}
