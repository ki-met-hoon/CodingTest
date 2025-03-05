import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nm = bufferedReader.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);

        int[] line = new int[n];
        for (int i = 0; i < n; i++) {
            line[i] = Integer.parseInt(bufferedReader.readLine());
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 0; j < line.length; j++) {
                if (j == line.length - 1) {
                    continue;
                }

                if (line[j] % i > line[j + 1] % i) {
                    int temp = line[j];
                    line[j] = line[j + 1];
                    line[j + 1] = temp;
                }
            }
        }

        for (int i : line) {
            bufferedWriter.write(String.valueOf(i));
            bufferedWriter.newLine();
        }

        bufferedWriter.flush();
    }
}
