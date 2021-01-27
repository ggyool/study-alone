package a348_access_modifier_test;

import a330_super_test.OtherPackageParent;

public class Main {
    public static void main(String[] args) {
        Child child = new Child();
        child.func();
    }
}

class Child extends OtherPackageParent {
    void func() {
        System.out.println("부모는 다른 패키지에 있으므로 default 변수는 접근하지 못한다.");
        System.out.println(this.protectedVariable);
        System.out.println(this.publicVariable);
    }
}
