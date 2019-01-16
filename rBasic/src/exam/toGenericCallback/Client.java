package exam.toGenericCallback;

/**
 * Created by 宸笙 on 2019/1/16.
 */
public class Client {

    public static void main(String[] args) {
        new Helper().getLabel("1:2:3:4:5", new Callback<String>() {
            @Override
            public void onSuccess(String s) {
                System.out.println("l: " + s);
            }

            @Override
            public void onError(Exception e) {

            }
        });

    }
}
