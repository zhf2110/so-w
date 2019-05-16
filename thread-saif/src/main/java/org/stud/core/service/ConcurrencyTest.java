package org.stud.core.service;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import lombok.extern.slf4j.Slf4j;

/**
 * @author zhangfeng542
 * @date 5/16/19
 */
@Slf4j
public class ConcurrencyTest {

	private static int clientTotal = 1000;

	private static int threadTotal = 200;

	private static int count = 0;

	public static void main(String[] args) throws Exception{

		ExecutorService executorService = Executors.newCachedThreadPool();
		//信号量
		final Semaphore semaphore = new Semaphore(threadTotal);
		final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
		for(int i = 0;i < clientTotal;i++){
			executorService.execute(()->{
				try {
					semaphore.acquire();
					add();
					semaphore.release();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				countDownLatch.countDown();
			});
		}
		countDownLatch.await();
		executorService.shutdown();

		log.info("{}",count);
	}

	private static void add (){
		count ++;
	}

}
