# 🍕 Pizza Ordering JavaFX Application

A modern, easy-to-use **JavaFX desktop app** for pizza orders, with a sleek UI and MySQL database integration.  
Place orders, view history, and calculate bills—all in one place!

---

[![JavaFX](https://img.shields.io/badge/JavaFX-24.0.1-blue.svg)]()
[![MySQL](https://img.shields.io/badge/MySQL-8.0+-blue.svg)]()
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)]()

---

## ✨ Features

- **Add Pizza Order**: Capture customer name, mobile, pizza size, and toppings
- **View Orders**: See all orders in a table
- **Instant Bill Calculation**: Automatic pricing based on size & toppings
- **Persistent Storage**: Orders saved in MySQL database
- **Responsive UI**: Built with JavaFX for a smooth desktop experience

---

## 📁 Project Structure

PreetPizzaOrderApp1/
│
├── src/
│ ├── MainApp.java
│ ├── controller/
│ │ └── PizzaController.java
│ ├── dao/
│ │ └── PizzaOrderDAO.java
│ ├── model/
│ │ └── PizzaOrder.java
│ └── util/
│ └── DBUtil.java
│
├── view/
│ └── PizzaOrderView.fxml
│
├── lib/
│ └── mysql-connector-j-9.3.0.jar
│
└── out/

---

## 🛠️ Prerequisites

- [Java JDK 17+](https://adoptopenjdk.net/) (or compatible)
- [JavaFX SDK 24+](https://gluonhq.com/products/javafx/)
- [MySQL Server](https://dev.mysql.com/downloads/mysql/)
- MySQL Connector/J JAR (included in `lib` folder)

---

## ⚡ Quick Start

### 1️⃣ Clone and Prepare

Download or clone this repository, then open it in your favorite IDE or command prompt.

### 2️⃣ Set Up the Database

```sql
CREATE DATABASE pizzaapp;
USE pizzaapp;
CREATE TABLE orders (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(100),
  mobile VARCHAR(15),
  size VARCHAR(10),
  toppings INT,
  total DOUBLE
);
3️⃣ Configure DB Connection
Open src/util/DBUtil.java and set your MySQL username and password.

java
Copy
Edit
private static final String URL = "jdbc:mysql://localhost:3306/pizzaapp";
private static final String USER = "root";      // <--- your MySQL username
private static final String PASSWORD = "root";  // <--- your MySQL password
4️⃣ Build
In your project root, run:

sh
Copy
Edit
javac --module-path "C:\javafx-sdk-24.0.1\lib" --add-modules javafx.controls,javafx.fxml ^
-cp ".;lib/mysql-connector-j-9.3.0.jar" -d out ^
src\MainApp.java src\controller\PizzaController.java src\dao\PizzaOrderDAO.java src\model\PizzaOrder.java src\util\DBUtil.java
5️⃣ Copy FXML
sh
Copy
Edit
xcopy /s /y view out\view
6️⃣ Run
sh
Copy
Edit
cd out
java --module-path "C:\javafx-sdk-24.0.1\lib" --add-modules javafx.controls,javafx.fxml ^
-cp ".;../lib/mysql-connector-j-9.3.0.jar" MainApp


📚 How It Works
MVC Design: Organized into model, view, controller, dao, and util for clarity and reusability.

Order Placement: Enter customer details, pizza size, and number of toppings. Click Add Order.

Data Storage: Orders are saved directly into the MySQL database and displayed in the app table.

🙋 FAQ & Tips
If you get a DB Connection error, ensure MySQL is running and credentials in DBUtil.java are correct.

JavaFX SDK path should point to your extracted JavaFX installation.

Use English language for table/field names for best compatibility.

🤝 Credits
Built with ❤️ by Preet Patel

JavaFX, MySQL, OpenAI (for ChatGPT assistance)
