# Drones Service

## Build/run/test Instructions:
* Java: v.17.0.4
* Gradle project
* SpringBoot v. 2.7.9
* Project default port: 8080
* H2 in-memory database (http://localhost:8080/h2-console/). Access with default login information.
* src/main/resources/data.sql file contains and load initial information on startup.

## Assumptions:
* The drone can be loaded only in "IDLE" or "LOADING" states.
* If drone capacity is completely covered its state is set to LOADED.
* Periodic task runs every 10 seconds.