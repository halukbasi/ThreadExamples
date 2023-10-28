import java.util.*;

public class OddsEvens implements Runnable{
    private ArrayList<Integer> list;
    private Object LOCK = new Object();

    public ArrayList<Integer> getList() {
        return list;
    }
    public void setList(ArrayList<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {
        Random random = new Random();
        HashSet<Integer> newSet = new HashSet<>();

        while (newSet.size() != 2500) {
            synchronized (LOCK) {
                int randomNumber = random.nextInt(getList().size());
                newSet.add(getList().get(randomNumber));
                ArrayList<Integer> updatedList = getList();
                updatedList.remove(getList().get(randomNumber));
                setList(updatedList);
            }
//            System.out.println(Thread.currentThread().getName() + " newSet: " + newSet);
        }

        Iterator<Integer> itr = newSet.iterator();
        ArrayList<Integer> evenList = new ArrayList<>();
        ArrayList<Integer> oddList = new ArrayList<>();

        while (itr.hasNext()){
            int value = (Integer) itr.next();
            if(value % 2 == 0){
                evenList.add(value);
            }
            else{
                oddList.add(value);
            }
        }
        System.out.println(Thread.currentThread().getName() + " Odds: " + oddList);
        System.out.println(Thread.currentThread().getName() + " Evens: " + evenList);
        }

    }

