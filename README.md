# 🌡️ Smart Climate Control System

A simulated smart home system developed in **Java** using **gRPC**, consisting of 3 core services: **Thermostat**, **Humidity Controller**, and **Air Quality Monitor**. Each service demonstrates a different gRPC communication style and mimics real-world smart home automation scenarios.

---

## 🛠️ Built With

- **Java**
- **gRPC**
- **NetBeans IDE**
- **Swing (Java GUI)**
- **Protocol Buffers (proto3)**
- **JWT Authentication**

---

## ⚙️ Features

| Service              | gRPC Style             | Description                                                                 |
|----------------------|------------------------|-----------------------------------------------------------------------------|
| **Thermostat**       | Unary + Server Stream  | Set/Get temperature, toggle auto-adjust mode, stream periodic updates.     |
| **Humidity Control** | Client Streaming       | Send multiple humidity readings and receive a summary response.            |
| **Air Quality Monitor** | Bi-Directional Stream | Live monitoring: send room names and receive ongoing air quality alerts.    |

---

## 🔐 Security Features

- **JWT Authentication** between clients and servers
- **gRPC Interceptors** on both client and server for token validation
- Secure key management using `io.jsonwebtoken`
- Clear feedback when services are unavailable or unauthenticated
- Custom error messages in GUI

---

## 📁 Project Structure

```
smart-climate-control-system/
├── thermostat/
│   ├── ThermostatServer.java
│   ├── ThermostatServiceImpl.java
│   ├── ThermostatGUI.java
├── humidity/
│   ├── HumidityServer.java
│   ├── HumidityServiceImpl.java
│   ├── HumidityGUI.java
├── airquality/
│   ├── AirQualityServer.java
│   ├── AirQualityServiceImpl.java
│   ├── AirQualityGUI.java
├── security/
│   ├── JwtUtil.java
│   ├── JwtClientInterceptor.java
│   └── JwtServerInterceptor.java
├── protos/
│   ├── Thermostat.proto
│   ├── HumidityControl.proto
│   └── AirQualityMonitor.proto
```

---

## 🧪 How to Run

1. **Clone the repo**  
   ```bash
   git clone https://github.com/your-username/smart-climate-control-system.git
   ```

2. **Open in NetBeans**

3. **Generate gRPC code from .proto files** (if needed using `protoc`)

4. **Start Servers:**
   - Run `ThermostatServer.java`
   - Run `HumidityServer.java`
   - Run `AirQualityServer.java`

5. **Launch GUIs:**
   - Run `ThermostatGUI.java`
   - Run `HumidityGUI.java`
   - Run `AirQualityGUI.java`

---

## 📸 Screenshots

| Thermostat GUI | Humidity GUI | Air Quality GUI |
|----------------|--------------|------------------|
| ![Thermostat](./screenshots/thermostat.png) | ![Humidity](./screenshots/humidity.png) | ![AirQuality](./screenshots/airquality.png) |

---

## 📚 Report

- 📄 [Project Report (PDF)](https://github.com/SilveiraGuilherme/Smart-Climate-Control-System/blob/main/Report/Smart%20Climate%20Control%20System.pdf)

---

## 🔗 Links

- [gRPC Java Documentation](https://grpc.io/docs/languages/java/)
- [Protocol Buffers](https://developers.google.com/protocol-buffers)
- [jjwt GitHub](https://github.com/jwtk/jjwt)

---

## 👤 Author

**Guilherme Silveira**  
📧 gws.silveira@gmail.com  
🌍 Dublin, Ireland
