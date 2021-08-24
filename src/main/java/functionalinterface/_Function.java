package functionalinterface;

import java.util.function.BiFunction;
import java.util.function.Function;

public class _Function {
    public static void main(String[] args) {
        // function takes one argument and produces one result
        int increment = incrementByOne(0);
        System.out.println(increment);

        System.out.println("With function");
        Integer increment2 = incrementByOneFunction.apply(1);
        System.out.println(increment2);

        int multiply = multiplyByTenFunction.apply(increment2);
        System.out.println(multiply);

        System.out.println("Chaining functions");
        Function<Integer, Integer> addByOneAndThenMultiplyByTen = incrementByOneFunction
                .andThen(multiplyByTenFunction);
        System.out.println(addByOneAndThenMultiplyByTen.apply(4));

        // BiFunction takes 2 arguments and produces one result
        System.out.println("With BiFunctions");

        System.out.println(incrementByOneAndMultiply(4, 100));

        System.out.println(incrementByOneAndMultiplyByFunction.apply(4,100));
    }

    static Function<Integer, Integer> incrementByOneFunction = number -> number + 1;

    static Function<Integer, Integer> multiplyByTenFunction = number -> number * 10;

    static int incrementByOne(int number){
        return number + 1;
    }

   static BiFunction<Integer, Integer, Integer> incrementByOneAndMultiplyByFunction = (numberToIncrementByOne, numberToMultiplyBy) -> (numberToIncrementByOne + 1) * numberToMultiplyBy;

    static int incrementByOneAndMultiply(int number, int numToMultiplyBy){
        return (number + 1) * numToMultiplyBy;
    }
}
