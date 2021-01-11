package p1;

import java.util.List;

public class ComplexReportGenerator extends ReportGenerator {
    @Override
    protected String getReportHeader(List<Customer> customers) {
        return String.format("vip 고객 수: %d명\n", customers.size());
    }

    @Override
    protected boolean meetCondition(Customer customer) {
        final int vipCriterion = 300;
        return customer.getPoint() >= vipCriterion;
    }

    @Override
    protected String getReport(Customer customer) {
        return String.format("vip %s: %d\n", customer.getName(), customer.getPoint());
    }

    @Override
    protected String getReportFooter(List<Customer> customers) {
        int sum = customers.stream()
                .mapToInt(Customer::getPoint)
                .sum();
        return String.format("점수 합계: %d\n", sum);
    }
}
