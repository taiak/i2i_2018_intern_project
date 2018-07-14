package com.cell2iwebservice.services;

public class Cell2IWebServiceImplProxy implements com.cell2iwebservice.services.Cell2IWebServiceImpl {
  private String _endpoint = null;
  private com.cell2iwebservice.services.Cell2IWebServiceImpl cell2IWebServiceImpl = null;
  
  public Cell2IWebServiceImplProxy() {
    _initCell2IWebServiceImplProxy();
  }
  
  public Cell2IWebServiceImplProxy(String endpoint) {
    _endpoint = endpoint;
    _initCell2IWebServiceImplProxy();
  }
  
  private void _initCell2IWebServiceImplProxy() {
    try {
      cell2IWebServiceImpl = (new com.cell2iwebservice.services.Cell2IWebServiceImplServiceLocator()).getCell2iWebServiceImpl();
      if (cell2IWebServiceImpl != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)cell2IWebServiceImpl)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)cell2IWebServiceImpl)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (cell2IWebServiceImpl != null)
      ((javax.xml.rpc.Stub)cell2IWebServiceImpl)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.cell2iwebservice.services.Cell2IWebServiceImpl getCell2IWebServiceImpl() {
    if (cell2IWebServiceImpl == null)
      _initCell2IWebServiceImplProxy();
    return cell2IWebServiceImpl;
  }
  
  public boolean isAuthorized(java.lang.String userId, java.lang.String password) throws java.rmi.RemoteException{
    if (cell2IWebServiceImpl == null)
      _initCell2IWebServiceImplProxy();
    return cell2IWebServiceImpl.isAuthorized(userId, password);
  }
  
  public java.lang.String getUserInfo(java.lang.String userId) throws java.rmi.RemoteException{
    if (cell2IWebServiceImpl == null)
      _initCell2IWebServiceImplProxy();
    return cell2IWebServiceImpl.getUserInfo(userId);
  }
  
  public java.lang.String isConnected() throws java.rmi.RemoteException{
    if (cell2IWebServiceImpl == null)
      _initCell2IWebServiceImplProxy();
    return cell2IWebServiceImpl.isConnected();
  }
  
  public java.lang.String getTariffInfo(java.lang.String userId) throws java.rmi.RemoteException{
    if (cell2IWebServiceImpl == null)
      _initCell2IWebServiceImplProxy();
    return cell2IWebServiceImpl.getTariffInfo(userId);
  }
  
  public java.lang.String getUsageInfo(java.lang.String userId, java.lang.String infoType) throws java.rmi.RemoteException{
    if (cell2IWebServiceImpl == null)
      _initCell2IWebServiceImplProxy();
    return cell2IWebServiceImpl.getUsageInfo(userId, infoType);
  }
  
  public java.lang.String isDBConnected() throws java.rmi.RemoteException{
    if (cell2IWebServiceImpl == null)
      _initCell2IWebServiceImplProxy();
    return cell2IWebServiceImpl.isDBConnected();
  }
  
  public java.lang.String getInvoiceInfo(java.lang.String userId, int invoiceCount) throws java.rmi.RemoteException{
    if (cell2IWebServiceImpl == null)
      _initCell2IWebServiceImplProxy();
    return cell2IWebServiceImpl.getInvoiceInfo(userId, invoiceCount);
  }
  
  public boolean changeUserPassword(java.lang.String userId, java.lang.String password) throws java.rmi.RemoteException{
    if (cell2IWebServiceImpl == null)
      _initCell2IWebServiceImplProxy();
    return cell2IWebServiceImpl.changeUserPassword(userId, password);
  }
  
  
}