package corejava.chapter7.lab18;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Lab18 {

    public static void main(String[] args) {
        //не параметризированны определенным типов
        List emptyList = Collections.EMPTY_LIST;
        Map emptyMap = Collections.EMPTY_MAP;
        Set emptySet = Collections.EMPTY_SET;

        //они параметризированы и имеют тип данных, который мы передадим
        List<Integer> integers = Collections.emptyList();
        Map<String, Long> citiesPopulation = Collections.emptyMap();
        Set<String> words = Collections.emptySet();
    }
}
