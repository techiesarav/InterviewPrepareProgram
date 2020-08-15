
import java.util.ArrayList;
import java.util.List;

class Address{
	public Address(String city, int pincode) {
		this.city = city;
		this.pincode=pincode;
	}
	String city;
	int pincode;
}
 
final class Employee {

	private final String name;
	private final Address addr;
	private final List<Address> addresses;
	public Employee(String name, List<Address> addresses) {
		super();
		this.name = name;
		List<Address> tempAdd=new ArrayList<Address>();
		for (int i = 0; i < addresses.size(); i++) {
			tempAdd.add(addresses.get(i));
		}
		this.addresses = tempAdd;
	}
	public String getName() {
		return name;
	}
	public List<Address> getAddresses() {
		return new ArrayList<Address>(addresses);
	} 
}

public class ImmutableCheck {

	public static void main(String[] args) {
		Address addr = new Address("chen",123);
		List<Address> addrList = new ArrayList<>();
		addrList.add(addr);
		Employee emp = new Employee("sarav",addrList);
		System.out.println(emp.getAddresses());
		emp.getAddresses().add(new Address("chen",124));
		System.out.println(emp.getAddresses());
	}

}
