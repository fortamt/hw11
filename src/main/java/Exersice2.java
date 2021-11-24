

public class Exersice2 {
    public static void main(String[] args){
        Object lock = new Object();
        FizzBuzzClass fb = new FizzBuzzClass(15, lock);
        Thread A = new Thread(fb::fizz);
        Thread B = new Thread(fb::buzz);
        Thread C = new Thread(fb::fizzbuzz);
        Thread D = new Thread(fb::number);
        A.start();
        B.start();
        C.start();
        D.start();
    }
}


class FizzBuzzClass {
    private final int N;
    private int counter = 1;
    private final Object lock;

    public FizzBuzzClass(int n, Object lock) {
        this.N = n;
        this.lock = lock;
    }

    public void increment() {
        this.counter++;
    }

    public void fizz() {
        synchronized (lock){
            while (counter <= N){
                if(counter % 3 == 0 && counter % 5 != 0){
                    System.out.print("fizz");
                    if(counter != N){
                        System.out.print(", ");
                    } else {
                        System.out.print(".");
                    }
                    increment();
                    lock.notifyAll();
                } else {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public void buzz() {
        synchronized (lock){
            while (counter <= N){
                if(counter % 3 != 0 && counter % 5 == 0){
                    System.out.print("buzz");
                    if(counter != N){
                        System.out.print(", ");
                    } else {
                        System.out.print(".");
                    }
                    increment();
                    lock.notifyAll();
                } else {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public void fizzbuzz() {
        synchronized (lock){
            while (counter <= N){
                if(counter % 3 == 0 && counter % 5 == 0){
                    System.out.print("fizzbuzz");
                    if(counter != N){
                        System.out.print(", ");
                    } else {
                        System.out.print(".");
                    }
                    increment();
                    lock.notifyAll();
                } else {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public void number() {
        synchronized (lock){
            while (counter <= N){
                if(counter % 3 != 0 && counter % 5 != 0){
                    System.out.print(counter);
                    if(counter != N){
                        System.out.print(", ");
                    } else {
                        System.out.print(".");
                    }
                    increment();
                    lock.notifyAll();
                } else {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

}
