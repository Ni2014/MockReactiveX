package exam.splitToSolveCallbackHell;

/**
 * Created by 宸笙 on 2019/1/16.
 */
public abstract class AsyncJob<T> {

    public abstract void start(Callback<T> callback);

    public <R>AsyncJob<R> map(final Func<T,R> func){
        final AsyncJob<T> source = this;
        return new AsyncJob<R>() {
            @Override
            public void start(final Callback<R> callback) {
                source.start(new Callback<T>() {
                    @Override
                    public void onSuccess(T t) {
                        R mapped = func.call(t);
                        callback.onSuccess(mapped);
                    }

                    @Override
                    public void onError(Exception e) {
                        callback.onError(e);
                    }
                });
            }
        };
    }

    public <R> AsyncJob<R> flatMap(final Func<T,AsyncJob<R>> func){
        final AsyncJob<T> source = this;
        return new AsyncJob<R>() {
            @Override
            public void start(final Callback<R> callback) {
                source.start(new Callback<T>() {
                    @Override
                    public void onSuccess(T t) {
                        AsyncJob<R> mapped = func.call(t);
                        mapped.start(new Callback<R>() {
                            @Override
                            public void onSuccess(R r) {
                                callback.onSuccess(r);
                            }

                            @Override
                            public void onError(Exception e) {
                                callback.onError(e);
                            }
                        });
                    }

                    @Override
                    public void onError(Exception e) {
                        callback.onError(e);
                    }
                });
            }
        };
    }
}
