import java.util.*;
class MyNum   // mutable class
{
	private int num;
	MyNum(int num)
	{
		this.num=num;
	}
	/*public void setNum(int num)
	{
		this.num=num;
	}*/
	public boolean equals(Object ob)
	{
		System.out.println("in equals method");
		return num==((MyNum)(ob)).num;
	}
	public int hashCode()
	{
		System.out.println("in hashCode method\t"+num);
		return num;
	}
}
public class ImmutableDemo1
{
	public static void main(String args[])
	{
		HashMap<MyNum,Integer> h1=new HashMap<MyNum,Integer>();

		MyNum m1=new MyNum(10);

		h1.put(m1,1000);

		System.out.println("Before Modifying");
		System.out.println(h1.get(m1));
		System.out.println(h1.containsKey(m1));
		
		//m1.setNum(12);
		System.out.println("\nEffect of using mutable object as a key .............\n");
		System.out.println("After Modifying");
		System.out.println(h1.get(m1));
		System.out.println(h1.containsKey(m1));
	}
}
/*
Note:- Generally you use a java.lang.Integer or a java.lang.String class as the key, which are immutable Java objects. If you define your own key class then it is a best practice to make the key class an immutable object (i.e. do not provide any setXXX() methods in your key class. 
e.g. In above case there shouldn't have been "setNum(…) method . 
If a programmer wants to insert a new key then he/she will always have to instantiate a new object (i.e. cannot mutate the existing key because immutable key object class has no setter methods).	
*/		
	