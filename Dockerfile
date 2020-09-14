FROM openjdk:8 AS build-stage

WORKDIR /opt/app
COPY . .
RUN ./gradlew distTar

FROM openjdk:8

COPY --from=build-stage /opt/app/build/distributions/kronstadt-1.0-SNAPSHOT.tar /opt/app/kronstadt-1.0-SNAPSHOT.tar

WORKDIR /opt/app
RUN tar xf kronstadt-1.0-SNAPSHOT.tar && rm kronstadt-1.0-SNAPSHOT.tar

WORKDIR /opt/app/kronstadt-1.0-SNAPSHOT
CMD ./bin/kronstadt
