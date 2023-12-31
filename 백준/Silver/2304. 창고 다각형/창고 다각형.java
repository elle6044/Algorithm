import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.TreeMap;

public class Main {
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        int N=nextInt();
        int[] heights = new int[1001];

        int maxIdx = 0;
        int maxHeight = 0;

        for (int i = 0; i < N; i++) {
            int idx = nextInt();
            int height = nextInt();

            heights[idx] = height;

            if (height > maxHeight) {
                maxHeight = height;
                maxIdx = idx;
            }
        }

        int area = 0;
        int leftHeight = 0;
        for (int i = 0; i <= maxIdx; i++) {
            leftHeight = Math.max(leftHeight, heights[i]);
            area += leftHeight;
        }

        int rightHeight = 0;
        for (int i = 1000; i > maxIdx; i--) {
            rightHeight = Math.max(rightHeight, heights[i]);
            area += rightHeight;
        }

        bw.write(area+"");
        bw.close();
    }

    static int nextInt() throws Exception {
        int sign = 0;
        int n = 0;
        int c;
        while ((c = System.in.read()) <= 32);
        if(c == 45) {
            sign = 1;
            c = System.in.read();
        }
        do n = (n << 3) + (n << 1) + (c & 15);
        while ((c = System.in.read()) > 47 && c < 58);
        return sign == 0 ? n : ~n + 1;
    }

}
