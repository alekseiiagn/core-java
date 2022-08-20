package corejava.chapter5.lab11;

import java.util.Objects;

public class Lab11 {

    /**
     * <b>assert obj != null</b>
     * <p>
     * 1. Генерируется Error AssertionError<p>
     * 2. Проверка достоверности внутренних утверждений, а не соблюдение контракта<p>
     * 3. Можно отключить с помощью команды -da (в конечном коде не будет их)<p>
     * <p>
     * <b>Object.requireNonNull(obj)</b>
     * <p>
     * 1. Генерируется Exception NullPointerException<p>
     * 2. Можно прописать сообщение<p>
     * 3. Можно посмотреть StackTrace<p>
     * 4. Служит для механизма соблюдения контракта<p>
     * <p>
     * Я бы использовал assert, если бы obj был внутренней переменной, и я бы хотел проверить,
     * не накосячил ли я где-то так, что она стала бы null. А во время прода бы просто не использовал эту проверку.
     * <p>
     * Но если obj - переменная, которая на прямую взаимодействует с пользователем и может быть им изменена,
     * то я бы сделал проверку Object.requiredNonNull()
     */
    public static void main(String[] args) {

        Object obj = new Object();

        assert obj != null;

        Objects.requireNonNull(obj);

    }

}
