import java.util.Locale;
import java.util.ResourceBundle;

public class HelloLocale{
    public static void main(String[] args){
        Locale myLocale = Locale.getDefault(Locale.Category.FORMAT);
        System.out.println("Debug:\t" + myLocale.getDisplayCountry() + "  " + myLocale.getDisplayLanguage());
        ResourceBundle bundle = ResourceBundle.getBundle("hello", myLocale);
        System.out.println(bundle.getString("hello"));
    }

}
