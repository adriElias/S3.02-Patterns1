package Level3;

public class PDFReportStrategy implements ReportStrategy {
    @Override
    public String getReportType(){
        return "Report: PDF";
    }

    @Override
    public void generateReport(String nameReport){
        System.out.println("Generating " + nameReport + ".pdf");
    }
}
