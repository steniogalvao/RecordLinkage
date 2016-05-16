package br.com.vsg.recordlinkage.utils;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import br.com.vsg.recordlinkage.entities.Listing;
import br.com.vsg.recordlinkage.entities.Product;

/**
 * @author steniogalvao
 * 
 *         Create a thread pool preventing the time and memory overhead inherent
 *         in thread creation, it's used to reuse the threads in tasks
 */
public class ThreadPool {
	private static boolean finish = false;

	public static void main(List<Map<String, List<Listing>>> listingMap,
			List<Entry<String, List<Product>>> brandGroup) {
		ExecutorService executor = Executors.newFixedThreadPool(8);
		for (int i = 0; i < listingMap.size(); i++) {
			Runnable worker1 = new ThreadWord(listingMap.get(i), brandGroup.get(i));
			executor.execute(worker1);
		}
		executor.shutdown();
		while (!executor.isTerminated()) {
		}
		finish = true;
	}

	/**
	 * Signal about the end of process
	 * 
	 * @return boolean true when the process over
	 */
	public static boolean getFinish() {
		return finish;

	}

}