package com.example.zeynep.cell2i;


import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

/**
 * Created by rumey on 5.07.2018.
 */

public class ServiceManager {
    private static final String METHOD_NAME = "success_statu"; //kullanıdıgız service metodu
    public static final String NAMESPACE = "http://209.97.129.103:8080/Cell2iWebService/services/Cell2iWebServiceImpl?wsdl"; //web service isim alanı
    private static final String SOAP_ACTION = "http://209.97.129.103:8080/Cell2iWebService/services/Cell2iWebServiceImpl?wsdl/success_statu";
   public static final String URL = "http://209.97.129.103:8080/Cell2iWebService/services/Cell2iWebServiceImpl?wsdl";

    static SoapObject soapObject;
    static SoapSerializationEnvelope soapSerializationEnvelope;
    static HttpTransportSE httpTransportSE;

    //veri ekle
    public static boolean PushData() {
         String name = "";
         String password = "";
        soapObject = new SoapObject(NAMESPACE, METHOD_NAME);


        soapSerializationEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        soapSerializationEnvelope.dotNet = true;
        soapSerializationEnvelope.setOutputSoapObject(soapObject);
        soapObject.addProperty("name",name);
        soapObject.addProperty("password",password);

        httpTransportSE = new HttpTransportSE(URL);
        httpTransportSE.debug = true;
        try {
            httpTransportSE.call(SOAP_ACTION, soapSerializationEnvelope);
            SoapPrimitive soapPrimitive = (SoapPrimitive) soapSerializationEnvelope.getResponse();
            System.out.println(soapPrimitive.toString());
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    //login
    public static String getHelloData() {
        String returnedData = "";
        soapObject = new SoapObject(NAMESPACE, METHOD_NAME);
      //  soapObject.addProperty("username",gelenDegiskenUsername)

        soapSerializationEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        soapSerializationEnvelope.dotNet = true;
        soapSerializationEnvelope.setOutputSoapObject(soapObject);

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

    public static String checkUser(String username, String password){
        String returnedData = ""; //metoddan gelen değer
        String METHOD_NAME = "userControl";
        String NAMESPACE = "http://209.97.129.103:8080/Cell2iWebService/services/Cell2iWebServiceImpl?wsdl"; //web service isim alanı
        String SOAP_ACTION = "http://209.97.129.103:8080/Cell2iWebService/services/Cell2iWebServiceImpl?wsdl/userControl";
        String URL = "http://209.97.129.103:8080/Cell2iWebService/services/Cell2iWebServiceImpl?wsdl";

        soapObject = new SoapObject(NAMESPACE, METHOD_NAME);
        soapSerializationEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        soapSerializationEnvelope.setOutputSoapObject(soapObject);


        soapObject.addProperty("username",username );
        soapObject.addProperty("password", password);
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



}
