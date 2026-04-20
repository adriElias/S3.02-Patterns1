# Level 2 - Abstract Factory Pattern
**Description**: 

Implementation of the Abstract Factory design pattern with an international address and telephone number manager that automatically formats contact data according to the country of origin, allowing for correct representation without depending on concrete classes.

## 📌 Exercise Statement

### Level 2

### Abstract Factory Pattern

**What is it?**

The Abstract Factory pattern is a creational design pattern that provides an interface for creating families of related or dependent objects without specifying their concrete classes. In Java, this means we can create different sets of related objects through a single interface, ensuring that the created objects are compatible with each other.

Unlike the Singleton pattern, which focuses on creating a single instance, the Abstract Factory pattern focuses on creating families of related objects grouped by factories.

**Utility**

The Abstract Factory pattern is useful when:

🌍 We need to support multiple families of related objects (e.g., different country formats).

🔄 We want to switch between different implementations easily without modifying client code.

🛡️ We need to ensure that related objects are always created together consistently.

⚙️ We want to decouple the client from concrete implementations and promote flexibility.

A common example of Abstract Factory pattern usage is found in UI frameworks like Java Swing or JavaFX, where we can create different themes (Windows, Mac, Linux) with related components that work together consistently.

**Purpose**

The main purpose of the Abstract Factory pattern is:

👨‍👩‍👧‍👦 Create families of related objects without exposing their concrete classes.

🔗 Ensure that related objects work together correctly.

**Exercise:**

Implementation of an international address and phone number manager with the Abstract Factory pattern

**Objective**

Create a contact manager capable of automatically formatting addresses and phone numbers according to the country of origin using the Abstract Factory pattern.

Each concrete factory will be responsible for providing the specific format of each country, ensuring that the client can obtain the correct contact representation without depending on concrete classes.

**Description**

Imagine you are developing an international application that needs to manage contact data for users from different countries. Each country has:

- A specific address format (e.g., the order of fields, separators, etc.).
- A specific phone format, with a determined prefix and a specific pattern.

You need to implement a system that can:

- Create correctly formatted addresses and phones according to the selected country.
- Facilitate the extension to add new countries in the future without modifying existing code.

To achieve this, you will use the Abstract Factory pattern.

**Requirements**

1. Define abstract products: `Address`, `Phone`

2. Create the abstract factory: `ContactFactory`

3. Implement at least two concrete factories: `SpainContactFactory` and `USAContactFactory`

4. Implement concrete product classes. Each class must implement the specific format for its country:
   - Example Spain: `Carrer Example, 08001 Barcelona` | Example USA: `Example Street, New York, NY 10001`
   - Phone prefix Spain: `+34` | Phone prefix USA: `+1`

5. Create a `Contact` class that acts as a client:
   - Receives an instance of a concrete factory.
   - Allows creating addresses and phones without knowing concrete classes.

6. The results of the generated contact data must be demonstrated through **unit tests**.

**Expected Usage Example**

```java
// Spain
ContactFactory spainFactory = new SpainContactFactory(
    "Carrer Major 34", "Barcelona", "08001", "612345678"
);
Contact contactSpain = new Contact(spainFactory);
System.out.println(contactSpain.toString());
//OUTPUT: Address: Carrer Major 34, 08001 Barcelona | Phone: +34 612 34 56 78

// USA
ContactFactory usaFactory = new USAContactFactory(
    "154 5th Avenue", "New York", "NY 10001", "6123456789"
);
Contact contactUSA = new Contact(usaFactory);
System.out.println(contactUSA.toString());
//OUTPUT: Address: 154 5th Avenue, New York, NY 10001 | Phone: +1 (612) 345-6789
```

## ✨ Features
- Abstract Factory: Create families of related products (addresses and phones).
- Multiple country support: Spain and USA with specific formatting.
- Address formatting: Proper format for each country's addressing system.
- Phone formatting: Correct prefix and formatting pattern for each country.
- Client isolation: The Contact class does not depend on concrete implementations.
- Easy extensibility: New countries can be added by creating new factories and products.

## 🛠 Technologies
- Java 21
- Maven
- JUnit 5 for unit tests

## 🚀 Installation and Execution
1. Ensure that Java 21 and Maven are installed.
2. Clone the project repository.
3. Navigate to the project directory: `cd S3.02-Patterns1`
4. Compile the project: `mvn compile`
5. Run the main application: `mvn exec:java -Dexec.mainClass="Level2.App"`
6. Run the tests: `mvn test`

## 📁 Basic Project Structure (Level 2)
```text
S3.02-Patterns1/
├── src/
│   ├── main/
│   │   └── java/
│   │       └── Level2/
│   │           ├── Address.java
│   │           ├── App.java
│   │           ├── Contact.java
│   │           ├── ContactFactory.java
│   │           ├── Phone.java
│   │           ├── SpainAddress.java
│   │           ├── SpainContactFactory.java
│   │           ├── SpainPhone.java
│   │           ├── USAAddress.java
│   │           ├── USAContactFactory.java
│   │           ├── USAPhone.java
│   │           └── README.md
│   └── test/
│       └── java/
│           └── Level2/
│               └── ContactTest.java
├── pom.xml
├── README.md
└── .gitignore
```

## 📸 Demo
Not applicable, as it is a logic class without a graphical interface.

## 🧩 Diagrams and justification of technical decisions

### Architecture Overview

```
                    ┌─────────────────────┐
                    │    App (Client)     │
                    └──────────┬──────────┘
                               │ uses
                    ┌──────────▼──────────┐
                    │  ContactFactory     │
                    │   (interface)       │
                    │ + createAddress()   │
                    │ + createPhone()     │
                    │ + getStreet()       │
                    │ + getCity()         │
                    │ + getZipCode()      │
                    │ + getPhone()        │
                    └──┬──────────────┬───┘
                       │              │
         ┌─────────────▼─┐   ┌───────▼────────┐
         │SpainContact   │   │USAContact      │
         │Factory        │   │Factory         │
         └────────┬──────┘   └────────┬───────┘
                  │                   │
         ┌────────▼───────────────────▼──────┐
         │      Contact (Client)             │
         │ - contactFactory: ContactFactory  │
         │ - address: Address                │
         │ - phone: Phone                    │
         │ + toString(): String              │
         └────┬─────────────────────┬────────┘
              │                     │
         ┌────▼────┐           ┌───▼────┐
         │ Address  │           │ Phone  │
         │(interface)           │(interface)
         └─┬──────┬─────┘       └──┬───────┬──┘
           │      │                 │       │
    ┌──────▼──┐ ┌─▼──────┐   ┌──────▼─┐ ┌─▼────────┐
    │Spain    │ │USA     │   │Spain   │ │USA       │
    │Address  │ │Address │   │Phone   │ │Phone     │
    └─────────┘ └────────┘   └────────┘ └──────────┘
```

### Implementation Details

- **Abstract Factory Pattern**: 
  - `ContactFactory` interface defines the contract for creating families of products.
  - Concrete factories (`SpainContactFactory`, `USAContactFactory`) encapsulate country-specific data and creation logic.
  - Each factory stores `street`, `city`, `zipCode`, and `phone` as instance variables.
  - Factories provide getter methods to access this data.

- **Abstract Products**:
  - `Address` interface with `format(street, city, zipCode)` method.
  - `Phone` interface with `format(number)` and `getPrefix()` methods.
  - Defines the contract that all concrete implementations must follow.

- **Concrete Products**:
  - `SpainAddress`: Formats as `"street, zipCode city"` (e.g., "Carrer Major 34, 08001 Barcelona")
  - `USAAddress`: Formats as `"street, city, zipCode"` (e.g., "154 5th Avenue, New York, NY 10001")
  - `SpainPhone`: Formats as `"+34 XXX XX XX XX"` (9 digits with specific grouping)
  - `USAPhone`: Formats as `"+1 (XXX) XXX-XXXX"` (10 digits with specific grouping)

- **Contact Client**:
  - Stores a reference to the `ContactFactory` interface (not concrete implementations).
  - Creates Address and Phone products using the factory.
  - Implements `toString()` method that combines formatted address and phone.
  - Achieves loose coupling and high cohesion.

- **Key Design Decisions**:
  - **Factory as Data Container**: Factories store contact data (street, city, etc.) in addition to creating products. This simplifies the Contact class initialization.
  - **Dependency Injection**: Contact receives the factory as a constructor parameter, promoting testability and flexibility.
  - **Separation of Concerns**: Formatting logic is isolated in respective Address and Phone classes.
  - **Immutable Data**: Contact stores final references to factory, address, and phone objects.

- **Extensibility (Open/Closed Principle)**:
  - To add a new country (e.g., Germany), simply create:
    1. `GermanyContactFactory` implementing `ContactFactory`
    2. `GermanyAddress` implementing `Address`
    3. `GermanyPhone` implementing `Phone`
  - No modifications to existing code required.

- **Unit Tests (18 comprehensive tests)**:
  - 4 tests for `Contact.toString()` method
  - 3 tests for Spain address formatting
  - 3 tests for Spain phone formatting
  - 3 tests for USA address formatting
  - 3 tests for USA phone formatting
  - 2 tests for cross-country comparisons
  - All tests verify correct behavior and isolation between countries

