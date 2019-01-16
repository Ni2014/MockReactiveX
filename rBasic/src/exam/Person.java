package exam;

/**
 * Created by 宸笙 on 2019/1/16.
 */
public class Person implements Comparable<Person>{
    private int exitAmount;

    public int getExitAmount() {
        return exitAmount;
    }

    public void setExitAmount(int exitAmount) {
        this.exitAmount = exitAmount;
    }

    @Override
    public int compareTo(Person o) {
        return Integer.max(exitAmount,o.getExitAmount());
    }
}
