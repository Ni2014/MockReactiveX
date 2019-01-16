package exam.splitToSolveCallbackHell;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 宸笙 on 2019/1/16.
 */
public class ApiImpl implements Api {

    @Override
    public AsyncJob<List<Person>> getPersons(final String query) {
        return new AsyncJob<List<Person>>() {
            @Override
            public void start(Callback<List<Person>> callback) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                List<Person> persons = new ArrayList<Person>();
                String[] split = query.split(":");
                for (int i = 0; i < split.length; i++) {
                    Person person = new Person();
                    person.setExitAmount(100 + i);
                    persons.add(person);
                }
                callback.onSuccess(persons);
            }
        };
    }


    @Override
    public AsyncJob<String> getLabel(final Person person) {
        return new AsyncJob<String>() {
            @Override
            public void start(Callback<String> callback) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                callback.onSuccess("best rich :" + person.getExitAmount());
            }
        };
    }


}
