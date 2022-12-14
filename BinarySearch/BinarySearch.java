import java.util.Arrays;
import edu.princeton.cs.algs4.*;


public class BinarySearch
{
    public static int rank(int key, int[] a)
    {
        int lo = 0;
        int hi = a.length -1;
        int mid = lo + (hi - lo)/2;
        while (lo <= hi)
        {
            if (key > a[mid])
            {
                lo = mid + 1;
            }
            else if (key < a[mid])
            {
                hi = mid - 1;
            }
            else
            {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args)
    {
        //System.out.println("Hello world");
        In in = new In(args[0]);
        int[] whiteList = in.readAllInts();
        //System.out.println(Arrays.toString(whiteList));
        Arrays.sort(whiteList);
        //System.out.println("Sorted list for search");
        while(!StdIn.isEmpty()){
            int key = StdIn.readInt();
            System.out.println(key);
            if (rank(key, whiteList) == -1) {
                StdOut.println(key);
                break;
            }
        }
    }
}
