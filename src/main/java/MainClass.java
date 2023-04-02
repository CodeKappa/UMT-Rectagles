import java.util.Scanner;
import java.util.Set;

public class MainClass
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        in.close();

        Set<Point> points = Rectangles.parseData(input);
        //Rectangles.printPoints(points);
        System.out.println(Rectangles.countRectangles(points));
    }
}
