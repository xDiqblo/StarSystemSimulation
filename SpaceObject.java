public class SpaceObject {
    protected double gravitionalConstant = 6.67;
     double mass;
    private double radius;
    protected double xCoord;
    protected double yCoord;

    public SpaceObject(){
        mass = 10;
        radius = 10;
        xCoord = 250;
        yCoord = 250;
    }

    public SpaceObject(double setXCoord, double setYCoord, double setMass, double setRadius){
        mass = setMass;
        radius = setRadius;
        xCoord = setXCoord;
        yCoord = setYCoord;
    }

    public double getRadius() {
        return radius;
    }
    public double getMass(){
        return mass;
    }
    public double getXCoord() {
        return xCoord;
    }

    public double getYCoord() {
        return yCoord;
    }



    public void setXCoord(double newXCoord){
        this.xCoord = newXCoord;
    }
    public void setYCoord(double newYCoord){
        this.yCoord = newYCoord;
    }



}
