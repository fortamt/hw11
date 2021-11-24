public class Exercise1 {
    public static void main(String[] args) {
        Thread thread = new Thread(new Timer());

        Thread thread1 = new Thread(() ->{
            while(true) {
                try {
                    Thread.sleep(5000);
                    System.out.println("Прошло 5 секунд");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
        thread1.start();
    }
}


class Timer implements Runnable{
    private int hours = 0;
    private int minutes = 0;
    private int sec = 0;

    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(sec < 59){
                sec++;
            } else if(minutes < 59){
                sec = 0;
                minutes++;
            } else {
                sec = 0;
                minutes = 0;
                hours++;
            }
            System.out.println(hours + ":" + minutes + ":" + sec);
        }
    }
}