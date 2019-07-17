package com.wantup.callback;

/**
 * 模拟客户端发送请求
 * @ClassName: Client
 * @Description: 
 * @Author lgl
 * @DateTime 2019年7月17日 下午2:34:31
 */
public class Client implements ICallBack {

	private Server server;
	
	public Client(Server server) {
		
		this.server = server;
	
	}
	
	/**
	 * 发送请求
	 * @Title: sendMessage
	 * @Description: 
	 * @DateTime 2019年7月17日 下午3:22:31
	 */
	public void sendMessage(String msg) {
		
		System.out.println("客户端发送的消息为：" + msg);
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				
				server.asyncGet(Client.this, msg);
				
			}
		}).start();
		
		System.out.println("客户端发送消息成功");
		System.out.println("----------------------------");
		
	}
	
	@Override
	public void success(int result) {
		
		System.out.println("服务端回调成功，状态码 " + result);
		System.out.println("----------------------------");
		
	}

	@Override
	public void error(int result) {
		
		System.out.println("服务端回调失败，状态码 " + result);
		System.out.println("----------------------------");
		
	}

}
