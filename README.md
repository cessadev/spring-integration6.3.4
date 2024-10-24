# 🦠 COVID-19 Data Integration Demo using Spring Integration

## **Descripción**

Este proyecto es una **demostración práctica** del uso de **Spring Integration** para consumir datos de una API. La aplicación consulta la API REST de **COVID-19** cada 24 horas para obtener estadísticas por país, guarda los datos en una **base de datos H2** en memoria, y envía **alertas automáticas** si el número de casos supera un umbral crítico. 

El proyecto demuestra cómo Spring Integration permite **encapsular flujos de procesamiento** mediante mensajes, canales y transformaciones, lo que facilita la integración fluida de servicios externos en aplicaciones empresariales.

---

## **Características**
- **Consumo de APIs REST** usando un flujo automatizado con Spring Integration.
- **Persistencia de datos** en H2 (base de datos en memoria).
- **Alertas automáticas** si los casos de COVID-19 superan un límite definido.
- **Manejo de errores** al consumir servicios externos.
- **Endpoint REST adicional** para ejecutar el flujo de forma manual.

---

## **Tecnologías utilizadas**
- **Spring Boot** (2.x / 3.x)
- **Spring Integration**
- **Spring Data JPA**
- **H2 Database**
- **API REST de COVID-19**: [https://disease.sh](https://disease.sh)

---

## **Cómo ejecutar el proyecto**
1. **Clonar el repositorio**:
   ```bash
   git clone https://github.com/tu-usuario/covid-integration-demo.git
   cd covid-integration-demo
   ```

2. **Construir y ejecutar**:
   ```bash
   ./mvnw spring-boot:run
   ```

3. **Acceder a la consola H2** para verificar los datos guardados:
   - URL: [http://localhost:8080/h2-console](http://localhost:8080/h2-console)  
   - JDBC URL: `jdbc:h2:mem:testdb`
   - Usuario: `sa` (sin contraseña)

4. **Forzar la ejecución manual del flujo**:
   - **GET**: [http://localhost:8080/covid/trigger](http://localhost:8080/covid/trigger)

---

## **Ejemplo de Datos**
Respuesta de la API:
```json
{
  "country": "USA",
  "cases": 100500,
  "deaths": 1200,
  "recovered": 98500
}
```

---

## **Flujo de Integración**
1. **Consulta de datos**: La API de COVID-19 se consume cada 24 horas.
2. **Transformación**: La respuesta JSON se convierte en un objeto `CovidReport`.
3. **Persistencia**: El reporte se guarda en la base de datos.
4. **Alerta**: Si los casos superan los 100,000, se envía una alerta en la consola.

---

## **Mejoras Futuras**
- Envío de alertas por **correo electrónico** o **mensajería**.
- Implementación de **Kafka** para manejar reportes en tiempo real.
- Integración con un **dashboard** para mostrar los datos.

---

## **Licencia**
Este proyecto se distribuye bajo la **MIT License**.  
