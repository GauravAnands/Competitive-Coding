/*
*
* author @Gaurav Anand
*
*/
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//Source: https://www.hackerearth.com/tracks/pledge-2015-easy/dhoom-4/
class Dhoom4 {

    public static void main(String args[]) {

        Scanner in = new Scanner(System.in);

        int ownKey = in.nextInt();
        int lockKey = in.nextInt();

        int n = in.nextInt();
        int keys[] = new int[n];

        for (int i = 0; i < n; i++) {
            keys[i] = in.nextInt();
        }

        HashMap<Integer, Integer> time = new HashMap<Integer, Integer>();   // to store time taken
        time.put(ownKey, 0);

        Queue<Integer> q = new LinkedList<Integer>();     					       // to keep track of a visited combination

        q.add(ownKey);
        while (!q.isEmpty()) {
            int element = q.remove();

            if (element == lockKey) {									                    	// if we found the combination, return value from the hashmap
                System.out.println(time.get(element));
                return;
            }

            for (int i = 0; i < n; i++) {									                  // else create more initial keys
                long prod = (((long) element) * keys[i]) % 100000;

                if (!time.containsKey((int) prod)) {
                    time.put((int) prod, time.get(element) + 1);		      	// we store time 1 greater than previous sice we are going to next level.
                    q.add((int) prod);
                }
            }

        }

        System.out.println(-1);
    }

}
