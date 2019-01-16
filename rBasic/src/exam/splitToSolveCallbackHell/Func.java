package exam.splitToSolveCallbackHell;

/**
 * Created by 宸笙 on 2019/1/16.
 */
public interface Func<T,R> {
    R call(T t);
}
