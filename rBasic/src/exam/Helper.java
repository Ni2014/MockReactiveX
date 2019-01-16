package exam;

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

    public String getLabel(String query){
        List<Person> personList = api.getPersons(query);
        String label = api.getLabel(findRishestPerson(personList));
        return label;
    }

    private Person findRishestPerson(List<Person> persons){
        return Collections.max(persons);
    }
}
