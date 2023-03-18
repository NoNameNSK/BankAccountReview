import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        TODO переделать получение пути до ресурса так, что-бы оперировать только директориями внутри проекта
        String pathJson = "/Users/temior/IdeaProjects/BankAccount/src/main/java/resources/typeAccount.json";
        String pathXml = "/Users/temior/IdeaProjects/BankAccount/src/main/java/resources/curcod.xml";

        System.out.println("введите номер счета");
        Scanner sc = new Scanner(System.in);
        String accountNumber = sc.next();
        System.out.println("введите бик банка");
        String bik = sc.next();

        System.out.println("Проверка валидации длинны введенного номера.");

        if (Verification.validLength(accountNumber)) {
            System.out.println("номер введен корректно");
        } else {
            System.out.println("номер введен некорректно, проверьте количество символов");
        }

        System.out.println("проверка валюты номера");
        System.out.println(Verification.curAccountPath(accountNumber, pathXml));

        System.out.println("проверка принадлежности номера");
        System.out.println(Verification.typeAccountPath(accountNumber, ParserType.getJsonFile(pathJson)));

        Boolean isKeyValid = KeyAlgorithm.keyValid(accountNumber, bik);
        if (isKeyValid) {
            System.out.println("Счет корректен");
        }
        else{
            System.out.println("Проверьте правильность ввода номера счета и БИК банка");
            System.out.println("Корректный ключ для этого бик");
            System.out.println(KeyAlgorithm.validAccountNumber(accountNumber, bik));
        }
    }
}
