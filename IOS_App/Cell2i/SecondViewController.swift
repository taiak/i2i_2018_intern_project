//
//  SecondViewController.swift
//  Cell2i
//
//  Created by Ozlem Cinar on 7/3/18.
//  Copyright © 2018 sena. All rights reserved.
//

import UIKit

class SecondViewController: UIViewController {

    override func viewDidLoad() {
        super.viewDidLoad()

        // Do any additional setup after loading the view.
    }

    
    @IBOutlet weak var myLabel: UILabel!
    

    @IBAction func btnCoins(_ sender: Any) {
        performSegue(withIdentifier: "gotothirdpage", sender: nil)
        
    }
    

}
