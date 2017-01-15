public class MathProblem{
	//263. ugly number

	public boolean isUgly(int num) {
        if (num == 1){
        	return true;
        }else if(num <= 0){
        	return false;
        }
        while(num%2 == 0){
        	num = num/2;
        }
        while(num%3 == 0){
        	num = num/3;
        }
        while(num%5 == 0)
        	num = num/5;
        return (num == 1);
    } 
    //204. count primes
    //Count the number of prime numbers less than a non-negative number, n
    public int countPrimes(int n){
    	if(n <= 2){
    		return 0;
    	}
    	boolean[] nonprime = new boolean[n];
    	int count = 0;//count for nonprime
    	for (int i = 2;i < n ; i = i+1) {		
    		if (nonprime[i] == false) {
    			count = count+1;
    			for (int j = 2;i*j < n ;j = j+1 ) {
    				nonprime[i*j] = true;
    			}
    		}
    	}
    	
    	return count;
    }

    //264. ugly number ii
    //An ugly number must be multiplied by either 2, 3, or 5 from a smaller ugly number.
    //The key is how to maintain the order of the ugly numbers. Try a similar approach of merging from three sorted lists: L1, L2, and L3.
    //Assume you have Uk, the kth ugly number. Then Uk+1 must be Min(L1 * 2, L2 * 3, L3 * 5).
    public int nthUglyNumber(int n){
    	int[] ugly = new int[n];
    	ugly[0] = 1;
        int num1 = 2;
        int num2 = 3;
        int num3 = 5;
        int index1 = 0;
        int index2 = 0;
        int index3 = 0;
        for (int i = 1;i < n ;i = i+1) {
            ugly[i]= Math.min(Math.min(num1,num2),num3);
            if (ugly[i] == num1) {
                index1 = index1+1;
                num1 = ugly[index1]*2;
            }
            if (ugly[i] == num2) {
                index2 = index2+1;
                num2 = ugly[index2]*3;
            }
            if (ugly[i] == num3) {
                index3 = index3+1;
                num3 = ugly[index3]*5;
            }
        }
        return ugly[n-1];
    	
    }

    //313. Super Ugly Number
    public int nthSuperUglyNumber(int n, int[] primes) {
        int len = primes.length;
        int[] ugly = new int[n];
        ugly[0] = 1;
        int[] index = new int[len];
        int[] prime_num = new int[len];
        for(int i = 0; i< len; i= i+1){
            prime_num[i] = primes[i];
        }
        for (int j = 1;j < n ;j = j+1 ) {
            int min = prime_num[0];
            for (int i = 1;i < len ;i = i+1 ) {
                min = Math.min(prime_num[i],min);
            }
            ugly[j] = min;
            for (int k = 0;k < len ;k = k+1 ) {
                
                if (prime_num[k] == ugly[j]) {
                    
                    index[k] = index[k]+1;
                    prime_num[k] = ugly[index[k]]* primes[k];
                    
                }
            }
            
            

        }

        return ugly[n-1];
    }

}