import java.util.*;
import java.util.stream.Stream;
public class PersonTable {
    HashMap<String[], Person> Table;
    HashMap<String, Integer> firstnames;
    private int maxAge = -1;
    private int maxNumbersFirstname = 1;
    PersonTable() {
        Table = new HashMap<>();
        firstnames = new HashMap<>();
    }
    void add(Person p) {
        if(firstnames.containsKey(p.firstname)){
            Integer f = firstnames.get(p.firstname);
            firstnames.remove(p.firstname);
            firstnames.put(p.firstname, f+1);
            if(maxNumbersFirstname <f+1){
                maxNumbersFirstname = f+1;
            }

        }else{
            firstnames.put(p.firstname, 1);
        }
        Table.put(new String[]{p.firstname, p.lastname,p.surname}, p);

        if(maxAge< p.age){
            maxAge=p.age;
        }
    }
    void add(String lastname, String firstname, String surname, int age) {

        if(firstnames.containsKey(firstname)){
            Integer f = firstnames.get(firstname);
            firstnames.remove(firstname);
            firstnames.put(firstname, f+1);
            if(maxNumbersFirstname <f+1){
                maxNumbersFirstname = f+1;
            }
        }else{
            firstnames.put(firstname, 1);
        }
        Table.put(new String[]{firstname, lastname, surname}, new Person(lastname, firstname, surname, age));
        if(maxAge< age){
            maxAge= age;
        }
    }
    public Stream<Map.Entry<String, Integer>> firstNameStream() {
        ArrayList<Map.Entry<String, Integer>> result = new ArrayList<>();
        firstnames.entrySet().stream().filter(x-> firstnames.get(x.getKey()) == getMaxNumbersFirstname()).forEach(x -> result.add(x));
        return result.stream();
    }
    public Optional<Person> getMaxAge(String lastname) {
        Optional<Person> result = Optional.empty();
        Optional<Map.Entry<String[], Person>> tmp = Table.entrySet().stream().sorted(new NameComparator()).filter(x-> (x.getKey()[1].equals(lastname))).findFirst();
        if (tmp.isPresent()) {
            result = Optional.ofNullable(tmp.get().getValue());
        }
        return result;
    }
    public int getMaxNumbersFirstname(){
        return maxNumbersFirstname;
    }
}
