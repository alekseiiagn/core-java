package corejava.chapter3.lab7;

import java.util.*;

public class Lab7 {

    //Вычислить O()
    // //O(n!*n^2)?
    static void luckySort(List<String> strings, Comparator<String> comp) {
        while (!isListSortASC(strings, comp)/*O(n)*/) {  //O(n!*n^2)
            Collections.shuffle(strings);//O(n)
        }
    }

    static boolean isListSortASC(List<String> strings, Comparator<String> comp) {
        for (int i = 1; i < strings.size(); i++) {
            if (comp.compare(strings.get(i - 1), strings.get(i)) >= 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        List<String> strings = new ArrayList<>() {{
            add("7");
            add("8");
            add("9");
            add("4");
            add("5");
            add("6");
        }};
        System.out.println(strings);
        luckySort(strings, String::compareTo);
        System.out.println(strings);
    }
}
