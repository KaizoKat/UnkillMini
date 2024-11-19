package io.github.pws.unkillmini.Program.backbone;

public class Vector3 
{
    public int x;
    public int y;
    public int z;

    public Vector3(int x, int y, int z)
    {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vector3()
    {
        this.x = 0;
        this.y = 0;
        this.z = 0;
    }

    /**
     * @return retruns a new {@link Vector3}
     */
    public static Vector3 Zero()
    {
        return new Vector3();
    }

    /**
     * @return retruns a new {@link Vector3} equivalent to Vector3(1, 1, 1)
     */
    public static Vector3 One()
    {
        return new Vector3(1,1,1);
    }

    /**
     * @return retruns a new {@link Vector3} equivalent to Vector3(1, 0, 0)
     */
    public static Vector3 Right()
    {
        return new Vector3(1,0,0);
    }

    /**
     * @return retruns a new {@link Vector3} equivalent to Vector3(-1, 0, 0)
     */
    public static Vector3 Left()
    {
        return new Vector3(-1,0,0);
    }

    /**
     * @return retruns a new {@link Vector3} equivalent to Vector3(0, 1, 0)
     */
    public static Vector3 Down()
    {
        return new Vector3(0,1,0);
    }

    /**
     * @return retruns a new {@link Vector3} equivalent to Vector3(0, -1, 0)
     */
    public static Vector3 Up()
    {
        return new Vector3(0,-1,0);
    }

    /**
     * @return retruns a new {@link Vector3} equivalent to Vector3(0, 0, 1)
     */
    public static Vector3 Forward()
    {
        return new Vector3(0,0,1);
    }

    /**
     * @return retruns a new {@link Vector3} equivalent to Vector3(0, 0, -1)
     */
    public static Vector3 Backward()
    {
        return new Vector3(0,0,-1);
    }

    /**
     * @return the sum of this Vector3 with the other Vector3.
     */
    public Vector3 Add(Vector3 other)
    {
        return new Vector3(this.x + other.x, this.y + other.y, this.z + other.z);
    }

    /**
     * @return the rest of this Vector3 with the other Vector3.
     */
    public Vector3 Rest(Vector3 other)
    {
        return new Vector3(this.x - other.x, this.y - other.y, this.z - other.z);
    }

    /**
     * @return the division of this Vector3 with the other Vector3.
     */
    public Vector3 Div(Vector3 other)
    {
        return new Vector3(this.x / other.x, this.y / other.y, this.z / other.z);
    }

    /**
     * @return the multiplication of this Vector3 with the other Vector3.
     */
    public Vector3 Mul(Vector3 other)
    {
        return new Vector3(this.x * other.x, this.y * other.y, this.z * other.z);
    }

    /**
     * @return the module of this Vector3 with the other Vector3.
     */
    public Vector3 Mod(Vector3 other)
    {
        return new Vector3(this.x % other.x, this.y % other.y, this.z % other.z);
    }
}
