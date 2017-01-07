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


    //198.House Robber
    public int rob(int[] nums) {
        int len = nums.length;
        if(len == 1){
            return nums[0];
        }else if(len == 2){
            return Math.max(nums[1],nums[0]);
        }else if(len == 0){
            return 0;
        }else{
            int prev1 = nums[0];
            int prev2 = Math.max(nums[1],nums[0]);
            for(int i = 2;i<len;i = i+1){
                int current = Math.max(prev2,prev1+nums[i]);
                prev1 = prev2;
                prev2 = current;
            }
            return prev2;
            
        }
    }
    //148.sort list
    //need to use merge sort
    public ListNode sortList(ListNode head) {

       if(head == null){
           return head;
       }else if (head.next == null){
           return head;
       }
       ListNode prev = head;
       ListNode head1 = head;
       ListNode head2 = head;
       while(head2!= null && head2.next != null){//check next & current 
           prev = head1;
           head1 = head1.next;
           head2 = head2.next.next;
       }
       System.out.println("here");
       prev.next = null;
       ListNode l1 = sortList(head);
       ListNode l2 = sortList(head1);
       return merge(l1,l2);
       
    }
    
    private ListNode merge(ListNode l1, ListNode l2){
        ListNode l = new ListNode(0);
        ListNode current = l;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                current.next = l1;
                l1 = l1.next;
            }else{
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }
        System.out.println("here2");
        if(l1 != null){
            current.next = l1;
        }else{
            current.next = l2;
        }
        return l.next;
    }


    //Best Time to buy and sell stock

    public int maxProfit(int[] prices){
        int len = prices.length;
        if (len == 0) {
            return 0;
        }
        int maxprofit = 0;
        int min = prices[0];
        for(int i = 0; i< len; i= i+1){
            if(prices[i] < min){
                min = prices[i];
            }else{
                int diff = prices[i] - min;
                if(diff > maxprofit){
                    maxprofit = diff;
                }
            }
        }
        return maxprofit;
    }


}