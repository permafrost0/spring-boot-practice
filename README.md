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

## プロジェクト構成

```
02_Java_practice/
├── Dockerfile                 # マルチステージビルド (Gradle → JRE)
├── docker-compose.yml         # コンテナ起動設定
└── spring-boot-api/
    ├── build.gradle           # 依存関係管理
    ├── settings.gradle
    └── src/main/java/com/example/api/
        ├── ApiApplication.java              # エントリーポイント
        ├── model/
        │   └── Memo.java                    # メモのデータモデル
        └── controller/
            ├── HelloController.java         # Hello API
            └── MemoController.java          # メモ CRUD API
```

## API エンドポイント

### Hello API

| Method | Path | 説明 |
|--------|------|------|
| GET | /hello | Hello メッセージを返す |

### メモ API

| Method | Path | 説明 |
|--------|------|------|
| GET | /memos | メモ一覧を取得 |
| GET | /memos/{id} | 指定IDのメモを1件取得 |
| POST | /memos | 新しいメモを作成 |

### リクエスト・レスポンス例

**メモ作成:**
```bash
curl -X POST -H "Content-Type: application/json" \
  -d '{"title":"買い物","content":"牛乳と卵を買う"}' \
  http://localhost:8080/memos
```

```json
{"id":1,"title":"買い物","content":"牛乳と卵を買う","createdAt":"2026-02-12T14:10:52"}
```

**メモ一覧取得:**
```bash
curl http://localhost:8080/memos
```

## 備考

- データはメモリ上 (ArrayList) に保存されるため、コンテナ停止で消えます
