import java.util.*;
class NameComparator implements Comparator<Map.Entry<String[], Person>> {
    public int compare(Map.Entry<String[], Person>  a, Map.Entry<String[], Person> b) {
        int a0, b0;
        a0 = a.getValue().age;
        b0 = b.getValue().age;
        if (a0 < b0) { return 1; }
        if (a0 == b0) { return 0; }
        return -1;
    }
}
