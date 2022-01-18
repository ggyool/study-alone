package facade;

public class EmpReportDaoFacade implements EmpReportFacade{

    private EmpDao empDao;
    private ResumeDao resumeDao;

    public EmpReportDaoFacade(EmpDao empDao, ResumeDao resumeDao) {
        this.empDao = empDao;
        this.resumeDao = resumeDao;
    }

    @Override
    public String getEmpReportData() {
        return null;
    }
}
