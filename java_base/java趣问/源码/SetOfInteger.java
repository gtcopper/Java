import java.util.*;

public class SetOfInteger{
	public static void main(String[] args){
		Random random = new Random(47);
		Set<Integer> set = new HashSet<Integer>();
		for(int i = 0;i < 10000;i++){
			set.add(random.nextInt(30));
		}
		System.out.println(set);
	}
}