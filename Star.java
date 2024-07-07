import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Star extends SpaceObject{
    private double criticalSize; //Критический параметр, при достижении которого звезда превратится в чёрную дыру
    private double density; //Плотность звезды;влияет только на её превращение в чёрную дыру

    public Star(double setXCoord, double setYCoord){
        super(setXCoord, setYCoord, 1591.12, 25);
        density = getMass() / Math.pow(getRadius(), 3);
    }

    public Star(double setXCoord, double setYCoord, double mass, double radius) {
        super(setXCoord, setYCoord, mass, radius);
        density = getMass() / Math.pow(getRadius(), 3);
    }



    public void draw(Graphics gg) {
        Graphics2D g = (Graphics2D) gg;

        double leftX = (getXCoord() - getRadius());
        double upperY = (getYCoord() - getRadius());
        double diameter = (getRadius() * 2);

        // Использование объекта Graphics для рисования
        Ellipse2D.Double ellipse = new Ellipse2D.Double(leftX, upperY, diameter, diameter);
        g.draw(ellipse);
        g.fill(ellipse);
    }
}
