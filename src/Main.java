import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        OddsEvens s = new OddsEvens();
        for(int i = 0; i < 10000; i++){
            numbers.add(i);
        }
        s.setList(numbers);
        Thread t1 = new Thread(s);
        Thread t2 = new Thread(s);
        Thread t3 = new Thread(s);
        Thread t4 = new Thread(s);

        t1.start();
        t2.start();
        t3.start();
        t4.start();

    }
}
