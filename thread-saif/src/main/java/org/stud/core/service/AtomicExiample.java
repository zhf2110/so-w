package org.stud.core.service;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReference;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

/**
 * @author zhangfeng542
 * @date 5/16/19
 */
@Slf4j
public class AtomicExiample {

	private static AtomicIntegerFieldUpdater<AtomicExiample> updater = AtomicIntegerFieldUpdater.newUpdater(AtomicExiample.class,"cou");

	@Getter
	private volatile int cou = 0;



	private static AtomicReference<Integer> count = new AtomicReference<>(0);

	public static void main(String[] args) {
		count.compareAndSet(0,2); //如果是0,设置为2
		count.compareAndSet(0,1); //如果是0,设置为1,不执行


		log.info("coutn : {}",count.get());

		AtomicExiample atomicExiample = new AtomicExiample();

		updater.compareAndSet(atomicExiample,0,100);

		log.info("cou :{}",atomicExiample.getCou());

	}

}
