import Foundation
func makeIncrementer(forIncrement amount: Int) -> () -> Int {
    var runningTotal = 0
    func incrementer() -> Int {
        runningTotal += amount
        print(runningTotal)
        return runningTotal
    }

    return incrementer
}


let tmp = makeIncrementer(forIncrement: 10)

tmp()
tmp()
tmp()
