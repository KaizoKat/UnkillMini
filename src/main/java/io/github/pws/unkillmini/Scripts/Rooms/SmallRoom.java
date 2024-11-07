package io.github.pws.unkillmini.Scripts.Rooms;

import io.github.pws.unkillmini.Program.backbone.Room;
import io.github.pws.unkillmini.Program.backbone.ScriptableNode;

public class SmallRoom implements ScriptableNode
{
    Room r = new Room();
    Room rS = new Room();

    @Override
    public void start() 
    {
        r.transform.x = 1;
        r.transform.y = 1;
        rS.transform.x = 2;
        rS.transform.y = 3;

        r.setWidth(25);
        r.setHeight(15);
        rS.setWidth(25);
        rS.setHeight(7);

        r.roomMap = r.generateRoomMap();
        rS.roomMap = rS.generateRoomMap();

        r.roomMap = r.merge(rS);
    }

    @Override
    public void update()
    {
        r.CreateRoom();
    }

    @Override
    public void end()
    {
    }
    
}
