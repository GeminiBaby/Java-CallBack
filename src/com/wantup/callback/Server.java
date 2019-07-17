package com.wantup.callback;

import java.util.Random;

/**
 * 模拟服务端返回响应结果
 * @ClassName: Server
 * @Description: 
 * @Author lgl
 * @DateTime 2019年7月17日 下午2:35:15
 */
public class Server {
	
	/**
	 * 响应成功的状态码
	 */
	private static final int RESPONSE_SUCCESS = 200;
	
	/**
	 * 响应失败的状态码
	 */
	private static final int RESPONSE_ERROR = 500;

	/**
	 * 处理结果并返回
	 * @Description: 
	 * @Author lgl
	 * @DateTime 2019年7月17日 下午2:57:50
	 */
	public void asyncGet(ICallBack callback, String msg) {
		
		System.out.println("服务端获取到客户端发送的消息为：" + msg);
		
		// 睡眠两秒钟，模拟服务器处理耗时任务
		try {
	        Thread.sleep(2 * 1000);
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }
		
		// 获取随机数,随机的响应成功或失败
		int randomNumber = createRandomNumber();
		randomNumber = randomNumber % 2;
		randomNumber = randomNumber & 0xff;
		if (randomNumber == 1) {
			System.out.println("服务端数据处理成功，返回成功状态 " + RESPONSE_SUCCESS);
			System.out.println("----------------------------");
			callback.success(RESPONSE_SUCCESS);
		} else {
			System.out.println("服务端数据处理失败，返回失败状态 " + RESPONSE_ERROR);
			System.out.println("----------------------------");
			callback.error(RESPONSE_ERROR);
		}
		
	}
	
	/**
	 * 生成随机数
	 * @Title: createRandomNumber
	 * @Description: 
	 * @DateTime 2019年7月17日 下午2:42:32
	 * @return	生成的随机数
	 */
	public int createRandomNumber() {
		
		Random random = new Random();
		// 产生 0 到 9 的随机数
		int i = random.nextInt(10);
		
		return i;
		
	}

}
