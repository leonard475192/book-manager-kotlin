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

## DB

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

generatorConfig.xmlの8行目の変更

### FAQ

- build.gradle.ktsで、mybatisGeneratorうまく読み込めない
- `./gradlew mbGenerator`でエラー
- gradle/wrapper/gradle-wrapper-propertiesで、gradleをバージョンダウン
- `distributionUrl=https\://services.gradle.org/distributions/gradle-6.9.2-bin.zip`