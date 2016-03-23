import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
public class TimerTest3{
	public static void main(String args[]){
		new Timer().schedule(new TimerTask(){
			public void run(){
				System.out.println("线程ID: " + Thread.currentThread().getName());
			}
		}, 0, 1000);
	while(true){
		try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
		System.out.println(new Date().getSeconds());
	}
	}
}
