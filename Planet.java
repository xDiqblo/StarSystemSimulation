import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Planet extends SpaceObject{
    private double rotationAngle;
    private double angularSpeed = 0.1;
    private double xVel;
    private double yVel;
    private double xAcc;
    private double yAcc;

    public Planet(){
        super();
        rotationAngle = Math.random() * 2 * Math.PI;
        xVel = 0;
        yVel = 0;
        xAcc = 0;
        yAcc = 0;

    }

    public Planet(double setXCoord, double setYCoord, double setMass, double setRadius){
        super(setXCoord, setYCoord, setMass, setRadius);
        rotationAngle = Math.random() * 2 * Math.PI;
        xVel = 0;
        yVel = 0;
        xAcc = 0;
        yAcc = 0;
    }
    public double getXVel() {
        return xVel;
    }
    public double getRotationAngle(){return rotationAngle;}
    public double getYVel() {
        return yVel;
    }

    public double getXAcc() {
        return xAcc;
    }

    public double getYAcc() {
        return yAcc;
    }

    public void setXVel(double newXVel){
        this.xVel = newXVel;
    }
    public void setYVel(double newYVel){
        this.yVel = newYVel;
    }
    public void setXAcc(double newXAcc){
        this.xAcc = newXAcc;
    }
    public void setYAcc(double newYAcc){
        this.yAcc = newYAcc;
    }

// Константа гравитационной постоянной (примерное значение)
final double G = 6.67430e-11;
final double softCoeff = 1e-100;

    // Метод для расчета гравитационного притяжения и обновления ускорения
    public void updateAcceleration(Star star) {
        double dx = star.getXCoord() - this.getXCoord();
        double dy = star.getYCoord() - this.getYCoord();
        double distance = Math.sqrt(dx * dx + dy * dy);


        if (distance == 0) return;

        // Расчет силы притяжения
        double force = G * this.getMass() * star.getMass() / (distance * distance);

        // Расчет ускорения
        double accelerationX = force * dx * softCoeff / (this.getMass() * distance);
        double accelerationY = force * dy * softCoeff / (this.getMass() * distance);

        // Обновление ускорения
        this.xAcc = accelerationX;
        this.yAcc = accelerationY;
    }

    // Метод для обновления скорости
    public void updateVelocity(double dt) {
        this.xVel += this.xAcc * dt;
        this.yVel += this.yAcc * dt;
    }

    // Метод для обновления позиции
    public void updatePosition(double dt, Star star) {
        rotationAngle += angularSpeed * dt;
        double orbitalRadius = Math.sqrt(Math.pow(Math.abs(this.getXCoord()) - Math.abs(star.getXCoord()), 2) +
                + (Math.pow(Math.abs(this.getYCoord()) - Math.abs(star.getYCoord()), 2)));

        double dx = Math.cos(rotationAngle) * (orbitalRadius); // предполагаем, что orbitalRadius - это радиус орбиты
        double dy = Math.sin(rotationAngle) * orbitalRadius;

        double finalX = star.getXCoord() + dx; // предполагаем, что star - это центральное тело, вокруг которого вращается объект
        double finalY = star.getYCoord() + dy;

        this.setXCoord(finalX);
        this.setYCoord(finalY);
    }

    public void draw(Graphics gg) {
        Graphics2D g = (Graphics2D) gg;
        double leftX = (getXCoord() - getRadius()) ;
        double upperY = (getYCoord() - getRadius());
        double diameter = (getRadius() * 2);

        // Использование объекта Graphics для рисования
        Ellipse2D.Double ellipse = new Ellipse2D.Double(leftX, upperY, diameter, diameter);
        g.fill(ellipse);
    }
}

