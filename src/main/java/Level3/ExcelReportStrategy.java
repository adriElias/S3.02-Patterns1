package Level3;

public class ExcelReportStrategy implements ReportStrategy {
    @Override
    public String getReportType(){
        return "Report: Excel";
    }

    @Override
    public void generateReport(String nameReport){
        System.out.println("Generating " + nameReport + ".xlsx");
    }
}
