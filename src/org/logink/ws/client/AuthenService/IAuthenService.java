/**
 * IAuthenService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.logink.ws.client.AuthenService;

public interface IAuthenService extends java.rmi.Remote {
    public org.logink.ws.client.AuthenService.AuthenticationResult isTokenValied(java.lang.String applicantToken, java.lang.String userToken, java.lang.String resource) throws java.rmi.RemoteException, org.logink.ws.client.AuthenService.ServiceException;
    public org.logink.ws.client.AuthenService.AuthenticationResult applyUserToken(java.lang.String applicant, java.lang.String userid, java.lang.String password, java.lang.String resource) throws java.rmi.RemoteException, org.logink.ws.client.AuthenService.ServiceException;
    public org.logink.ws.client.AuthenService.AuthenticationResult authWithEncryptedPwd(java.lang.String applicant, java.lang.String userid, java.lang.String encryptedPwd, java.lang.String resource) throws java.rmi.RemoteException, org.logink.ws.client.AuthenService.ServiceException;
    public org.logink.ws.client.AuthenService.AuthenticationResult authenticate(java.lang.String applicant, java.lang.String userid, java.lang.String password, java.lang.String resource) throws java.rmi.RemoteException, org.logink.ws.client.AuthenService.ServiceException;
    public org.logink.ws.client.AuthenService.AuthenticationResult isTokenValid(java.lang.String applicantToken, java.lang.String uid, java.lang.String userToken, java.lang.String serviceid) throws java.rmi.RemoteException;
}
