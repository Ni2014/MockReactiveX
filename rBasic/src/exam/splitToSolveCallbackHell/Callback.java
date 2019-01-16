package exam.splitToSolveCallbackHell;

/**
 * Created by 宸笙 on 2019/1/16.
 */
public interface Callback<T> {

    void onSuccess(T t);
    void onError(Exception e);
}
