import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Rectangles
{
    /**
     * Parses the input data and returns a set of points.
     * @return A set of points
     */
    public static Set<Point> parseData(String data)
    {
        Set<Point> points = new TreeSet<Point>(); // TreeSet is used to sort the points for easier processing and to avoid duplicates
        Pattern pattern = Pattern.compile("\\((?<x>[-+]?\\d+), ?(?<y>[-+]?\\d)\\)"); // (X,Y) pattern where X and Y are integers

        Matcher matcher = pattern.matcher(data);

        while (matcher.find())
        {
            int x = Integer.parseInt(matcher.group("x"));
            int y = Integer.parseInt(matcher.group("y"));
            points.add(new Point(x, y));
        }

        return points;
    }

    /**
     * Calculates the number of rectangles that can be formed from the given set of points.
     * @param points A set of points
     * @return The number of rectangles that can be formed from the points.
     */
    public static int countRectangles(Set<Point> points)
    {
        // The algorithm is based on the following idea:
        // 1. We save the points in a map where the key is the x coordinate and the value is a list of y coordinates.
        // 2. For each 2 entries in the map we find the number of equal y coordinates (EQUALS).
        // 3. The number of rectangles that can be formed from the 2 entries is equal to
        // EQUALS * (EQUALS - 1) / 2 - the number of pairs that can be formed from EQUALS elements.

        int rectangles = 0;
        int n, equals;

        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        for(Point p : points)
        {
            map.putIfAbsent(p.getX(), new ArrayList<Integer>());
            map.get(p.getX()).add(p.getY());
        }

        List<List<Integer>> list = new ArrayList<List<Integer>>(map.values());

        n = list.size();
        for (int i = 0; i < n - 1; i++)
        {
            for (int j = i + 1; j < n; j++)
            {
                equals = equalElements(list.get(i), list.get(j));
                rectangles += equals * (equals - 1) / 2;
            }
        }

        return rectangles;
    }

    /**
     * Counts the number of equal elements in two sorted lists.
     * @param list1 The first list.
     * @param list2 The second list.
     * @return The number of equal elements.
     */
    public static int equalElements(List<Integer> list1, List<Integer> list2)
    {
        int i = 0, j = 0;
        int equals = 0;

        while (i < list1.size() && j < list2.size())
        {
            if (list1.get(i).equals(list2.get(j)))
            {
                equals++;
                i++;
                j++;
            }
            else if (list1.get(i) < list2.get(j))
            {
                i++;
            }
            else
            {
                j++;
            }
        }

        return equals;
    }

    /**
     * Prints all points in the set.
     * @param points The set of points.
     */
    public static void printPoints(Set<Point> points)
    {
        System.out.println(points);
    }
}
