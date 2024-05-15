package ClassWork.May7thReviewExercise;

import java.util.Random;

public class ShapeGenerator {
    static Shape getShape() {
        Random rand = new Random();
        if (rand.nextInt() % 2 == 0) {
            return new Circle(rand.nextDouble(1,10));
        }
        else {
            return new Rectangle(rand.nextDouble(1,10), rand.nextDouble(1,10));
        }
    }
}
