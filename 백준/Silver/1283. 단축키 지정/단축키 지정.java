import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        String[] sentence = new String[n];
        String key = "";
        int[][] index = new int[n][2];

        for (int i = 0; i < n; i++) {
            boolean isFix = false;
            sentence[i] = br.readLine();

            String[] words = sentence[i].split(" ");

            for (int j = 0; j < words.length; j++) {
                String character = String.valueOf(words[j].charAt(0));

                if (!key.toLowerCase().contains(character.toLowerCase())) {
                    key += character;
                    index[i][0] = j;
                    index[i][1] = 0;
                    isFix = true;
                    break;
                }
            }

            if (!isFix) {
                for (int j = 0; j < words.length; j++) {
                    String[] word = words[j].split("");

                    for (int k = 1; k < word.length; k++) {
                        if (!key.toLowerCase().contains(word[k].toLowerCase())) {
                            key += word[k];
                            index[i][0] = j;
                            index[i][1] = k;
                            isFix = true;
                            break;
                        }
                    }

                    if (isFix) {
                        break;
                    }
                }
            }

            if (!isFix) {
                index[i][0] = -1;
                index[i][1] = -1;
            }
        }

        for (int i = 0; i < n; i++) {
            String[] temps = sentence[i].split(" ");
            int wordSpace = index[i][0];
            int charSpace = index[i][1];

            for (int j = 0; j < temps.length; j++) {
                String[] temp = temps[j].split("");

                for (int k = 0; k < temp.length; k++) {
                    if (wordSpace == j && charSpace == k) {
                        sb.append("[");
                        sb.append(temp[k]);
                        sb.append("]");
                        continue;
                    }

                    sb.append(temp[k]);
                }

                sb.append(" ");
            }

            sb.append("\n");
        }

        bw.write(String.valueOf(sb));
        bw.flush();
    }
}
