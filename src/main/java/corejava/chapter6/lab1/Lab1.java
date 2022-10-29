package corejava.chapter6.lab1;

public class Lab1 {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        stack.push(1);
        stack.push(1);
        stack.push(1);
        System.out.println(stack.isEmpty());

        stack.pop();
        stack.pop();
        stack.pop();
        System.out.println(stack.isEmpty());
    }
}
