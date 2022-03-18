package corejava.chapter2.lab5;

/**
 * Класс точки для двумерной координатной оси
 *
 * @author aleksejagnenkov
 * @version 1.0
 */

public final class Point {
    private final double x;
    private final double y;

    /**
     * Конструктор без параметров.
     * Создает точку в координате (0;0)
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
     * Получить координату точки по оси Х
     *
     * @return координата по оси Х
     */
    public double getX() {
        return x;
    }

    /**
     * Получить координату точки по оси Y
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
     * @return результирующая точка
     */
    public Point scale(double k) {
        return new Point(x * k, y * k);
    }

    /**
     * Перемещение точки на определенное расстояние в направлении координат x и y
     *
     * @param x перемещение по координате Х
     * @param y перемещение по координате Y
     * @return результирующая точка
     */
    public Point translate(double x, double y) {
        return new Point(this.x + x, this.y + y);
    }

    /**
     * Преобразование класса в строчку
     *
     * @return строковое представление класса
     */
    @Override
    public String toString() {
        return "(" + x + "; " + y + ')';
    }
}
