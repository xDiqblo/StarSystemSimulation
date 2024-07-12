import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        MainField field = new MainField(1500, 700);

// Координаты центра экрана
        int centerX = field.getWidth() / 2;
        int centerY = field.getHeight() / 2;

// Создаем планеты с уменьшенными расстояниями от солнца (в пикселях)
        Planet mercury = new Planet(centerX + 30, centerY, 3.285e+23, 2.439); // Меркурий
        Planet venus = new Planet(centerX + 50, centerY, 4.867e+24, 6.051); // Венера
        Planet earth = new Planet(centerX + 75, centerY, 5.972e+24, 6.371); // Земля
        Planet mars = new Planet(centerX + 100, centerY, 6.39e+23, 3.389); // Марс
        Planet jupiter = new Planet(centerX + 200, centerY, 1.898e+27, 10.991); // Юпитер
        Planet saturn = new Planet(centerX + 300, centerY, 5.683e+26, 10.8232); // Сатурн
        Planet uranus = new Planet(centerX + 400, centerY, 8.681e+25, 7.5362); // Уран
        Planet neptune = new Planet(centerX + 500, centerY, 1.024e+26, 8.4622); // Нептун

// Создаем солнце в центре экрана
        Star sun = new Star(centerX, centerY, 1.989e+30, 18.889); // Солнце

// Добавляем планеты и солнце в поле
        field.createNewPlanet(mercury);
        field.createNewPlanet(venus);
        field.createNewPlanet(earth);
        field.createNewPlanet(mars);
        field.createNewPlanet(jupiter);
        field.createNewPlanet(saturn);
        field.createNewPlanet(uranus);
        field.createNewPlanet(neptune);
        field.createNewStar(sun);


        field.processingCycle();
    }
}