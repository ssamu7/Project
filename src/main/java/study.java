import java.util.Arrays;

public class study {
    public static void main(String[] args) {
        /*int[][] arr = {
                {5, 5, 5, 5, 5},
                {10, 10, 10, 10, 10},
                {20, 20, 20, 20, 20},
                {30, 30, 30, 30, 30},
        };

        int total = 0;
        float average = 0;
        float count = 0;

        for(int i = 0; i < arr.length; i++) {
            count += arr[i].length; //이게 더 효율
            for (int j = 0; j < arr[i].length; j++){
                // count++;
                total += arr[i][j];
                average = total / count;
            }
        }
        System.out.println("total = "+total);
        System.out.println("average = "+ average);*/


        /*int[] coinUnit = {500, 100, 50, 10};

        int money = 2680;
        System.out.println("money = "+money);

        int count = 0;
        for(int i=0; i<coinUnit.length; i++){
            if(money == 0) break;
            count = money / coinUnit[i];
            money = money % coinUnit[i];
            // money = money - count*coinUnit[i]
            System.out.println(coinUnit[i]+"원:"+count);
        }*/

        /*int[] ballArr = {1, 2, 3, 4, 5, 6, 7, 8, 9,};
        int[] ball3 = new int[3];

        for(int i=0; i<ballArr.length; i++){
            int j = (int)(Math.random()*ballArr.length);
            int tmp = 0;
            tmp = ballArr[i];
            ballArr[i] = ballArr[j];
            ballArr[j] = tmp;
        }
        ball3 = Arrays.copyOf(ballArr, 3);

        for(int i =0; i<ball3.length; i++)
            System.out.print(ball3[i]);*/


    }
}
