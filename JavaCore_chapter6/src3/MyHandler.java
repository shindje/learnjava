package src3;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import com.sun.scenario.effect.Merge;

import sun.reflect.Reflection;

public class MyHandler implements InvocationHandler {

	MyHandler() {}
	
	/**
	 * @param args
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		MyHandler h = new MyHandler();
		
		h.toString();
		
		System.out.println("chek visible: " + Class.forName(ToBeProxied.class.getName()));
		System.out.println("chek visible: " + Class.forName(ToBeProxied.class.getName(), false, ClassLoader.getSystemClassLoader()));
		
		ToBeProxied proxy = (ToBeProxied)Proxy.newProxyInstance( ClassLoader.getSystemClassLoader(), new Class[]{ToBeProxied.class}, h);
		Object res = proxy.getF();
		Object check = proxy.hashCode();
		Object checkFinal = proxy.getClass();
		System.out.println("--proxy.getF(): " + res);
		
//		Comparable proxy = (Comparable)Proxy.newProxyInstance(null, new Class[]{Comparable.class}, h);
//		System.out.println("--proxy.invoke: " + proxy.compareTo(new Object(){}));
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("--handled actions: " + method.getName());
		return 0;	//if return null then will be NullPointerException
		//method.invoke(proxy /*Some REAL class*/, args);
	}
}