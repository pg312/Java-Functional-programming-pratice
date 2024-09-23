import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerExample {

    public void consumer(){

        List<Integer> integerList = new ArrayList<>();

        integerList.add(1);
        integerList.add(2);
        integerList.add(3);
        integerList.add(4);
        integerList.add(5);
        integerList.add(6);

        //Consumer example:
        //Printing the square of each element: This is an example of accept method.
        //Approach 1:
        System.out.println("Consumer Example");
        integerList.forEach(e -> System.out.println(e*e));
        //Approach 2:
        Consumer<Integer> squareConsumer = (e) -> System.out.println(e*e);
        integerList.forEach(squareConsumer);
        //Approach 3:
        Consumer<Integer> consumer = new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(integer*integer);
            }
        };


        //Check for even and then print square of each element:
        //Approach 1:
        Consumer<Integer> evenOddConsumer = (e) ->  System.out.println(e % 2 == 0 ? "Even" : "Odd");
        Consumer<Integer> squareConsumerAndThen = e -> System.out.println(e*e);
        Consumer<Integer> resultant = evenOddConsumer.andThen(squareConsumerAndThen);
        integerList.forEach(e -> resultant.accept(e));

        //Approach 3:
        Consumer<Integer> evenOddConsumer2 = new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(integer % 2 == 0 ? "Even" : "Odd");
            }
        };

        Consumer<Integer> squareConsumer2 = new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(integer*integer);
            }
        };

        Consumer<Integer> resultant2 = evenOddConsumer.andThen(squareConsumerAndThen);
        integerList.forEach(e -> resultant2.accept(e));
    }
}
