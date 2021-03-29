import org.junit.jupiter.api.Test;

import good.morning.Silly;
import good.morning.Steve;

public class SillyTest {
    Silly testSteve = new Silly();

    @Test
    public void testSayHi() {
        testSteve.sayHi(() -> System.out.println(Steve.greetingSilly));
    }

}
