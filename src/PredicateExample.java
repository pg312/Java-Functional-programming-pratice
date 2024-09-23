import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PredicateExample {

    public void predicateExample(){
        List<Integer> integerList = new ArrayList<>();

        integerList.add(1);
        integerList.add(2);
        integerList.add(3);
        integerList.add(4);
        integerList.add(5);
        integerList.add(6);

        //Predicate  example interface:
        //test
        System.out.println("Predicate Example");
        Predicate<Integer> evenPredicate = (e) -> e%2 == 0;
        integerList.stream().filter(e -> evenPredicate.test(e)).forEach(System.out::println);

        //negate
        integerList.stream().filter(evenPredicate.negate()).forEach(System.out::println);

        //and
        Predicate<Integer> fourDivisible = e -> e%4 == 0;
        Predicate<Integer> results = evenPredicate.and(fourDivisible);

        integerList.stream().filter(results).forEach(System.out::println);

        //or
        results = evenPredicate.or(fourDivisible);
        integerList.stream().filter(results).forEach(System.out::println);

    }
}
