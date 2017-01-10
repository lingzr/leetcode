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
}