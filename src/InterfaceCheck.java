
 class OverridenClass
{   
    public static void main(String[] args) 
    {
     Pritable objParent = new Parent();
     objParent.sysout();
//     objParent.displayName();    
    }
}

interface Pritable
{
    void sysout();
}

class Parent implements Pritable
{
    public void displayName() 
    {
     System.out.println("This is Parent Name");
    }

    public void sysout()
    {
        System.out.println("I am Printable Interfacein Parent Class");
    }
}


class Bar {
    public static void foo(Pritable p) {
        p.sysout();
//        p.displayName();
    }
}

public class InterfaceCheck {
    public static final void main(String[] args) {
//        Bar.foo(new Parent());
        Parent p =new child();
        p.displayName();
        child c =(child) new Parent();
        c.displayName();
    }
}

class child extends Parent{
	public void childMethod() {
		System.out.println("In Child Method");
	}
	
	 public void displayName() 
	    {
	     System.out.println("This is Child Name");
	    }
}
