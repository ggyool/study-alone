package modernjavainaction.practice;

import java.util.Objects;

public class Wedge {
    MyPredicate<Integer> myPredicate = a -> (a==10);
}

interface MyPredicate<T>{
    boolean test(T t);
    default boolean isNull(T t){
        return Objects.isNull(t);
    }
    default void print(T t){
        System.out.println(t);
    }
}