package io.github.pws.unkillmini.Scripts.World;

import io.github.pws.unkillmini.Program.backbone.Script;
import io.github.pws.unkillmini.Program.backbone.Vector2;
import io.github.pws.unkillmini.Program.rendering.Window;
import io.github.pws.unkillmini.Scripts.Entities.Player;

import java.util.ArrayList;
import java.util.List;

import javax.swing.text.Position;

import io.github.pws.unkillmini.Program.backbone.Room;

public class PlayableArea extends Script
{
    public List<Room> rooms = new ArrayList<>();
    public List<Player> myPlayers = new ArrayList<>();
    public Vector2 origin = new Vector2(60, 12);

    @Override
    public void start() 
    {

    }

    @Override
    public void update() 
    {
        if(myPlayers.toArray().length == 0)
        {
            Window.print("Player not provided for the playable area.");
            return;
        }

        for (Player player : myPlayers) 
        {
            int index = myPlayers.indexOf(player);

            if(index == 0)
            {
                player.spr.pos = origin;
            }
            else
            {
                //(unhandled) secon player exception implementation here.
            }

            player.spr.populate();
            myPlayers.set(myPlayers.indexOf(player), player);
        }
    }

    @Override
    public void end() 
    {

    }
}
