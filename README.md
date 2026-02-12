# Spring Boot REST API 学習プロジェクト

Java + Spring Boot の学習用プロジェクトです。Docker環境で開発を行います。

## 技術スタック

- Java 21
- Spring Boot 3.4.1
- Gradle
- Docker

## 起動方法

```bash
docker-compose up --build
```

## API エンドポイント

| Method | Path | 説明 |
|--------|------|------|
| GET | /hello | Hello メッセージを返す |

## アクセス

http://localhost:8080/hello
