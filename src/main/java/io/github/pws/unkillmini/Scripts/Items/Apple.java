package io.github.pws.unkillmini.Scripts.Items;

import io.github.pws.unkillmini.Program.backbone.ScriptableNode;
import io.github.pws.unkillmini.Program.rendering.Window;
public class Apple implements ScriptableNode
{
    @Override
    public void start()
    {
    }

    @Override
    public void update() 
    {
        Window.appendToSuffix("used Apple.");
    }

    @Override
    public void end() 
    {
    }
}
