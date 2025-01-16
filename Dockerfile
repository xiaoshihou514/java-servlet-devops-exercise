FROM maven:3-eclipse-temurin-11

RUN apt-get update && \
    apt-get install -y pandoc texlive-latex-base texlive-latex-recommended

COPY . /app
WORKDIR /app
RUN mvn package
ENTRYPOINT ["sh", "target/bin/simplewebapp"]
