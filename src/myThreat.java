import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: asus
 * Date: 2022-11-21
 * Time: 21:00
 */
public class myThreat {
    public static void main1(String[] args) {
        Thread[] threads = new Thread[20];
        Thread threads1 = threads[21];
        for(int i= 0;i<20;i++){
            int n = i;
            threads[i] = new Thread(()-> System.out.println(n));
        }
        for(Thread t:threads){
            t.start();
        }
        for(Thread t:threads){
            try {
                t.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("OK");

    }

    public static void main5(String[] args) throws InterruptedException {
//        Thread thread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                while (true){
//                    System.out.println("he;llo");
//                }
//            }
//        });
//        thread.start();

        Object ob = new Object();
        synchronized (ob){
            System.out.println("qian");
            ob.wait();
            System.out.println("hou");
        }
    }

}


