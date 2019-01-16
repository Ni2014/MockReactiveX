package exam.toAsync;

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

    interface HelperLabelCallback{
        void onLabel(String label);
        void onError(Exception e);
    }

    public void getLabel(String query, final HelperLabelCallback callback){
        api.getPersons(query, new Api.PersonsCallback() {
            @Override
            public void onReceived(List<Person> persons) {
                api.getLabel(findRishestPerson(persons), new Api.LabelCallback() {
                    @Override
                    public void onLabel(String label) {
                        callback.onLabel(label);
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
