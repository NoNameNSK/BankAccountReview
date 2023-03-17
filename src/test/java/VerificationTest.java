import junit.framework.TestCase;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class VerificationTest extends TestCase {

    String numberFull;
    String numberNull;
    String numberFinUsd;
    String numberATS;
    String numberNotFoundType;
    String numberNotFoundCur;
    String numberNotFoundCurZero;
    String numberValidKet;
    String numberNotValidKey;
    String pathXml = "/Users/temior/IdeaProjects/BankAccount/src/main/java/resources/curcod.xml";
    String pathJson = "/Users/temior/IdeaProjects/BankAccount/src/main/java/resources/typeAccount.json";

    @Override
    @BeforeAll
    protected void setUp() throws Exception {
        numberFull = "40501840912312312311";
        numberNull = "";
        numberFinUsd = "40501840912312312311";
        numberNotFoundType = "00001840912312312311";
        numberNotFoundCurZero = "00001000912312312311";
        numberValidKet = "40602810700000000025";
        numberNotValidKey = "40602810800000000025";
        numberNotFoundCur = "40602044700000000025";
        numberATS = "40602040700000000025";
    }

    @Test
    @Tag("ValidLength")
    public void testValidLengthFull() {
        boolean actual = Verification.validLength(numberFull);
        boolean expected = true;
        assertEquals(expected, actual);
    }

    @Test
    @Tag("ValidLength")
    public void testValidLengthNull() {
        boolean actual = Verification.validLength(numberNull);
        boolean expected = false;
        assertEquals(expected, actual);
    }

    @Test
    @Tag("TypeAccountPath(")
    public void testTypeAccountPath() {
        String actual = Verification.typeAccountPath(numberFinUsd, ParserType.getJsonFile(pathJson));
        // assertEquals(expected, actual);
        assertTrue(actual.contains("Финансовые организации"));
    }

    @Test
    @Tag("TypeAccountPath(")
    public void testTypeAccountPathNotFound() {
        String actual = Verification.typeAccountPath(numberNotFoundType, ParserType.getJsonFile(pathJson));
        // assertEquals(expected, actual);
        assertTrue(actual.contains("Тип счета не найден в справочнике"));
    }

    @Test
    @Tag("curAccountPath")
    public void testCurAccountPath() {
        String actual = Verification.curAccountPath(numberFinUsd, pathXml);
        assertTrue(actual.contains("Доллар США"));
    }

    @Test
    @Tag("curAccountPath")
    public void testCurAccountPathNotFound() {
        String actual = Verification.curAccountPath(numberNotFoundCurZero, pathXml);
        assertTrue(actual.contains("валюта счета не найдена в справочнике"));
    }

    @Test
    @Tag("curAccountPath")
    public void testCurAccountPathNotFoundCur() {
        String actual = Verification.curAccountPath(numberNotFoundCur, pathXml);
        assertTrue(actual.contains("валюта счета не найдена в справочнике"));
    }

    @Override
    @AfterAll
    protected void tearDown() throws Exception {
        super.tearDown();
    }
}
