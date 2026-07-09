# Mini ERP Backend

A console-based Mini ERP backend project built using **Java**, **JDBC**, **Oracle XE**, **PL/SQL**, **Triggers**, and **Oracle JDeveloper**.

This project was created to practice backend development concepts and demonstrate proficiency in:

- Java programming
- Oracle SQL
- PL/SQL packages
- Database triggers
- JDBC connectivity
- Oracle JDeveloper
- Oracle XE database operations

---

## Tech Stack

- Java 17
- Oracle Database XE 21c
- Oracle JDBC (`ojdbc11.jar`)
- PL/SQL
- Oracle JDeveloper 14c

---

## Project Type

This is a **backend-only** project.

There is no graphical user interface. The application is executed using:

- SQL scripts through Oracle SQL Worksheet
- Java console applications in Oracle JDeveloper

---

## Features

- Employee management
- Customer management
- Product management
- Order creation
- Order item management
- Automatic line total calculation using triggers
- Order total calculation using PL/SQL packages
- Automatic stock reduction after order placement
- Java-based reporting using JDBC

---

## Modules

- Employees
- Customers
- Products
- Orders
- Order Items
- Reports

---

## Project Structure

```text
mini-erp/
├── sql/
│   ├── 01_tables.sql
│   ├── 02_trigger_line_total.sql
│   ├── 03_package_spec.sql
│   ├── 04_package_body.sql
│   ├── 05_seed_data.sql
│   ├── 06_reset_data.sql
│   └── 07_check_data.sql
│
├── java/
│   ├── DbUtil.java
│   ├── SetupCheck.java
│   ├── EmployeeReport.java
│   ├── ProductStockReport.java
│   └── PlaceOrderDemo.java
│
└── README.md
```

---

## Prerequisites

Ensure the following software is installed:

- Oracle JDK 17
- Oracle Database XE 21c
- Oracle JDeveloper 14c

---

## Database Connection

Use the following Oracle database configuration:

| Property | Value |
|----------|-------|
| Host | localhost |
| Port | 1521 |
| Service Name | XEPDB1 |

---

## JDBC Driver

Add the Oracle JDBC driver to your JDeveloper project libraries:

```text
C:\app\kalya\product\21c\dbhomeXE\jdbc\lib\ojdbc11.jar
```

---

## SQL Execution Order

Run the SQL scripts in the following sequence:

1. `01_tables.sql`
2. `02_trigger_line_total.sql`
3. `03_package_spec.sql`
4. `04_package_body.sql`
5. `05_seed_data.sql`
6. `07_check_data.sql`

Use `06_reset_data.sql` whenever you need to reset the project data.

---

## Java Execution Order

Run the Java classes in the following order:

1. `SetupCheck`
2. `EmployeeReport`
3. `ProductStockReport`
4. `PlaceOrderDemo`
5. `ProductStockReport` (again to verify stock updates)

---

## Java Classes

### DbUtil.java

Creates the JDBC connection to Oracle XE.

### SetupCheck.java

Verifies that Java can successfully connect to the Oracle database.

### EmployeeReport.java

Displays employee records stored in the ERP database.

### ProductStockReport.java

Displays product information and current stock quantities.

### PlaceOrderDemo.java

Creates a sample order, inserts order items, finalizes the order, calculates totals, and updates product inventory.

---

## Business Workflow

The project demonstrates a complete backend ERP flow:

1. Seed employee, customer, and product data.
2. Create a customer order.
3. Add products to the order.
4. Automatically calculate line totals.
5. Calculate the complete order total.
6. Reduce product stock.
7. Generate reports using Java and JDBC.

---

## Key Learning Outcomes

This project demonstrates practical experience with:

- Java and Oracle database connectivity
- JDBC programming
- Calling PL/SQL packages from Java
- Writing reusable PL/SQL packages
- Oracle trigger implementation
- Transaction management
- Backend ERP workflow design
- Organizing SQL scripts for maintainability

---

## Notes

- This project is intentionally console-based to emphasize backend development concepts.
- Line totals are calculated automatically using Oracle triggers.
- Order totals are calculated through PL/SQL package logic.
- Identity values may continue increasing after repeated data resets depending on the reset strategy used.

---

## Author

Built as a learning and showcase project to practice backend development using **Java**, **Oracle Database XE**, **PL/SQL**, **JDBC**, and **Oracle JDeveloper**.