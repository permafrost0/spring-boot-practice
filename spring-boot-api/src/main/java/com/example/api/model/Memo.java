package com.example.api.model;

import java.time.LocalDateTime;

public class Memo {

    private Long id;              // メモの識別番号
    private String title;         // タイトル
    private String content;       // 本文
    private LocalDateTime createdAt;  // 作成日時

    // --- コンストラクタ ---
    // 引数なしコンストラクタ（JSONからオブジェクトを作る時に必要）
    public Memo() {
    }

    // 全フィールドを指定するコンストラクタ
    public Memo(Long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.createdAt = LocalDateTime.now();
    }

    // --- Getter / Setter ---
    // Spring BootがJSONに変換する時、getterを使ってフィールドの値を読み取る
    // JSONからオブジェクトを作る時は、setterを使って値を書き込む

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
