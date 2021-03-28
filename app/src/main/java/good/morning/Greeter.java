package good.morning;

/**
 * Using this class to build understanding of lambda expressions and functional interfaces
 */

public class Greeter {
    public void greet(Greeting greeting) {
        greeting.perform();
    }
    
    public static void main(String[] args) {
        Greeter greeter = new Greeter();

        Greeting lambdaGreeting = ()->System.out.println("Hello World!");

        Greeting innerClassGreeting = new Greeting() {
            public void perform() {
                System.out.println("Hello World!!");
            }
        };

        greeter.greet(()->System.out.println("Hello World!!!"));
        greeter.greet(innerClassGreeting);
        greeter.greet(lambdaGreeting);
    }
}
