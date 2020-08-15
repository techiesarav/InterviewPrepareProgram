
//static.normal,constru blo

public class BlockCheck {
	
	static {
		System.out.println("1");
	}
	BlockCheck(){
		System.out.println("3");
	}
	{
		System.out.println("2");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new BlockCheck();
	}

}
