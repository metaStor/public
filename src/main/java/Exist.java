import java.io.File;

public class Exist {

    private String filePath;

    public Exist(String filePath) {
        this.filePath = filePath;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public boolean fileExist() {
        try {
            File file = new File(this.filePath);
            if (!file.exists()) {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    // delete file or directory
    public void deleteIt() {
        File file = new File(this.filePath);
        if (file.exists() && file.isFile()) {
            deleteFile(this.filePath);
        } else if (file.exists() && file.isDirectory()) {
            deleteDirectory(this.filePath);
        } else {
            System.out.println("nothing to delete!");
        }
    }

    public boolean deleteFile(String path) {
        File file = new File(path);
        if (file.delete()) {
            System.out.println("delete " + file.getAbsolutePath() + " successful!");
            return true;
        } else {
            System.out.println("delete " + file.getAbsolutePath() + " failed!");
            return false;
        }
    }

    public boolean deleteDirectory(String path) {
        File file = new File(path);
        File[] files = file.listFiles();
        boolean success = true;
        for (File file_temp : files) {
            if (file_temp.exists() && file_temp.isFile()) {
                success = deleteFile(file_temp.getAbsolutePath());
            } else if (file_temp.exists() && file_temp.isDirectory()) {
                success = deleteDirectory(file_temp.getAbsolutePath());
            }
            if (!success) {
                break;
            }
        }
        if (file.delete()) {
            System.out.println("delete " + file.getAbsolutePath() + " successful!");
            return true;
        } else {
            System.out.println("delete " + file.getAbsolutePath() + " failed!");
            return false;
        }
    }
}
