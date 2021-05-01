import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// Ref: https://java2blog.com/java-8-collectors-examples/
public class CollectorsExample {
	public static void main(String[] args) {
		List<Integer> intList=Arrays.asList(10,20,30,40,50);
		
		//Counting
		Object count = intList.stream()
				.collect(Collectors.counting());
		System.out.println(count);
		
		//AveragingInt
		Double avg = intList.stream().collect(Collectors.averagingInt(e -> e));
		System.out.println(avg);
		
		avg = intList.stream().collect(Collectors.averagingInt(e -> e*e));
		System.out.println(avg);
		
		//joining
		List<String> nameList=Arrays.asList("Arpit","John","Martin");
		String joinedList = nameList.stream().collect(Collectors.joining(" || "));
		System.out.println(joinedList);
		
		joinedList = nameList.stream().collect(Collectors.joining("||", "A", "Z"));
		System.out.println(joinedList);
		
		//summingInt
		int sum = intList.stream().collect(Collectors.summingInt(e -> e));
		System.out.println(sum);
		
		sum = intList.stream().collect(Collectors.summingInt(e -> e*e));
		System.out.println(sum);
		
		//collectingAndThen
		String finalOp = nameList.stream().collect(Collectors.collectingAndThen(Collectors.joining("|"), e -> e.replace("A", "Z")));
		System.out.println(finalOp);
	}
}
