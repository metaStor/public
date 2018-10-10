import java.io.BufferedReader;
import java.io.FileReader;

public class Statistics {

    private String target;

    public Statistics(String target) {
        this.target = target;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public long statistics() {
        long count = 0;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(this.target));
            while (reader.readLine() != null) {
                count += 1;
            }
            reader.close();
        } catch (Exception e) {
            System.out.println("Target_file does not exist!");
            return 0;
        }
        return count;
    }

}
