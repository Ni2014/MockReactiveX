package exam.toGenericCallback;

import java.util.List;

/**
 * Created by 宸笙 on 2019/1/16.
 */
public interface Api {

    void getPersons(String query, Callback<List<Person>> personsCallback);

    void getLabel(Person person, Callback<String> labelCallback);
}
