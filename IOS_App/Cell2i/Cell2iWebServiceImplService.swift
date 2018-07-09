 import Foundation 
public class Cell2iWebServiceImplService {
 public var Url:String = "http://209.97.129.103:8080/Cell2iWebService/services/Cell2iWebServiceImpl"
 public var Host:String = "209.97.129.103:8080"
public func dataToBase64(data:NSData)->String{
        
        let result = data.base64EncodedString(options: NSData.Base64EncodingOptions.init(rawValue: 0))
        return result;
    }
    public func dataToBase64(data: Data)->String {
        let result = data.base64EncodedString()
        return result
    }
    public func byteArrayToBase64(data:[UInt])->String{
        let nsdata = NSData(bytes: data, length: data.count)
        let data  = Data.init(referencing: nsdata)
        if let str = String.init(data: data, encoding: String.Encoding.utf8){
            return str
        }
        return "";
    }
    public func timeToString(date:Date)->String{
        let dateFormatter = DateFormatter()
        dateFormatter.dateFormat = "HH:mm:ss"
        let dateString = dateFormatter.string(from: date)
        return dateString
    }
    public func dateToString(date:Date)->String{
        let dateFormatter = DateFormatter()
        dateFormatter.dateFormat = "yyyy-MM-dd HH:mm:ss"
        let dateString = dateFormatter.string(from: date)
        return dateString
    }
    
    public func base64ToByteArray(base64String: String) -> [UInt8] {
        let data = Data.init(base64Encoded: base64String)
        let dataCount = data!.count
        var bytes = [UInt8].init(repeating: 0, count: dataCount)
        data!.copyBytes(to: &bytes, count: dataCount)
        return bytes
    }
    func stringFromXMLString(xmlToParse:String)->String {
        do
        {
            let xml = SWXMLHash.lazy(xmlToParse)
 
            let xmlResponse : XMLIndexer? = xml.children.first?.children.first?.children.first
            let xmlResult: XMLIndexer?  = xmlResponse?.children.last
            
            let xmlElement = xmlResult?.element
            let str = xmlElement?.text
            let xmlElementFirst = xmlElement?.children[0] as!TextElement
            return xmlElementFirst.text
        }
        catch
        {
            print("string from xml string de hata var")
        }
        //NOT IMPLETEMENTED!
        var returnValue:String!
        return returnValue
    }
    func stringFromXML(data:Data)-> String
    {
        
        let xmlToParse :String? = String.init(data: data, encoding: String.Encoding.utf8)
        if xmlToParse == nil {
            return ""
        }
        if xmlToParse!.count == 0 {
            return ""
        }
        let  stringVal = stringFromXMLString(xmlToParse:  xmlToParse!)
        return stringVal
        
    }
    func stringArrFromXMLString(xmlToParse :String)->[String?]{
        let xml  = SWXMLHash.lazy(xmlToParse)
        let xmlRoot  = xml.children.first
        let xmlBody = xmlRoot?.children.last
        let xmlResponse : XMLIndexer? =  xmlBody?.children.first
        let xmlResult : XMLIndexer?  = xmlResponse?.children.last
        
        var strList = [String?]()
        let childs = xmlResult!.children
        for child in childs {
            let text = child.element?.text
            strList.append(text)
        }
        
        return strList
    }
    func stringArrFromXML(data:Data)->[String?]{
        let xmlToParse :String? = String.init(data: data, encoding: String.Encoding.utf8)
        if xmlToParse == nil {
            return [String?]()
        }
        if xmlToParse!.count == 0 {
            return [String?]()
        }
        
        let  stringVal = stringArrFromXMLString(xmlToParse:  xmlToParse!)
        return stringVal
    }
    
    func byteArrayToBase64(bytes: [UInt8]) -> String {
        
        let data = Data.init(bytes: bytes)
        let base64Encoded = data.base64EncodedString()
        return base64Encoded;
       
    }
    
    func base64ToByteArray(base64String: String) -> [UInt8]? {
        if let data = Data.init(base64Encoded: base64String){
            var bytes = [UInt8](repeating: 0, count: data.count)
            data.copyBytes(to: &bytes, count: data.count)
            return bytes;
        }
        return nil // Invalid input
    }
  
public func success_statu()-> String{
   var soapReqXML:String = "<?xml version=\"1.0\" encoding=\"utf-8\"?>"

   soapReqXML += "<soapenv:Envelope xmlns:soapenv='http://schemas.xmlsoap.org/soap/envelope/' xmlns:ser='http://services.cell2iwebservice.com'>"
   soapReqXML += " xmlns:xsd =\"http://www.w3.org/2001/XMLSchema\""
   soapReqXML += " xmlns:soap =\"http://schemas.xmlsoap.org/soap/envelope/\">"
   soapReqXML += " <soapenv:Header/>"
    soapReqXML += " <soapenv:Body>"
   soapReqXML += "<success_statu xmlns=\"http://services.cell2iwebservice.com\">"
   soapReqXML += "</success_statu>"
   soapReqXML += "</soapenv:Body>"
   soapReqXML += "</soapenv:Envelope>"
    
    
   let soapAction :String = "http://services.cell2iwebservice.com/success_statu"

   let responseData:Data = SoapHttpClient.callWS(Host : self.Host,WebServiceUrl:self.Url,SoapAction:soapAction,SoapMessage:soapReqXML)
   let strVal :String? = stringFromXML(data : responseData);
   if strVal == nil {
       return  ""
   }
    
   let returnValue:String = strVal!
   return returnValue
}
public func userControl(name:String, password:String)-> Bool{
   var soapReqXML:String = "<?xml version=\"1.0\" encoding=\"utf-8\"?>"

    
    soapReqXML += "<soapenv:Envelope xmlns:soapenv='http://schemas.xmlsoap.org/soap/envelope/' xmlns:ser='http://services.cell2iwebservice.com'>"
soapReqXML += " <soapenv:Header/>"
soapReqXML += " <soapenv:Body>"
    soapReqXML += "<ser:userControl>"
        soapReqXML += "<ser:name>"
            soapReqXML += name
        soapReqXML += "</ser:name>"
        soapReqXML += "<ser:password>"
            soapReqXML += password
        soapReqXML += "</ser:password>"
    soapReqXML += "</ser:userControl>"
soapReqXML += "</soapenv:Body>"
soapReqXML += "</soapenv:Envelope>"
   let soapAction :String = "http://services.cell2iwebservice.com/userControl"

   let responseData:Data = SoapHttpClient.callWS(Host : self.Host,WebServiceUrl:self.Url,SoapAction:soapAction,SoapMessage:soapReqXML)
 let strVal :String? = stringFromXML(data : responseData);
 if strVal == nil {
    return  false
 }
 let returnValue:Bool = strVal!.lowercased() == "true"
   return returnValue
}
}
