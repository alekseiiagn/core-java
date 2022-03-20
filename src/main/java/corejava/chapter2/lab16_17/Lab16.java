package corejava.chapter2.lab16_17;

public class Lab16 {
    public static void main(String[] args) {

/*        Queue<Integer> arrayList = new LinkedList<>();
        for(int i=0; i<10; i++){
            arrayList.add(i);
        }

        Iterator<Integer> iter = arrayList.iterator();
        for(int i=0; i<5; i++){
            iter.next();
        }

        while (arrayList.size()>0) {
            iter.remove();
            System.out.println(arrayList);
        }*/

        Queue<String> queue = new Queue<>();
        queue.add("1");
        queue.add(null);
        queue.add("3");
        queue.add("4");
        System.out.println(queue);

        queue.remove();
        System.out.println(queue);
        queue.add("5");
        System.out.println(queue);
        queue.remove();
        System.out.println(queue);
        queue.add("6");
        System.out.println(queue);

        Queue<String>.Iterator it = queue.iterator();
        for (int i = 0; i < queue.size() / 2; i++) {
            it.next();
        }
        it.remove();
        while (it.hasNext()) {
            System.out.println(it.next());
        }


        Queue<String>.Iterator it2 = queue.iterator();
        while (it2.hasNext()) {
            System.out.println(it2.next());
        }

        System.out.println(queue);
    }
}
