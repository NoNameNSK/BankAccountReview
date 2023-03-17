import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String pathJson = "/Users/temior/IdeaProjects/BankAccount/src/main/java/resources/typeAccount.json";
        String pathXml = "/Users/temior/IdeaProjects/BankAccount/src/main/java/resources/curcod.xml";
        System.out.println("введите номер счета");
        Scanner sc = new Scanner(System.in);
        String accountNumber = sc.next().toString();
        System.out.println("введите бик банка");
        String bik = sc.next().toString();

        System.out.println("Проверка валидации длинны введеного номера.");
        Verification vrfy = new Verification();

        if (vrfy.validLength(accountNumber)) {
            System.out.println("номер введен корректно");
        } else {
            System.out.println("номер введен некорректно, проверьте количество символов");
        }
        System.out.println("проверка валюты номера");
        System.out.println(vrfy.curAccountPath(accountNumber, pathXml));
        System.out.println("проверка принадлежности номера");
        System.out.println(vrfy.typeAccountPath(accountNumber, ParserType.getJsonFile(pathJson)));
        System.out.println(KeyAlgoritm.keyVilid(accountNumber, bik));
        if (KeyAlgoritm.keyVilid(accountNumber, bik).equals("Проверьте правильность ввода номера счета и БИК банка")) {
            System.out.println("Корректный ключ для этого бик");
            System.out.println(KeyAlgoritm.validAccountNumber(accountNumber, bik));
        }

    }
}
