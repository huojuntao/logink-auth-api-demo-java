/**
 * IAuthenServiceServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.logink.ws.client.AuthenService;

public class IAuthenServiceServiceLocator extends org.apache.axis.client.Service implements org.logink.ws.client.AuthenService.IAuthenServiceService {

    public IAuthenServiceServiceLocator() {
    }


    public IAuthenServiceServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public IAuthenServiceServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for IAuthenServicePort
    private java.lang.String IAuthenServicePort_address = "http://logink.org:80/AuthenticationService/AuthenService";

    public java.lang.String getIAuthenServicePortAddress() {
        return IAuthenServicePort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String IAuthenServicePortWSDDServiceName = "IAuthenServicePort";

    public java.lang.String getIAuthenServicePortWSDDServiceName() {
        return IAuthenServicePortWSDDServiceName;
    }

    public void setIAuthenServicePortWSDDServiceName(java.lang.String name) {
        IAuthenServicePortWSDDServiceName = name;
    }

    public org.logink.ws.client.AuthenService.IAuthenService getIAuthenServicePort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(IAuthenServicePort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getIAuthenServicePort(endpoint);
    }

    public org.logink.ws.client.AuthenService.IAuthenService getIAuthenServicePort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            org.logink.ws.client.AuthenService.IAuthenServiceServiceSoapBindingStub _stub = new org.logink.ws.client.AuthenService.IAuthenServiceServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getIAuthenServicePortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setIAuthenServicePortEndpointAddress(java.lang.String address) {
        IAuthenServicePort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (org.logink.ws.client.AuthenService.IAuthenService.class.isAssignableFrom(serviceEndpointInterface)) {
                org.logink.ws.client.AuthenService.IAuthenServiceServiceSoapBindingStub _stub = new org.logink.ws.client.AuthenService.IAuthenServiceServiceSoapBindingStub(new java.net.URL(IAuthenServicePort_address), this);
                _stub.setPortName(getIAuthenServicePortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("IAuthenServicePort".equals(inputPortName)) {
            return getIAuthenServicePort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://client.ws.logink.org/AuthenService", "IAuthenServiceService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://client.ws.logink.org/AuthenService", "IAuthenServicePort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("IAuthenServicePort".equals(portName)) {
            setIAuthenServicePortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
