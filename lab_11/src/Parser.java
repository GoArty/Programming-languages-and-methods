import java.util.ArrayList;

public class Parser {
    private static int pos;
    private static ArrayList<String> tokens;

    public static void parse(String input) {
        tokens = Lexer.tokenize(input);
        pos = 0;
        try {
            decl();
            System.out.println("Parsing successful!");
        } catch (Exception e) {
            System.out.println("Parsing error: " + e.getMessage());
        }
    }

    public static void decl() throws Exception {
        enumDef();
        varsOpt();
        match(";");
    }

    public static void enumDef() throws Exception {
        match("enum");
        match("IDENT");
        match("{");
        list();
        match("}");
    }

    public static void list() throws Exception {
        item();
        ltail();
    }

    public static void ltail() throws Exception {
        if (tokens.get(pos).equals(",")) {
            match(",");
            list();
        }
    }

    public static void item() throws Exception {
        match("IDENT");
        itail();
    }

    public static void itail() throws Exception {
        if (tokens.get(pos).equals("=")) {
            match("=");
            match("NUMBER");
        }
    }

    public static void varsOpt() throws Exception {
        if (tokens.get(pos).startsWith("IDENT")) {
            vars();
        }
    }

    public static void vars() throws Exception {
        match("IDENT");
        vtail();
    }

    public static void vtail() throws Exception {
        if (tokens.get(pos).equals(",")) {
            match(",");
            vars();
        }
    }

    public static void match(String expected) throws Exception {
        if (pos < tokens.size() && tokens.get(pos).equals(expected)) {
            pos++;
        } else {
            throw new Exception("Expected " + expected + " but found " + tokens.get(pos) + " (Index:" + pos + ")");
        }
    }
}
