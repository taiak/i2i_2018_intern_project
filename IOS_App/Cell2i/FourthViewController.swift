//
//  FourthViewController.swift
//  Cell2i
//
//  Created by sena on 9.07.2018.
//  Copyright © 2018 sena. All rights reserved.
//

import UIKit

class FourthViewController: UIViewController , UICollectionViewDataSource , UICollectionViewDelegate {

    
    let monthName = ["May Invoice" , " March Invoice" , "February Invoice"]
    
    let costName = ["78,34" , " 78,34" , "78,34"]
    
    let date = ["28.05.2018" , "28.04.2018" , "28.03.2018"]
    
    
    override func viewDidLoad() {
        super.viewDidLoad()

        // Do any additional setup after loading the view.
    }
    
    func collectionView(_ collectionView: UICollectionView, numberOfItemsInSection section: Int) -> Int {
        return monthName.count
    }
    
    func collectionView(_ collectionView: UICollectionView, cellForItemAt indexPath: IndexPath) -> UICollectionViewCell {
        let cell = collectionView.dequeueReusableCell(withReuseIdentifier: "cell" , for: indexPath) as! CollectionViewCell
        
        cell.monthName.text = monthName[indexPath.row]
        cell.costName.text = costName[indexPath.row]
        cell.date.text = date[indexPath.row]
        
        cell.contentView.layer.cornerRadius = 4.0
        cell.contentView.layer.borderWidth = 1.0
        cell.contentView.layer.borderColor = UIColor.clear.cgColor
        cell.contentView.layer.masksToBounds = false
        cell.layer.shadowColor = UIColor.gray.cgColor
        cell.layer.shadowOffset = CGSize(width: 0 , height: 1.0 )
        cell.layer.shadowRadius = 4.0
        cell.layer.shadowOpacity = 1.0
        cell.layer.masksToBounds = false
        cell.layer.shadowPath = UIBezierPath(roundedRect : cell.bounds , cornerRadius : cell.contentView.layer.cornerRadius).cgPath
        
        return cell
    }

    @IBAction func backTurnButton(_ sender: Any) {
        self.dismiss(animated: true, completion: nil)
    }
    

    /*
    // MARK: - Navigation

    // In a storyboard-based application, you will often want to do a little preparation before navigation
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        // Get the new view controller using segue.destinationViewController.
        // Pass the selected object to the new view controller.
    }
    */

}
