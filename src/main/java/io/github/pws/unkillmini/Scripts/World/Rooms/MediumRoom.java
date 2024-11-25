package io.github.pws.unkillmini.Scripts.World.Rooms;

import io.github.pws.unkillmini.Program.backbone.Room;
import io.github.pws.unkillmini.Program.backbone.DataTypes.Vector2;
import io.github.pws.unkillmini.Program.rendering.Color;

public class MediumRoom
{
    public static Room room1 = new Room();
    public static Room room2 = new Room();

    public static void generate()
    {
        // Create the first room
        room1.setWidth(10);
        room1.setHeight(10);
        room1.generateRoomMap();
        room1.startingPosition = new Vector2(5, 5);
        room1.setBackground(Color.rgbBG(90, 156, 152));

        // Create the second room
        room2.setWidth(10);
        room2.setHeight(10);
        room2.generateRoomMap();
        room2.startingPosition = new Vector2(3,3);

        // Merge room2 into room1
        char[][] mergedMap = room1.merge(room2);

        // Assign the merged map to room1
        room1.roomMap = mergedMap;
    }
}
