import edu.princeton.cs.algs4.StdOut;

public class Binomial {

    // slow recursive calls
    // N - num of trials
    // k - expected num of successes
    // p - probability of success
    // mathematically (N choose k) p^k (1-p)^N-k

    public static int count; 

    public static double binomial1(int N, int k, double p) { 
        count++;
        if (N==0 && k==0) {
            return 1.0;
        }
        if (N < 0 || k < 0) {
            return 0.0;
        }
        double res = (1.0 - p)*binomial1(N-1, k, p) + p*binomial1(N-1, k-1, p);
        return res;
    }

    // memoization
    public static double bionmial2(int N, int k, double p) {
        // create an empty 2d array with dim N+1, k+1
        double [][] b = new double[N+1][k+1];

        // base cases - iterate N times; set all the n row, 0 col values
        for (int i = 0; i <= N; i++) {
            b[i][0] = Math.pow(1.0 - p, i);
        }
        b[0][0] = 1.0;

        // recursive formula - i iterating over rows, j iterating over columns 
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= k; j++) {
                /*
                 * Here b[i-1][j-1] represents a previous term in the array wrt b[i][j]
                 * Recall that i represents number of trials, that must get consumed each iteration
                 * However recall that j represents number of successes k, and that only gets consumed if p is true
                 * Therefore in case of (1-p) "failure" then k does not decrement and therefore, b[i-1][j]
                 */
                b[i][j] = p * b[i-1][j-1] + (1.0 - p) * b[i-1][j];
            }
        }

        return b[N][k];
    }

    public static void main(String[] args){
        int N = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);
        double p = Double.parseDouble(args[2]);
        
        double res = binomial1(N, k, p);
        
        System.out.println(res);
        System.out.println(count);
    }
}

// Copyright © 2000–2019, Robert Sedgewick and Kevin Wayne. 
