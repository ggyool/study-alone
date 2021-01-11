package p1;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer("aaa", 150));
        customers.add(new Customer("bbb", 250));
        customers.add(new Customer("ccc", 350));
        customers.add(new Customer("ddd", 450));
        customers.add(new Customer("eee", 550));

        ReportGenerator simpleReportGenerator = new SimpleReportGenerator();
        String simpleReport = simpleReportGenerator.generate(customers);
        System.out.println(simpleReport);


        ReportGenerator complexReportGenerator = new ComplexReportGenerator();
        String complexReport = complexReportGenerator.generate(customers);
        System.out.println(complexReport);
    }
}
