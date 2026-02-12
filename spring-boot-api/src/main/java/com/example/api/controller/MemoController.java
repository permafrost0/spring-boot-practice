package com.example.api.controller;

import com.example.api.model.Memo;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController              // このクラスはREST APIのControllerです
@RequestMapping("/memos")    // このクラスの全エンドポイントが /memos で始まる
public class MemoController {

    // メモの保存先（今はメモリ上のリスト。サーバーを止めたら消える）
    private final List<Memo> memos = new ArrayList<>();

    // IDを自動採番するためのカウンター（1, 2, 3, ... と増えていく）
    private final AtomicLong idCounter = new AtomicLong(1);

    // ==========================================
    // GET /memos — メモ一覧を取得
    // ==========================================
    @GetMapping
    public List<Memo> getAllMemos() {
        return memos;
    }

    // ==========================================
    // POST /memos — 新しいメモを作成
    // ==========================================
    @PostMapping
    public Memo createMemo(@RequestBody Memo memo) {
        // @RequestBody: リクエストのJSON本文をMemoオブジェクトに変換してくれる
        //
        // クライアントが送るJSON:
        //   {"title": "買い物", "content": "牛乳を買う"}
        //          ↓ Spring Bootが自動変換
        //   Memo オブジェクト (title="買い物", content="牛乳を買う")

        memo.setId(idCounter.getAndIncrement());  // IDを自動採番
        memo.setCreatedAt(java.time.LocalDateTime.now());  // 作成日時を設定
        memos.add(memo);  // リストに追加
        return memo;       // 作成したメモをレスポンスとして返す
    }
}
