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
