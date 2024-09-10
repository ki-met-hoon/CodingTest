import java.io.*;

class Main {
    private static int r;
    private static int c;
    private static int count;
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] nrc = br.readLine().split(" ");
        int N = Integer.parseInt(nrc[0]);
        r = Integer.parseInt(nrc[1]);
        c = Integer.parseInt(nrc[2]);
        count = 0;

        Z(0, 0, (int) Math.pow(2, N));
    }

    private static void Z(int x, int y, int n) throws IOException {
        int size = n / 2;

        if (n == 1) {
            bw.write(String.valueOf(count));
            bw.flush();
            return;
        }

        if (r < x + size && c < y + size) {
            Z(x, y, size);
        } else if (r < x + size && y + size <= c) {
            count += n * n / 4;
            Z(x, y + size, size);
        } else if (x + size <= r && c < y + size) {
            count += n * n / 4 * 2;
            Z(x + size, y, size);
        } else if (x + size <= r && y + size <= c) {
            count += n * n / 4 * 3;
            Z(x + size, y + size, size);
        }
    }
}
