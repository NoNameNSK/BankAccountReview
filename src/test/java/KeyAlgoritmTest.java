import junit.framework.TestCase;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class KeyAlgoritmTest extends TestCase {

    String numberValidKet;
    String numberNotValidKey;
    String bik;

    @Override
    @BeforeAll
    protected void setUp() throws Exception {
        numberValidKet = "40602810700000000025";
        numberNotValidKey = "40602810800000000025";
        bik="049805746";
    }

    @Test
    @Tag("keyVilid")
    public void testKeyVilid (){
        String actual = KeyAlgoritm.keyVilid(numberValidKet,bik);
        assertTrue(actual.contains("Счет корректен"));
    }

    @Test
    @Tag("keyVilid")
    public void testKeyVilidNo (){
        String actual = KeyAlgoritm.keyVilid(numberNotValidKey,bik);
        assertTrue(actual.contains("Проверьте правильность ввода номера счета и БИК банка"));
    }

    @Test
    @Tag("keyVilid")
    public void testValidAccountNumber (){
        String actual = KeyAlgoritm.validAccountNumber(numberNotValidKey,bik);
        assertTrue(actual.contains("40602810700000000025"));
    }

}
