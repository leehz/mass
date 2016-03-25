

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hz on 2016/3/24.
 */
public class Test2 {

    public static class Plate{
        private List<Object> apples = new ArrayList<Object>();
        private List<Object> bananas = new ArrayList<>();

        public Plate(){
        }

        public synchronized void putApple(Object apple){

            while (apples.size() > 0 || bananas.size() > 0) {
                try{
                    wait();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }

            System.out.println("M Put Apple");
            apples.add(apple);

            System.out.println("M Putted" + Thread.currentThread().getName());
            notifyAll();
        }

        public synchronized void putBanana(Object banana){

            while (apples.size() > 0 || bananas.size() > 0) {
                try{
                    wait();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
                System.out.println("F Put Banana");
                bananas.add(banana);
                System.out.println("F Putted" + Thread.currentThread().getName());
                notifyAll();
        }

        public synchronized void getApple(){
            while (apples.size() == 0) {
                try{
                    wait();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
                //apples.get(0);
                System.out.println("S Get Apple");
                apples.clear();
                //apples.remove(0);
                System.out.println("S Getted" + Thread.currentThread().getName());
                notifyAll();
        }

        public synchronized void getBanana(){
            while (bananas.size() == 0) {
                try{
                    wait();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
                System.out.println("D Get Banana");
                //bananas.remove(0);
                bananas.clear();
                System.out.println("D Getted" +  Thread.currentThread().getName());
                notifyAll();
        }
    }

    public static class ThreadTest implements Runnable{
        private Plate plate;
        private boolean isApple;
        private boolean isPut;

        public ThreadTest(Plate plate, boolean isApple, boolean isPut){
            this.plate = plate;
            this.isApple = isApple;
            this.isPut = isPut;
        }

        @Override
        public void run() {
            if(isApple){
                if(isPut)
                    plate.putApple(new Object());
                else
                    plate.getApple();
            } else {
                if(isPut)
                    plate.putBanana(new Object());
                else
                    plate.getBanana();
            }
			while(true);
           // System.out.println(Thread.currentThread().getName() + " " + isPut + " " + isApple);
        }
    }

    public static void main(String[] args){
        Plate plate = new Plate();
            new Thread(new ThreadTest(plate, true, true)).start();
            new Thread(new ThreadTest(plate, true, false)).start();
            new Thread(new ThreadTest(plate, false, true)).start();
            new Thread(new ThreadTest(plate, false, false)).start();

    }
}
