import java.io.*;
import java.util.*;

public class Main
{
	public static void main(String[] args) throws IOException
	{
		try{
		 A.sc();
		}catch(Exception e){
			return;
		}
	}
}
	class A	
	{
		 
	    static class write{
		static void on(Object msg) {
			System.out.println(msg);
		}
	}
	    int i=10;
	    static 
	    {
	        write.on("I am static A");
	        
	    }
	    {
	        write.on("I am {} A");
	    }
	    public A()
	    {
	    	this.i=10;
	        write.on("I am parameterised A");
	    }
	    public A(int i)
	    {
	        this.i=i;
	        write.on("I am parameterised constructor A");
	    }
	    void function()
	    {
	        write.on("I am function A");
	    }
	    public static void sc() 
	    {
	        System.out.println("__________________1");
	        A a = new F(10);
	        System.out.println("__________________2");
	        a.function();
	        System.out.println("__________________3");
	        write.on(a.i);
	        System.out.println("__________________4");
	        a=new A();
	        System.out.println("__________________5");
	        write.on(a.i);
	        System.out.println("__________________6");
	        write.on(B.i);
	        System.out.println("__________________7");
	        write.on(C.D.i);
	        System.out.println("__________________8");
	        F f=new F(10);
	        System.out.println("__________________9");
	        F.H b=f.new H();
	        System.out.println("__________________10");
	        b.function();
	        System.out.println("__________________11");
	        F.G c=f.new G();
	        System.out.println("__________________12");
	        write.on(c.i ); 
	        System.out.println("__________________13");
	    }
	}
	
	class B extends A
	{
	   static int i;
	   static 
	    {
		    i = i+10;
	        write.on("I am static B");
	    } 
	    {
	        write.on("I am {} B");
	    }
	    B(){
	    	super(i+20);
	    	this.i=10;
	    	write.on("I am constructor B");
	    }
	}
	class C extends B
	{
		C(){
			super();
		}
		C(int i){
			super();
			this.i =i;
		}
	    static 
	    {
	        write.on("I am static C");
	    }
	    {
	        write.on("I am {} C");
	    }
	    static class D
	    {
			public static int i =50;
	        
	    }
	    class E
	    {
	    	{
	    		new C();
	    	}
	    }
	}
	class F extends C
	{
		int i;
		F(){
		}
		F(int i){
			super(i+10);
			this.i=i+20;
		}
	    static 
	    {
	        write.on("I am static F");
	    }
	    class H extends D
	    {
	
			public void function() {
				write.on("I am function C.D");
				
			}
	    
	    }
	    class G extends E 
	    {
	
			public int i =60;
	    
	    }
	}