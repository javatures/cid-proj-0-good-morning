package good.morning.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import good.morning.controller.TaskDao;

public class Display {

    static Logger logger = LogManager.getLogger(Display.class);
    public static Scanner userInput = new Scanner(System.in);

    public static void welcome() throws InterruptedException {

        logger.info("Displaying welcome sequence");

        long sleepDuration = 0;

        System.out.println("Thank you for checking out this ghuD!");
        Thread.sleep(sleepDuration);
        System.out.println();
        Thread.sleep(sleepDuration);
        System.out.println();
        Thread.sleep(sleepDuration);
        System.out.println();
        System.out.println("ghuD stands for Great Heads Up Display.");
        Thread.sleep(sleepDuration);
        System.out.println();
        Thread.sleep(sleepDuration);
        System.out.println();
        Thread.sleep(sleepDuration);
        System.out.println();
        System.out.println("Your ghuD is a good tool for organizing your Headspace.");
        Thread.sleep(sleepDuration);
        System.out.println();
        Thread.sleep(sleepDuration);
        System.out.println();
        Thread.sleep(sleepDuration);
        System.out.println();
        System.out.println("Your Headspace is the collective contents of your ghuD.");
        Thread.sleep(sleepDuration);
        System.out.println();
        Thread.sleep(sleepDuration);
        System.out.println();
        Thread.sleep(sleepDuration);
        System.out.println();
        System.out.println("View your Headspace through a selected Frame Of Mind to gather your Thoughts.");
        Thread.sleep(sleepDuration);
        System.out.println();
        Thread.sleep(sleepDuration);
        System.out.println();
        Thread.sleep(sleepDuration);
        System.out.println();
        System.out.println("Your Thoughts are the individual contents that make up your collective contents.");
        Thread.sleep(sleepDuration);
        System.out.println();
        Thread.sleep(sleepDuration);
        System.out.println();
        Thread.sleep(sleepDuration);
        System.out.println();
        System.out.println("You can think of these as tasks, but they're really just anything on your mind.");
        Thread.sleep(sleepDuration);
        System.out.println();
        Thread.sleep(sleepDuration);
        System.out.println();
        Thread.sleep(sleepDuration);
        System.out.println();

    };

    public static void yesToContinue() {
        
        logger.info("Displaying yes-to-continue");
        
        System.out.println("Would you like to continue?");
        System.out.println();
        System.out.println("[1] Yes!");
        System.out.println("[2] Noo!");
        
    }
    
    public static void yesToContinueLogic() {


    }

    public static void modeMenu() throws Exception {
        
        logger.info("Displaying mode menu");
        
        System.out.println("What mode should we continue in?");
        System.out.println();
        System.out.println("[1] Normal");
        System.out.println("[2] Presentation");
        System.out.println("[3] Goodbye Mode!");

        Display.modeMenuLogic();
    }

    public static void modeMenuLogic() throws Exception {

        logger.info("Displaying mode menu logic");

        List<Integer> modes = Arrays.asList(1, 2, 3);
        int modeMenuSelection = userInput.nextInt();
        if(modes.contains(modeMenuSelection)) {
            switch(modeMenuSelection) {
                case 1:
                    Display.thinkMenu();
                    break;
                case 2:
                    Display.presentation();
                    Display.yesToContinue();
                    break;
                case 3:
                    System.out.println("See ya!");
            }
        } else {
            logger.error("Invalid choice");
            System.out.println("Invalid selection... bye!");
            throw new Exception();
        }
    }

    public static void thinkMenu() throws Exception {

        logger.info("Displaying think menu");

        System.out.println("Okay- let's think!");
        System.out.println("What Frame Of Mind are we in?");
        System.out.println();
        System.out.println("[1] Front And Center");
        System.out.println("[2] Top Of Mind");
        System.out.println("[3] Learning");
        System.out.println("[4] Earning");
        System.out.println("[5] Love");
        System.out.println("[6] Doing something...");
        System.out.println("[7] Leaving!");

        Display.thinkMenuLogic();
    }

    private static void thinkMenuLogic() throws Exception {

        logger.info("Displaying think menu logic");

        List<Integer> framesOfMind = Arrays.asList(1,2,3,4,5,6,7);
        int thinkMenuSelection = userInput.nextInt();
        if(framesOfMind.contains(thinkMenuSelection)) {
            switch(thinkMenuSelection) {
                case 1:
                    TaskDao.frontAndCenter();
                    break;
                case 2:
                    TaskDao.topOfMind();
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
            }
        } else {
            System.out.println("Invalid choice... bye!");
            logger.error("Invalid choice");
            throw new Exception();
        }

    }

    public static void doMenu() throws Exception {

        System.out.println("Ah, yes- let's gather our Thoughts!");
        System.out.println("How should we tidy up?");
        System.out.println();
        System.out.println("[1] Add a Thought");
        System.out.println("[2] Revisit a Thought");
        System.out.println("[3] Forget a Thought");
        System.out.println("[4] Think about something...");
        System.out.println("[5] Make like a tree!");

        Display.doMenuLogic();

    }

    private static void doMenuLogic() throws Exception {

        logger.info("Displaying do menu");

        List<Integer> laundryList = Arrays.asList(1,2,3,4,5);
        int doMenuSelection = userInput.nextInt();
        if(laundryList.contains(doMenuSelection)) {
            switch(doMenuSelection) {
                case 1:
                    TaskDao.add();
                    break;
                case 2:
                case 3:
                case 4:
                case 5:
            } Display.thinkMenu();
        } else {
            System.out.println("Invalid choice... bye!");
            logger.error("Invalid choice");
            throw new Exception();
        }


    }

    public static void presentation() {

        logger.info("Displaying presentation");

        System.out.println("Presentation");
        System.out.println("Intro");
        System.out.println("Feature Suggestions");
        System.out.println("Tech Stack");
        System.out.println("Ending");

    }




}