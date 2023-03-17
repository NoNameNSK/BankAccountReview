public class KeyAlgoritm {

    public static String keyVilid(String scanNumber, String bik) {
        String subBik = bik.substring(6);
        String bikAndNumber = subBik + scanNumber;
        //7,1,3,7,1,3,7,1,3,7,1,3,7,1,3,7,1,3,7,1,3,7,1
        int resultKey = Character.digit(bikAndNumber.charAt(0), 10) * 7 +
                Character.digit(bikAndNumber.charAt(1), 10) +
                Character.digit(bikAndNumber.charAt(2), 10) * 3 +
                Character.digit(bikAndNumber.charAt(3), 10) * 7 +
                Character.digit(bikAndNumber.charAt(4), 10) +
                Character.digit(bikAndNumber.charAt(5), 10) * 3 +
                Character.digit(bikAndNumber.charAt(6), 10) * 7 +
                Character.digit(bikAndNumber.charAt(7), 10) +
                Character.digit(bikAndNumber.charAt(8), 10) * 3 +
                Character.digit(bikAndNumber.charAt(9), 10) * 7 +
                Character.digit(bikAndNumber.charAt(10), 10) +
                Character.digit(bikAndNumber.charAt(11), 10) * 3 +
                Character.digit(bikAndNumber.charAt(12), 10) * 7 +
                Character.digit(bikAndNumber.charAt(13), 10) +
                Character.digit(bikAndNumber.charAt(14), 10) * 3 +
                Character.digit(bikAndNumber.charAt(15), 10) * 7 +
                Character.digit(bikAndNumber.charAt(16), 10) +
                Character.digit(bikAndNumber.charAt(17), 10) * 3 +
                Character.digit(bikAndNumber.charAt(18), 10) * 7 +
                Character.digit(bikAndNumber.charAt(19), 10) +
                Character.digit(bikAndNumber.charAt(20), 10) * 3 +
                Character.digit(bikAndNumber.charAt(21), 10) * 7 +
                Character.digit(bikAndNumber.charAt(22), 10);
        int reseult = resultKey % 10;
        if (reseult == 0) return "Счет корректен";
        else return "Проверьте правильность ввода номера счета и БИК банка";
    };

    public static String validAccountNumber(String scanNumber, String bik) {
        String subBik = bik.substring(6);
        String bikAndNumber = subBik + scanNumber;
        int resultKey = Character.digit(bikAndNumber.charAt(0), 10) * 7 +
                Character.digit(bikAndNumber.charAt(1), 10) +
                Character.digit(bikAndNumber.charAt(2), 10) * 3 +
                Character.digit(bikAndNumber.charAt(3), 10) * 7 +
                Character.digit(bikAndNumber.charAt(4), 10) +
                Character.digit(bikAndNumber.charAt(5), 10) * 3 +
                Character.digit(bikAndNumber.charAt(6), 10) * 7 +
                Character.digit(bikAndNumber.charAt(7), 10) +
                Character.digit(bikAndNumber.charAt(8), 10) * 0 +//ключевой символ
                Character.digit(bikAndNumber.charAt(9), 10) * 7 +
                Character.digit(bikAndNumber.charAt(10), 10) +
                Character.digit(bikAndNumber.charAt(11), 10) * 3 +
                Character.digit(bikAndNumber.charAt(12), 10) * 7 +
                Character.digit(bikAndNumber.charAt(13), 10) +
                Character.digit(bikAndNumber.charAt(14), 10) * 3 +
                Character.digit(bikAndNumber.charAt(15), 10) * 7 +
                Character.digit(bikAndNumber.charAt(16), 10) +
                Character.digit(bikAndNumber.charAt(17), 10) * 3 +
                Character.digit(bikAndNumber.charAt(18), 10) * 7 +
                Character.digit(bikAndNumber.charAt(19), 10) +
                Character.digit(bikAndNumber.charAt(20), 10) * 3 +
                Character.digit(bikAndNumber.charAt(21), 10) * 7 +
                Character.digit(bikAndNumber.charAt(22), 10);
        int keyNumber = (resultKey % 10*3)%10;
        String resultNumber = scanNumber.substring(0,8)+keyNumber+scanNumber.substring(9);
        return resultNumber; };
}
