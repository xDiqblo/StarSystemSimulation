public class SpaceObject {
    private double gravitionalConstant = 6.67;
    private double mass;
    private double radius;
    private double xCoord;
    private double yCoord;
    private double xVel;
    private double yVel;
    private double xAcc;
    private double yAcc;
    public SpaceObject(){
        mass = 10;
        radius = 10;
        xCoord = 250;
        yCoord = 250;
        xVel = 0;
        yVel = 0;
        xAcc = 0;
        yAcc = 0;
    }

    public SpaceObject(double setXCoord, double setYCoord, double setMass, double setRadius){
        mass = setMass;
        radius = setRadius;
        xCoord = setXCoord;
        yCoord = setYCoord;
        xVel = 0;
        yVel = 0;
        xAcc = 0;
        yAcc = 0;
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

    public double getXVel() {
        return xVel;
    }

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

    public void setXCoord(double newXCoord){
        this.xCoord = newXCoord;
    }
    public void setYCoord(double newYCoord){
        this.yCoord = newYCoord;
    }

    public void updatePosition(int dt){
        double dx = this.getXVel() * dt;
        double dy = this.getYVel() * dt;
        this.setXCoord(this.getXCoord() + dx);
        this.setYCoord(this.getYCoord() + dx);
    }
    
    public void updateVelocity(int dt){
        double dxVel = this.getXAcc() * dt;
        double dyVel = this.getYAcc() * dt;
        this.setXVel(this.getXVel() + dxVel);
        this.setYVel(this.getYVel() + dyVel);
    }

    public void updateAcceleration(SpaceObject influencingObject){
        double F;
        double distance;
        double dx = influencingObject.getXCoord() - this.getXCoord();
        double dy = influencingObject.getYCoord() - this.getYCoord();
        distance = Math.sqrt(Math.pow(Math.abs(this.getXCoord()) - Math.abs(influencingObject.getXCoord()), 2) +
        + (Math.pow(Math.abs(this.getYCoord()) - Math.abs(influencingObject.getYCoord()), 2)));
        F = gravitionalConstant * this.getMass() * influencingObject.getMass() / Math.pow(distance, 2);
        this.setXAcc(this.getXAcc() + (dx * F));
        this.setYAcc(this.getYAcc() + (dy * F));

    }


}
