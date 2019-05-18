package org.stud.core.service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;
import lombok.extern.slf4j.Slf4j;

/**
 * @author zhangfeng542
 * @date 5/17/19
 */
@Slf4j
public class SemaphoreExample {


	public static void main(String[] args) {
		final Semaphore semaphore = new Semaphore(1);

		ReentrantLock lock ;

		ExecutorService service = Executors.newCachedThreadPool();

		for(int i = 0;i < 10;i ++){
			service.execute(()->{
				try {
					semaphore.acquire();
                    Thread.sleep(1000);
					log.info("信号量执行id： {}",Thread.currentThread().getId());
					semaphore.release();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			});
		}
	}


}
