public class MostFreqentProblemSolution{
	//226. Invert Binary Tree
	public TreeNode invertTree (TreeNode root){
		if(root !=  null){
			TreeNode newleft = root.right;
			TreeNode newright = root.left;
			root.left = invertTree(newleft);
			root.right = invertTree(newright);
		}

		return root;
	}

	// 283. Move Zeroes
	//two pointer
	public void moveZeroes(int[] nums){
		int len = nums.length;
		for(int i = 0; i < len; i = i+1){
			if(nums[i] == 0){
				for (int j= i+1; j < len;j = j+1 ) {
					if (nums[j]!= 0) {
						int temp = nums[j];
						nums[j] = nums[i];
						nums[i] = temp;
						break;
					}
				}
			}
		}
	}


	//141.Linked List Cycle
	//two pointer one moves fast one moves slow. 
	//fast will always catch up slow one if there is a circular
	public boolean hasCycle(ListNode head) {
	    if(head==null) {
	        return false;
	        
	    }else{
	        ListNode fast = head;
	        ListNode slow = head;
	        while(fast.next != null && fast.next.next != null){
	            slow = slow.next;
	            fast = fast.next.next;
	            if(slow == fast){
	                return true;
	            }
	        }
	        return false;
	    }
        
    }


    //412.Fizz Buzz
    public List<String> fizzBuzz(int n){
    	List<String> list = new ArrayList<String>();
    	for (int i = 1;i <= n ;i = i+1 ) {
    		String str = "";
    		if (i%15 == 0) {
    			list.add("FizzBuzz");
    		}else if(i%5 == 0){
    			list.add("Buzz");
    		}else if(i%3 == 0){
    			list.add("Fizz");
    		}else{
    			list.add(Integer.toString(i));
    		}
    	}
    	return list;
    }
    //70.Climbing Stairs
    //Dynmaic programming
    public int climbStairs(int n){
    	if(n == 1){
    		return 1;
    	}else if(n == 2){
    		return 2;
    	}
    	int prev1 = 1;int prev2 = 2;
    	for (int i = 3;i <= n ;i = i+1 ) {    		
    		int temp = prev2;
    		prev2 = prev1+prev2;
    		prev1 = temp;
    	}
    	return prev2;
    }
    //66.plus one
    public int[] plusOne(int[]digits){
    	int len = digits.length;
    	for (int i = len-1;i>=0 ;i = i-1 ) {
    		if (digits[i]<9) {
    			digits[i] = digits[i]+1;
    			return digits;
    		}else{
    			digits[i] = 0;
    		}
    	}
    	
    	int[] ret = new int[len+1];
    	ret[0] = 1;
    	return ret;
    }
    //148.sort list
    //need to use merge sort
    public ListNode sortList(ListNode head) {
        
        ListNode head1 = head;
        while(head1 != null){
        	ListNode min = head1;
        	while(head2 != null){
        		if(head2.val < min.val){
        			min = head2;
        		}
        		head2 = head2.next;
        	}
        	int temp = min.val;
        	min.val = head1.val;
        	head1.val = temp;

        }
        return head;
    }

}