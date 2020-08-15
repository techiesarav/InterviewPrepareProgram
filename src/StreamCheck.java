import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamCheck {

	public static void main(String[] args) {
		List<List<String>> stringList = new ArrayList<>();
		List<String> strList = new ArrayList<>();

		strList.add("One flew over the cuckoo's nest");
		strList.add("To kill a muckingbird");
		strList.add("Gone with the wind");
		List<String> strList1 = new ArrayList<>();

		strList1.add("One");
		strList1.add("To ");
		strList1.add("Gone");
		stringList.add(strList);
		stringList.add(strList1);

		Stream<List<String>> stream = stringList.stream();

		/**Flat Map Example**/
		List<String> tr =stream.flatMap((value) -> {
		    return (Stream<String>) value.stream();
		}).collect(Collectors.toList());
		System.out.println(tr);
		
		/**Peek Function**/
		List<String> stringList2 = new ArrayList<String>();

		stringList2.add("abc");
		stringList2.add("def");

		Stream<String> stream1 = stringList2.stream();

		Stream<String> streamPeeked = stream1.peek((value) -> {
		    System.out.println("value");
		});
		List<String> stringList1 = new ArrayList<String>();

		stringList1.add("One flew over the cuckoo's nest");
		stringList1.add("To kill a muckingbird");
		stringList1.add("Gone with the wind");

		Stream<String> stream2 = stringList1.stream();

		Optional<String> reduced = stream2.reduce((value, combinedValue) -> {
		    System.out.println("sdf "+combinedValue);
			return combinedValue + " + " + value;
		});
		System.out.println(reduced.get());
		
	}

}
