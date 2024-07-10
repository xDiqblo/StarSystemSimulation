import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MainField extends JPanel {
    private JFrame mainFrame;
    private JPanel slidersPanel;
    private JSlider timeSlider;
    private int width;
    private int height;
    private int delayTick;
    private int planetsCount;
    private int timer;
    private Planet[] planets;
    private Star[] stars;
    private int starsCount;
    private int objectsCount;

    public void updateTimer(int delayTick) {
        this.timer += delayTick;
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
        delayTick = 100;
        this.width = setWidth;
        this.height = setHeight;
        mainFrame = new JFrame("Simulation");
        mainFrame.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){
                double x = e.getX();
                double y = e.getY();
                Planet planet = new Planet(x, y, 6e+24, 6.0);
                createNewPlanet(planet);
            }
        });
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(setWidth, setHeight);
        mainFrame.setLocationRelativeTo(null);

        timeSlider = new JSlider(1, 1000, 41);
        timeSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                delayTick = timeSlider.getValue();
            }
        });

        mainFrame.setLayout(new BorderLayout()); // Установка менеджера компоновки
        this.setPreferredSize(new Dimension(setWidth, setHeight));
        mainFrame.add(this, BorderLayout.CENTER); // Добавление основного компонента окна в центр
        mainFrame.add(timeSlider, BorderLayout.NORTH);
        mainFrame.pack(); // Упаковка компонентов
        mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
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

    public void processingCycle() {
        while (true) {
            processingIteration(delayTick);
            repaint();
            try {
                // Остановить программу на 500 миллисекунд
                Thread.sleep(1000 / delayTick);
            } catch (InterruptedException e) {
                // Обработка возможного исключения, если поток прерван
                e.printStackTrace();
            }

        }
    }
    private void processingIteration(int delayTick) {
        this.updateTimer(delayTick);
        for (int i = 0; i < planetsCount; i++) {
            for (int j = 0; j < starsCount; j++) {
                planets[i].updateAcceleration(stars[j]);
                planets[i].updateVelocity(delayTick);
                borderCheck(planets[i]);
                planets[i].updatePosition(delayTick, stars[j]);

            }
        }

    }
    public void borderCheck(Planet planet){
        int leftX = 0;
        int upperY = 0;
        int rightX = width;
        int lowerY = height;

        if (planet.getXCoord() - planet.getRadius() <= leftX || planet.getXCoord() + planet.getRadius() >= rightX){
            planet.setXVel(-planet.getXVel());
        }
        if (planet.getYCoord() - planet.getRadius() <= upperY || planet.getYCoord() + planet.getRadius() >= lowerY){
            planet.setYVel(-planet.getYVel());
        }

    }
}

