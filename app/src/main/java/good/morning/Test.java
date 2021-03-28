package good.morning;

public class Test {

    public static void main(String[] args) {

        // Functional interface test with one abstract method

        // option 1
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("New thread created");
            }
        }).start();

        // option 2
        Thread myThread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("New thread created");
            }
        });

        myThread.run();


        // Functional interface test with lambda expression

        // option 1
        new Thread(()->
            {System.out.println("New thread created");}).start();

        // option 2
        Thread myLambdaThread = new Thread(()-> System.out.println("New thread created"));
        myLambdaThread.run();
    }
}
