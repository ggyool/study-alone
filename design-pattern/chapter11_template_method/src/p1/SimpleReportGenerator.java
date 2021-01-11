package p1;

import java.util.List;

public class SimpleReportGenerator extends ReportGenerator {
    @Override
    protected String getReportHeader(List<Customer> customers) {
        return String.format("고객 수: %d명\n", customers.size());
    }

    @Override
    protected boolean meetCondition(Customer customer) {
        return true;
    }

    @Override
    protected String getReport(Customer customer) {
        return String.format("%s: %d\n", customer.getName(), customer.getPoint());
    }

    @Override
    protected String getReportFooter(List<Customer> customers) {
        return "";
    }
}
