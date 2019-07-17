package com.wantup.callback;

/**
 * 回调测试
 * @ClassName: AsyncCallBackTest
 * @Description: 
 * @Author lgl
 * @DateTime 2019年7月17日 下午3:36:41
 */
public class AsyncCallBackTest {

	public static void main(String[] args) {
		
		Server server = new Server();
		Client client = new Client(server);
		
		client.sendMessage("Hello CallBack");
		
	}
	
}
