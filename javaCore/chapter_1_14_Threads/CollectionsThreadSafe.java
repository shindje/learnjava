package chapter14_Threads;

import java.util.*;
import java.util.concurrent.*;

public class CollectionsThreadSafe {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List l = new CopyOnWriteArrayList<>();
		Set s = new CopyOnWriteArraySet<>();
		
		List<Long> syncList = Collections.synchronizedList(new ArrayList<Long>());	//Все действия синхронизированы, кроме действий с итератором!
		Iterator i = syncList.iterator(); // Must be manually synched by user!
		
		Map syncMap = Collections.synchronizedMap(new HashMap());
	}

}
