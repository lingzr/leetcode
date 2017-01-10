//tag under array
public class ArrayProblem{
	//238 product of Array Self
	//forward & backward
	public int[] productExceptSelf(int[] nums){
		int len = nums.length;
		int[] ret = new int[len];
		ret[0] = 1;
		for (int i = 1; i < len;i = i+1 ) {
			ret[i] = ret[i-1]*nums[i-1];
		}
		int right = 1;
		for (int i = len-2;i>=0 ;i = i-1 ) {
			ret[i] = ret[i]*nums[i+1]*right;
			right = nums[i+1]*right;
		}
		return ret;
	}
	//53. Maximum Subarray
	//dynamic programming
	//subproblem:keep record max num and record the maxsubarray that contains a[i-1]
    public int maxSubArray(int[] nums) {
        int len = nums.length;
		int[] maxsubarray = new int[len];
		int max = nums[0];
		maxsubarray[0] = nums[0];
		System.out.println(maxsubarray[0]);
		for (int i = 1; i < len ; i = i+1 ) {
			maxsubarray[i] = (maxsubarray[i-1] > 0?maxsubarray[i-1]:0) + nums[i];
			max = Math.max(maxsubarray[i],max);
		}
		return max;
    }

    //217. contains duplicate
    public boolean containsDuplicate(int[] nums){
    	Arrays.sort(nums);
    	int len = nums.length;
    	for (int i = 1;i < len ;i = i+1 ) {
    		if (nums[i] == nums[i-1]) {
    			return true;
    		}
    	}
    	return false;
    }

    //122. Best Time to Buy and Sell Stock II
    //transaction as many as you want 
    public int maxProfit(int[] prices){
        int maxprofit = 0;
    	int len = prices.length;
    	if (len == 0) {
    		return maxprofit;
    	}
    	int i = 0;
    	while(i < len){
    		int j = i;
    		while(j+1 < len && (prices[j] > prices[j+1])){ j =j+1;}
    		int k = j+1;
    		while(k+1 < len && (prices[k] < prices[k+1])){ k = k+1;}
            if(k < len){
                maxprofit = maxprofit + prices[k] - prices[j];
            }
            i = k+1;
    	}
    	return maxprofit;
    }

    //153. Find Minimum in rotated sorted array
    //use range
    public int findMin(int[] nums){
        if (nums.length == 0){
            throw new IllegalArgumentException();
        }
        int start = 0;
        int end = nums.length-1;
        while(start < end){
            if(nums[start] < nums[end]){
                return nums[start];
            }else{
                int mid = (start+end)/2;
                if(nums[mid] >= nums[start]){
                    
                    start = mid+1;
                }else{
                    end = mid;
                }
            }
        }
        return nums[start];


    }

    //328. odd even linked list
    // divide into two list
    //even & odd
    public ListNode oddEvenList(ListNode head){
        if (head == null) {
            return head;
        }
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenhead = even;
        while(odd.next!= null && even.next != null){
            odd.next = odd.next.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }
        odd.next = evenhead;
        return head;

    }

    //118. pascal's triangle:
 //    [
 //     [1],
 //    [1,1],
 //   [1,2,1],
 //  [1,3,3,1],
 // [1,4,6,4,1]
// ]
    public List<List<Integer>> generate(int numRows){
        List<List<Integer>> pascal = new ArrayList<>();
        if (numRows == 0) {
            return pascal;
        }
        ArrayList<Integer> num_arr1 = new ArrayList<Integer>();
        num_arr1.add(1);
        pascal.add(num_arr1);
        for (int i = 2;i <= numRows ;i = i+1 ) {
            List<Integer> num_arr = new ArrayList<Integer>();
            List<Integer> num_pre_arr = pascal.get(i-2);
            int len = num_pre_arr.size();
            for(int j = 0;j < i; j = j+1){
                if (j-1 < 0) {
                    num_arr.add(1);
                }else if (j > len-1) {
                    num_arr.add(1);
                }else{
                    num_arr.add(num_pre_arr.get(j-1)+num_pre_arr.get(j));
                }
            }
            pascal.add(num_arr);

        }
        return pascal;
    }


    

}