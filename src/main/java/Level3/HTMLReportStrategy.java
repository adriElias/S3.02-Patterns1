package Level3;

public class HTMLReportStrategy implements ReportStrategy{
    @Override
    public String getReportType(){
        return "Report: HTML";
    }

    @Override
    public void generateReport(String nameReport){
        System.out.println("Generating " + nameReport + ".html");
    }
}
