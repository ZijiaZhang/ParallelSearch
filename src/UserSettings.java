import com.sun.javafx.UnmodifiableArrayList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UserSettings {
    private static ArrayList<String> searchDomains =  new ArrayList<>();
    private static String searchString;


    public static List<String> getSearchDomains() {
        return Collections.unmodifiableList(searchDomains);
    }
    public static void addDomain(String url){
        searchDomains.add(url);
    }

    public static boolean removeDomain(String url){
        return searchDomains.remove(url);
    }

    public static String getSearchString(){
        return searchString;
    }

    public static void setSearchString(String string){
        searchString = string;
    }
}
