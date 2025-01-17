import java.util.ArrayList;

public class Lexer {
    public static ArrayList<String> tokenize(String input) {
        ArrayList<String> tokens = new ArrayList<String>();
        String[] words = input.trim().split("\\s+");
        for (String word : words) {
            if (!word.matches("enum") && (word.matches("[a-zA-Z]+") || word.matches("[a-zA-Z]+[\\,]")))  {
                tokens.add("IDENT");
            } else if (word.matches("[0-9]+")) {
                tokens.add("NUMBER");
            } else {
                tokens.add(word);
            }
        }
        return tokens;
    }
}
