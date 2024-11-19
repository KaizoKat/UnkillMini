package io.github.pws.unkillmini.Scripts.Entities;

import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import io.github.pws.unkillmini.Application;
import io.github.pws.unkillmini.Program.Manager;
import io.github.pws.unkillmini.Program.backbone.Input;
import io.github.pws.unkillmini.Program.backbone.Script;
import io.github.pws.unkillmini.Program.backbone.Sprite;
import io.github.pws.unkillmini.Program.backbone.Vector2;
import io.github.pws.unkillmini.Program.rendering.Color;
import io.github.pws.unkillmini.Program.rendering.Window;
import io.github.pws.unkillmini.Scripts.World.PlayableArea;

public class Player extends Script
{
    public Sprite spr = new Sprite();
    public String pixel = "ø";
    private PlayableArea area = new PlayableArea();
    private Vector2 direction = new Vector2();
    public Player()
    {
        Manager.addScript(this);
    }
    
    @Override
    public void start() 
    {
        spr.pixels = pixel;
        spr.pos.x = 0;
        spr.pos.y = 0;
        spr.foreground = Color.rgbFG(255, 10, 10);
        spr.background = Color.rgbBG(120, 10, 10);

        area.start();
        area.myPlayers.add(this);
    }

    boolean prevPrs = false;
    boolean sprt = false;
    @Override
    public void update() 
    {
        area.update();

        sprt = Application.input.isHeld("Sprint");

        if(Application.input.isPressed("Move Forward")) prevPrs = true;
        else if(Application.input.isReleased("Move Forward")) prevPrs = false;

        if(sprt) Window.print("Sprinting!");
        if(prevPrs)
            Window.print("Forward Pressed");
        else
            Window.print("Forward Released");
    }

    @Override
    public void end() 
    {
        area.end();
    }

    private void handleInput()
    {
        
    }
}
