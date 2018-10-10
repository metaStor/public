import java.util.HashSet;

public class Main {

    static String Path = "/home/meta/shenhao/fstest/password";
    static String Source = "/etc/passwd";

    public static void question1() {
        System.out.println("Hello World!");
    }

    public static void question2() {
        Exist exist = new Exist(Path);
        if (exist.fileExist()) {
            exist.deleteIt();
        } else {
            System.out.println(exist.getFilePath() + " not exist!");
        }
    }

    public static void question3() {
        System.out.println("Start copy to " + Path);
        CopyFile copyFile = new CopyFile(Source, Path);
        if (copyFile.copy()) {
            System.out.println("Copy to " + Path + " successful!");
        }
    }

    public static void question4() {
        String content = "123456789";
        AppendToFile appendToFile = new AppendToFile(content, Path);
        if (appendToFile.appendToFile()) {
            System.out.println("Successful append '" + content + "' to " + Path);
        }
    }

    public static void question5() {
        Statistics statistics = new Statistics(Path);
        System.out.println(statistics.statistics());
    }

    public static void question6() {
        String string = "root";
        FindString findString = new FindString(Path, string);
        HashSet<String> result = findString.find_string();
        for (String line :
                result) {
            System.out.println(line);
        }
    }

    public static void main(String[] args) {
//        question1();
//        question2();
//        question3();
//        question4();
//        question5();
//        question6();
    }


}
