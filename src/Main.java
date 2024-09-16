import java.util.List;

public class Main {
    public static void main(String[] args) {
        MyLinkedList<Integer> list = new MyLinkedList<>();

        list.add(5);
        list.add(2);
        list.add(4);
        list.add(1);

        System.out.println("Список: ");
        list.printIt();

        int N = 2;
        List<Integer> topNValues = list.findTopN(N);
        System.out.println("Топ " + N + " значений: " + topNValues);

        boolean removed = list.remove(2);
        System.out.println("Удален элемент 2: " + removed);
        System.out.println("Список после удаления элемента 2: ");
        list.printIt();

        removed = list.remove(10); //нет в списке
        System.out.println("Удален элемент 10: " + removed);

        System.out.println("Список после попытки удаления элемента 10: ");
        list.printIt();
    }
}