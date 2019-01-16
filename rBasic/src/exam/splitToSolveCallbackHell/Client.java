package exam.splitToSolveCallbackHell;

/**
 * Created by 宸笙 on 2019/1/16.
 */
public class Client {

    public static void main(String[] args) {

        // use flatMap
//        AsyncJob<String> asyncJob = new Helper().getLabel("1:2:3:4:5:6:7");
//        asyncJob.start(new Callback<String>() {
//            @Override
//            public void onSuccess(String s) {
//                System.out.println("Label:" + s);
//            }
//
//            @Override
//            public void onError(Exception e) {
//
//            }
//        });

        // other normal use style

       new AsyncJob<Integer>() {
            @Override
            public void start(Callback<Integer> callback) {
                callback.onSuccess(0);
            }
       }.map(new Func<Integer, String>() {
            @Override
            public String call(Integer integer) {
                return String.valueOf(integer+1);
            }
       }).flatMap(new Func<String,AsyncJob<Boolean>>(){

            @Override
            public AsyncJob<Boolean> call(final String s) {
                return new AsyncJob<Boolean>() {
                    @Override
                    public void start(Callback<Boolean> callback) {
                        if (s.equals("1")){
                            callback.onSuccess(true);
                        }
                    }
                };
            }
       }).start(new Callback<Boolean>() {
            @Override
            public void onSuccess(Boolean aBoolean) {
                System.out.println("数据下游结果:" + aBoolean);
            }

            @Override
            public void onError(Exception e) {
                System.out.println("数据下游Error:" + e);
            }
       });



//        AsyncJob<AsyncJob<String>> asyncJob = new Helper().getLabel("1:2:3:4:5:6");
//        // todo: 需要支持flatmap
//        asyncJob.start(new Callback<AsyncJob<String>>() {
//            @Override
//            public void onSuccess(AsyncJob<String> stringAsyncJob) {
//                stringAsyncJob.start(new Callback<String>() {
//                    @Override
//                    public void onSuccess(String s) {
//                        System.out.println("l:: " + s);
//                    }
//
//                    @Override
//                    public void onError(Exception e) {
//
//                    }
//                });
//            }
//
//            @Override
//            public void onError(Exception e) {
//
//            }
//        });
    }
}
