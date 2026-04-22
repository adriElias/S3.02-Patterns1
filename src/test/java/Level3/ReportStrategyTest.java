package Level3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ReportStrategyTest {
    
    private ReportStrategy htmlStrategy;
    private ReportStrategy pdfStrategy;
    private ReportStrategy jsonStrategy;
    private ReportStrategy xmlStrategy;
    private ReportStrategy csvStrategy;
    private ReportStrategy wordStrategy;
    private ReportStrategy excelStrategy;

    @BeforeEach
    public void setUp() {
        htmlStrategy = new HTMLReportStrategy();
        pdfStrategy = new PDFReportStrategy();
        jsonStrategy = new JSONReportStrategy();
        xmlStrategy = new XMLReportStrategy();
        csvStrategy = new CSVReportStrategy();
        wordStrategy = new WordReportStrategy();
        excelStrategy = new ExcelReportStrategy();
    }

    // ─── HTML Report Strategy tests ───────────────────────────────

    @Test
    public void testHTMLReportStrategyType() {
        assertEquals("Report: HTML", htmlStrategy.getReportType());
    }

    @Test
    public void testHTMLReportStrategyNotNull() {
        assertNotNull(htmlStrategy.getReportType());
    }

    @Test
    public void testHTMLReportStrategyGenerate() {
        assertDoesNotThrow(() -> htmlStrategy.generateReport("test_report"));
    }

    // ─── PDF Report Strategy tests ────────────────────────────────

    @Test
    public void testPDFReportStrategyType() {
        assertEquals("Report: PDF", pdfStrategy.getReportType());
    }

    @Test
    public void testPDFReportStrategyNotNull() {
        assertNotNull(pdfStrategy.getReportType());
    }

    @Test
    public void testPDFReportStrategyGenerate() {
        assertDoesNotThrow(() -> pdfStrategy.generateReport("test_report"));
    }

    // ─── JSON Report Strategy tests ───────────────────────────────

    @Test
    public void testJSONReportStrategyType() {
        assertEquals("Report: JSON", jsonStrategy.getReportType());
    }

    @Test
    public void testJSONReportStrategyNotNull() {
        assertNotNull(jsonStrategy.getReportType());
    }

    @Test
    public void testJSONReportStrategyGenerate() {
        assertDoesNotThrow(() -> jsonStrategy.generateReport("test_report"));
    }

    // ─── XML Report Strategy tests ────────────────────────────────

    @Test
    public void testXMLReportStrategyType() {
        assertEquals("Report: XML", xmlStrategy.getReportType());
    }

    @Test
    public void testXMLReportStrategyNotNull() {
        assertNotNull(xmlStrategy.getReportType());
    }

    @Test
    public void testXMLReportStrategyGenerate() {
        assertDoesNotThrow(() -> xmlStrategy.generateReport("test_report"));
    }

    // ─── CSV Report Strategy tests ────────────────────────────────

    @Test
    public void testCSVReportStrategyType() {
        assertEquals("Report: CSV", csvStrategy.getReportType());
    }

    @Test
    public void testCSVReportStrategyNotNull() {
        assertNotNull(csvStrategy.getReportType());
    }

    @Test
    public void testCSVReportStrategyGenerate() {
        assertDoesNotThrow(() -> csvStrategy.generateReport("test_report"));
    }

    // ─── Word Report Strategy tests ───────────────────────────────

    @Test
    public void testWordReportStrategyType() {
        assertEquals("Report: Word", wordStrategy.getReportType());
    }

    @Test
    public void testWordReportStrategyNotNull() {
        assertNotNull(wordStrategy.getReportType());
    }

    @Test
    public void testWordReportStrategyGenerate() {
        assertDoesNotThrow(() -> wordStrategy.generateReport("test_report"));
    }

    // ─── Excel Report Strategy tests ──────────────────────────────

    @Test
    public void testExcelReportStrategyType() {
        assertEquals("Report: Excel", excelStrategy.getReportType());
    }

    @Test
    public void testExcelReportStrategyNotNull() {
        assertNotNull(excelStrategy.getReportType());
    }

    @Test
    public void testExcelReportStrategyGenerate() {
        assertDoesNotThrow(() -> excelStrategy.generateReport("test_report"));
    }

    // ─── Cross-strategy comparison tests ──────────────────────────

    @Test
    public void testAllStrategiesReturnDifferentTypes() {
        assertNotEquals(htmlStrategy.getReportType(), pdfStrategy.getReportType());
        assertNotEquals(pdfStrategy.getReportType(), jsonStrategy.getReportType());
        assertNotEquals(jsonStrategy.getReportType(), xmlStrategy.getReportType());
        assertNotEquals(xmlStrategy.getReportType(), csvStrategy.getReportType());
        assertNotEquals(csvStrategy.getReportType(), wordStrategy.getReportType());
        assertNotEquals(wordStrategy.getReportType(), excelStrategy.getReportType());
    }

    @Test
    public void testAllStrategiesAreNotNull() {
        assertNotNull(htmlStrategy);
        assertNotNull(pdfStrategy);
        assertNotNull(jsonStrategy);
        assertNotNull(xmlStrategy);
        assertNotNull(csvStrategy);
        assertNotNull(wordStrategy);
        assertNotNull(excelStrategy);
    }

    // ─── Document integration tests ───────────────────────────────

    @Test
    public void testDocumentWithHTMLStrategy() {
        Document doc = new Document("test", htmlStrategy);
        assertDoesNotThrow(doc::generateDocument);
    }

    @Test
    public void testDocumentWithPDFStrategy() {
        Document doc = new Document("test", pdfStrategy);
        assertDoesNotThrow(doc::generateDocument);
    }

    @Test
    public void testDocumentWithJSONStrategy() {
        Document doc = new Document("test", jsonStrategy);
        assertDoesNotThrow(doc::generateDocument);
    }

    @Test
    public void testDocumentWithXMLStrategy() {
        Document doc = new Document("test", xmlStrategy);
        assertDoesNotThrow(doc::generateDocument);
    }

    @Test
    public void testDocumentWithCSVStrategy() {
        Document doc = new Document("test", csvStrategy);
        assertDoesNotThrow(doc::generateDocument);
    }

    @Test
    public void testDocumentWithWordStrategy() {
        Document doc = new Document("test", wordStrategy);
        assertDoesNotThrow(doc::generateDocument);
    }

    @Test
    public void testDocumentWithExcelStrategy() {
        Document doc = new Document("test", excelStrategy);
        assertDoesNotThrow(doc::generateDocument);
    }

    // ─── Strategy polymorphism tests ──────────────────────────────

    @Test
    public void testStrategyPolymorphism() {
        ReportStrategy[] strategies = {
            htmlStrategy, pdfStrategy, jsonStrategy, 
            xmlStrategy, csvStrategy, wordStrategy, excelStrategy
        };
        
        for (ReportStrategy strategy : strategies) {
            assertNotNull(strategy.getReportType());
            assertDoesNotThrow(() -> strategy.generateReport("report"));
        }
    }

    @Test
    public void testDocumentStrategyIndependence() {
        Document doc1 = new Document("Report1", htmlStrategy);
        Document doc2 = new Document("Report2", pdfStrategy);
        Document doc3 = new Document("Report3", jsonStrategy);
        
        assertDoesNotThrow(doc1::generateDocument);
        assertDoesNotThrow(doc2::generateDocument);
        assertDoesNotThrow(doc3::generateDocument);
    }
}
