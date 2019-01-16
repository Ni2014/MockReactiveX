package exam.toAsync;

import java.util.List;

/**
 * Created by 宸笙 on 2019/1/16.
 */
public interface Api {
    interface PersonsCallback{
        void onReceived(List<Person> persons);
        void onError(Exception e);
    }

    interface LabelCallback{
        void onLabel(String label);
        void onError(Exception e);
    }
    
    void getPersons(String query,PersonsCallback personsCallback);

    void getLabel(Person person,LabelCallback labelCallback);
}
