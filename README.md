# Java HTTP Server 

A lightweight, custom-built HTTP server in Java.

## Features

- ✅ Static file serving (HTML, CSS, JavaScript)
- ✅ Custom HTTP server implementation
- ✅ Configurable port and webroot
- ✅ JSON-based configuration
- ✅ Logging with SLF4J
- ✅ Multi-threaded request handling

## Prerequisites

- Java 8 or higher
- Maven (for dependency management)

## Project Structure

```
portfolio-server/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/nalaka/httpserver/
│   │   │       ├── HttpServer.java
│   │   │       ├── config/
│   │   │       │   ├── Configuration.java
│   │   │       │   └── ConfigurationManager.java
│   │   │       ├── core/
│   │   │       │   ├── ServerListenerThread.java
│   │   │       │   ├── HttpConnectionWorkerThread.java
│   │   │       │   ├── TelnetServer.java
│   │   │       │   └── io/
│   │   │       │       └── WebRootNotFoundException.java
│   │   │       ├── http/
│   │   │       │   ├── HttpRequest.java
│   │   │       │   ├── HttpResponse.java
│   │   │       │   └── HttpParser.java
│   │   │       └── util/
│   │   │           └── FileHelper.java
│   │   └── resources/
│   │       ├── http.json
│   │       └── webroot/
│   │           ├── index.html
│   │           ├── css/
│   │           └── js/
│   └── test/
└── pom.xml
```

## Configuration

Edit `src/main/resources/http.json`:

```json
{
  "port": 8080,
  "webroot": "E:\\Code\\http-server\\src\\main\\resources\\webroot"
}
```

- **port**: HTTP server port (default: 8080)
- **webroot**: Absolute path to your portfolio files

## Installation & Setup

1. **Clone the repository:**
   ```bash
   git clone <your-repo-url>
   cd http-server
   ```

2. **Build the project:**
   ```bash
   mvn clean install
   ```

3. **Place your HTML files in the webroot folder:**
   ```
   src/main/resources/webroot/
   ├── index.html

## Running the Server

### Option 1: Using Maven
```bash
mvn exec:java -Dexec.mainClass="com.nalaka.httpserver.HttpServer"
```

### Option 2: Using compiled JAR
```bash
java -jar target/http-server-1.0-SNAPSHOT.jar
```

### Option 3: From IDE
Run the `HttpServer.java` main class

## Accessing Your Server

### Local Access
```
http://localhost:8080
```
