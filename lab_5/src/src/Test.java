public class Test {
    public static void main(String[] args) {
        PersonTable t = new PersonTable();
        t.add("sf", "a", "aaa", 1);
        t.add("fs", "ss", "bbb", 10);
        t.add("g", "a", "ccc", 3);
        t.add("d", "ss", "ddd", 4);
        t.add("b", "cc", "sv", 5);
        t.add("c", "a", "fr", 2);
        t.add("xx", "cc", "fr", 7);
        t.add(new Person("xx","cc","kef", 8));
        System.out.println("Наиболее часто встречающееся имя:");
        t.firstNameStream().forEach(x-> System.out.println(x.getKey()));
        System.out.println("Наиболее часто встречающееся имя:");
        System.out.println(t.getMaxAge("xx").get().age);
    }
}
