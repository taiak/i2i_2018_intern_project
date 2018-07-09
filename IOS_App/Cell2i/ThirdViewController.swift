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

        // Do any additional setup after loading the view.
    }

    @IBOutlet weak var backgroundImage: UIImageView!
    
    @IBOutlet weak var enterName: UITextField!
    

    @IBOutlet weak var newPassword: UITextField!
    
    @IBOutlet weak var confirmPassword: UITextField!
    
    @IBAction func doneButtonClicked(_ sender: Any) {
        
        self.dismiss(animated: true, completion: nil)
    }
    
    
    
    
}
