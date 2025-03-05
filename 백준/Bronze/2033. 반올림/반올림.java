import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(bufferedReader.readLine());
        int num = 10;

        while (n > num) {
            if (n % num >= num / 2) {
                n = n + num;
            }

            n -= (n % num);

            num *= 10;
        }

        bufferedWriter.write(String.valueOf(n));
        bufferedWriter.flush();
    }
}
