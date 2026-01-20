# Areca-Trend-AI
AI-powered Arecanut price prediction tool for Karnataka markets. Features a bilingual UI, CSV data analysis, and automated trend forecasting using Linear Regression
📈 Karnataka Arecanut Price Predictor


A bilingual (Kannada/English) application to view and predict arecanut prices in Karnataka markets.

This project provides two ways to use it:

Web version (HTML + JS) — open index.html.

Console version (Java) — interactive command-line program using the same data.

📑 Table of Contents

Web Version (HTML)

Console Version (Java)

File Description

How It Works

Bilingual Support

Tips

🌐 Web Version (HTML)
<details> <summary>Click to expand instructions</summary>

Open the folder and locate index.html.

Double-click index.html — your default web browser will open the app.

Upload or use the included Arecanut_Market_Data.csv.

Select District and Variety to see a 3-day price forecast with table and chart.

</details>
💻 Console Version (Java)
<details> <summary>Click to expand instructions</summary>

Ensure Java is installed (JDK 11 or later recommended).

Use the provided 5 Java files:

ArecanutPricePredictor.java → Main interactive program

BasePrices.java → Stores arecanut base prices

ForecastGenerator.java → Calculates 3-day forecast

Districts.java → List of Karnataka districts

Utils.java → Date formatting helper

Compile all Java files in the folder:

javac *.java


Run the program:

java ArecanutPricePredictor


Follow the interactive prompts:

Choose Language (English/Kannada)

Select District

Select Variety

View predicted price(s) for selected date(s)

The program reads the included CSV (arecanut_prices.csv) but you can edit or replace it.
Ensure columns remain the same:

district,variety,date,price
Shivamogga,Rashi,20-01-2026,55800
Shivamogga,Saraku,20-01-2026,85199

</details>
📁 File Description
File / Folder	Description
index.html	Main browser interface. Open to run.
Arecanut_Market_Data.csv	Historical arecanut prices. Can be edited.
css/	Optional CSS styles for web version.
js/	Optional JS scripts for web version.
README.md	This file.
ArecanutPricePredictor.java	Main console program in Java.
BasePrices.java	Base prices of varieties.
ForecastGenerator.java	3-day forecast logic.
Districts.java	District list for filtering.
Utils.java	Helper functions (date formatting).
🧠 How It Works
<details> <summary>Click to expand</summary>

Web version:

Reads CSV in the browser.

Allows selection of district & variety.

Shows 3-day forecast with table + chart.

Uses base prices + random fluctuation to simulate market trend.

Java version:

Reads CSV using Java.

Provides interactive console interface.

Generates the same 3-day forecast logic as the HTML version.

Both versions are consistent: the Java program replicates the HTML + JS logic.

🌍 Bilingual Support

Kannada (ಕನ್ನಡ) and English fully supported.

Switch language in console or sidebar (web version).

⚡ Tips
details summary Click to expand summary

CSV can be edited or replaced — just keep column headers: district,variety,date,price.

Double-click index.html → opens in browser.

Java version gives interactive prompts for language, district, variety, and date.

</details>
