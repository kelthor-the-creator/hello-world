package solutions.lab2;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicInteger;

public class TwoJobs implements Runnable {

	private static final int N = 10;
	private int id;

	private static final CyclicBarrier BARRIER = new CyclicBarrier(N);
	private static final AtomicInteger COUNTER = new AtomicInteger(0); 


	public TwoJobs(int id) {
		this.id = id;
	}

	@Override
	public void run() {
		firstJob();
		waitForOthersBarrier();
		// waitForOthersBusyLoop();
		secondJob();
	}

	public static void main(String[] args) {
		for (int i = 0; i < N; i++) {
			new Thread(new TwoJobs(i)).start();
		}
	}

	public void firstJob() {
		System.out.println("Thread " + id + ", first job done");
	}

	public void secondJob() {
		System.out.println("Thread " + id + ", second job done");
	}

	public void waitForOthersBarrier() {
		try {
			BARRIER.await();
		} catch (InterruptedException | BrokenBarrierException e) {
			e.printStackTrace();
		}
	}
	

	public void waitForOthersBusyLoop() {
		COUNTER.incrementAndGet(); 
		while (COUNTER.get()<N) {
			util.Lib.delay(100); 
		}
		
	}
}