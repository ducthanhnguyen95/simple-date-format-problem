import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

        private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
//    private static final ThreadLocal<SimpleDateFormat> dateFormat = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"));
//    private static final FastDateFormat  dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");

    public static void main(String[] args) {


        String dateStr = "2020-10-17T12:34:51";

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 10; i++) {
            executorService.submit(() -> {
                try {
//                    Date date = dateFormat.get().parse(dateStr);
                    Date date = dateFormat.parse(dateStr);
                    System.out.println("Successfully parsed: " + date);
                } catch (Exception e) {
                    System.out.println("Exception: ");
                    e.printStackTrace();
                }
            });
        }

        executorService.shutdown();
    }
}