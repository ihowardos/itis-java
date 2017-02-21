import java.io.*;

/**
 * Created by Сергей on 31.12.2016.
 */
public class TestLog {
    public static void main(String[] args) {
        File f = new File("log.lg");
        try {
            f.createNewFile();
        } catch (IOException e) {}

        try {
            BufferedInputStream input = new BufferedInputStream(new ObjectInputStream(System.in));
            BufferedOutputStream output = new BufferedOutputStream(new ObjectOutputStream(System.out));

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

            String te = bufferedReader.readLine();
            System.out.println(te);

        } catch (IOException e) {}


    }
}
