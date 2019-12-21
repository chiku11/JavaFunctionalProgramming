import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class JavaFunctionalProgramming {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9);
        

        //Print numbers
        System.out.println("Print Numbers:");
        numbers.forEach(System.out::println);

        //Sum of N numbers
        System.out.println("\nSum of N numbers:");
        int total = numbers.stream().reduce(0, (a,b) -> a+b);
        System.out.println(total);

        
        //Filter numbers by predicate
        System.out.println("\nFilter numbers by predicate");
        Predicate<Integer> even = a -> a%2 == 0;
        Predicate<Integer> odd = a -> a%2 != 0;
        System.out.println(" Even:");
        List<Integer> evens = numbers.stream().filter(even::test).collect(Collectors.toList());
        evens.forEach(System.out::println);
        System.out.println("\n Odd:");
        List<Integer> odds = numbers.stream().filter(odd::test).collect(Collectors.toList());
        odds.forEach(System.out::println);

        //Enhance Filter numbers by predicate by extracting to a Bi Fn.
        BiFunction<List<Integer>, Predicate<Integer>, Void> biFunc = JavaFunctionalProgramming::print;
        biFunc.apply(numbers, even);

        //Enhance Filter numbers by predicate by extracting to a Tri Fn.
        TriFunc<List<Integer>, Predicate<Integer>, String> triFunc = JavaFunctionalProgramming::printwithpredicateName;
        triFunc.apply(numbers, even, "even");
        triFunc.apply(numbers, odd, "odd");

    }

    public static Void print(List<Integer> numbers, Predicate<Integer> predicate) {
        List<Integer> filteredList = numbers.stream().filter(predicate::test).collect(Collectors.toList());
        System.out.println("\n");
        filteredList.forEach(System.out::println);
        return null;
    }

    public static void printwithpredicateName(List<Integer> numbers, Predicate<Integer> predicate, String predicateName) {
        List<Integer> filteredList = numbers.stream().filter(predicate::test).collect(Collectors.toList());
        System.out.println("\nFilter " + predicateName);
        filteredList.forEach(System.out::println);
    }

    @FunctionalInterface
    public interface TriFunc<T1,T2,T3>{
        public void apply(T1 t1,T2 t2,T3 t3);
    }
        
}