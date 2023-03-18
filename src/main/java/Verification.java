import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

public class Verification {
    public static boolean validLength(String scanNumber) { //тут надо добавить проверку (и в тесты) что введены только цифры.
        return scanNumber.length() == 20;
    }

    public static String typeAccountPath(String scanNumber, String getPathFile) {
        DocumentContext context = JsonPath.parse(getPathFile);
        String scanNumberCut = scanNumber.substring(0, 5);
        try {
            String codePath = "$[?(@.code == '" + scanNumberCut + "')]";
            String nameType = context.read(codePath).toString();
            if (nameType.equals("[]"))
                return "Тип счета не найден в справочнике\n";
            return nameType;
        } catch (Exception ex) {
            return ex + "Тип счета не найден в справочнике\n";
        }
    }

    public static String curAccountPath(String scanNumber, String fileContent) {
        String scanNumberCut = scanNumber.substring(5, 8);
        if (scanNumberCut.equals("000")) {
            return "валюта счета не найдена в справочнике";
        }
        while (scanNumberCut.charAt(0) == '0') {
            scanNumberCut = scanNumberCut.substring(1);
        }
        try {
            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document document = documentBuilder.parse(fileContent);

            XPathFactory pathFactory = XPathFactory.newInstance();
            XPath xpath = pathFactory.newXPath();
            String numCode = "//Denomination/Item[ISO_Num_Code='" + scanNumberCut + "']/Name";
            XPathExpression expr = xpath.compile(numCode);

            if (!expr.evaluate(document).isEmpty())
                return (expr.evaluate(document));
            else return "валюта счета не найдена в справочнике\n";
        } catch (Exception ex) {
            return ex.toString();
        }
    }

    ;
}