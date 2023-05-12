public class Test {
    public static void main(String[] args) {
        System.out.println("\nCorrect stitch:");
        String input = "enum Day { SUN = 0 , MON , TUE , WED , THU , FRI , SAT } first , last ;";
        Parser.parse(input);

        System.out.println("\nError: skipped 0");
        input = "enum Day { SUN =  , MON , TUE , WED , THU , FRI , SAT } first , last ;";
        Parser.parse(input);

        System.out.println("\nError: skipped =");
        input = "enum Day { SUN  0 , MON , TUE , WED , THU , FRI , SAT } first , last ;";
        Parser.parse(input);

        System.out.println("\nError: skipped ,");
        input = "enum Day { SUN = 0 , MON  TUE , WED , THU , FRI , SAT } first , last ;";
        Parser.parse(input);

        System.out.println("\nError: skipped TUE");
        input = "enum Day { SUN = 0 , MON ,  , WED , THU , FRI , SAT } first , last ;";
        Parser.parse(input);

        System.out.println("\nError: skipped }");
        input = "enum Day { SUN = 0 , MON , TUE , WED , THU , FRI , SAT  first , last ;";
        Parser.parse(input);

        System.out.println("\nError: skipped {");
        input = "enum Day  SUN = 0 , MON , TUE , WED , THU , FRI , SAT } first , last ;";
        Parser.parse(input);

        System.out.println("\nError: skipped ;");
        input = "enum Day { SUN = 0 , MON , TUE , WED , THU , FRI , SAT } first , last ";
        Parser.parse(input);

        System.out.println("\nError: skipped enum");
        input = " Day { SUN = 0 , MON , TUE , WED , THU , FRI , SAT  first , last ;";
        Parser.parse(input);

        System.out.println("\nError: skipped Day");
        input = "enum  { SUN = 0 , MON , TUE , WED , THU , FRI , SAT  first , last ;";
        Parser.parse(input);
    }
}
