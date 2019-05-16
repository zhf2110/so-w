package org.stud.core.service;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import lombok.extern.slf4j.Slf4j;

/**
 * @author zhangfeng542
 * @date 5/16/19
 */
@Slf4j
public class AQSExample {

	AbstractQueuedSynchronizer qu = new AbstractQueuedSynchronizer() {
		@Override
		protected boolean tryAcquire(int arg) {
			return super.tryAcquire(arg);
		}
	};

}
