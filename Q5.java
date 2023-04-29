import java.util.Arrays;
import javafx.geometry.Point2D;

public class Main {
    public static void main(String[] args) {
        final int N = 5;

        // Create an array of N diamond objects
        Diamond[] diamonds = new Diamond[N];
        for (int i = 0; i < N; i++) {
            diamonds[i] = new Diamond(new Point2D(i * 10, i * 10), 5 + i, 10 - i);
        }

        // Iterate through the array and move each object
        for (Moveable m : diamonds) {
            m.move(3, -2);
        }

        // Sort the array based on the diamonds' area
        Arrays.sort(diamonds);

        // Iterate over the array and draw each object
        for (Shape s : diamonds) {
            s.draw();
        }
    }
}
