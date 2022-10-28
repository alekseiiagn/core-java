package corejava.chapter5.additional.withoutExceptions;

import java.util.ArrayList;
import java.util.List;

public class CustomList<T> {

    private List<T> data;

    private CustomError error;

    public static <T> CustomList<T> of(List<T> data) {
        return new CustomList<>(data, null);
    }

    public static <T> CustomList<T> of(CustomError error) {
        return new CustomList<>(error);
    }

    private CustomList(CustomError error) {
        this.data = new ArrayList<>();
        this.error = error;
    }


    private CustomList(List<T> data, CustomError error) {
        this.data = data;
        this.error = error;
    }

    public List<T> getData() {
        return data;
    }

    public CustomError getError() {
        return error;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public void setError(CustomError error) {
        this.error = error;
    }
}
