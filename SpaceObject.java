public class SpaceObject {
    private int mass;
    private int radius;
    private int gravity;
    private int xCoord;
    private int yCoord;
    private int xSpeed;
    private int ySpeed;
    private int xAcc;
    private int yAcc;
    public SpaceObject(){
        mass = 10;
        radius = 10;
        gravity = 1;
        xCoord = 250;
        yCoord = 250;
        xSpeed = 0;
        ySpeed = 0;
        xAcc = 0;
        yAcc = 0;
    }

    public SpaceObject(int setXCoord, int setYCoord, int setMass, int setRadius){
        mass = setMass;
        radius = setRadius;
        gravity = 1;
        xCoord = setXCoord;
        yCoord = setYCoord;
        xSpeed = 0;
        ySpeed = 0;
        xAcc = 0;
        yAcc = 0;
    }

    public int getRadius() {
        return radius;
    }

    public int getGravity() {
        return gravity;
    }

    public int getXCoord() {
        return xCoord;
    }

    public int getYCoord() {
        return yCoord;
    }

    public int getXSpeed() {
        return xSpeed;
    }

    public int getYSpeed() {
        return ySpeed;
    }

    public int getXAcc() {
        return xAcc;
    }

    public int getYAcc() {
        return yAcc;
    }
}
