package exam;

import java.util.List;

/**
 * Created by 宸笙 on 2019/1/16.
 */
public interface Api {
    List<Person> getPersons(String query);

    String getLabel(Person person);
}
