package Level3;

public class JSONReportStrategy implements ReportStrategy {
    @Override
    public String getReportType(){
        return "Report: JSON";
    }

    @Override
    public void generateReport(String nameReport){
        System.out.println("Generating " + nameReport + ".json");
    }
}
