package corejava.chapter2.lab16_17;

public class Lab16 {
    public static void main(String[] args) {

        Queue<String> queue = new Queue<>();
        queue.add("1");
        queue.add(null);
        queue.add("3");
        queue.add("4");
        queue.add("5");
        queue.add("6");
        System.out.println(queue);

        Queue<String>.Iterator iter1 = queue.iterator();
        while (iter1.hasNext()) {
            System.out.println(iter1.next());
        }

        while (queue.size()>0){
            System.out.println(queue.remove());
        }
        System.out.println(queue);

        Queue<String>.Iterator iter2 = queue.iterator();
        while (iter2.hasNext()) {
            System.out.println(iter2.next());
            iter2.remove();
        }
        System.out.println(queue);
    }
}
