# ===== Build Stage =====
FROM gradle:8.12-jdk21 AS build

WORKDIR /app

# Gradleの依存関係キャッシュのため、ビルドファイルを先にコピー
COPY spring-boot-api/build.gradle spring-boot-api/settings.gradle ./
RUN gradle dependencies --no-daemon || true

# ソースコードをコピーしてビルド
COPY spring-boot-api/src ./src
RUN gradle bootJar --no-daemon

# ===== Runtime Stage =====
FROM eclipse-temurin:21-jre

WORKDIR /app

# ビルド成果物をコピー
COPY --from=build /app/build/libs/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
