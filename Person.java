import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Person implements Comparable<Person>

{

	private String firsName;
	private String lastName;
	private UUID id;

	//create an object of Person
	private static Person personInstance = new Person();

	//make the constructor private so that this class cannot be
	//instantiated
	private Person() {
	}

	//Get the only object available
	public static Person getPersonInstance() {
		return personInstance;
	}

	private void fillAndSearch() {
		Person person = null;
		Map<Person, String> mymap = new HashMap<>();
		for (int i = 0; i < LIMIT; i++) {
			UUID randomUUID = UUID.randomUUID();
			person = new Person("fn", "ln", randomUUID);
			mymap.put(person, "comment" + i);
			System.out.println(mymap.get(person));
		}
		long start = System.currentTimeMillis();
		mymap.get(person);
		long stop = System.currentTimeMillis();

		System.out.println(stop - start + " millis #1");
	}

	//end new <code>

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
		long start = System.currentTimeMillis();
		Person persobject = Person.getPersonInstance();
		persobject.fillAndSearch();
		long stop = System.currentTimeMillis();
		System.out.println(stop - start + " millis #2");
	}
}
