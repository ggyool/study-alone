//
//  main.swift
//  2775
//
//  Created by ggyool on 2020/09/15.
//  Copyright © 2020 ggyool. All rights reserved.
//

import Foundation

let tc: Int = Int(readLine()!) ?? 0

for _ in 0..<tc {
    let k: Int = Int(readLine()!) ?? 0
    let n: Int = Int(readLine()!) ?? 0
    var arr: [Int] = Array(repeating: 0, count: n+1)
    for i in 1...n {
        arr[i] = i
    }

    for _ in 1...k {
        for i in 1...n {
            arr[i] += arr[i-1]
        }
    }
    print(arr[n])
}

