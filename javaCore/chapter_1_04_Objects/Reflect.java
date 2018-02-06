package chapter_1_04_Objects;

import java.lang.reflect.*;

public class Reflect {

	/**
	 * @param args
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 * @throws NoSuchMethodException 
	 */
	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException, NoSuchMethodException {
		// TODO Auto-generated method stub
		Class c = Reflect.class;
		try {
			Field f = c.getField("i");	//ONLY PUBLIC!!!
			System.out.println("fi: " + f.getName() + " " + f.getType());
			System.out.println("fi value: " + f.get(new Reflect()));

			f = c.getDeclaredField("j");
			System.out.println("fj: " + f.getName() + " " + f.getType());
			
			System.out.println("fj is Public: " + Modifier.isPublic(f.getModifiers()));

			Class pc = PrivCl.class;
			f = pc.getDeclaredField("k");
			System.out.println("fk: " + f.getName() + " " + f.getType());
			System.out.println("fk is Private: " + Modifier.isPrivate(f.getModifiers()));
			//System.out.println("fk value: " + f.get(new Reflect()));	//IllegalAccessException!!!
			System.out.println("fk is Accessible: " + f.isAccessible());
			f.setAccessible(true);
			PrivCl p = new PrivCl();
			System.out.println("fk value: " + f.get(p));
			
			f.set(p, 55);
			System.out.println("fk value: " + f.get(p));
			
			
			long[] la = (long [])Array.newInstance(long.class, 3);
			System.out.println("la: " + la);
			System.out.println("la length: " + la.length);
			System.out.println("la length: " + Array.getLength(la));
			System.out.println("la is Array: " + la.getClass().isArray());
			la[0] = 4;
			System.out.println("la 0: " + Array.get(la, 0));
			Array.set(la, 0, 5);
			System.out.println("la 0: " + Array.get(la, 0));
			
			Method m = pc.getMethod("getK");
			System.out.println("m.getK: " + m.invoke(p));
			

			
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public int i = 5;

	private long j;
	
	int getI() {
		return i;
	}
	
	Reflect() {
		i = 3;
	}
	
	Reflect (int ii) {
		i = ii;
	}

}

class PrivCl {
	private long k = 3;
	
	public long getK() {
		return k;
	}
}
