//test
import UIKit

class Person{
    var name: String = "ggyool"
    var age: Int = 30
}

var ov1: Int? = nil
var ov2: Int! = nil

ov1 = 100
ov2 = ov1

print(ov1!)
print(ov2!) // 꼭 ! 붙여야함


