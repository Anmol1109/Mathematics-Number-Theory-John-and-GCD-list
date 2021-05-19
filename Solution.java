import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer strToken = new StringTokenizer(reader.readLine());
        //StringTokenizer strToken = new StringTokenizer("1");
        int T = Integer.parseInt(strToken.nextToken());
        
        
        for(int testCount=0;testCount<T;testCount++)
        {    
            strToken = new StringTokenizer(reader.readLine());
            //strToken = new StringTokenizer("3");
            int N = Integer.parseInt(strToken.nextToken());
            
            int[] A = new int[N];
            int[] B = new int[N+1];
            
            strToken = new StringTokenizer(reader.readLine());
            //strToken = new StringTokenizer("5 10 5");
            for(int i=0;i<N;i++)
                A[i] = Integer.parseInt(strToken.nextToken());
            
            B[0] = A[0];
            B[N] = A[N-1];
            
            int gcd = 0;
            for(int i=1;i<N;i++)
            {    gcd = 0;
                gcd = findGcd(A[i-1], A[i]);
                B[i] = (A[i-1]*A[i])/gcd;
            }
            
            for(int i=0;i<N;i++)
                System.out.print(B[i] + " ");
            System.out.println(B[N]);
        }
    }
    
    public static int findGcd(int num1, int num2)
    {
        int remainder = 0;
        int min = 0, max = 0;
        if(num1<num2)
        {    min = num1;
            max = num2;
        }
        else
        {    min = num2;
            max = num1;
        }
        
        remainder = max%min;
        if(remainder == 0)
            return min;
        else
            return findGcd(min, remainder);
    }
}
