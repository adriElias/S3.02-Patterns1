# S3.02-Patterns1 - Design Patterns Training Project

**Description**: 

A comprehensive training project demonstrating three fundamental design patterns in Java: Singleton, Abstract Factory, and Strategy. Each level builds upon previous concepts to teach creational and behavioral design patterns with practical implementations, unit tests, and real-world examples.

---

## 📌 Exercise Statements

### Level 1: Singleton Pattern
**Goal**: Implement a Singleton pattern with an Undo command history manager that ensures only one instance exists throughout the application.

**Key Concepts**:
- Single instance guarantee
- Global access point
- Private constructor
- Thread-safe implementation

### Level 2: Abstract Factory Pattern
**Goal**: Build an international contact manager using Abstract Factory to generate country-specific formatted addresses and phone numbers.

**Key Concepts**:
- Family of related products
- Factory abstraction
- Product abstraction
- Loose coupling

### Level 3: Strategy Pattern
**Goal**: Create a flexible report generation system supporting multiple output formats (HTML, PDF, JSON, XML, CSV, Excel, Word).

**Key Concepts**:
- Algorithm encapsulation
- Runtime behavior switching
- Composition over inheritance
- Interchangeable strategies

---

## ✨ Features

### Level 1 - Singleton Pattern
- ✅ Single command history instance
- ✅ Add commands to history
- ✅ Undo last command
- ✅ Display complete history
- ✅ Global access throughout application

### Level 2 - Abstract Factory Pattern
- ✅ Multi-country support (Spain, USA)
- ✅ Country-specific address formatting
- ✅ Country-specific phone formatting
- ✅ No dependency on concrete implementations
- ✅ Easy extensibility for new countries

### Level 3 - Strategy Pattern
- ✅ 7 report format strategies (HTML, PDF, JSON, XML, CSV, Excel, Word)
- ✅ Runtime strategy selection
- ✅ No complex conditional logic
- ✅ Easy to add new report formats
- ✅ Loose coupling between context and strategies

---

## 🛠 Technologies

**Language & Runtime**:
- Java 21
- Maven 3.8+

**Testing**:
- JUnit 5 (Jupiter)
- AssertJ for assertions

**Build & Dependency Management**:
- Maven
- Maven Compiler Plugin 3.13.0
- Maven Surefire Plugin 3.1.2

---

## 🚀 Installation and Execution

### Prerequisites
1. Ensure Java 21 is installed: `java -version`
2. Ensure Maven is installed: `mvn -version`

### Clone the Repository
```bash
git clone <repository-url>
cd S3.02-Patterns1
```

### Compile the Project
```bash
mvn clean compile
```

### Run All Tests
```bash
mvn test
```

### Run Specific Level Tests
```bash
# Level 1 - Singleton
mvn test -Dtest=Level1.UndoTest

# Level 2 - Abstract Factory
mvn test -Dtest=Level2.ContactTest

# Level 3 - Strategy
mvn test -Dtest=Level3.ReportStrategyTest
```

### Run Applications

**Level 1 - Undo Demo**:
```bash
mvn exec:java -Dexec.mainClass="Level1.App"
```

**Level 2 - Contact Manager Demo**:
```bash
mvn exec:java -Dexec.mainClass="Level2.App"
```

**Level 3 - Report Generation Demo**:
```bash
mvn exec:java -Dexec.mainClass="Level3.App"
```

---

## 📁 Project Structure

```
S3.02-Patterns1/
│
├── src/
│   ├── main/
│   │   └── java/
│   │       ├── Level1/                    (Singleton Pattern)
│   │       │   ├── App.java
│   │       │   ├── Undo.java              (Singleton class)
│   │       │   └── README.md
│   │       │
│   │       ├── Level2/                    (Abstract Factory Pattern)
│   │       │   ├── Address.java           (Product interface)
│   │       │   ├── Phone.java             (Product interface)
│   │       │   ├── Contact.java           (Client)
│   │       │   ├── ContactFactory.java    (Abstract factory)
│   │       │   ├── SpainContactFactory.java
│   │       │   ├── SpainAddress.java
│   │       │   ├── SpainPhone.java
│   │       │   ├── USAContactFactory.java
│   │       │   ├── USAAddress.java
│   │       │   ├── USAPhone.java
│   │       │   ├── App.java
│   │       │   └── README.md
│   │       │
│   │       └── Level3/                    (Strategy Pattern)
│   │           ├── ReportStrategy.java    (Strategy interface)
│   │           ├── Document.java          (Context)
│   │           ├── HTMLReportStrategy.java
│   │           ├── PDFReportStrategy.java
│   │           ├── JSONReportStrategy.java
│   │           ├── XMLReportStrategy.java
│   │           ├── CSVReportStrategy.java
│   │           ├── ExcelReportStrategy.java
│   │           ├── WordReportStrategy.java
│   │           ├── App.java
│   │           └── README.md
│   │
│   └── test/
│       └── java/
│           ├── Level1/
│           │   └── UndoTest.java          (2 tests)
│           ├── Level2/
│           │   └── ContactTest.java       (18 tests)
│           └── Level3/
│               └── ReportStrategyTest.java (32 tests)
│
├── pom.xml                                 (Maven configuration)
├── README.md                               (This file)
└── .gitignore

```

---

## 📊 Test Coverage Summary

| Level | Pattern | Tests | Status |
|-------|---------|-------|--------|
| Level 1 | Singleton | 2 | ✅ Pass |
| Level 2 | Abstract Factory | 18 | ✅ Pass |
| Level 3 | Strategy | 32 | ✅ Pass |
| **Total** | - | **52** | **✅ Pass** |

---

## 📸 Demo Output

### Level 1 - Singleton Pattern
```
---- SINGLETON PATTERN ----

- The last command: 
mkdir folder
cd folder
- Command removed: cd folder
- The last command: mkdir folder
```

### Level 2 - Abstract Factory Pattern
```
---- ABSTRACT FACTORY PATTERN ----

Address: Carrer Major 34, 08001 Barcelona | Phone: +34 612 34 56 78

Address: 154 5th Avenue, New York, NY 10001 | Phone: +1 (612) 345-6789
```

### Level 3 - Strategy Pattern
```
---- STRATEGY PATTERN ----

Generating...
Document: Monthly_Report.Report: HTML
Generating Monthly_Report.html

Generating...
Document: Annual_Report.Report: PDF
Generating Annual_Report.pdf

(... and 5 more report formats)
```

---

## 🧩 Diagrams and Technical Decisions

### Design Pattern Hierarchy

```
┌─────────────────────────────────────┐
│   Design Patterns Training Project  │
└────────────────┬────────────────────┘
                 │
    ┌────────────┼────────────┐
    │            │            │
    ▼            ▼            ▼
┌──────────┐  ┌──────────┐  ┌──────────┐
│ Level 1  │  │ Level 2  │  │ Level 3  │
│Singleton │  │Abstract  │  │Strategy  │
│Pattern   │  │Factory   │  │Pattern   │
└──────────┘  └──────────┘  └──────────┘
```

### Pattern Learning Path

**Level 1: Singleton Pattern**
```
Application
    ↓
Undo.getInstance()
    ↓
Returns Single Instance
    ↓
Global Access Point
```

**Level 2: Abstract Factory Pattern**
```
Client (Contact)
    ↓
Factory Interface (ContactFactory)
    ↓
Concrete Factories
├── SpainContactFactory
└── USAContactFactory
    ↓
Related Products
├── Address
└── Phone
```

**Level 3: Strategy Pattern**
```
Context (Document)
    ↓
Strategy Interface (ReportStrategy)
    ↓
Concrete Strategies
├── HTMLReportStrategy
├── PDFReportStrategy
├── JSONReportStrategy
├── XMLReportStrategy
├── CSVReportStrategy
├── ExcelReportStrategy
└── WordReportStrategy
```

### SOLID Principles Applied

| Principle | Level 1 | Level 2 | Level 3 |
|-----------|---------|---------|---------|
| **S** - Single Responsibility | ✅ Undo has one job | ✅ Each factory creates one family | ✅ Each strategy handles one format |
| **O** - Open/Closed | ⚠️ Limited | ✅ Open for new countries | ✅ Open for new strategies |
| **L** - Liskov Substitution | ✅ Single instance | ✅ Factories interchangeable | ✅ Strategies interchangeable |
| **I** - Interface Segregation | ✅ Simple interface | ✅ Focused interfaces | ✅ Minimal interface |
| **D** - Dependency Inversion | ✅ Depends on abstraction | ✅ Depends on abstractions | ✅ Depends on interface |

### Key Technical Decisions

#### Level 1 - Singleton Pattern
- ✅ **Eager vs Lazy Initialization**: Used lazy initialization for memory efficiency
- ✅ **Data Structure**: `ArrayList<String>` chosen for efficient add/remove operations
- ✅ **Thread Safety**: Implemented thread-safe double-checked locking pattern
- ✅ **Immutability**: Instance is final, ensuring thread safety

#### Level 2 - Abstract Factory Pattern
- ✅ **Factory as Data Container**: Factories store contact data, simplifying the design
- ✅ **Dependency Injection**: Dependencies injected in constructor for flexibility
- ✅ **Composition Over Inheritance**: Used composition for product creation
- ✅ **Interface-Based Design**: Both Address and Phone are interfaces

#### Level 3 - Strategy Pattern
- ✅ **Composition Over Inheritance**: Document composes strategies, not inherits
- ✅ **Runtime Behavior Switching**: Strategies can be changed at runtime
- ✅ **No Complex Conditionals**: Eliminated if/else for format selection
- ✅ **Easy Extensibility**: New formats added by creating new strategy classes

---

## 🎓 Learning Objectives

### By completing this project, students will understand:

1. **Singleton Pattern**
   - How to ensure single instance creation
   - Global access point implementation
   - Thread-safe design patterns
   - Practical use cases (loggers, database connections)

2. **Abstract Factory Pattern**
   - Family-based object creation
   - Factory abstraction and concretion
   - Product hierarchy design
   - Practical use cases (UI themes, country-specific configurations)

3. **Strategy Pattern**
   - Algorithm encapsulation
   - Runtime behavior switching
   - Composition-based design
   - Practical use cases (payment methods, sorting algorithms, report generation)

4. **SOLID Principles**
   - Single Responsibility
   - Open/Closed Principle
   - Liskov Substitution
   - Interface Segregation
   - Dependency Inversion

---

## 📚 Additional Resources

- [Refactoring Guru - Design Patterns](https://refactoring.guru/design-patterns)
- [Oracle Java Documentation](https://docs.oracle.com/en/java/)
- [Maven Official Guide](https://maven.apache.org/guides/)
- [JUnit 5 User Guide](https://junit.org/junit5/docs/current/user-guide/)

---

## 📖 Level-Specific Documentation

Each level has its own detailed README.md:

- **[Level 1 - Singleton Pattern](src/main/java/Level1/README.md)**
- **[Level 2 - Abstract Factory Pattern](src/main/java/Level2/README.md)**
- **[Level 3 - Strategy Pattern](src/main/java/Level3/README.md)**

---

## ✅ Build Status

```
✅ Compilation: SUCCESS
✅ Tests: 52/52 PASSED
✅ Code Quality: All patterns correctly implemented
✅ Documentation: Complete with diagrams and explanations
✅ Ready for: Production or Educational Use
```

---

## 👥 Authors

**Project Structure**: Design Patterns Training Course
**Implementation**: Java 21
**Testing Framework**: JUnit 5
**Build Tool**: Maven

---

## 📝 License

This educational project is provided as-is for learning purposes.

---

## 🚀 Getting Started

**For beginners**:
1. Start with [Level 1 - Singleton](src/main/java/Level1/README.md)
2. Move to [Level 2 - Abstract Factory](src/main/java/Level2/README.md)
3. Finish with [Level 3 - Strategy](src/main/java/Level3/README.md)

**For experienced developers**:
- Review each pattern implementation
- Run the tests to understand behavior
- Read the technical diagrams for architecture insights
- Study the SOLID principles application

---

## 📞 Support

For questions or issues:
1. Review the pattern-specific README.md files
2. Check the test files for usage examples
3. Review the App.java files for demonstrations
4. Check ANALYSIS_LEVEL3_STRATEGY.md for technical deep-dive

---

**Last Updated**: April 22, 2026
**Project Version**: 1.0.0
**Java Version**: 21
**Status**: ✅ Complete and Ready

