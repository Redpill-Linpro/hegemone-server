# hegemone-server
Application that serves and stores plant data.

Requires `podman` and Java 17

Run locally:
1. Start postgres container

    ```
    podman run --oom-score-adj=200 --name hegemone-postgres -e POSTGRES_USER=admin -e POSTGRES_PASSWORD=planty -e POSTGRES_DB=hegemone -p 5432:5432 postgres:14.2
    ```

2. Start hegeonme-server in quarkus dev mode

    ```
    mvn quarkus:dev
    ```

3. Check health

    ```
    curl localhost:8080/device-measurements/health
    ```