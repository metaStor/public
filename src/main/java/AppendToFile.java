import java.io.File;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;

public class AppendToFile {

    private String content;
    private String target;

    public AppendToFile(String content, String target) {
        this.content = content;
        this.target = target;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public boolean appendToFile() {
        // add a Enter
        this.content = "\n" + this.content;
        try {
            RandomAccessFile target_file = new RandomAccessFile(new File(this.target), "rw");
            long file_lenth = target_file.length();
            target_file.seek(file_lenth);
            byte[] buffer = this.content.getBytes();
            target_file.write(buffer);
            target_file.close();
        } catch (Exception e) {
            System.out.println("Target_file does not exist!");
        }
        return true;
    }
}
