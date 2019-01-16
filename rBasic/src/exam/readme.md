## MockReactiveX in Java

### About

* 推导RxJava的实现
* 还原实际使用map和flatMap的场景并实现类似的操作符功能
* 从最基础的同步Api到异步Api，再到响应式的流式Api解决CallHell问题；


### 一些用法

```java
        AsyncJob<List<Person>> personsAsyncJob1 = api.getPersons(query);
        AsyncJob<Person> richestAsyncJob1 = personsAsyncJob1.map(new Func<List<Person>, Person>() {
            @Override
            public Person call(List<Person> persons) {
                return findRishestPerson(persons);
            }
        });
        AsyncJob<String> labelAsyncJob1 = richestAsyncJob1.flatMap(new Func<Person, AsyncJob<String>>() {

            @Override
            public AsyncJob<String> call(Person person) {
                return api.getLabel(person);
            }
        });
        
```



```java
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

```

>  ^_^如果将AsyncJob替换为Observable，Callback替换为Subscriber或新增onComplete回调，是不是就眼熟了😄  
