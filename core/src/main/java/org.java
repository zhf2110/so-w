import java.util.Arrays;
import java.util.List;

public class org {

    public static void main(String[] args) {
        List<String> parma = Arrays.asList("1","2","3");
        //方法引用
        parma.forEach(System.out::println);
    }

}
