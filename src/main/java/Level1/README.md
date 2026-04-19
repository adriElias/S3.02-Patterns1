# Level 1 - Singleton Pattern
**Description**: 

Implementation of the Singleton design pattern with an Undo class that allows managing a command history, adding new commands, undoing the last one, and displaying the history.

## 📌 Exercise Statement

### Level 1

### Singleton Pattern

**What is it?**

The Singleton pattern is a creational design pattern that guarantees that a class has only one instance and provides a global access point to it. In Java, this means that we can only create one object of this class, and we will always get the same instance every time we request it.

Under normal circumstances, a class in Java can be instantiated multiple times. However, there are situations where we only need a single instance to coordinate actions throughout the application. This is the typical case of the Singleton pattern.

**Utility**

The Singleton pattern is useful when:

🔒 We want to control access to a shared resource, such as a database connection, a configuration file, or a centralized log.


🌍 We need to maintain coherent global state accessible from different parts of the system.

⚠️ We seek to avoid creating multiple instances that consume unnecessary resources or generate synchronization conflicts.

A common example of Singleton pattern usage is found in frameworks like Spring, where beans are instantiated as Singleton by default to ensure that business logic is not unnecessarily duplicated.

**Purpose**

The main purpose of the Singleton pattern is:

🧍‍♂️ Guarantee a single instance of a class.

🌐 Provide a global access point to this instance.

**Exercise:**

Implementation of the Singleton pattern with an Undo class

**Objective**

Implement a class that replicates the basic functionality of the Undo command, using the Singleton design pattern to ensure that there is only one shared instance throughout the application.

**Description**

Create a class called Undo that is capable of:

Adding commands to its history.

Undoing the last command (undo-type functionality).

Listing all stored commands (similar to history in Linux).

The Undo class must implement the Singleton pattern to ensure that the entire program shares the same history.

**Requirements**

1. The constructor must be private.

2. Access to the instance must be done through a static getInstance() method.

3. The class must use a data structure such as Stack<String> or List<String> to store the commands.

4. Implement the following methods:
   - void addCommand(String command);
   - String undoCommand(); – returns and removes the last command.
   - void showHistory(); – displays all commands stored so far.

5. The code implementation must be demonstrated through **unit tests**.


Expected Usage Example

```text
Undo undo = Undo.getInstance();
undo.addCommand("mkdir carpeta");
undo.addCommand("cd carpeta");
undo.showHistory(); 
// Output: mkdir carpeta, cd carpeta

undo.undoCommand(); 
undo.showHistory(); 
// Output: mkdir carpeta
```

## ✨ Features
- Singleton: Guarantee a single instance of the Undo class.
- Add commands to the history.
- Undo the last command and return it.
- Display the command history on the console.

## 🛠 Technologies
- Java 21
- Maven
- JUnit 5 for unit tests

## 🚀 Installation and Execution
1. Ensure that Java 21 and Maven are installed.
2. Clone the project repository.
3. Navigate to the project directory: `cd S3.02-Patterns1`
4. Compile the project: `mvn compile`
5. Run the tests: `mvn test`

## 📁 Basic Project Structure (Level 1)
```text
S3.02-Patterns1/
├── src/
│   ├── main/
│   │   └── java/
│   │       └── Level1/
│   │           ├── App.java
│   │           ├── Undo.java
│   │           └── README.md
│   └── test/
│       └── java/
│           └── Level1/
│               └── UndoTest.java
├── pom.xml
├── README.md
└── .gitignore
```

## 📸 Demo
Not applicable, as it is a logic class without a graphical interface.

## 🧩 Diagrams and justification of technical decisions
- **Singleton Pattern**: Implemented with a private static `instance` field and a `getInstance()` method that creates the instance only if it does not exist. This guarantees a single global instance.
- **Data Structure**: `ArrayList<String>` is used for the history, as it allows adding elements at the end and removing the last one efficiently with `removeLast()`.
- **Methods**: `addCommand` adds to the list, `undoCommand` removes and returns the last one, `showCommandHistory` iterates and prints.
- **Tests**: JUnit 5 is used to verify the Singleton behavior and basic operations.
