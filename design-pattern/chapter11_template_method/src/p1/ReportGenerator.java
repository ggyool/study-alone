package p1;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public abstract class ReportGenerator {
    public String generate(List<Customer> customers) {
        StringBuilder sb = new StringBuilder();
        List<Customer> selectedCustomers = selectProperCustomers(customers);

        sb.append(getReportHeader(selectedCustomers));
        sb.append(getReportBody(selectedCustomers));
        sb.append(getReportFooter(selectedCustomers));

        return sb.toString();
    }

    private List<Customer> selectProperCustomers(List<Customer> customers) {
        return customers.stream()
                .filter(this::meetCondition)
                .collect(Collectors.toList());
    }

    private String getReportBody(List<Customer> customers) {
        return customers.stream()
                .map(this::getReport)
                .collect(Collectors.joining());
    }


    protected abstract String getReportHeader(List<Customer> customers);

    protected abstract boolean meetCondition(Customer customer);

    protected abstract String getReport(Customer customer);

    protected abstract String getReportFooter(List<Customer> customers);
}
