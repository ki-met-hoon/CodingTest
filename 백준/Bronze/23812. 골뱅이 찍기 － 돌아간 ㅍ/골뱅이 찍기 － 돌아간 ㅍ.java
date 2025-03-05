import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder stringBuilder = new StringBuilder();

        int n = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < 2; i++) {
            stringBuilder.append(oneSession(n));
            stringBuilder.append(twoSession(n));
        }

        stringBuilder.append(oneSession(n));

        bufferedWriter.write(String.valueOf(stringBuilder));
        bufferedWriter.flush();
    }

    private static StringBuilder oneSession(int n) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append("@");
            }

            for (int k = 0; k < n * 3; k++) {
                sb.append(" ");
            }

            for (int j = 0; j < n; j++) {
                sb.append("@");
            }

            sb.append("\n");
        }

        return sb;
    }

    private static StringBuilder twoSession(int n) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n * 5; j++) {
                sb.append("@");
            }

            sb.append("\n");
        }

        return sb;
    }
}
