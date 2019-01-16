package exam.splitToSolveCallbackHell;

import java.util.List;

/**
 * Created by 宸笙 on 2019/1/16.
 */
public interface Api {

    AsyncJob<List<Person>> getPersons(String query);

    AsyncJob<String> getLabel(Person person);
}
