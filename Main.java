import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        MainField field = new MainField(1920, 1080);
        SpaceObject object1 = new SpaceObject();
        field.createNewSomeObjectOnField(object1);

    }
}