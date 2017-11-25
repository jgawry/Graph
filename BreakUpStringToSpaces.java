import java.util.*;

public class BreakUpStringToSpaces {

    private static final HashSet<String> DICTIONARY =  new HashSet<>(Arrays.asList(new String[]{"Convert", "Arrays", "to","Set", "in" ,"Java", "pea", "but", "peanut", "butter"}));

    public static void main(String[] args) {
        String str = "butterpeanut";

        System.out.println(breakUpString(str));
    }

    public static ArrayList<String> breakUpString(String str) {
        if (str == null) {
            return null;
        }

        ArrayList<String> words = new ArrayList<>();

        findWords(words, str);

        return words;
    }

    private static boolean findWords(ArrayList<String> words, String str) {
        if (str == null || str.equals("")) {
            return true;
        }

        int strLength = str.length();

        for (int i = 0, c = strLength; i <= c; i++) {
            String left = str.substring(0, i);

            if (DICTIONARY.contains(left)) {
                words.add(left);

                if (i > str.length() - 1) {
                    return true;
                }

                String right = str.substring(i, strLength);

                if (findWords(words, right)) {
                    return true;
                } else {
                    words.remove(words.size() - 1);
                }
            }
        }

        return false;
    }
}
