//
//class Puppy {
//    var name: String
//    var owner: Person?
//    init(name: String) {
//        self.name = name
//    }
//    func goOut() {
//        print("\(name)가 주인 \(owner!.name)와 산책을 합니다")
//    }
//}
//
//class Person {
//    var name: String
//    var pet: Puppy?
//    var child: Person?
//    init(name: String, child: Person? = nil) {
//        self.name = name
//        self.child = child
//    }
//    func test() {
//        if let petName = pet?.name, let childName = child?.name {
//            print("\(name)가 \(childName)에게 \(petName)를 인도합니다")
//            self.pet?.owner = child
//        }
//    }
//}
//
//var puppy: Puppy? = Puppy(name: "choco")
//var child: Person? = Person(name: "son")
//var parent: Person? = Person(name: "park", child: child)
//
//puppy?.owner = parent
//puppy?.goOut()
//parent?.pet = puppy
//parent?.test()
//

enum VendingMachineError {
    case invalidInput
    case insufficientFunds(moneyNeeded: Int)
    case outOfStock
}

var a: VendingMachineError = VendingMachineError.invalidInput
var b: VendingMachineError = VendingMachineError.insufficientFunds(moneyNeeded: 10)


print(a)
print(b)
