//
//  ViewController.swift
//  Cell2i
//
//  Created by sena on 3.07.2018.
//  Copyright © 2018 sena. All rights reserved.
//

import UIKit

class ViewController: UIViewController {

    @IBOutlet weak var userNameText: UITextField!
    @IBOutlet weak var passwordText: UITextField!
 
    override func viewDidLoad() {
        super.viewDidLoad()
        passwordText.isSecureTextEntry = true

    }
    
    @IBAction public func buttonClicked(_ sender: Any) {
        let wsgetSuccess = Cell2iWebServiceImplService()

        if(wsgetSuccess.userControl(name: userNameText.text!, password: passwordText.text!)){
            performSegue(withIdentifier: "gotosecondpage", sender: nil)
        }
        else if userNameText.text == "" {
            let alert = UIAlertController(title: "Alert", message: "Username Is empty", preferredStyle: UIAlertControllerStyle.alert)
            let okButton = UIAlertAction(title: "OK", style: UIAlertActionStyle.cancel, handler: nil )
            alert.addAction(okButton)
            self.present(alert , animated: true , completion: nil)
            
        }
        else if passwordText.text == "" {
            let alert = UIAlertController(title: "Alert", message: "Password Is Empty", preferredStyle: UIAlertControllerStyle.alert)
            let okButton = UIAlertAction(title: "OK", style: UIAlertActionStyle.cancel, handler: nil )
            alert.addAction(okButton)
            self.present(alert , animated: true , completion: nil)
            
        }
        else{
            let alert = UIAlertController(title: "Alert", message: "Password or Username Is Incorrect", preferredStyle: UIAlertControllerStyle.alert)
            let okButton = UIAlertAction(title: "OK", style: UIAlertActionStyle.cancel, handler: nil )
            alert.addAction(okButton)
            self.present(alert , animated: true , completion: nil)
            
            
        }
    }
}

