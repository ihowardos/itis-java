import java.io.*;

/**
 * Created by ihowardos on 24.11.2015.
 */
public class Standings {
    public static void main(String[] args)
            throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("������� ���������� ���: ");
        int n = Integer.parseInt(in.readLine());
        String[][] a = new String[n][3];

        for (int i = 0; i < n; i++) {
            for(int j = 0; j<2; j++){
                System.out.println("������� �������� �������" + (j+1) + ":");
                a[i][j] = in.readLine();
            }
            System.out.println("������� ������� ���� �������1: ");
            int g1 = Integer.parseInt(in.readLine());
            System.out.println("������� ������� ���� �������2: ");
            int g2 = Integer.parseInt(in.readLine());
            System.out.println("������� ������� ����� = ");
            a[i][2] = Integer.toString(Math.abs(g1-g2));
            System.out.println(a[i][2]);

        }

    }
}
