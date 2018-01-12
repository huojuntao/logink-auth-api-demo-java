package restful;

import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSONObject;

/**
 * 统一认证restful接口改造
 * 
 * 依赖jar包：
 * httpclient-4.5.jar
 * httpcore-4.4.1.jar
 * fastjson-1.2.2.jar
 * commons-lang-2.6.jar
 * 
 * @date 2018-01-11
 *
 *
 */
public class RestTestNew {

	private static String baseUrl = "https://ssl.logink.org";
	
	private static String applyTokenUrl = "/authapi/rest/auth/apply?";
	
	private static String verifyTokenUrl = "/authapi/rest/auth/verify?";
	
	//申请令牌参数
	private static String userid = "物流交换代码";//获取物流交换代码：http://www.logink.org/col/col1240/index.html
	
	private static String password = "物流交换代码对应的密码";
	
	//该参数申请令牌及校验令牌共用
	private static String resource = "已开通服务的ID";
	
	//校验令牌参数
	private static String applicantToken = "";
	
	private static String userToken = "";
	
	private static String seperator = "&";
	
	private static int timeOut = 100000;
	
	public static void main(String[] args) {
		//公用部分
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("Accept", "application/json; charset=UTF-8");
		headers.put("Content-Type",  "application/json; charset=UTF-8");
		Map<String, String> querys = new HashMap<String, String>();
		String body = "";
		//申请令牌地址
		String applyTokenPath = applyTokenUrl + "userid=" + userid + seperator + "password=" + password + seperator + "resource=" + resource;
        try {
        	//申请令牌
			HttpResponse applyTokenResponse = HttpUtils.httpPost(baseUrl, applyTokenPath, timeOut, headers, querys, body);
			HttpEntity applyTokenEntity = applyTokenResponse.getEntity();
			String applyTokenResult = EntityUtils.toString(applyTokenEntity);
			JSONObject applyTokenJson = new JSONObject();
			applyTokenJson = JSONObject.parseObject(applyTokenResult);
			//申请令牌结果
			String applyToken = applyTokenJson.getString("token");
			String applyUserid = applyTokenJson.getString("userid");
			String applyResource = applyTokenJson.getString("resource");
			String applyResultCode = applyTokenJson.getString("resultCode");
			String applyTokenValied = applyTokenJson.getString("tokenValied");
			System.out.println("applyToken=" + applyToken + "\napplyUserid=" + applyUserid + "\napplyResource=" + applyResource + "\napplyResultCode=" + applyResultCode + "\napplyTokenValied=" + applyTokenValied);
			
			//校验令牌参数
			applicantToken = applyToken;
			userToken = applyToken;
			//校验令牌地址
			String verifyTokenPath = verifyTokenUrl + "applicantToken=" + applicantToken + seperator + "userToken=" + userToken + seperator + "resource=" + resource;
			HttpResponse verifyTokenResponse = HttpUtils.httpPost(baseUrl, verifyTokenPath, timeOut, headers, querys, body);
			HttpEntity verifyTokenEntity = verifyTokenResponse.getEntity();
			String verifyTokenResult = EntityUtils.toString(verifyTokenEntity);
			JSONObject verifyTokenJson = new JSONObject();
			verifyTokenJson = JSONObject.parseObject(verifyTokenResult);
			//校验令牌结果
			String verifyResultCode = verifyTokenJson.getString("resultCode");
			String verifyTokenValied = verifyTokenJson.getString("tokenValied");
			String verifyToken = verifyTokenJson.getString("token");
			String verifyUserid = verifyTokenJson.getString("userid");
			String verifyResource = verifyTokenJson.getString("resource");
			System.out.println("verifyToken=" + verifyToken + "\nverifyUserid=" + verifyUserid + "\nverifyResource=" + verifyResource + "\nverifyResultCode=" + verifyResultCode + "\nverifyTokenValied=" + verifyTokenValied);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		
	}
	
	
	
}
