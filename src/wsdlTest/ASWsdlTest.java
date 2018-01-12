package wsdlTest;

import java.rmi.RemoteException;

import org.logink.ws.client.AuthenService.AuthenticationResult;
import org.logink.ws.client.AuthenService.IAuthenService;
import org.logink.ws.client.AuthenService.IAuthenServiceProxy;
import org.logink.ws.client.AuthenService.ServiceException;

public class ASWsdlTest {

	
		/**
		 * https方式调用webservice接口，导入证书步骤
		 * (需要使用的证书，已加入到certificate包下)
		 * 1、     获取加密数字证书
		 * 访问https://logink.org,根据提示安装证书，然后导出证书，例如导出为e:\ClientSoon.crt
		 * 2、     装jdk6.0以上版本
		 * 3、     执行keytool命令,生成keystore文件，例如e:\ClientSoon.keystore
		 * 输入命令：keytool -import -alias nciic -file e:\ClientSoon.crt -keystore e:\ClientSoon.keystore
		 * 4、     修改代码
		 * 在调用接口方法之前，添加如下代码：
		 * System.setProperty("javax.net.ssl.trustStore", "c://nciic.keystore"); 其中的c://nciic.keystore为keystorte文件存放目录
		 * System.setProperty("java.protocol.handler.pkgs","com.sun.net.ssl.internal.www.protocol");
		 * java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
		 * 
		 * 参考资料：
		 * http://www.cnblogs.com/enenen/p/6238504.html
		 */
	
	
	
	
	
		//认证结果对象
		static AuthenticationResult result = null;
		
		//认证的wsdl地址
		static String authWsdl = "https://logink.org/AuthenticationService/AuthenService";
		
		//
		private static IAuthenService auth = new IAuthenServiceProxy(authWsdl);
		
		//申请人
		private static String applicant = "19696";
		
		//申请令牌的物流交换代码
		private static String userid = "19696";
		
		//明文密码
		private static String password = "huyueying";
		
		//申请令牌的资源ID（校验令牌的资源ID）
		private static String resource = "493CA712371E0188E053C0A87F0C0188";
		
		//申请人令牌 ---申请令牌成功后，赋值
		private static String applicantToken = null;
		
		//用户令牌 ---申请令牌成功后，赋值
		private static String userToken = null;
		
		
		public static void main(String[] args) throws ServiceException, RemoteException {
			//申请令牌
			result = auth.authenticate(applicant, userid, password, resource);
			if(result != null && (result.getResultCode() == 100000)){
				applicantToken = result.getToken();
				userToken = result.getToken();
			}
			System.out.println("=========申请令牌结果=========");
			print(result);
			
			
			//校验令牌
			result = auth.isTokenValied(applicantToken, userToken, resource);
			System.out.println("=========校验令牌结果=========");
			print(result);
		}
		
		
		private static void print(AuthenticationResult result){
			if(result != null){
				System.out.println("resultCode: " + result.getResultCode());
				System.out.println("token: " + result.getToken());
				System.out.println("resource: " + result.getResource());
				System.out.println("userid: " + result.getUserid());
				System.out.println("isTokenValid: " + result.isTokenValied());
			}
			
		}
}
