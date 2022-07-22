import java.util.concurrent.*;

class Car extends Thread
{
    Semaphore sem;
    String category;
    public Car(Semaphore sem, String category)
    {
        super(category);
        this.sem = sem;
        this.category = category;
    }

    @Override
    public void run() {
        if(this.getName().equals("Cars driving on the North-South road"))
        {
            System.out.println("Starting " + category);
            try
            {
                System.out.println(category + " are waiting at the semaphore.");

                sem.acquire();

                System.out.println(category + " passing.");
            } catch (InterruptedException exc) {
                System.out.println(exc);
            }
            System.out.println("Semaphore turning red again on the South North road");
            sem.release();
        }
        else
        {
            System.out.println("Starting " + category);
            try
            {
                System.out.println(category + " are waiting at the semaphore.");

                sem.acquire();

                System.out.println(category + " passing.");
            } catch (InterruptedException exc) {
                System.out.println(exc);
            }

            System.out.println("Semaphore turning red again on the East West road");
            sem.release();
        }
    }
}
public class Semafor
{
    public static void main(String args[]) throws InterruptedException
    {

        Semaphore sem = new Semaphore(1);

        Car car1 = new Car(sem, "Cars driving on the North-South road");
        Car car2 = new Car(sem, "Cars driving on the East-West road");

        car1.start(); car2.start();
        car1.join(); car2.join();
    }
}