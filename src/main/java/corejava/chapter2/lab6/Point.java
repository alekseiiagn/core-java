package corejava.chapter2.lab6;

/**
 * Класс точки для двумерной координатной оси
 *
 * @author aleksejagnenkov
 * @version 1.1
 */
public class Point {
    private double x;
    private double y;

    /**
     * Конструктор без параметров.
     * Создает {@link Point} в координате (0;0)
     */
    public Point() {
        x = 0;
        y = 0;
    }

    /**
     * Конструктор по определенным координатам
     *
     * @param x координата по оси Х
     * @param y координата по оси Y
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Получить координату {@link Point} по оси Х
     *
     * @return координата по оси Х
     */
    public double getX() {
        return x;
    }

    /**
     * Получить координату {@link Point} по оси Y
     *
     * @return координата по оси Y
     */
    public double getY() {
        return y;
    }

    /**
     * Изменение масштаба по обеим координатам заданный коэффициент
     *
     * @param k коэффициент умножения
     * @return обновленная {@link Point}
     */
    public Point scale(double k) {
        x *= k;
        y *= k;
        return this;
    }

    /**
     * Перемещение {@link Point} на определенное расстояние в направлении координат x и y
     *
     * @param x перемещение по координате Х
     * @param y перемещение по координате Y
     * @return обновленная {@link Point}
     */
    public Point translate(double x, double y) {
        this.x += x;
        this.y += y;
        return this;
    }

    /**
     * Преобразование {@link Point} в строчку
     *
     * @return строковое представление класса
     */
    @Override
    public String toString() {
        return "(" + x + "; " + y + ')';
    }
}
