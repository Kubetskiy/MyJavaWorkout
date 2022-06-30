import java.util.Scanner;

public class RaceStart {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
//        System.out.println("%2:%2:%2",t/3600, (t%3600)/60, t%60);
        System.out.printf("%2d:%02d:%02d",t/3600, (t%3600)/60, t%60);
/*
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    long input = scanner.nextLong() * 1000;
    Date date = new Date(input);
    SimpleDateFormat format = new SimpleDateFormat("H:mm:ss");
    String result = format.format(date);
    System.out.println(result);
  }
}
*/

    }
}
