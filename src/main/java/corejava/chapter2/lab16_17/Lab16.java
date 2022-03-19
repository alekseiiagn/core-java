package corejava.chapter2.lab16_17;

public class Lab16 {
    public static void main(String[] args) {

        Queue<String> queue = new Queue<>();
        queue.add("1");
        queue.add("2");
        queue.add("3");
        queue.add("4");

        System.out.println(queue.takeFirst());
        System.out.println(queue);
        queue.add("5");
        System.out.println(queue);
        System.out.println(queue.takeFirst());
        System.out.println(queue);
        queue.add("6");
        System.out.println(queue);

        Queue.Iterator<String> it = queue.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
    }
}
