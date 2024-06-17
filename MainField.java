import javax.swing.*;
import java.awt.*;
public class MainField extends JPanel {
    private JFrame mainFrame;
    private int width;
    private int height;
    private int someObjectsCount;
    private SpaceObject[] someObjects;

    public MainField() {
        initMainFrame(500, 500);
    }

    public MainField(int setHorizontalSize, int setVerticalSize) {
        initMainFrame(setHorizontalSize, setVerticalSize);
    }

    private void initMainFrame(int setWidth, int setHeight) {
        someObjectsCount = 0;
        someObjects = new SpaceObject[500];
        this.width = setWidth;
        this.height = setHeight;
        mainFrame = new JFrame("Simulation");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(500, 500);
        mainFrame.setLocationRelativeTo(null);
        this.setPreferredSize(new Dimension(setWidth, setHeight));
        mainFrame.add(this);
        mainFrame.setVisible(true);
    }

    public void createNewSomeObjectOnField(SpaceObject someObject) {
        if (someObjectsCount < someObjects.length) { // Проверка на переполнение массива
            this.someObjects[someObjectsCount] = someObject;
            someObjectsCount++;
            repaint(); // Вызов перерисовки компонента
        }
    }

    @Override
    public void paintComponent(Graphics g) { // Переопределение метода paintComponent для рисования
        super.paintComponent(g); // Вызов родительской реализации для корректной отрисовки
        for (int i = 0; i < someObjectsCount; i++) {
            paintObject(g, someObjects[i]); // Рисование каждого объекта
        }
    }

    private void paintObject(Graphics g, SpaceObject someObject) {
        int leftX = someObject.getXCoord() - someObject.getRadius();
        int upperY = someObject.getYCoord() - someObject.getRadius();
        int diameter = someObject.getRadius() * 2;

        g.drawOval(leftX, upperY, diameter, diameter); // Использование объекта Graphics для рисования
    }
}
