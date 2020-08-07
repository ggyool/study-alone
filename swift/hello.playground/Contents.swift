//func plus(a: Int, b: Int) -> Int {
//  return a + b
//}
//
//let add: (Int, Int)->Int = plus(a:b:)
//print(add(10,20))

//
//class Person{
//    var firstname: String
//    var lastname: String
//    init(_ firstname: String, _ lastname: String){
//        self.firstname = firstname
//        self.lastname = lastname
//    }
//    var koreanName: String {
//        set(v){
//            lastname = v
//        }
//        get{
//            return lastname + " " + firstname
//        }
//    }
//}
//
//var p1: Person = Person("james", "kim")
//var p2: Person = Person("bruce", "lee")
//
//p1.koreanName = "park"
//print(p1.koreanName)


struct Money{
    var currencyRate: Double = 1100
    var dollar: Double{
        willSet{
            print("dollar가 \(dollar) 에서 \(newValue)로 변경 될 예정입니다.")
        }
        didSet{
            print("dollar가 \(oldValue)에서 \(dollar)로 변경되었습니다.")
        }
    }
    var won: Double{
        get{
            return dollar * currencyRate
        }
        set{
            dollar = newValue/currencyRate
        }
    }
}


var money: Money = Money(dollar:10)

print(money.won, money.dollar)
money.won = 1100
print("----")
print(money.won, money.dollar)

