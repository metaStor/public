import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class CopyFile {

    private String source;
    private String target;

    public CopyFile(String source, String target) {
        this.source = source;
        this.target = target;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public boolean copy() {
        try {
            File source_file = new File(this.source);
            File target_file = new File(this.target);
            // create the target directory
            if (!target_file.exists()) {
                target_file.mkdirs();
                target_file.delete();  // 删除最后一个多余到目录
                System.out.println("create the target directory successful!");
            }
            if (source_file.exists()) {
                int byteRead = 0;
                int byteSum = 0;
                byte[] buffer = new byte[1024];
                FileInputStream input = new FileInputStream(source_file);
                FileOutputStream output = new FileOutputStream(this.target);
                while ((byteRead = input.read(buffer)) != -1) {
                    byteSum += byteRead;
                    output.write(buffer);
                }
                System.out.println("Sum: " + byteSum);
                input.close();
                output.close();
            }
        } catch (Exception e) {
            System.out.println("Source_file or Target_file does not exist!");
//            e.printStackTrace();
            return false;
        }
        return true;
    }
}
