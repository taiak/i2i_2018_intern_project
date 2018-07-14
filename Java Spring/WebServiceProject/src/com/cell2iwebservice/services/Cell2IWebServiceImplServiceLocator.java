/**
 * Cell2IWebServiceImplServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.cell2iwebservice.services;

public class Cell2IWebServiceImplServiceLocator extends org.apache.axis.client.Service implements com.cell2iwebservice.services.Cell2IWebServiceImplService {

    public Cell2IWebServiceImplServiceLocator() {
    }


    public Cell2IWebServiceImplServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public Cell2IWebServiceImplServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for Cell2iWebServiceImpl
    private java.lang.String Cell2iWebServiceImpl_address = "http://209.97.129.103:8080/Cell2iWebService/services/Cell2iWebServiceImpl";

    public java.lang.String getCell2iWebServiceImplAddress() {
        return Cell2iWebServiceImpl_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String Cell2iWebServiceImplWSDDServiceName = "Cell2iWebServiceImpl";

    public java.lang.String getCell2iWebServiceImplWSDDServiceName() {
        return Cell2iWebServiceImplWSDDServiceName;
    }

    public void setCell2iWebServiceImplWSDDServiceName(java.lang.String name) {
        Cell2iWebServiceImplWSDDServiceName = name;
    }

    public com.cell2iwebservice.services.Cell2IWebServiceImpl getCell2iWebServiceImpl() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(Cell2iWebServiceImpl_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getCell2iWebServiceImpl(endpoint);
    }

    public com.cell2iwebservice.services.Cell2IWebServiceImpl getCell2iWebServiceImpl(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.cell2iwebservice.services.Cell2IWebServiceImplSoapBindingStub _stub = new com.cell2iwebservice.services.Cell2IWebServiceImplSoapBindingStub(portAddress, this);
            _stub.setPortName(getCell2iWebServiceImplWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setCell2iWebServiceImplEndpointAddress(java.lang.String address) {
        Cell2iWebServiceImpl_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.cell2iwebservice.services.Cell2IWebServiceImpl.class.isAssignableFrom(serviceEndpointInterface)) {
                com.cell2iwebservice.services.Cell2IWebServiceImplSoapBindingStub _stub = new com.cell2iwebservice.services.Cell2IWebServiceImplSoapBindingStub(new java.net.URL(Cell2iWebServiceImpl_address), this);
                _stub.setPortName(getCell2iWebServiceImplWSDDServiceName());
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
        if ("Cell2iWebServiceImpl".equals(inputPortName)) {
            return getCell2iWebServiceImpl();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://services.cell2iwebservice.com", "Cell2iWebServiceImplService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://services.cell2iwebservice.com", "Cell2iWebServiceImpl"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("Cell2iWebServiceImpl".equals(portName)) {
            setCell2iWebServiceImplEndpointAddress(address);
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
