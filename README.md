# Java-CallBack
通过 Java 模拟请求，客户端向服务端发送请求，服务端通过异步回调的方式进行响应，包括成功或失败，通过服务端的线程睡眠来进行模拟服务端处理数据和网络数据传输所消耗的时间。
​	可以使用 `node` 或 `Tomcat` 搭建一个简单的服务器，通过 `HttpURLConnection` 进行真实的网络请求

**回调接口**

```java
public class AsyncCallBackTest {

	public static void main(String[] args) {
		
		Server server = new Server();
		Client client = new Client(server);
		
		client.sendMessage("Hello CallBack");
		
	}
	
}
```

**客户端**

```java
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
```

**服务端**

```java
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
```
