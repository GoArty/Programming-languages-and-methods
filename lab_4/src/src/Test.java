public class Test {
    public static void main(String[] args) {
        Sequence sequence = new Sequence(1, 2, 3, 4, 5);
        System.out.print("\nИзначальная последовательность: ");
        for (int s : sequence) {
            System.out.print(s + " ");
        }
        System.out.println();
        sequence.set(2, 10);
        sequence.set(4, 20);
        System.out.print("Изменённая последовательность(число с индексом 2 заменяем на 10, а с 4 на 20): ");
        for (int s : sequence) {
            System.out.print(s + " ");
        }
        System.out.println();
    }
}
