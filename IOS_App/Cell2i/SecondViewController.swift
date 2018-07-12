//
//  SecondViewController.swift
//  Cell2i
//
//  Created by Ozlem Cinar on 7/3/18.
//  Copyright © 2018 sena. All rights reserved.
//

import UIKit

class SecondViewController: UIViewController {

    @IBOutlet weak var progressBar: UIProgressView!
    @IBOutlet weak var progressBar2: UIProgressView!
    @IBOutlet weak var progressBar3: UIProgressView!
    var text: String? = nil
    
    
    @IBOutlet weak var tariffID: UITextField!
    @IBOutlet weak var numberBar: UITextField!
    @IBOutlet weak var nameBar: UITextField!
    
    @IBOutlet weak var totalGB: UITextField!
    @IBOutlet weak var totalSMS: UITextField!
    @IBOutlet weak var totalDK: UITextField!
   
    @IBOutlet weak var GB_kullanilan: UILabel!
    
    @IBOutlet weak var DK_kullanilan: UILabel!
    
    @IBOutlet weak var SMS_kullanilan: UILabel!
    
    
    let wsgetSuccess = Cell2iWebServiceImplService()
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        let userInfo = wsgetSuccess.getUserInfo(userId: text!)
        let userInfo_Split = userInfo.split(separator: "_")
        
        nameBar.text! = String(userInfo_Split[1] + " " + userInfo_Split[2])
        numberBar.text! = String(userInfo_Split[0])
        
        let TariffInfo = wsgetSuccess.getTariffInfo(userId: text!)
        let TariffInfo_Split = TariffInfo.split(separator: "_")
        
        tariffID.text! = String(TariffInfo_Split[0]) //tarife adi
        totalDK.text! = String(TariffInfo_Split[1] + " DK") //dakika sayisi
        
        let data_GB = Float((Float(String(TariffInfo_Split[3])))!/1000) //data total
        let data_GB_2 = String(format:"%.2f", data_GB)
        totalGB.text! = String(data_GB_2 + " GB")
        
        totalSMS.text! = String(TariffInfo_Split[2] + " SMS") //sms total
        
        var SMS_Infos: String = wsgetSuccess.getUsageInfo(userId: text!, infoType: ("SMS")) //kullanilan
        let SMS_Infos_Split = SMS_Infos.split(separator: "_")

        var float_total_sms = Float(String(TariffInfo_Split[2]))! //total sms float cinsinden
        
        var float_kullanilmis_sms = Float(String(SMS_Infos_Split[1]))! //kullanilan sms float cinsi
       // print(float_kullanilmis_sms)
        SMS_kullanilan.text! = String(SMS_Infos_Split[1]) + " SMS"
        
        var progress_sms_yuzde = Float(float_kullanilmis_sms/float_total_sms)
        
        progressBar3.transform = progressBar.transform.scaledBy(x: 1, y: 10)
        progressBar3.setProgress(Float(progress_sms_yuzde), animated: true)
        
        var DATA_Infos: String = wsgetSuccess.getUsageInfo(userId: text!, infoType: ("DATA"))
        let Data_Infos_Split = DATA_Infos.split(separator: "_")
        
        var float_total_data = (Float(String(TariffInfo_Split[3])))!
        
        var float_kullanilmis_data = Float(String(Data_Infos_Split[1]))!
       // print(float_kullanilmis_data)
        GB_kullanilan.text! = String(Data_Infos_Split[1]) + " GB"
        
        var progress_data_yuzde = Float(float_kullanilmis_data/float_total_data)
        progressBar.transform = progressBar.transform.scaledBy(x: 1, y: 10)
        progressBar.setProgress(progress_data_yuzde, animated: true)
        
        var DK_Infos = wsgetSuccess.getUsageInfo(userId: text!, infoType: ("VOICE")) //kullanilan
        let DK_Infos_Split = DK_Infos.split(separator: "_")
        
        var float_total_DK = (Float(String(TariffInfo_Split[1])))!
        
        var float_kullanilmis_DK = Float(String(DK_Infos_Split[1]))!
        print(float_kullanilmis_DK)
        DK_kullanilan.text! = String(DK_Infos_Split[1]) + " DK"
        var progress_DK_yuzde = Float(float_kullanilmis_DK/float_total_DK)
 
        progressBar2.transform = progressBar2.transform.scaledBy(x: 1, y: 10)
        progressBar2.setProgress(progress_DK_yuzde, animated: true)
        
        
        
        
        
        
       
        
    }

    @IBAction func goFirstPage(_ sender: Any) {
        performSegue(withIdentifier: "goFirstPage", sender: nil)
    }
    
    @IBOutlet weak var myLabel: UILabel!
    

    @IBAction func btnCoins(_ sender: Any) {
        performSegue(withIdentifier: "gotothirdpage", sender: nil)
        
    }
    

}
