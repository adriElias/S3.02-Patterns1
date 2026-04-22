# Level 3 - Strategy Pattern
**Description**: 

Implementation of the Strategy design pattern with a flexible and extensible report generation system that allows generating reports in multiple formats (CSV, JSON, PDF, HTML, XML, Word, Excel) by switching algorithms at runtime.

## 📌 Exercise Statement

### Level 3

### Strategy Pattern

**What is it?**

Strategy is a behavioral design pattern. Essentially, it allows us to change the behavior of an algorithm at runtime.

Normally, we would start with an interface that is used to apply an algorithm and then implement it multiple times for each possible algorithm. By leveraging Java 8, the introduction of lambdas has made anonymous inner types more or less redundant. This means creating strategies inline is now much cleaner and easier.

```java
public interface ReportStrategy {
    String getReportType();
    void generateReport(String nameReport);
    
    // Factory methods for creating strategies
    static ReportStrategy htmlStrategy() {
        return new HTMLReportStrategy();
    }
    
    static ReportStrategy pdfStrategy() {
        return new PDFReportStrategy();
    }
    
    static ReportStrategy jsonStrategy() {
        return new JSONReportStrategy();
    }
}
```

**Utility**

The Strategy pattern is useful when:

🍱 We want to separate the code that defines the strategy from the main logic to facilitate maintenance and extension.

⛓️ We want to avoid using complex conditions (if/switch) to choose a behavior.

A typical example is the implementation of different payment methods, sorting filters, or calculation strategies.

Common use cases include:
- Different payment methods (credit card, PayPal, bank transfer)
- Sorting algorithms (bubble sort, quick sort, merge sort)
- Compression algorithms (ZIP, RAR, 7Z)
- Report generation formats (CSV, JSON, PDF)

**Purpose**

The main purpose of the Strategy pattern is:

🔄 Replace inheritance with composition.

🎭 Separate different strategies of a specific behavior.

🧱 Introduce new strategies without having to change the context.

**Exercise:**

Implementation of the Strategy pattern for a report generation system.

**Objective**

Build a system capable of generating reports in different formats (CSV, JSON, PDF, HTML, XML, Word, Excel) using the Strategy pattern.

The system should be:
- **Flexible and extensible**: Allow easily adding new types of reports without modifying existing code (Open for extension, closed for modification).
- **Loosely coupled**: The class using reports should not depend on any concrete implementation (Dependency Inversion).

**Description**

Imagine you are building a reporting service that needs to generate reports in multiple formats. Each format has different output requirements and structure. Rather than using complex conditional logic to handle each format, we use the Strategy pattern to encapsulate each format in its own strategy.

**Requirements**

1. Define a `ReportStrategy` interface that specifies how reports should be generated.

2. Implement multiple report generation strategies:
   - HTML
   - JSON
   - XML
   - PDF
   - CSV
   - Excel
   - Word

3. Create a `Document` class that acts as the context and accepts any ReportStrategy implementation.

4. The class should not know the specifics of how each format works; it simply delegates to the strategy.

5. The demonstration of using strategies must be performed through unit tests.

**Expected Usage Example**

```java
// HTML Report
ReportStrategy htmlStrategy = new HTMLReportStrategy();
Document htmlDocument = new Document("Monthly_Report", htmlStrategy);
htmlDocument.generateDocument();
//OUTPUT: 
// Generating...
// Document: Monthly_Report.Report: HTML
// Generating Monthly_Report.html

// PDF Report
ReportStrategy pdfStrategy = new PDFReportStrategy();
Document pdfDocument = new Document("Annual_Report", pdfStrategy);
pdfDocument.generateDocument();
//OUTPUT:
// Generating...
// Document: Annual_Report.Report: PDF
// Generating Annual_Report.pdf

// Dynamic Strategy Change
Document report = new Document("Report", new HTMLReportStrategy());
report.generateDocument(); // Generates HTML

```

## ✨ Features
- Strategy Pattern: Encapsulate algorithms to make them interchangeable.
- Multiple Report Formats: Support for HTML, PDF, JSON, XML, CSV, Excel, and Word.
- Runtime Strategy Selection: Choose the report format at runtime without code changes.
- Loose Coupling: Document class is independent of concrete strategy implementations.
- Easy Extensibility: Add new report formats by simply implementing the ReportStrategy interface.
- No Complex Conditionals: Eliminates if/switch statements for choosing behavior.

## 🛠 Technologies
- Java 21
- Maven
- JUnit 5 for unit tests

## 🚀 Installation and Execution
1. Ensure that Java 21 and Maven are installed.
2. Clone the project repository.
3. Navigate to the project directory: `cd S3.02-Patterns1`
4. Compile the project: `mvn compile`
5. Run the main application: `mvn exec:java -Dexec.mainClass="Level3.App"`
6. Run the tests: `mvn test -Dtest=Level3.ReportStrategyTest`

## 📁 Basic Project Structure (Level 3)
```text
S3.02-Patterns1/
├── src/
│   ├── main/
│   │   └── java/
│   │       └── Level3/
│   │           ├── ReportStrategy.java (Interface)
│   │           ├── Document.java (Context)
│   │           ├── HTMLReportStrategy.java
│   │           ├── PDFReportStrategy.java
│   │           ├── JSONReportStrategy.java
│   │           ├── XMLReportStrategy.java
│   │           ├── CSVReportStrategy.java
│   │           ├── ExcelReportStrategy.java
│   │           ├── WordReportStrategy.java
│   │           ├── App.java
│   │           └── README.md
│   └── test/
│       └── java/
│           └── Level3/
│               └── ReportStrategyTest.java
├── pom.xml
├── README.md
└── .gitignore
```

## 📸 Demo
The application generates reports in 7 different formats:

```
---- STRATEGY PATTERN ----

Generating...
Document: Monthly_Report.Report: HTML
Generating Monthly_Report.html

Generating...
Document: Annual_Report.Report: PDF
Generating Annual_Report.pdf

Generating...
Document: API_Response.Report: JSON
Generating API_Response.json

(... and so on for XML, CSV, Word, Excel)
```

## 🧩 Diagrams and justification of technical decisions

### Architecture Overview

```
                    ┌──────────────────────┐
                    │   App (Client)       │
                    └──────────┬───────────┘
                               │ uses
                    ┌──────────▼──────────┐
                    │  ReportStrategy     │
                    │   (Strategy)        │
                    │ + getReportType()   │
                    │ + generateReport()  │
                    └──┬──────────────┬───┘
                       │              │
         ┌─────────────▼─┐   ┌───────▼────────┐
         │HTMLReportStr. │   │PDFReportStr.   │
         │JSONReportStr. │   │XMLReportStr.   │
         │CSVReportStr.  │   │ExcelReportStr. │
         │WordReportStr. │   │                │
         └──────┬────────┘   └────────────────┘
                │                    │
         ┌──────▼──────────────────┬─┘
         │   Document (Context)   │
         │ - reportStrategy       │
         │ + generateDocument()   │
         │
         └────────────────────────┘
```

### Implementation Details

- **Strategy Interface** (`ReportStrategy`):
  - Defines the contract for all report generation strategies
  - `getReportType()` - Returns the type of report being generated
  - `generateReport(String name)` - Generates the report with the specified name

- **Concrete Strategies** (7 implementations):
  - Each strategy encapsulates the algorithm for generating a specific report format
  - `HTMLReportStrategy` - Generates HTML reports with .html extension
  - `PDFReportStrategy` - Generates PDF reports with .pdf extension
  - `JSONReportStrategy` - Generates JSON reports with .json extension
  - `XMLReportStrategy` - Generates XML reports with .xml extension
  - `CSVReportStrategy` - Generates CSV reports with .csv extension
  - `ExcelReportStrategy` - Generates Excel reports with .xlsx extension
  - `WordReportStrategy` - Generates Word reports with .docx extension

- **Context Class** (`Document`):
  - Accepts a `ReportStrategy` in its constructor (Dependency Injection)
  - Stores a reference to the strategy (composition over inheritance)
  - Delegates report generation to the strategy via `generateDocument()`

### Design Principles Applied

- **Strategy Pattern**: Encapsulates algorithms in interchangeable objects
- **Composition over Inheritance**: Document uses strategies through composition, not inheritance
- **Dependency Inversion Principle**: Document depends on the ReportStrategy abstraction, not concrete implementations
- **Open/Closed Principle**: Open for extension (add new strategies), closed for modification (no changes to Document needed)
- **Single Responsibility Principle**: Each strategy is responsible for generating one format
- **Liskov Substitution Principle**: All strategies are interchangeable
- **Interface Segregation Principle**: ReportStrategy provides a minimal, focused interface

### Key Benefits

1. **Flexibility**: Change report format at runtime without recompiling
2. **Extensibility**: Add new formats by creating new strategy classes
3. **Maintainability**: Each format is isolated in its own class
4. **Testability**: Each strategy can be tested independently
5. **No Complex Conditionals**: Eliminates if/else or switch statements

### Comparison: Without vs With Strategy Pattern

**Without Strategy (Anti-pattern)**:
```java
public class Document {
    private String format;
    
    public void generateDocument() {
        if (format.equals("HTML")) {
            // Generate HTML
        } else if (format.equals("PDF")) {
            // Generate PDF
        } else if (format.equals("JSON")) {
            // Generate JSON
        }
        // ... many more conditions
    }
}
```

**With Strategy (Correct Pattern)**:
```java
public class Document {
    private ReportStrategy strategy;
    
    public void generateDocument() {
        strategy.generateReport(name);
    }
}
```

The strategy pattern approach is:
- ✅ More maintainable
- ✅ More extensible
- ✅ Easier to test
- ✅ Follows SOLID principles
- ✅ Reduces complexity

### Unit Tests

32 comprehensive tests verify:
- Each strategy returns the correct report type
- Each strategy generates reports without errors
- Document can work with any strategy
- Strategies are interchangeable (polymorphism)
- Integration between Document and strategies works correctly
- All 7 report formats are handled correctly

---

## 🏆 Conclusion

The Strategy pattern implementation demonstrates how to:
- Encapsulate varying algorithms in separate classes
- Make algorithms interchangeable at runtime
- Avoid complex conditional logic
- Create flexible and extensible systems
- Follow SOLID design principles

This design allows the report generation system to easily support new formats in the future without modifying existing code.
