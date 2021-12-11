package textbook.ch13.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ArrayListStreamTest {
    public static void main(String[] args) {
        List<String> sList = new ArrayList<String>();
        sList.add("Tomas");
        sList.add("Edward");
        sList.add("Jack");

        // Stream<E> stream() 메서드는 스트림 클래스를 반환한다.
        Stream<String> stream = sList.stream();
        stream.forEach(s-> System.out.print(s + " "));
        System.out.println();

        sList.stream().sorted().forEach(s-> System.out.print(s + " "));
    }
}
