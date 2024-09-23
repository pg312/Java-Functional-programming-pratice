import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class SupplierExample {

    public void supplierExample(){

        //Supplier:
        // return first 10 positive integers:
        //Approach 1:
        Supplier<List<Integer>> integerList = () -> {
            List<Integer> results = new ArrayList();
            for(int i = 0; i < 10;i++)
                results.add(i);
            return results;
        };
        integerList.get();

        //Approach 2:
        Supplier<List<Integer>> integerList2 = new Supplier<List<Integer>>() {
            List<Integer> results = new ArrayList();

            @Override
            public List<Integer> get() {
                for(int i = 0; i < 10;i++)
                    results.add(i);
                return results;
            }
        };
        integerList2.get();

    }
}
