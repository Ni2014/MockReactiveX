package exam.toAsync;

/**
 * Created by 宸笙 on 2019/1/16.
 */
public class Client {

    public static void main(String[] args) {
        new Helper().getLabel("1:2:3:4:5", new Helper.HelperLabelCallback() {
            @Override
            public void onLabel(String label) {
                System.out.println("l:" + label);
            }

            @Override
            public void onError(Exception e) {

            }
        });

    }
}
