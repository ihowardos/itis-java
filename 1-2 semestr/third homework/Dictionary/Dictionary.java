import java.io.*;

/**
 * Created by ihowardos on 27.11.2015.
 */
public class Dictionary {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Word1: ");
        String word1 = reader.readLine();
        int k1 = word1.length();
        System.out.println("Word2: ");
        String word2 = reader.readLine();
        int k2 = word2.length();

        if(k1>=k2) {
    for (int i = 0; i < k2; i++) {
        char c1 = word1.charAt(i);
        char c2 = word2.charAt(i);
        if (c1 > c2){ System.out.println(word2); break;}
        if (c1 < c2) { System.out.println(word1); break; }
        if (c1 == c2) continue;

    }
}
        else {
    for (int i = 0; i < k1; i++) {
        char c1 = word1.charAt(i);
        char c2 = word2.charAt(i);
        if (c1 > c2) {
            System.out.println(word2);
            break;
        }
        if (c1 < c2) {
            System.out.println(word1);
            break;
        }
        if (c1 == c2) continue;
    }
}
    }
}
