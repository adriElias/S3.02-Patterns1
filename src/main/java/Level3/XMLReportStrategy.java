package Level3;

public class XMLReportStrategy implements ReportStrategy{
    @Override
    public String getReportType(){
        return "Report: XML";
    }

    @Override
    public void generateReport(String nameReport){
        System.out.println("Generating " + nameReport + ".xml");
    }
}
