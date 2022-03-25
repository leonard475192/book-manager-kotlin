# Book Manager

## 

- lang: kotlin
- framework: Spring Boot
- ORM: Mybatis

## ハッシュ化したパスワードの生成方法

bcryptのアルゴリズムでハッシュ化したパスワードを生成する方法になります。
htpasswdコマンドを使用して以下のような形で生成できます。

```
$ htpasswd -n -B pass
New password: #引数で渡したパスワードを入力
Re-type new password: #引数で渡したパスワードを入力
pass:$2y$05$7IWY4KIY8l52R5XbTfU24uRw679eZeHHiSwtY2sfT5R7eAVGdJ1IS # この値を使用する
```
-nオプションで出力先を標準出力にし、-Bオプションでbcryptのアルゴリズムを使用するように指定しています。

これで最後の引数(上記の例ではpass)をbcryptでハッシュ化した値が標準出力に表示されます。

その後2回パスワードの入力を求められるので、引数と同様の値を入力し、出力された値をデータベースに登録するパスワードとして使用します。

## DB on docker

### 起動

```
cd docker
docker-compose up -d
```

### アクセス

```mysql -h 127.0.0.1 --port 3306 -u root -p mysql```

### DB作成

```
create database book_manager;
use book_manager;
```

### Table作成&ダミーデータの追加

sqlフォルダのsqlを実行

### MyBatisのコード生成

generatorConfig.xmlの8行目のmysql-connector-javaのパスは、各自の環境に合わせて変更


### sql文追加時

```./gredlew nbGenerator```

### FAQ

- build.gradle.ktsで、mybatisGeneratorうまく読み込めない
- `./gradlew mbGenerator`でエラー
  - gradle/wrapper/gradle-wrapper-propertiesで、gradleをバージョンダウン
  - `distributionUrl=https\://services.gradle.org/distributions/gradle-6.9.2-bin.zip`

## 動作確認

### 認証
#### ログイン

成功:user
```
curl -i -c cookie.txt -H 'Content-Type:application/x-www-form-urlencoded' -X POST -d 'email=user@test.com' -d 'pass=user' http://localhost:8080/login
```
成功:管理者
```
curl -i -c cookie.txt -H 'Content-Type:application/x-www-form-urlencoded' -X POST -d 'email=admin@test.com' -d 'pass=admin' http://localhost:8080/login
```


失敗: TODO エラーメッセージ 401だけだと、なにが足りないのか不明なため
```
curl -i -c cookie.txt -H 'Content-Type:application/x-www-form-urlencoded' -X POST -d 'email=user@test.com' -d 'pass=test' http://localhost:8080/login
```

#### 一覧
```
curl -i -b cookie.txt http://localhost:8080/book/list
```

#### 詳細
```
curl -i -b cookie.txt http://localhost:8080/book/detail/200
```

#### 貸出
```
curl -i -b cookie.txt -H 'Content-Type:application/json' -X POST -d '{"book_id":200}' http://localhost:8080/rental/start
```

#### 返却
```
curl -i -b cookie.txt -X DELETE http://localhost:8080/rental/end/200
```


### 認可: 管理者権限
#### 登録
```
curl -i -b cookie.txt -H 'Content-Type:application/json' -X POST -d '{"id":400,"title":"Kotlinサーバーサイドプログラミング実践","author":"竹端尚人","release_date":"2020-12-24"}' http://localhost:8080/admin/book/register
```

#### 更新
```
curl -i -b cookie.txt -H 'Content-Type:application/json' -X PUT -d '{"id":400,"title":"Kotlinサーバーサイドプログラミング実践第２版"}' http://localhost:8080/admin/book/update
```

#### 削除
```
curl -i -b cookie.txt -X DELETE http://localhost:8080/admin/book/delete/400
```
