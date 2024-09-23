import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class FunctionExample {
    public void functionExam(){

        List<Integer> integerList = new ArrayList<>();

        integerList.add(1);
        integerList.add(2);
        integerList.add(3);
        integerList.add(4);
        integerList.add(5);
        integerList.add(6);


        //Functional interface:
        //apply example:
        //Square each element and print them:
        //Approach1:
        System.out.println("Function Example");
        integerList.stream().map( e -> e*e).forEach(System.out::println);

        //Approach2:
        Function<Integer,Integer> squareFunction = (e) -> { return e*e; };
        Consumer<Integer> printConsumer = (e) -> System.out.println(e);
        integerList.stream().map(squareFunction).forEach(printConsumer);

        //compose example:
        Function<Integer,Integer> addFunction = (e) -> e+1;

        Function<Integer, Integer> results = squareFunction.compose(addFunction);

        integerList.stream().peek(results::apply).forEach(System.out::println);

        //andThen example:

        Function<Integer, Integer> resultsAndThen = addFunction.andThen(squareFunction);
        integerList.stream().peek(resultsAndThen::apply).forEach(System.out::println);

    }
}
