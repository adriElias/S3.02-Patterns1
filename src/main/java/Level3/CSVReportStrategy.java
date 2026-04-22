package Level3;

public class CSVReportStrategy implements ReportStrategy {
    @Override
    public String getReportType(){
        return "Report: CSV";
    }

    @Override
    public void generateReport(String nameReport){
        System.out.println("Generating " + nameReport + ".csv");
    }
}
