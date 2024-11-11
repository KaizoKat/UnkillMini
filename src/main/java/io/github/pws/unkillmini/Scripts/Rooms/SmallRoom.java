package io.github.pws.unkillmini.Scripts.Rooms;

import io.github.pws.unkillmini.Program.Manager;
import io.github.pws.unkillmini.Program.backbone.Room;
import io.github.pws.unkillmini.Program.backbone.Script;

public class SmallRoom extends Script
{
    Room r = new Room();
    Room rS = new Room();

    public SmallRoom()
    {
        Manager.addScript(this);
    }

    @Override
    public void start() 
    {
        r.transform.x = 20;
        r.transform.y = 5;
        rS.transform.x = 5;
        rS.transform.y = 5;

        r.setWidth(20);
        r.setHeight(10);
        rS.setWidth(20);
        rS.setHeight(10);

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
