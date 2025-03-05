import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder stringBuilder = new StringBuilder();

        String[] nm = bufferedReader.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);

        int[] line = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            line[i] = i;
        }

        for (int k = 0; k < m; k++) {
            String[] temp1 = bufferedReader.readLine().split(" ");
            int i = Integer.parseInt(temp1[0]);
            int j = Integer.parseInt(temp1[1]);

            for (int l = i; l <= (j + i) / 2; l++) {
                int temp = line[l];
                line[l] = line[(i + j) - l];
                line[(i + j) - l] = temp;
            }
        }

        for (int i = 1; i < line.length; i++) {
            stringBuilder.append(line[i]);
            stringBuilder.append(" ");
        }

        bufferedWriter.write(String.valueOf(stringBuilder));
        bufferedWriter.flush();
    }
}
