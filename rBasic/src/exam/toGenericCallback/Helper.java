package exam.toGenericCallback;

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


    public void getLabel(String query, final Callback<String> callback){
        api.getPersons(query, new Callback<List<Person>>() {
            @Override
            public void onSuccess(List<Person> persons) {
                api.getLabel(findRishestPerson(persons), new Callback<String>() {
                    @Override
                    public void onSuccess(String s) {
                        callback.onSuccess(s);
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


    private Person findRishestPerson(List<Person> persons){
        return Collections.max(persons);
    }
}
