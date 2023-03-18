public class KeyAlgorithm {

    public static Boolean keyValid(String scanNumber, String bik) {
        return calculateKey(
                bik.substring(6) + scanNumber)
                % 10 == 0;
    }

    private static int calculateKey(String bikAndNumber) {
        int cof = 7;
        int key = 0;
        for (int i = 0; i < bikAndNumber.length(); i++) {
            key += Integer.parseInt(String.valueOf(bikAndNumber.charAt(i))) * cof;
            cof = cofNext(cof);
        }
        return key;
    }

    private static int cofNext(int cof) {
        switch (cof) {
            case 7:
                return 1;
            case 1:
                return 3;
            case 3:
            case 0:
                return 7;
            default:
                return 0;
        }
    }

    public static String validAccountNumber(String scanNumber, String bik) {
        int resultKey = calculateAccountNumber(bik.substring(6) + scanNumber);
        int keyNumber = (resultKey % 10 * 3) % 10;
        return scanNumber.substring(0, 8) + keyNumber + scanNumber.substring(9);
    }

    private static int calculateAccountNumber(String bikAndNumber) {
        int cof = 7;
        int key = 0;
        for (int i = 0; i < bikAndNumber.length(); i++) {
            if (i == 8)
                cof = 0;
            key += Integer.parseInt(String.valueOf(bikAndNumber.charAt(i))) * cof;
            cof = cofNext(cof);
        }
        return key;
    }
}
