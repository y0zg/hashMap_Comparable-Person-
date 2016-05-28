import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Person implements Comparable<Person>

{

	private String firsName;
	private String lastName;
	private UUID id;


	public Person(String firsName, String lastName, UUID id) {
		this.firsName = firsName;
		this.lastName = lastName;
		this.id = id;
	}

	@Override
	public int hashCode() {
		return 5;
	}

	@Override
	public int compareTo(Person person) {
		return this.id.compareTo(person.id);
	}


	private static final int LIMIT = 30000;


	public static void main(String[] args) {
		Person person = null;
		long start = System.currentTimeMillis();
		Map<Person, String> mymap = new HashMap<>();
		for (int i = 0; i < LIMIT; i++) {
			UUID randUUID = UUID.randomUUID();
			person = new Person("fn", "ln", randUUID);
			mymap.put(person, "comment" + i);
			System.out.println(mymap.get(person));
		}

		mymap.get(person);
		long stop = System.currentTimeMillis();

		System.out.println(stop - start + "msec");
	}
}
