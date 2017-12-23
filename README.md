## Name
ユーザ管理システム

## Description
ユーザは個人情報を登録する。
その後ログインして、検索・更新・削除を行うことができるシステム。

## Feature
1. 検索：ユーザの個人情報を入力して、DBから呼び出す。
2. 更新：特定ユーザの情報を修正して、DBにセーブする。
3. 削除：特定ユーザの情報を、以降検索時見えないようにする。


＊登録、検索、そして更新フォームには入力値検証機能が付けられている。

## Demo
後日添付予定

## Requirement
* JAVA 1.8.0_144
* Pivotal tc Server v3.0 - v3.1
* MySQL  Ver 14.14 Distrib 5.7.20, for macos10.12 (x86_64) 

* その他: pom.xmlに全て定義されている（後述）

* ツール
 - Version: 3.7.3.RELEASE
 - MySQLWorkbench 6.3.9 (option)

## How to start
1. [javaインストール(Mac)] (https://weblabo.oscasierra.net/java-install-oracle-jdk8-macosx/)


2. [MySQLインストール(Mac)]
(https://www.youtube.com/watch?v=UcpHkYfWarM)

3. [STSインストール](https://spring.io/tools/sts/all)


4. Pivotal tc Server: 
STSインストールすると、その中で現れる。
STS → Servers → New → Server → Pivotal tc Server → 経路追加　→ Finish

5. Git → インストールする経路に移動　→ Git clone git@github.com:LLCCLL/userMng2.git

6. STS → Package Explore → プロジェクトフォルダimport: 
この時、pom.xmlに定義されてあるライブラリーがダウンロードされる。

7. プロジェクト実行：
Package Explore → ums右クリック → Run As → Run on Server → http://localhost:8080/ums/login?form