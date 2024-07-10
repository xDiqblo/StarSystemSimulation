import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        MainField field = new MainField(1000, 768);
        Planet earth = new Planet(200, 400, 5.972e+24, 6.371); // Земля
        Planet mercury = new Planet(300, 300, 3.285e+23, 2.439); // Меркурий
        Planet venus = new Planet(500, 600, 4.867e+24, 6.051); // Венера
        Star sun = new Star(400, 400, 1.989e+30, 6.963 * 2); // Солнце

        field.createNewPlanet(earth);
        field.createNewPlanet(mercury);
        field.createNewPlanet(venus);
        field.createNewStar(sun);

        field.processingCycle();
    }
}