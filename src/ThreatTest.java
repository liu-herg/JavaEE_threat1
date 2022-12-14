import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

class MyThread extends Thread{
}
public class ThreatTest {

    public static void main(String[] args) {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("1");
            }
        });
        System.out.println(t.isAlive());//isAlive()判断系统内核的线程有没有创建
        t.start();//操作系统内核创建PCB，PCB才是真正的线程，run跑完，线程销毁，PCB被释放。
        System.out.println("2");
    }

    public static void main1(String[] args) {
        Thread thread1 = new Thread(()->{
            long b= 0;
           for(long i=0;i<100_0000_0000L;i++){
               b++;
           }
        });

        Thread thread2 = new Thread(()->{
            long b= 0;
            for(long i=0;i<100_0000_0000L;i++){
                b++;
            }
        });

        long beg = System.currentTimeMillis();
        thread1.start();


        try{
            thread1.join();

        }catch (InterruptedException e){
            e.printStackTrace();
        }
        thread2.start();
        try{

            thread2.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println((end-beg)+"ms");
    }


    public static void main12(String[] args) {
        Counter counter = new Counter();
        Thread thread1 = new Thread(()->{
            for(int i = 0;i<50000;i++){
                counter.add();
            }
        });
        Thread thread2 = new Thread(()->{
            for(int i = 0;i<50000;i++){
                counter.add();
            }
        });
        long beg = System.currentTimeMillis();
        thread1.start();
        thread2.start();

        try{
            thread1.join();
            thread2.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println(counter.count);
        System.out.println(end-beg);
    }
}
class Counter {
    public static int count = 0;

    public synchronized void add(){
        count++;
    }

}
