import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        int dt = 1;
        MainField field = new MainField(    1920, 1080);
        SpaceObject object1 = new SpaceObject(250, 250, 10, 20);
        SpaceObject object2 = new SpaceObject(500, 250, 10, 20);
        SpaceObject object3 = new SpaceObject(350, 400, 10, 20);
        field.createNewSomeObject(object1);
        field.createNewSomeObject(object2);
        field.createNewSomeObject(object3);
        field.processingCycle(dt);
    }
}