import junit.framework.TestCase;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class KeyAlgorithmTest extends TestCase {

    String numberValidKey;
    String numberInvalidKey;
    String bik;

    @Override
    @BeforeAll
    protected void setUp() {
        numberValidKey = "40602810700000000025";
        numberInvalidKey = "40602810800000000025";
        bik="049805746";
    }

    @Test
    @Tag("keyValid")
    public void testKeyValid(){
        assertTrue(KeyAlgorithm.keyValid(numberValidKey,bik));
    }

    @Test
    @Tag("keyValid")
    public void testKeyValidNo(){
        assertTrue(KeyAlgorithm.keyValid(numberInvalidKey,bik));
    }

    @Test
    @Tag("keyValid")
    public void testValidAccountNumber (){
        assertTrue(
                KeyAlgorithm.validAccountNumber(numberInvalidKey,bik)
                        .contains("40602810700000000025"));
    }
}
