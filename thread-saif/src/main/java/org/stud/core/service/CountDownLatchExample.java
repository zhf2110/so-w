package org.stud.core.service;

import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import lombok.extern.slf4j.Slf4j;

/**
 * @author zhangfeng542
 * @date 5/16/19
 */
@Slf4j
public class CountDownLatchExample {

	public static void main(String[] args) {
		final CountDownLatch countDownLatch = new CountDownLatch(2);

		ExecutorService service = Executors.newCachedThreadPool();

		for(int i = 0;i < 5;i++){
			service.execute(()->{
				try {
					Thread.sleep((int)Math.random()*1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				log.info(" 线程id为： {}",Thread.currentThread().getId());
				countDownLatch.countDown();
			});
		}

		try {
			countDownLatch.await();
			/**
			 * 等待时间，如果任务10秒内没有完成，则不再关心。
			 */
			//countDownLatch.await(10, TimeUnit.SECONDS);
			log.info("ok");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		service.shutdown();
	}

}
