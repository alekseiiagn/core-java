package corejava.chapter4.lab1_2_3;

import java.util.Objects;

public class LabeledPoint extends Point {
    String label;

    LabeledPoint(String label, double x, double y) {
        super(x, y);
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        LabeledPoint that = (LabeledPoint) o;
        return Objects.equals(label, that.label);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), label);
    }

    @Override
    public String toString() {
        return "LabeledPoint{" +
                "label='" + label + "', " +
                "x='" + x + "', " +
                "y='" + y + "'" +
                '}';
    }
}
