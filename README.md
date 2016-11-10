## Angular 2 Frontent with SpringBoot (Java) Backend
Application to demonstrate various parts of a service oriented RESTfull application. 


### Technology Stack
Component         | Technology
---               | ---
Frontend          | Angular 2 , ReactiveX, Material-Design 
Backend (REST)    | SpringBoot 1.4 (Java)
Security          | Token Based (Spring Security and JWT)
REST Documentation| Swagger UI and ReDoc
REST Spec         | Open API Standard
In Memory DB      | H2 
Persistence       | JPA
Client Build Tools| angular-cli, Webpack, npm
Server Build Tools| Maven(Java)
Localization      | <Pending>     


## Build Instruction
Prerequisite 
- Java 8
- Maven 3.3.9
- Node 6.2.2, npm 3.9.5
- Angular-cli

Clone the repo in a folder
navigate to the folder where pom.xml is present 

### Install REST Backend

```bash
mvn clean install
```

### Install Frontend

```bash
# navigate to the client folder (the below command is relative to the folder where pom.xml is present) 
cd ./src/main/webui/cli_ng_msw
```

Install/Upgrade angular-cli Global package:

```bash
npm uninstall -g angular-cli
npm cache clean
npm install -g angular-cli@latest
```

Local project package:

```bash
rm -rf node_modules dist tmp
npm install --save-dev angular-cli@latest
npm install
```

### Running the app

**Server:** served from port 9119

to start the server go to the folder where pom.xml is present

```bash
# build: if no already build 
mvn clean install

# Start the server
java -jar ./target/sonicwall-1.0.0.jar
```

**Client:** served from port 4200

open another terminal and navigate to client folder 

```bash
# Navigate to client folder   
cd ./src/main/webui/cli_ng_msw

# build the client if not already built
npm install

# Start the client
ng serve
```

- Access Server at <http://localhost:9119/index.html>
- Access Client at <http://localhost:4200>

**Login Credentials**
```
demo:demo
admin:admin
inactive:inactive
```

**To get an authentication token** 

```bash
curl -X POST --header 'Content-Type: application/json' --header 'Accept: application/json' -d '{"username": "demo", "password": "demo" }' 'http://localhost:9119/session'
```
or POST the username and password to http://localhost:9119/session


after you get the authentication token you must provide this in the header for all the protected urls 

```bash
curl -X GET --header 'Accept: application/json' --header 'Authorization: [replace this with token ]' 'http://localhost:9119/version'
```
