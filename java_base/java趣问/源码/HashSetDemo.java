import java.util.*;
public class HashSetDemo{
		public static void main(String[] args){
			Set<Integer> set = new HashSet<Integer>();
			for(int i = 0;i < 100;i++){
				set.add(i);
			}
			System.out.println(set);
		}
}
	