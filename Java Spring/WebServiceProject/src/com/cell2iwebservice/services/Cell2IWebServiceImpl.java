/**
 * Cell2IWebServiceImpl.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.cell2iwebservice.services;

public interface Cell2IWebServiceImpl extends java.rmi.Remote {
    public boolean isAuthorized(java.lang.String userId, java.lang.String password) throws java.rmi.RemoteException;
    public java.lang.String getUserInfo(java.lang.String userId) throws java.rmi.RemoteException;
    public java.lang.String isConnected() throws java.rmi.RemoteException;
    public java.lang.String getTariffInfo(java.lang.String userId) throws java.rmi.RemoteException;
    public java.lang.String getUsageInfo(java.lang.String userId, java.lang.String infoType) throws java.rmi.RemoteException;
    public java.lang.String isDBConnected() throws java.rmi.RemoteException;
    public java.lang.String getInvoiceInfo(java.lang.String userId, int invoiceCount) throws java.rmi.RemoteException;
    public boolean changeUserPassword(java.lang.String userId, java.lang.String password) throws java.rmi.RemoteException;
}
