public class ex2 {
    public static void main(String[] args) {
        int total = 0;
        int[] sum = new int[51];

        sum[0] = 1;
        sum[1] = 1;
        sum[2] = 3;

        for (int i = 3; i < 51; i++) {
            sum[i] = sum[i - 3] + sum[i - 1];
        }

        for (int i = 0; i < 51; i++) {
            System.out.print(" " + sum[i]);
            if (sum[i] % 2 == 0) {
                total += sum[i];
            }
        }
    }
}