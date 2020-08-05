import UIKit

class Person{
    var name: String = "ggyool"
    var age: Int = 30
}


var integers: Array<Int> = Array<Int>()

var dict: Dictionary<String, Int> = [String:Int]()
dict["a"] = 1
dict["b"] = 2
dict["b"] = nil
// dict.removeValue(forKey: "b")
print(dict["b"]!)
