
class AA{
	private int i;
	
	private void methodOne() {
		System.out.println("AA one");
	}
	
    public void methodTwo() {
		
	}
    
    protected void methodThree() {
		
	}
}

class BB extends AA{
	
	//private method can be overrided with protected/public/private
	protected void methodOne() {
		System.out.println("BB one");
	}
	
	//public method can be overrided only with public method and can't changed to private/protected
	private void methodTwo() {
		System.out.println("BB two");
	}
	
	//Protected can be overrided with public/protected and can't changed to private
	private void methodThree() {
		System.out.println("BB three");	
		}
}

public class ModifierCheck {

	public static void main(String[] args) {
		BB b = new BB();
		b.

	}

}
