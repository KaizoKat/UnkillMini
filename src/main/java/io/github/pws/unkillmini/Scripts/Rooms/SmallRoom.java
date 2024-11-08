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
        r.transform.x = -17;
        r.transform.y = -3;
        rS.transform.x = 10;
        rS.transform.y = 10;

        r.setWidth(20);
        r.setHeight(15);
        rS.setWidth(20);
        rS.setHeight(15);

        r.generateRoomMap();
        rS.generateRoomMap();

        r.roomMap = r.merge(rS);
    }

    @Override
    public void update()
    {
        r.createRoom();
    }

    @Override
    public void end()
    {
    }
    
}
