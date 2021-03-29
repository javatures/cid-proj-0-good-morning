package good.morning;

/**
 * This user guide mood strives to speak in bumper stickers... the kind that you'd CONSIDER buying... maybe...
 */

public class Silly extends Steve {

    @Override
    public void sayHi(Greeting greeting) {
        greeting.perform();
    }

    // public boolean addTask(Task task) {
    //     // tasks.add(task);
    //     return true;
    // }



    

    // @Override
    // public String saysFarewell() {
    //     String farewell = "See ya later alli... gotcha!";
    //     return farewell;
    // }

    // @Override
    // public String introducesSelf() {
        
    //     return "Hi, my name is " + getName() + "!";
    // }

    // String expressesSelf() {
    //     String expression = "How 'bout a joke? \nWhy'd the chicken cross the road? \nOh, you've heard that one before...";
    //     return expression;
    // }
}
