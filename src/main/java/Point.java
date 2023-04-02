public class Point implements Comparable<Point>
{
    private int x;
    private int y;

    public Point(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }

    public void setX(int x)
    {
        this.x = x;
    }

    public void setY(int y)
    {
        this.y = y;
    }

    @Override
    public int compareTo(Point other)
    {
        if (this.x == other.x)
        {
            return this.y - other.y;
        }
        else
        {
            return this.x - other.x;
        }
    }

    @Override
    public String toString()
    {
        return "(" + x + ", " + y + ")";
    }
}
