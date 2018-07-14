//
//  ViewController.swift
//  Cell2i
//
//  Created by sena on 3.07.2018.
//  Copyright © 2018 sena. All rights reserved.
//
//deneme 
import UIKit

class ViewController: UIViewController , UITextFieldDelegate {
    @IBOutlet weak var button: UIButton!
    @IBOutlet weak var userNameText: UITextField!
    @IBOutlet weak var passwordText: UITextField!
    @IBOutlet weak var underline1: UILabel!
    @IBOutlet weak var underline2: UILabel!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        passwordText.isSecureTextEntry = true
        button.layer.shadowColor = UIColor.lightGray.cgColor
        button.layer.shadowOffset = CGSize(width: 5, height: 5)
        button.layer.shadowRadius = 10
        button.layer.shadowOpacity = 1.0
        button.layer.cornerRadius = button.bounds.size.height / 3
    }
   
    override func touchesBegan(_ touches: Set<UITouch>, with event: UIEvent?) {
        self.view.endEditing(true)
    }
    
    func textFieldShouldReturn(_ textField: UITextField) -> Bool {
        textField.resignFirstResponder()
        return true
    }

    @IBAction public func buttonClicked(_ sender: Any) {  
        let wsgetSuccess = Cell2iWebServiceImplService()
        let str = wsgetSuccess.isConnected()
        if(str == "Connect Successful") {
            if(wsgetSuccess.isAuthorized(userId: userNameText.text!, password: passwordText.text!)){
            performSegue(withIdentifier: "gotosecondpage", sender: nil)
            }
            else if userNameText.text == "" {
                let alert = UIAlertController(title: "Login Failed", message: "Fields can not be blank", preferredStyle: UIAlertControllerStyle.alert)
                let okButton = UIAlertAction(title: "OK", style: UIAlertActionStyle.cancel, handler: nil )
                alert.addAction(okButton)
                self.present(alert , animated: true , completion: nil)
            
            }
            else if passwordText.text == "" {
                let alert = UIAlertController(title: "Login Failed", message: "Fields can not blank", preferredStyle: UIAlertControllerStyle.alert)
                let okButton = UIAlertAction(title: "OK", style: UIAlertActionStyle.cancel, handler: nil )
                alert.addAction(okButton)
                self.present(alert , animated: true , completion: nil)
            }
            else{
                let alert = UIAlertController(title: "Login Failed", message: "Please check your phone number and password then try again", preferredStyle: UIAlertControllerStyle.alert)
                let okButton = UIAlertAction(title: "OK", style: UIAlertActionStyle.cancel, handler: nil )
            alert.addAction(okButton)
            self.present(alert , animated: true , completion: nil)
            }
        }
        else{
            let alert = UIAlertController(title: "Connection Failed", message: "Please check your network connection try again", preferredStyle: UIAlertControllerStyle.alert)
            let okButton = UIAlertAction(title: "OK", style: UIAlertActionStyle.cancel, handler: nil )
            alert.addAction(okButton)
            self.present(alert , animated: true , completion: nil)
        }
            
    }
    
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        if let SecondViewController = segue.destination as? SecondViewController{
            SecondViewController.texta = userNameText.text
        }
        
    }
    
    
    
}

