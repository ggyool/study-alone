class WeakOneClass {
    var secondObj: WeakTwoClass!
    init() {print("WeakOneClass 생성")}
    deinit {print("WeakOneClass 해제")}
}
class WeakTwoClass {
    // 이렇게 프로퍼티 앞에 weak 키워드를 넣으면 약한 참조입니다.
    weak var firstObj: WeakOneClass!
    init() {print("WeakTwoClass 생성")}
    deinit {print("WeakTwoClass 해제")}
}
var first03: WeakOneClass? = WeakOneClass()
// OneClass 생성
var second03: WeakTwoClass? = WeakTwoClass()
// TwoClass 생성

first03?.secondObj = second03
second03?.firstObj = first03

first03 = nil
// WeakOneClass 해제
second03 = nil
// WeakTwoClass 해제
