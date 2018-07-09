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
    
    override func viewDidLoad() {
        super.viewDidLoad()

        progressBar.transform = progressBar.transform.scaledBy(x: 1, y: 10)
        progressBar2.transform = progressBar2.transform.scaledBy(x: 1, y: 10)
        progressBar3.transform = progressBar3.transform.scaledBy(x: 1, y: 10)

        
    }

    @IBAction func goFirstPage(_ sender: Any) {
        performSegue(withIdentifier: "goFirstPage", sender: nil)
    }
    
    @IBOutlet weak var myLabel: UILabel!
    

    @IBAction func btnCoins(_ sender: Any) {
        performSegue(withIdentifier: "gotothirdpage", sender: nil)
        
    }
    

}
