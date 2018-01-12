package org.logink.ws.client.AuthenService;

public class IAuthenServiceProxy implements org.logink.ws.client.AuthenService.IAuthenService {
  private String _endpoint = null;
  private org.logink.ws.client.AuthenService.IAuthenService iAuthenService = null;
  
  public IAuthenServiceProxy() {
    _initIAuthenServiceProxy();
  }
  
  public IAuthenServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initIAuthenServiceProxy();
  }
  
  private void _initIAuthenServiceProxy() {
    try {
      iAuthenService = (new org.logink.ws.client.AuthenService.IAuthenServiceServiceLocator()).getIAuthenServicePort();
      if (iAuthenService != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)iAuthenService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)iAuthenService)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (iAuthenService != null)
      ((javax.xml.rpc.Stub)iAuthenService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public org.logink.ws.client.AuthenService.IAuthenService getIAuthenService() {
    if (iAuthenService == null)
      _initIAuthenServiceProxy();
    return iAuthenService;
  }
  
  public org.logink.ws.client.AuthenService.AuthenticationResult isTokenValied(java.lang.String applicantToken, java.lang.String userToken, java.lang.String resource) throws java.rmi.RemoteException, org.logink.ws.client.AuthenService.ServiceException{
    if (iAuthenService == null)
      _initIAuthenServiceProxy();
    return iAuthenService.isTokenValied(applicantToken, userToken, resource);
  }
  
  public org.logink.ws.client.AuthenService.AuthenticationResult applyUserToken(java.lang.String applicant, java.lang.String userid, java.lang.String password, java.lang.String resource) throws java.rmi.RemoteException, org.logink.ws.client.AuthenService.ServiceException{
    if (iAuthenService == null)
      _initIAuthenServiceProxy();
    return iAuthenService.applyUserToken(applicant, userid, password, resource);
  }
  
  public org.logink.ws.client.AuthenService.AuthenticationResult authWithEncryptedPwd(java.lang.String applicant, java.lang.String userid, java.lang.String encryptedPwd, java.lang.String resource) throws java.rmi.RemoteException, org.logink.ws.client.AuthenService.ServiceException{
    if (iAuthenService == null)
      _initIAuthenServiceProxy();
    return iAuthenService.authWithEncryptedPwd(applicant, userid, encryptedPwd, resource);
  }
  
  public org.logink.ws.client.AuthenService.AuthenticationResult authenticate(java.lang.String applicant, java.lang.String userid, java.lang.String password, java.lang.String resource) throws java.rmi.RemoteException, org.logink.ws.client.AuthenService.ServiceException{
    if (iAuthenService == null)
      _initIAuthenServiceProxy();
    return iAuthenService.authenticate(applicant, userid, password, resource);
  }
  
  public org.logink.ws.client.AuthenService.AuthenticationResult isTokenValid(java.lang.String applicantToken, java.lang.String uid, java.lang.String userToken, java.lang.String serviceid) throws java.rmi.RemoteException{
    if (iAuthenService == null)
      _initIAuthenServiceProxy();
    return iAuthenService.isTokenValid(applicantToken, uid, userToken, serviceid);
  }
  
  
}