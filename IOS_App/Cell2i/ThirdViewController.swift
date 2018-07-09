//
//  ThirdViewController.swift
//  Cell2i
//
//  Created by Ozlem Cinar on 7/4/18.
//  Copyright © 2018 sena. All rights reserved.
//

import UIKit

class ThirdViewController: UIViewController {

    override func viewDidLoad() {
        super.viewDidLoad()
       // doneButton.layer.shadowColor = UIColor.lightGray.cgColor
        //doneButton.layer.shadowOffset = CGSize(width: 5, height: 5)
       // doneButton.layer.shadowRadius = 10
        //doneButton.layer.shadowOpacity = 1.0
        doneButton.layer.cornerRadius = doneButton.bounds.size.height / 3
        // Do any additional setup after loading the view.
        confirmPassword.isSecureTextEntry = true
        newPassword.isSecureTextEntry = true
    }
    override func touchesBegan(_ touches: Set<UITouch>, with event: UIEvent?) {
        self.view.endEditing(true)
    }
    
    func textFieldShouldReturn(_ textField: UITextField) -> Bool {
        textField.resignFirstResponder()
        return true
    }
    @IBOutlet weak var underline1: UILabel!
    @IBOutlet weak var underline2: UILabel!
    @IBOutlet weak var underline3: UILabel!
    @IBOutlet weak var backgroundImage: UIImageView!
    @IBOutlet weak var enterName: UITextField!
    @IBOutlet weak var newPassword: UITextField!    
    @IBOutlet weak var confirmPassword: UITextField!
    @IBOutlet weak var doneButton: UIButton!

    
    @IBAction func doneButtonClicked(_ sender: Any) {
        func isValidPassword(testStr:String?) -> Bool {
            guard testStr != nil else { return false }
            let passwordTest = NSPredicate(format: "SELF MATCHES %@", "^(?=.*[a-z])(?=.*[$@$#!%*?&])[A-Za-z\\d$@$#!%*?&]{8,}")
            return passwordTest.evaluate(with: testStr)
        }
        let wsgetSuccess = Cell2iWebServiceImplService()
        if(newPassword.text! == confirmPassword.text!){
            if(isValidPassword(testStr: newPassword.text)){
                wsgetSuccess.changeUserPassword(userId: enterName.text!, password: newPassword.text!)
                let alert = UIAlertController(title: "Password Confirmed", message: "", preferredStyle: UIAlertControllerStyle.alert)
                let doneButtonClicked = UIAlertAction(title: "OK", style: UIAlertActionStyle.cancel) { (UIAlertAction) in self.performSegue(withIdentifier: "turnFirst", sender: nil)}
            alert.addAction(doneButtonClicked)
            self.present(alert , animated: true , completion: nil)
            }
            else{
                let alert = UIAlertController(title: "", message: "Your password should be 8 character long and should contain at least one special character and number", preferredStyle: UIAlertControllerStyle.alert)
                let doneButtonClicked = UIAlertAction(title: "OK", style: UIAlertActionStyle.cancel, handler: nil )
                alert.addAction(doneButtonClicked)
                self.present(alert , animated: true , completion: nil)
            }
        }
         else if(newPassword.text! != confirmPassword.text!){
            let alert = UIAlertController(title: "", message: "Your passwords should match", preferredStyle: UIAlertControllerStyle.alert)
            let doneButtonClicked = UIAlertAction(title: "OK", style: UIAlertActionStyle.cancel, handler: nil )
            alert.addAction(doneButtonClicked)
            self.present(alert , animated: true , completion: nil)
        }
    }
}
