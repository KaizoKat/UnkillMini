package io.github.pws.unkillmini.Scripts.Items;

import io.github.pws.unkillmini.Program.backbone.ScriptableNode;
import io.github.pws.unkillmini.Program.rendering.Window;
public class Apple extends ScriptableNode
{
    @Override
    public void start() 
    {
    }

    @Override
    public void update() 
    {
        Window.appendToSuffix("Apple!");
    }

    @Override
    public void end() 
    {
    }
    
}
