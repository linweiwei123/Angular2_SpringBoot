all commands to be executed from the same folder where this readme file is present

INSTALL
-------
mvn clean package

RUN
---
java -jar ./target/sonicwall-1.0.0.jar



TO RUN JAVASCRIPT CLIENT ONLY
-----------------------------
cd src/main/webui/msw/msw
sencha app watch 
or 
sencha app build

http://localhost:1841/msw

