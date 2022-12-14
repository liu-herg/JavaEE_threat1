import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: asus
 * Date: 2022-11-22
 * Time: 10:58
 */
class test2{
     final int a = 10;
     public test2(int a,int b){
         System.out.println("123");

     }
    public static int func(int a){
        System.out.println("hello");
        return 1;
    }
}
class person extends test2 {
    public person(){
        super(1,2);
        System.out.println("132");
    }

}
public class Test {
    public static void main(String[] args) {
        person p = new person();
        System.out.println(p.a);
    }
}

