import org.junit.jupiter.api.Test;

import good.morning.Silly;
import good.morning.Steve;

public class SillyTest {
    @Test
    public void testSayHi() {
        Silly testSteve = new Silly();
        testSteve.sayHi(() -> System.out.println(Steve.greetingSilly));
    }
}
