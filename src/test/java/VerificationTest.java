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
    String numberValidKey;
    String numberInvalidKey;
//    TODO переделать получение пути до ресурса так, что-бы оперировать только директориями внутри проекта
    String pathXml = "/Users/temior/IdeaProjects/BankAccount/src/main/java/resources/curcod.xml";
    String pathJson = "/Users/temior/IdeaProjects/BankAccount/src/main/java/resources/typeAccount.json";

    @Override
    @BeforeAll
    protected void setUp() {
        numberFull = "40501840912312312311";
        numberNull = "";
        numberFinUsd = "40501840912312312311";
        numberNotFoundType = "00001840912312312311";
        numberNotFoundCurZero = "00001000912312312311";
        numberValidKey = "40602810700000000025";
        numberInvalidKey = "40602810800000000025";
        numberNotFoundCur = "40602044700000000025";
        numberATS = "40602040700000000025";
    }

    @Test
    @Tag("ValidLength")
    public void testValidLengthFull() {
        assertTrue(Verification.validLength(numberFull));
    }

    @Test
    @Tag("ValidLength")
    public void testValidLengthNull() {
        assertFalse(Verification.validLength(numberNull));
    }

    @Test
    @Tag("TypeAccountPath")
    public void testTypeAccountPath() {
        assertTrue(
                Verification.typeAccountPath(numberFinUsd, ParserType.getJsonFile(pathJson))
                        .contains("Финансовые организации"));
    }

    @Test
    @Tag("TypeAccountPath")
    public void testTypeAccountPathNotFound() {
        assertTrue(
                Verification.typeAccountPath(numberNotFoundType, ParserType.getJsonFile(pathJson))
                        .contains("Тип счета не найден в справочнике"));
    }

    @Test
    @Tag("curAccountPath")
    public void testCurAccountPath() {
        assertTrue(Verification.curAccountPath(numberFinUsd, pathXml).contains("Доллар США"));
    }

    @Test
    @Tag("curAccountPath")
    public void testCurAccountPathNotFound() {
        assertTrue(
                Verification.curAccountPath(numberNotFoundCurZero, pathXml)
                        .contains("валюта счета не найдена в справочнике"));
    }

    @Test
    @Tag("curAccountPath")
    public void testCurAccountPathNotFoundCur() {
        assertTrue(Verification.curAccountPath(numberNotFoundCur, pathXml)
                .contains("валюта счета не найдена в справочнике"));
    }

    @Override
    @AfterAll
    protected void tearDown() throws Exception {
        super.tearDown();
    }
}
