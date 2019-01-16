package exam.splitToSolveCallbackHell;

import java.util.Collections;
import java.util.List;

/**
 * Created by 宸笙 on 2019/1/16.
 */
public class Helper {

    Api api;

    public Helper(){
        api = new ApiImpl();
    }

    // AsyncJob<List<Person>> -> AsyncJob<Person> -> AsyncJob<String>
    public AsyncJob<String> getLabel(final String query){


        // v3 add use flatMap
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

        return labelAsyncJob1;
        // v2 use map
//        AsyncJob<List<Person>> personsAsyncJob0 = api.getPersons(query);
//        AsyncJob<Person> richestAsyncJob0 = personsAsyncJob0.map(new Func<List<Person>, Person>() {
//            @Override
//            public Person call(List<Person> persons) {
//                return findRishestPerson(persons);
//            }
//        });
//        AsyncJob<AsyncJob<String>> labelAsyncJob0 = richestAsyncJob0.map(new Func<Person, AsyncJob<String>>() {
//            @Override
//            public AsyncJob<String> call(Person person) {
//                return api.getLabel(person);
//            }
//        });
//
//        return labelAsyncJob0;

//        return new AsyncJob<String>(){
//
//            @Override
//            public void start(final Callback<String> callback) {
//                api.getPersons(query)
//                        .start(new Callback<List<Person>>() {
//                            @Override
//                            public void onSuccess(List<Person> persons) {
//                                api.getLabel(findRishestPerson(persons))
//                                        .start(new Callback<String>() {
//                                            @Override
//                                            public void onSuccess(String s) {
//                                                callback.onSuccess(s);
//                                            }
//
//                                            @Override
//                                            public void onError(Exception e) {
//                                                callback.onError(e);
//                                            }
//                                        });
//                            }
//
//                            @Override
//                            public void onError(Exception e) {
//                                callback.onError(e);
//                            }
//                        });
//            }
//        };
    }



    private Person findRishestPerson(List<Person> persons){
        return Collections.max(persons);
    }
}
