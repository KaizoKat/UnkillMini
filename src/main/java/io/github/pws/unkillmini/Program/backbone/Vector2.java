package io.github.pws.unkillmini.Program.backbone;

public class Vector2 
{
    public int x;
    public int y;

    public Vector2(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public Vector2()
    {
        this.x = 0;
        this.y = 0;
    }

    /**
     * @return a new empty {@link Vector2}.
     */
    public static Vector2 Zero()
    {
        return new Vector2();
    }

    /**
     * @return a new {@link Vector2} equivalent to Vector2(1, 1).
     */
    public static Vector2 One()
    {
        return new Vector2(1,1);
    }

    /**
     * @return a new {@link Vector2} equivalent to Vector2(1, 0).
     */
    public static Vector2 Right()
    {
        return new Vector2(1,0);
    }

    /**
     * @return a new {@link Vector2} equivalent to Vector2(-1, 0).
     */
    public static Vector2 Left()
    {
        return new Vector2(-1,0);
    }

    /**
     * @return a new {@link Vector2} equivalent to Vector2(0, 1).
     */
    public static Vector2 Down()
    {
        return new Vector2(0,1);
    }

    /**
     * @return a new {@link Vector2} equivalent to Vector2(0, -1).
     */
    public static Vector2 Up()
    {
        return new Vector2(0,-1);
    }

    /**
     * @return the sum of this Vector2 with the other Vector2.
     */
    public Vector2 Add(Vector2 other)
    {
        return new Vector2(this.x + other.x, this.y + other.y);
    }

    /**
     * @return the rest of this Vector2 with the other Vector2.
     */
    public Vector2 Rest(Vector2 other)
    {
        return new Vector2(this.x - other.x, this.y - other.y);
    }

    /**
     * @return the division of this Vector2 with the other Vector2.
     */
    public Vector2 Div(Vector2 other)
    {
        return new Vector2(this.x / other.x, this.y / other.y);
    }

    /**
     * @return the multiplication of this Vector2 with the other Vector2.
     */
    public Vector2 Mul(Vector2 other)
    {
        return new Vector2(this.x * other.x, this.y * other.y);
    }

    /**
     * @return the module of this Vector2 with the other Vector2.
     */
    public Vector2 Mod(Vector2 other)
    {
        return new Vector2(this.x % other.x, this.y % other.y);
    }
}
