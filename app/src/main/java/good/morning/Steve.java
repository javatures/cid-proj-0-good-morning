package good.morning;

/**
 * Steve is a friendly, light-hearted user guide.

 */

public abstract class Steve implements Bud {

    private String name = "Steve";

    public String getName() {
        return this.name;
    }

    String introducesSelf() {
        return "Hi, my name is " + name;
    }

    abstract String expressesSelf();

    
}
