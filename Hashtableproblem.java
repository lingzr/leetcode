public class Hashtableprobelm{
	//202. Happy number
	public boolean isHappy(int n){
		int slow = convertnum(n);
		int fast = convertnum(n);
		fast = convertnum(fast);
		while(fast != slow && slow != 1){
			slow = convertnum(slow);
			fast = convertnum(fast);
			fast = convertnum(fast);
			

		}
		return (slow == 1);
	}


	public int convertnum(int n){
			int number = n;
			int temp = 0;
			while(number >= 10){
				int digit = number%10;
				temp = digit*digit+temp;
				number = number/10;
			}
			temp = number*number+temp;
			number = temp;
			return number;
	}

	//49. Group Anagrams
	public List<List<String>> groupAnagrams(String[] strs){
		
        HashMap<String, List<String>> map = new HashMap<>();
		int len = strs.length;
		for (int i = 0;i < len ;i = i+1 ) {
			char[] strs_arr = strs[i].toCharArray();
			Arrays.sort(strs_arr);
			String str = String.valueOf(strs_arr);
			if (!map.containsKey(str)) {
				map.put(str,new ArrayList<>());
			}
			map.get(str).add(strs[i]);

		}
		
		List<List<String>> list = new ArrayList<>(map.values());
		return list;
	}

	//242. Valid Anagram
	public boolean isAnagram(String s, String t) {
		char[] s_char = s.toCharArray();
		char[] t_char = t.toCharArray();
		Arrays.sort(s_char);
		Arrays.sort(t_char);
		String new_s = String.valueOf(s_char);
		String new_t = String.valueOf(t_char);
		if (new_s.compareTo(new_t) == 0) {
			return true;
		}else {
			return false;
		}
        
    }
    //219. contains duplicate ii
    public boolean containsNearbyDuplicate(int[] nums, int k){
        HashMap<Integer,Stack<Integer>> map = new HashMap<>();
    	int len = nums.length;
    	for (int i = 0;i <  len;i = i+1 ) {
    		if (!map.containsKey(nums[i])) {
    			map.put(nums[i],new Stack<Integer>());
    		}else{
    			int j = map.get(nums[i]).peek();
    			if (i-j <= k) {
    				return true;
    			}
    		}
    		map.get(nums[i]).push(i);

    	}
    	return false;
    }

    //187. Repeated DNA Sequences
    public List<String> findRepeatedDnaSequences(String s) {
        HashMap<String, Integer> DNA_sequence = new HashMap<String,Integer>();
        HashMap<String,Integer> repeated_map = new HashMap<String,Integer>();
        List<String> list = new ArrayList<String>();
        int len = s.length();
        for (int j = 10;j <  len + 1; j = j+1) {// +1 due to substring
        	String sub_str = s.substring(j-10,j);
        	if (!DNA_sequence.containsKey(sub_str)) {
        		DNA_sequence.put(sub_str,0);
        	}else if (!repeated_map.containsKey(sub_str)) {
        		repeated_map.put(sub_str,0);
        		list.add(sub_str);
        	}
        	
        }
        return list;
    }

    //349. Intersection of Two Arrays
    public int[] intersection(int[] nums1, int[] nums2){
        HashSet<Integer> hset = new HashSet<Integer>();
    	int len = nums1.length;
    	for (int i = 0;i < len ;i = i+1 ) {
    		hset.add(nums1[i]);
    	}
    	int len2 = nums2.length;
    	ArrayList<Integer> list = new ArrayList<>();
    	for (int j = 0;j < len2 ;j = j+1 ) {
    		if (hset.remove(nums2[j])) {
    			list.add(nums2[j]);
    		}

    	}
    	int[] ret =  new int[list.size()];
    	for(int i = 0; i < ret.length; i =i+1){
    	    ret[i] = list.get(i);
    	}
    	return ret;
    }

    //347. Top Frequency Elements
    //use bucket sort
     public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> freq_table = new HashMap<>();
     	for (int num:nums) {
     	    if(!freq_table.containsKey(num)){
     	        freq_table.put(num,0);
     	    }else{
     		freq_table.put(num,freq_table.get(num)+1);
     	    }
     	}
     	List<Integer>[] bucket = new List[nums.length];
     	for (int key:freq_table.keySet()) {
     	    int freq = freq_table.get(key);
     	    if(bucket[freq] == null){
     	        bucket[freq] = new ArrayList<>();
     	    }
     		bucket[freq].add(key);
     	}
     	int len = bucket.length;
     	List<Integer> list= new ArrayList<>();
     	int counter = 0;
     	for (int i = len-1;i >= 0 ;i = i-1 ) {
     		if(bucket[i] != null){
     		    for(int j:bucket[i]){
     		        list.add(j);
     		        counter = counter+1;
     		        if(counter == k){
     		            i =-1;//break the for loop
     		            break;
     		            
     		        }
     		    }
     		    
     		}
     	}
     	return list;
        
    }

    //463. island perimeter
    public int islandPerimeter(int[][] grid) {
      int h = grid.length;
      int w = grid[0].length;
      int perimeter = 0;
      for (int i = 0;i < h ;i = i+1 ) {
        	for (int j = 0;j < w ;j = j+1 ) {
        		if (grid[i][j] == 1) {
        			if (i == 0|| grid[i-1][j] == 0) {
        				perimeter = perimeter+1;
        			}
        			if (j == 0 || grid[i][j-1] == 0) {
        				perimeter = perimeter+1;
        			}
        			if (i == h-1|| grid[i+1][j] == 0) {
        				perimeter = perimeter+1;
        			}
        			if (j == w-1|| grid[i][j+1] == 0) {
        				perimeter = perimeter+1;
        			}
        		}
        	}
        }
        return perimeter;  
    }


    //205. isomorphic Strings
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character,Integer> s_map = new HashMap<>();
        HashMap<Character,Integer> t_map = new HashMap<>();
        int s_len = s.length();
        int t_len = t.length();
        if(s_len != t_len){
        	return false;
        }
        for (int i = 0; i < s_len ;i = i+1 ) {
        	char s_char = s.charAt(i);
        	char t_char = t.charAt(i);
        	if(!s_map.containsKey(s_char)){
        		s_map.put(s_char,i);
        	}
        	int pos = s_map.get(s_char);
        	if (!t_map.containsKey(t_char)) {
        		t_map.put(t_char,i);
        	}
        	int pos2 = t_map.get(t_char);
        	if (pos != pos2) {
        		return false;
        	}
        	
        }
        return true;
    }

    //350. Intersection of Two Arrays II
        public int[] intersect(int[] nums1, int[] nums2) {
        	HashMap<Integer,Integer> hmap = new HashMap<>();
        	for (int num:nums1) {
        		if (!hmap.containsKey(num)) {
        			hmap.put(num,1);
        		}else{
        			hmap.put(num,hmap.get(num)+1);
        		}
        	}
        	ArrayList<Integer> list = new ArrayList<>();
        	for (int num:nums2) {
        		if (hmap.get(num) != null) {
        			list.add(num);
        			hmap.put(num,hmap.get(num)-1);
        			if (hmap.get(num) == 0) {
        				hmap.remove(num);
        			}
        		}
        	}
        	int[] ret_arr = new int[list.size()];
        	for (int i = 0; i < list.size();i = i+1) {
        		ret_arr[i] = list.get(i);
        	}
        	return ret_arr;

    	}

    	//290. word pattern
    	public boolean wordPattern(String pattern, String str) {
        	String[] str_arr = str.split(" ");
        	HashMap<Character, Integer> hpattern = new HashMap<>();
        	HashMap<String, Integer> hstr = new HashMap<>();
        	int len = pattern.length();
        	if(len  != str_arr.length){
        		return false;
        	}
        	for (int i = 0; i < len ;i = i+1 ) {
        		char pattern_char = patter.charAt(i);
        		if(!hpattern.containsKey(pattern_char)){
        			hpattern.put(pattern_char,i);
        		}
        		int pos = hpattern.get(pattern_char);
        		String substr = str_arr[i];
        		if (!hstr.containsKey(substr)) {
        			hstr.put(substr,i);
        		}
        		int pos2 = hstr.get(substr);
        		if (pos2 != pos) {
        			return false;
        		}

        	}
        	return true;
    	}

    	//299. Bulls and Cows
    	public String getHint(String secret, String guess) {
    		HashMap<Character,Integer> hmap = new HashMap<>();
    		int len = secret.length();
    		int bull = 0;
    		int cow = 0;//same length
    		ArrayList<Character> list = new ArrayList<>();
    		// for bull;
    		for (int i = 0;i < len ; i = i+1) {
    			char s_char = secret.charAt(i);
    			char g_char = guess.charAt(i);
    			if (s_char == g_char) {
    				bull = bull+1;
    			}else{
    				list.add(g_char);
    				if (!hmap.containsKey(s_char)) {
    				hmap.put(s_char,1);
	    			}else{
	    				hmap.put(s_char,hmap.get(s_char)+1);
	    			}
    			}    			
    		}
    		//for cow;
    		for (char g_str:list) {
    			if (hmap.get(g_str)!=null) {
    				cow = cow+1;
    				hmap.put(g_str,hmap.get(g_str)-1);
    				if (hmap.get(g_str) == 0) {
    					hmap.remove(g_str);
    				}
    			}

    		}

    		String ret = Integer.toString(bull)+"A"+Integer.toString(cow)+"B";
    		return ret;        
    	}


    	//166. Fraction to Recurring Decimal
    	//use remainder, if the remainder is the same, then it starts loop 
    	public String fractionToDecimal(int numerator, int denominator) {
    		int interger_part = numerator/denominator;
    		int decimal_part = numerator%denominator;
    		if (decimal_part == 0) {
    			return Integer.toString(interger_part);
    		}else{
    			String str = Integer.toString(interger_part);
    			str = str+".";
    			HashMap<Integer,Integer> hmap = new HashMap<>();
    			String decimal = "";
    			while(){
    				decimal_part = decimal_part*10;
    				decimal = decimal+Integer.toString(Math.abs(decimal_part/denominator));
    				decimal_part = decimal_part%denominator;


    			}

    		}
        
    	}

    	//389.Find the difference
    	//use add: bit manipulator
    	public char findTheDifference(String s, String t) {
	        int c = 0;
	        for (int i = 0;i < t.length() ;i = i+1 ) {
	        	c = c+t.charAt(i);
	        }
	        for (int j = 0;j < s.length() ;j = j+1 ) {
	        	c = c-s.charAt(j);
	        }
	        return (char)c;

    	}



}