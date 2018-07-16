package com.example.zeynep.cell2i.service;


import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

/**
 * Created by rumey on 5.07.2018.
 */
public class ServiceManager {
    static SoapObject soapObject;
    static SoapSerializationEnvelope soapSerializationEnvelope;
    static HttpTransportSE httpTransportSE;
    public static String changeUserPassword(String phoneNumber, String password) {
        String METHOD_NAME = "changeUserPassword";
        String NAMESPACE = "http://209.97.129.103:8080/Cell2iWebService/services/Cell2iWebServiceImpl?wsdl";
        String SOAP_ACTION = "http://209.97.129.103:8080/Cell2iWebService/services/Cell2iWebServiceImpl?wsdl/" + METHOD_NAME;
        final String URL = "http://209.97.129.103:8080/Cell2iWebService/services/Cell2iWebServiceImpl?wsdl";
        String returnedData = "";
        soapObject = new SoapObject(NAMESPACE, METHOD_NAME);
        soapSerializationEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        soapSerializationEnvelope.dotNet = true;
        soapSerializationEnvelope.setOutputSoapObject(soapObject);
        soapObject.addProperty("phoneNumber", phoneNumber);
        soapObject.addProperty("password", password);
        httpTransportSE = new HttpTransportSE(URL);
        httpTransportSE.debug = true;
        try {
            httpTransportSE.call(SOAP_ACTION, soapSerializationEnvelope);
            SoapPrimitive soapPrimitive = (SoapPrimitive) soapSerializationEnvelope.getResponse();
            returnedData = soapPrimitive.toString();
            System.out.println(soapPrimitive.toString());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return returnedData;

    }
    public static String checkUser(String phoneNumber, String password) {
        String returnedData = "";
        String METHOD_NAME = "isAuthorized";
        String NAMESPACE = "http://209.97.129.103:8080/Cell2iWebService/services/Cell2iWebServiceImpl?wsdl";
        String SOAP_ACTION = "http://209.97.129.103:8080/Cell2iWebService/services/Cell2iWebServiceImpl?wsdl/" + METHOD_NAME;
        String URL = "http://209.97.129.103:8080/Cell2iWebService/services/Cell2iWebServiceImpl?wsdl";
        soapObject = new SoapObject(NAMESPACE, METHOD_NAME);
        soapSerializationEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        soapSerializationEnvelope.setOutputSoapObject(soapObject);
        soapObject.addProperty("phoneNumber", phoneNumber);
        soapObject.addProperty("password", password);
        httpTransportSE = new HttpTransportSE(URL);
        httpTransportSE.debug = true;
        try {
            httpTransportSE.call(SOAP_ACTION, soapSerializationEnvelope);
            SoapPrimitive soapPrimitive = (SoapPrimitive) soapSerializationEnvelope.getResponse();
            returnedData = soapPrimitive.toString();
            System.out.println(soapPrimitive.toString());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return returnedData;
    }

    public static String getUserInfo(String phoneNumber) {
        String returnedData = "";
        String METHOD_NAME = "getUserInfo";
        String NAMESPACE = "http://209.97.129.103:8080/Cell2iWebService/services/Cell2iWebServiceImpl?wsdl";
        String SOAP_ACTION = "http://209.97.129.103:8080/Cell2iWebService/services/Cell2iWebServiceImpl?wsdl/" + METHOD_NAME;
        String URL = "http://209.97.129.103:8080/Cell2iWebService/services/Cell2iWebServiceImpl?wsdl";
        soapObject = new SoapObject(NAMESPACE, METHOD_NAME);
        soapSerializationEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        soapSerializationEnvelope.setOutputSoapObject(soapObject);
        soapObject.addProperty("phoneNumber", phoneNumber);
        httpTransportSE = new HttpTransportSE(URL);
        httpTransportSE.debug = true;
        try {
            httpTransportSE.call(SOAP_ACTION, soapSerializationEnvelope);
            SoapPrimitive soapPrimitive = (SoapPrimitive) soapSerializationEnvelope.getResponse();
            returnedData = soapPrimitive.toString();
            System.out.println(soapPrimitive.toString());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return returnedData;
    }

    public static String getUserTariffName(String phoneNumber) {
        String returnedData = "";
        String METHOD_NAME = "getTariffInfo";
        String NAMESPACE = "http://209.97.129.103:8080/Cell2iWebService/services/Cell2iWebServiceImpl?wsdl";
        String SOAP_ACTION = "http://209.97.129.103:8080/Cell2iWebService/services/Cell2iWebServiceImpl?wsdl/" + METHOD_NAME;
        String URL = "http://209.97.129.103:8080/Cell2iWebService/services/Cell2iWebServiceImpl?wsdl";
        soapObject = new SoapObject(NAMESPACE, METHOD_NAME);
        soapSerializationEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        soapSerializationEnvelope.setOutputSoapObject(soapObject);
        soapObject.addProperty("phoneNumber", phoneNumber);
        httpTransportSE = new HttpTransportSE(URL);
        httpTransportSE.debug = true;
        try {
            httpTransportSE.call(SOAP_ACTION, soapSerializationEnvelope);
            SoapPrimitive soapPrimitive = (SoapPrimitive) soapSerializationEnvelope.getResponse();
            returnedData = soapPrimitive.toString();
            System.out.println(soapPrimitive.toString());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return returnedData;
    }

    public static String getUsageInfo(String phoneNumber, String info) {
        String returnedData = "";
        String METHOD_NAME = "getUsageInfo";
        String NAMESPACE = "http://209.97.129.103:8080/Cell2iWebService/services/Cell2iWebServiceImpl?wsdl";
        String SOAP_ACTION = "http://209.97.129.103:8080/Cell2iWebService/services/Cell2iWebServiceImpl?wsdl/" + METHOD_NAME;
        String URL = "http://209.97.129.103:8080/Cell2iWebService/services/Cell2iWebServiceImpl?wsdl";
        soapObject = new SoapObject(NAMESPACE, METHOD_NAME);
        soapSerializationEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        soapSerializationEnvelope.setOutputSoapObject(soapObject);
        soapObject.addProperty("phoneNumber", phoneNumber);
        soapObject.addProperty("info", info);
        httpTransportSE = new HttpTransportSE(URL);
        httpTransportSE.debug = true;
        try {
            httpTransportSE.call(SOAP_ACTION, soapSerializationEnvelope);
            SoapPrimitive soapPrimitive = (SoapPrimitive) soapSerializationEnvelope.getResponse();
            returnedData = soapPrimitive.toString(); //async e gitmesini sağlar
            System.out.println(soapPrimitive.toString());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return returnedData;
    }

    public static String getInvoicesInfo(String phoneNumber, int count) {
        String returnedData = "";
        String METHOD_NAME = "getInvoiceInfo";
        String NAMESPACE = "http://209.97.129.103:8080/Cell2iWebService/services/Cell2iWebServiceImpl?wsdl";
        String SOAP_ACTION = "http://209.97.129.103:8080/Cell2iWebService/services/Cell2iWebServiceImpl?wsdl/" + METHOD_NAME;
        String URL = "http://209.97.129.103:8080/Cell2iWebService/services/Cell2iWebServiceImpl?wsdl";
        soapObject = new SoapObject(NAMESPACE, METHOD_NAME);
        soapSerializationEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        soapSerializationEnvelope.setOutputSoapObject(soapObject);
        soapObject.addProperty("phoneNumber", phoneNumber);
        soapObject.addProperty("invoiceCount", count);
        httpTransportSE = new HttpTransportSE(URL);
        httpTransportSE.debug = true;
        try {
            httpTransportSE.call(SOAP_ACTION, soapSerializationEnvelope);
            SoapPrimitive soapPrimitive = (SoapPrimitive) soapSerializationEnvelope.getResponse();
            returnedData = soapPrimitive.toString();
            System.out.println(soapPrimitive.toString());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return returnedData;
    }
}
