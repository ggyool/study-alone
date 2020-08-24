struct Abc{
    var name: String
    var age: Int
    
}
    

let abc = Abc(name: "aaa", age: 10)

let def = abc

print(Unmanaged.passRetained(abc).toOpaque())
print(Unmanaged.passRetained(def).toOpaque())


