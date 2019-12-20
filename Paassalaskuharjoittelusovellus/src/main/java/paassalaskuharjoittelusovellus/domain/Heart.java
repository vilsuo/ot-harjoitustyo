
package paassalaskuharjoittelusovellus.domain;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;

public class Heart {
    private Shape heart;

    public Heart(double x, double y) {
        double offset = 5;
        Shape c1 = new Circle(x - offset, y, offset);
        Shape c2 = new Circle(x + offset, y, offset);
        
        Shape p = new Polygon(new double[]{
            x - 1.8 * offset, y + 0.6 * offset,
            x, y,
            x + 1.8 * offset, y + 0.6 * offset,
            x, y + 3 * offset
        });
        
        heart = Shape.union(c1, c2);
        heart = Shape.union(heart, p);
        heart.setFill(Color.RED);
    }

    public Shape getHeart() {
        return heart;
    }
    
}
