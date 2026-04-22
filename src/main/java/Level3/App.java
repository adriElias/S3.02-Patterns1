package Level3;

public class App {
    public static void main(String[] args) {
        System.out.println("---- STRATEGY PATTERN ----");
        System.out.println();

        // HTML Report Strategy
        Document htmlDocument = new Document("Monthly_Report", new HTMLReportStrategy());
        htmlDocument.generateDocument();
        System.out.println();

        // PDF Report Strategy
        Document pdfDocument = new Document("Annual_Report", new PDFReportStrategy());
        pdfDocument.generateDocument();
        System.out.println();

        // JSON Report Strategy
        Document jsonDocument = new Document("API_Response", new JSONReportStrategy());
        jsonDocument.generateDocument();
        System.out.println();

        // XML Report Strategy
        Document xmlDocument = new Document("Data_Export", new XMLReportStrategy());
        xmlDocument.generateDocument();
        System.out.println();

        // CSV Report Strategy
        Document csvDocument = new Document("Sales_Data", new CSVReportStrategy());
        csvDocument.generateDocument();
        System.out.println();

        // Word Report Strategy
        Document wordDocument = new Document("Technical_Documentation", new WordReportStrategy());
        wordDocument.generateDocument();
        System.out.println();

        // Excel Report Strategy
        Document excelDocument = new Document("Financial_Analysis", new ExcelReportStrategy());
        excelDocument.generateDocument();
    }
}
