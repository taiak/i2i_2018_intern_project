 
import Foundation

extension String
{
    public var xmlLocalName:String{
        get{
            var strs = self.split(separator:  ":")
            if let lastStr:String = strs.last as! String
            {
                return lastStr
            }
            return ""
        }
    }
    public func toInt()->Int?
    {
        if let  i:Int = Int(self) {
            return i;
        }
        return nil;
    }
    public func toInt(defaultValue:Int)->Int{
        if let  i:Int = Int(self) {
            return i;
        }
        return defaultValue;
    }
    public func toUInt()->UInt?
    {
        if let  i:UInt = UInt(self) {
            return i;
        }
        return nil;
    }
    public func toUInt(defaultValue:UInt)->UInt{
        if let  i:UInt = UInt(self) {
            return i;
        }
        return defaultValue;
    }
    
    
    public func toInt8()->Int8?{
        if let  i:Int8 = Int8(self) {
            return i;
        }
        return nil;
    }
    public func toInt8(defVal:Int8)->Int8{
        if let  i:Int8 = Int8(self) {
            return i;
        }
        return defVal;
    }
    
    public func toUInt8()->UInt8?{
        if let  i:UInt8 = UInt8(self) {
            return i;
        }
        return nil;
    }
    public func toUInt8(defVal:UInt8)->UInt8{
        if let  i:UInt8 = UInt8(self) {
            return i;
        }
        return defVal;
    }
    
    
    public func toInt16()->Int16?{
        if let  i:Int16 = Int16(self) {
            return i;
        }
        return nil;
    }
    public func toInt16(defVal:Int16)->Int16{
        if let  i:Int16 = Int16(self) {
            return i;
        }
        return defVal
    }
    public func toUInt16()->UInt16?{
        if let  i:UInt16 = UInt16(self) {
            return i;
        }
        return nil;
    }
    public func toUInt16(defVal:UInt16)->UInt16{
        if let  i:UInt16 = UInt16(self) {
            return i;
        }
        return defVal
    }
    
    
    public func toInt32()->Int32?{
        if let  i:Int32 = Int32(self) {
            return i;
        }
        return nil;
    }
    public func toInt32(defVal:Int32)->Int32{
        if let  i:Int32 = Int32(self) {
            return i;
        }
        return defVal;
    }
    
    
    public func toUInt32()->UInt32?{
        if let  i:UInt32 = UInt32(self) {
            return i;
        }
        return nil;
    }
    public func toUInt32(defVal:UInt32)->UInt32{
        if let  i:UInt32 = UInt32(self) {
            return i;
        }
        return defVal;
    }
    
    
    public func toInt64()->Int64?{
        if let  i:Int64 = Int64(self) {
            return i;
        }
        return nil;
    }
    public func toInt64(defVal:Int64)->Int64{
        if let  i:Int64 = Int64(self) {
            return i;
        }
        return defVal;
    }
    
    public func toUInt64()->UInt64?{
        if let  i:UInt64 = UInt64(self) {
            return i;
        }
        return nil;
    }
    public func toUInt64(defVal:UInt64)->UInt64{
        if let  i:UInt64 = UInt64(self) {
            return i;
        }
        return defVal;
    }
    
    
    public func toFloat()->Float?{
        if let  i:Float = Float(self) {
            return i;
        }
        return nil;
    }
    public func toFloat(defVal:Float)->Float?{
        if let  i:Float = Float(self) {
            return i;
        }
        return defVal;
    }
    
    public func toDouble()->Double?{
        if let  i:Double = Double(self) {
            return i;
        }
        return nil;
    }
    public func toDouble(defVal:Double)->Double?{
        if let  i:Double = Double(self) {
            return i;
        }
        return defVal;
    }
    
    public func toDate()->Date?{
        let dateFormatter = DateFormatter()
        dateFormatter.dateFormat = "yyyy-MM-dd HH:mm:ss" /*find out and place date format from http://userguide.icu-project.org/formatparse/datetime*/
        if let date = dateFormatter.date(from: self) {
            return date
        }
        return nil
    }
    public func toDate(dateformat:String)->Date?{
        let dateFormatter = DateFormatter()
        dateFormatter.dateFormat = dateformat
        if let date = dateFormatter.date(from: self) {
            return date
        }
        return nil
    }
    

    
}