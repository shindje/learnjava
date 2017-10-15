package chapter11_Exception;

import java.util.logging.Level;
import java.util.logging.Logger;

public class MyLogger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Logger.getGlobal().setLevel(Level.OFF);	//if exists -> no output
		Logger logger = Logger.getGlobal();
		logger.fine("some");	// No output with level Fine
		logger.log(Level.INFO, "info text");
		logger.logp(Level.INFO, "my new class", "my new method", "message from my new");
		Thread.dumpStack();
		/*java.lang.Exception: Stack trace
			at java.lang.Thread.dumpStack(Thread.java:1336)
			at src.MyLogger.main(MyLogger.java:15)
		*/
	}

}
