package exam.toGenericCallback;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 宸笙 on 2019/1/16.
 */
public class ApiImpl implements Api {


    @Override
    public void getPersons(String query, Callback<List<Person>> personsCallback) {
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
        personsCallback.onSuccess(persons);
    }


    @Override
    public void getLabel(Person person, Callback<String> labelCallback) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        labelCallback.onSuccess("best rich :" + person.getExitAmount());
    }

}
