import java.util.Arrays;
import java.util.stream.Stream;

public class StreamEx {
	public static void main(String[] args) {
		Stream<Integer> stream = Stream.generate(() -> 5)
				.limit(5);
				stream.forEach(System.out::println);
				
		Stream<String> nameStream = Stream.of("mohan","john","vaibhav","amit");
		Stream<String> nameStartJ = nameStream.map(String::toUpperCase)
		                                    .peek(System.out::println)
		                                  .filter(s -> s.startsWith("J"));
		 
		System.out.println("Calling terminal operation: count");
		long count = nameStartJ.count();
		System.out.println("Count: "+ count);
		 
		int sum = Arrays.stream(new int[] {1,2,3})
		                .sum();
		
		System.out.println(sum);
	}
}
