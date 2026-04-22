package Level3;

public class WordReportStrategy implements ReportStrategy {
    @Override
    public String getReportType(){
        return "Report: Word";
    }

    @Override
    public void generateReport(String nameReport){
        System.out.println("Generating " + nameReport + ".docx");
    }
}
