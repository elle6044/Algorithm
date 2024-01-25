import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String num = br.readLine();
        int[] array = new int[num.length()];

        for (int i = 0; i < num.length(); i++) {
            int n = Character.getNumericValue(num.charAt(i));
            array[i] = n;
        }

        Arrays.sort(array);

        for (int i = 0; i < num.length(); i++) {
            bw.write((array[num.length() - i - 1])+"");
        }
        bw.close();
    }
}
