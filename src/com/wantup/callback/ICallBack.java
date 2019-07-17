package com.wantup.callback;

/**
 * 回调接口
 * @ClassName: CSCallBack
 * @Description: 
 * @Author lgl
 * @DateTime 2019年7月17日 下午2:26:58
 */
public interface ICallBack {
	
	/**
	 * 请求成功回调的方法
	 * @Title: success
	 * @Description: 
	 * @DateTime 2019年7月17日 下午2:28:03
	 */
	void success(int state);
	
	/**
	 * 请求失败回调的方法
	 * @Title: error
	 * @Description: 
	 * @Author lgl
	 * @DateTime 2019年7月17日 下午2:28:25
	 */
	void error(int state);

}
