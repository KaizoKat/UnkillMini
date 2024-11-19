package io.github.pws.unkillmini.Program.backbone;

import io.github.pws.unkillmini.Program.rendering.Color;
import io.github.pws.unkillmini.Program.rendering.Window;

import java.util.Arrays;

public class Room
{
    public Sprite spr = new Sprite();
    public char[][] roomMap;
    private int width = 3;
    private int height = 3;
    private String background = Color.rgbBG(0, 0, 0);
    private String foreground = Color.rgbBG(255, 255, 255);

    /**
     * Set the width of the room
     * @param width min 3, max 128(unimplemented)
     */
    public final void setWidth(int width)
    {
        this.width = Math.max(width,3);
    }

    /**
     * Set height of the room
     * @param height min 3 max 32(unimplemented)
     */
    public final void setHeight(int height)
    {
        this.height = Math.max(height,3);
    }

    /**
     * Set the background color of the room
     * @param color string from the Color class.
     */
    public final void setBackground(String color)
    {
        this.background = color;
    }

    /**
     * Set the foreground color of the room
     * @param color string from the Color class.
     */
    public final void setForeground(String color)
    {
        this.foreground = color;
    }

    /**
     * Creates the room and prints it to the screen (supports negative positions)
     */
    public final void createRoom()
    {
        StringBuilder sb = new StringBuilder();

        for (int yy = 0; yy < roomMap.length; yy++)
        {
            if(this.spr.pos.y + yy > Window.height - 1) continue;

            for (int xx = 0; xx < roomMap[yy].length; xx++)
            {
                if(this.spr.pos.x + xx > Window.width - 1) continue;
                if(roomMap[yy][xx] == '#') sb.append("#");
                else if(roomMap[yy][xx] == '.' || roomMap[yy][xx] == ':') sb.append(" ");
                else sb.append(roomMap[yy][xx]);
            }
            sb.append("\n");
        }
        spr.pixels = sb.toString();
        spr.background = this.background;
        spr.foreground = this.foreground;
        spr.populate();
    }

    /**
     * Merges two rooms but doesn't support negative valyes for the second room yet.
     * @param other the room that you waht this room to merge with.
     * @return a new char 2d array of the newly merged room.
     */
    public final char[][] merge(Room other)
    {
        char[][] mergedRoom = new char[32][128];

        for (char[] chars : mergedRoom)
        {
            Arrays.fill(chars, ' ');
        }

        for (int yy = 0; yy < this.height; yy++)
            for (int xx = 0; xx < this.width; xx++)
                mergedRoom[yy][xx] = this.roomMap[yy][xx];

        for (int yy = 0; yy < other.height; yy++)
            for (int xx = 0; xx < other.width; xx++)
                mergedRoom[Math.max(yy + other.spr.pos.y, yy)][Math.max(xx + other.spr.pos.x, xx)] = other.roomMap[yy][xx];
        
        for (int yy = 1; yy < 31; yy++)
        {
            for (int xx = 1; xx < 127; xx++)
            {
                int nrDots = 0;
                if(mergedRoom[yy-1][xx] == '.') nrDots++;
                if(mergedRoom[yy+1][xx] == '.') nrDots++;
                if(mergedRoom[yy][xx-1] == '.') nrDots++;
                if(mergedRoom[yy][xx+1] == '.') nrDots++;

                if(nrDots >= 2 && mergedRoom[yy][xx] == '#')
                {
                    mergedRoom[yy][xx] = ':';
                }
            }
        }

        return mergedRoom;
    }

    /**
     * Generates the base room map
     */
    public final void generateRoomMap()
    {
        roomMap = new char[this.height][this.width];

        for (int yy = 0; yy < this.height; yy++)
        {
            for (int xx = 0; xx < this.width; xx++)
            {
                if(yy > 0 && yy < this.height-1 && xx > 0 && xx < this.width -1)
                {
                    roomMap[yy][xx] = '.';
                }
                else
                {
                    roomMap[yy][xx] = '#';
                }
            }
        }
    }
}
