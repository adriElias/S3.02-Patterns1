package Level3;

public class Document {
    private final String name;
    private final ReportStrategy reportStrategy;

    public Document(String name, ReportStrategy reportStrategy) {
        this.name = name;
        this.reportStrategy = reportStrategy;
    }

    public void generateDocument(){
        System.out.println("Generating...");
        System.out.println("Document: " +  name + "." + reportStrategy.getReportType());

        reportStrategy.generateReport(name);
    }
}
