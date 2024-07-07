import javax.swing.*;
import java.awt.*;

import static java.lang.Thread.*;

public class MainField extends JPanel {
    private JFrame mainFrame;
    private int width;
    private int height;
    private int planetsCount;
    private int timer;
    private Planet[] planets;
    private Star[] stars;
    private int starsCount;
    private int objectsCount;


    public MainField() {
        initMainFrame(500, 500);
        timer = 0;
    }

    public void updateTimer(int dt) {
        this.timer += dt;
    }

    public MainField(int setWidth, int setHeight) {
        initMainFrame(setWidth, setHeight);
        timer = 0;
    }

    private void initMainFrame(int setWidth, int setHeight) {
        planetsCount = 0;
        planets = new Planet[500];
        starsCount = 0;
        stars = new Star[5];
        objectsCount = 0;
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

    public void createNewPlanet(Planet planet) {
        if (planetsCount < planets.length) { // Проверка на переполнение массива
            this.planets[planetsCount] = planet;
            planetsCount++;
            objectsCount++;

        }
    }


    public void createNewStar(Star star){
        if (starsCount < stars.length){
            this.stars[starsCount] = star;
            starsCount++;
            objectsCount++;

        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < planetsCount; i++) {
            planets[i].draw(g);
        }
        for (int i = 0; i < starsCount; i++) {
            stars[i].draw(g);
        }
    }



    public void processingCycle(int setDt) {
        int dt = setDt;
        while (true) {

            processingIteration(dt);
            repaint();
            try {
                // Остановить программу на 500 миллисекунд
                Thread.sleep(1000 / dt);
            } catch (InterruptedException e) {
                // Обработка возможного исключения, если поток прерван
                e.printStackTrace();
            }
        }
    }

    private void processingIteration(int dt) {
        this.updateTimer(dt);
        for (int i = 0; i < planetsCount; i++) {
            for (int j = 0; j < starsCount; j++) {
                planets[i].updateAcceleration(stars[j]);
                planets[i].updateVelocity(dt);
                planets[i].updatePosition(dt, stars[j]);
            }
        }
    }
}

