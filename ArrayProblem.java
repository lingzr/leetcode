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
	//subproblem:
	public int maxSubArray(int[] nums){

	}

}