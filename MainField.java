import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

import static java.lang.Thread.*;

public class MainField extends JPanel {
    private JFrame mainFrame;
    private int width;
    private int height;
    private int someObjectsCount;
    private int timer;
    private SpaceObject[] someObjects;

    public MainField() {
        initMainFrame(500, 500);
        timer = 0;
    }

    public void updateTimer(int dt){
        this.timer += dt;
    }
    public MainField(int setHorizontalSize, int setVerticalSize) {
        initMainFrame(setHorizontalSize, setVerticalSize);
        timer = 0;
    }

    private void initMainFrame(int setWidth, int setHeight) {
        someObjectsCount = 0;
        someObjects = new SpaceObject[500];
        this.width = setWidth;
        this.height = setHeight;
        mainFrame = new JFrame("Simulation");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(setWidth, setHeight);
        mainFrame.setLocationRelativeTo(null);
        this.setPreferredSize(new Dimension(setWidth, setHeight));
        mainFrame.add(this);
        mainFrame.setVisible(true);
    }

    public void createNewSomeObject(SpaceObject someObject) {
        if (someObjectsCount < someObjects.length) { // Проверка на переполнение массива
            this.someObjects[someObjectsCount] = someObject;
            someObjectsCount++;
            repaint(); // Вызов перерисовки компонента
        }
    }

    public void updateField(){
        for (int i = 0; i < someObjectsCount; i++){
            repaint();
        }
    }
    @Override
    public void paintComponent(Graphics g) { // Переопределение метода padoubleComponent для рисования
        super.paintComponent(g); // Вызов родительской реализации для корректной отрисовки
        for (int i = 0; i < someObjectsCount; i++) {
            paintObject(g, someObjects[i]); // Рисование каждого объекта
        }
    }

    private void paintObject(Graphics gg, SpaceObject someObject) {
        Graphics2D g = (Graphics2D) gg;
        double leftX = someObject.getXCoord() - someObject.getRadius();
        double upperY = someObject.getYCoord() - someObject.getRadius();
        double diameter = someObject.getRadius() * 2;

        // Использование объекта Graphics для рисования
        Ellipse2D.Double ellipse = new Ellipse2D.Double(leftX, upperY, diameter, diameter);
        g.draw(ellipse);
        g.fill(ellipse);
    }

    public void processingCycle(int setDt){
        int dt = setDt;
        while (true){
            try {
                // Остановить программу на 500 миллисекунд
                Thread.sleep(dt * 500);
            } catch (InterruptedException e) {
                // Обработка возможного исключения, если поток прерван
                e.printStackTrace();
            }
            processingIteration(dt);
            updateField();
        }
    }
    private void processingIteration(int dt){
        this.updateTimer(dt);
        for (int i = 0; i < someObjectsCount; i++){
            for (int j = 0; j < someObjectsCount; j++) {
                if (i != j) {
                    someObjects[i].updateAcceleration(someObjects[j]);
                    someObjects[i].updateVelocity(dt);
                    someObjects[i].updatePosition(dt);
                }
            }
        }
    }

}
