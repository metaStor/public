import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashSet;

public class FindString {

    private String target;
    private String string;

    public FindString(String target, String string) {
        this.target = target;
        this.string = string;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public HashSet<String> find_string() {
        HashSet<String> result = new HashSet<String>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(this.target));
            String readline;
            while ((readline = reader.readLine()) != null) {
                if (readline.contains(this.string)) {
                    result.add(readline);
                }
            }
            reader.close();
        } catch (Exception e) {
            System.out.println("Target_file does not exist!");
            return null;
        }
        return result;
    }
}
