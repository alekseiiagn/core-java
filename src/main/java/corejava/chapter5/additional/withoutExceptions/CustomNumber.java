package corejava.chapter5.additional.withoutExceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomNumber<T> {
    private T answer;
    private CustomError error;

    public CustomNumber(CustomError error) {
        answer = null;
        this.error = error;
    }

    public CustomNumber(T answer) {
        answer = null;
    }

    public CustomNumber(T answer, CustomError error) {
        this.answer = answer;
        this.error = error;
    }

    @Override
    public String toString() {
        return "Sum{" +
                "answer=" + answer +
                ", error=" + error +
                '}';
    }
}
