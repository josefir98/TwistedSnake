import java.util.Arrays;

public class Test {

    static int[] arr = {0, 1, 1, 2, 3, 3, 5, 6, 7, 7};
    static int[] arr2 = {3, 2, 1, 5, 4, 7, 7, 4, 3};

    //Arrays.stream(arr).distinct().toArray();

    public static void main(String[] args) {
        System.out.println(Arrays.toString(Arrays.stream(arr2).distinct().sorted().toArray()));
    }
}
