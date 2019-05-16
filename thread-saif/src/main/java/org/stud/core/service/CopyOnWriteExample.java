package org.stud.core.service;

import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import lombok.extern.slf4j.Slf4j;

/**
 * @author zhangfeng542
 * @date 5/16/19
 */
@Slf4j
public class CopyOnWriteExample {


	private final CopyOnWriteArrayList<String> stroe = new CopyOnWriteArrayList<>();

	private final CopyOnWriteArraySet set = new CopyOnWriteArraySet();

	ConcurrentSkipListSet listSet = new ConcurrentSkipListSet();

	private void init(){
		for(int i = 0 ;i < 100;i ++){
			stroe.add("xxxx"+i);
		}
	}

	private void read(){
		int loop = 200;
		for(int i = 0;i < loop;i ++){
			log.info(" read : {}",stroe.get(i));
		}
	}


	private void write(String va){
		stroe.add(va);
	}


	public static void main(String[] args) {
		final CopyOnWriteExample example = new CopyOnWriteExample();
		example.init();
		ExecutorService service = Executors.newCachedThreadPool();
		service.execute(()->{
			example.read();
		});

		service.execute(()->{
			for(int i= 0;i < 100;i ++){
				example.write("yyyy"+i);
			}
		});
	}

}
