# 🦠 COVID-19 Data Integration Demo using Spring Integration

## **Description**

This project is a **practical demonstration** of using **Spring Integration** to consume data from an API. The application queries the **COVID-19 REST API** every 24 hours to retrieve country-specific statistics, stores the data in an **in-memory H2 database**, and sends **automatic alerts** if the number of cases exceeds a critical threshold.

The project showcases how Spring Integration enables **encapsulation of processing flows** through messages, channels, and transformations, facilitating seamless integration of external services into enterprise applications.

---

## **Features**
- **REST API consumption** using an automated flow with Spring Integration.
- **Data persistence** in an in-memory H2 database.
- **Automatic alerts** when COVID-19 cases exceed a defined limit.
- **Error handling** when consuming external services.
- **Additional REST endpoint** to trigger the flow manually.

---

## **Technologies Used**
- **Spring Boot** (3.x)
- **Spring Integration**
- **Spring Data JPA**
- **H2 Database**
- **COVID-19 REST API**: [https://disease.sh](https://disease.sh)

---

## **How to Run the Project**
1. **Clone the repository**:
   ```bash
   git clone https://github.com/cessadev/spring-integration6.3.4.git
   cd spring-integration6.3.4
   ```

2. **Build and run the application**:
   ```bash
   ./mvnw spring-boot:run
   ```

3. **Access the H2 Console** to verify the stored data:
   - URL: [http://localhost:8080/h2-console](http://localhost:8080/h2-console)  
   - JDBC URL: `jdbc:h2:mem:testdb`
   - User: `sa` (no password)

4. **Manually trigger the flow**:
   - **GET**: [http://localhost:8080/covid/trigger](http://localhost:8080/covid/trigger)

---

## **Sample Data**
API response:
```json
{
  "country": "Colombia",
  "cases": 100500,
  "deaths": 1200,
  "recovered": 98500
}
```

---

## **Integration Flow**
1. **Data Query**: The COVID-19 API is queried every 24 hours.
2. **Transformation**: The JSON response is converted into a `CovidReport` object.
3. **Persistence**: The report is saved to the database.
4. **Alert**: If cases exceed 100,000, an alert is logged to the console.

---

## **Future Improvements**
- Sending alerts via **email** or **messaging services**.
- Implementing **Kafka** to handle real-time reports.
- Integration with a **dashboard** to display data visually.

---

## **License**
This project is distributed under the **MIT License**.
