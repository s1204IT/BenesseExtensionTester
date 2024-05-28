# BenesseExtension Tester

`android.os.BenesseExtension` の機能を呼び出します。

### 対応機種
- チャレンジパッド３  
  ※02.04.000以降
- チャレンジパッドNeo
- チャレンジパッドNext

### 関数一覧
変数 : (引数), (戻り値) です。

- **checkPassword** : (String), (boolean)  
  `com.mediatek(android).server.BenesseExtensionService.DEFAULT_HASH` もしくは `/factory/dcha_hash` の値と比較検証し､ 一致する場合は true を返します｡  
  `/factory/dcha_hash` の方が優先度が高いです｡  
  また､ CT3の場合､ 成功時は **SecurityException** が発生します｡

- **checkUsbCam** : (void), (boolean)  
  `/dev/video0` が存在するかどうかを確認します。  
  CT3 のみ存在します。

- **getBaseDisplaySize** : (void), (Point)  
  `IWindowsManager` の `getWindowsManager().getBaseDisplaySize(0, new android.graphics.Point())` の値を返します。  
  CT3 のみ存在します。

- **getDchaState** : (void), (int)  
  system テーブルの "**dcha_state**" の値を返します｡

- **getInitialDisplaySize** : (void), (Point)  
  `getBaseDisplaySize` と同様で、参照先が変わっただけです。  
  CT3 のみ存在します。

- **getInt** : (String), (int)  
  **bc** から始まる変数の値を返します｡  
  CT3 には存在しません｡

- **getLcdSize** : (void), (Point)
  `getInitialDisplaySize()` を呼び出します。  
  CT3 のみ存在します。

- **getString** : (String), (String)  
  **bc** から始まる変数の値を返します｡  
  CT3 では **`bc:mac_address`** のみ取得できます。

- **putInt** : (String, int), (boolean)  
  **bc** から始まる変数の値を変更します｡  
  CT3 には存在しません｡

- **putString** : (String, String), (boolean)  
  １つ目の引数に、  
  - bc:**touchpanel:fw_update**
  - bc:**digitizer:fw_update**
  - bc:**touchpanel:nvt:fw_update**
  
  ２つ目の引数に、アップデートファイルのパスを入力します。  
  bc:**touchpanel:fts:fw_update** は無視されています。    
  上手く動作していないので推測です。  
  CT3 及び CTX には存在しません｡

- **setDchaState** : (int), (void)  
  **dcha_state** の値を変更します｡  
  CT3 では **SecurityException** が発生します｡

- **setForcedDisplaySize**: (int, int), (boolean)  
  解像度を変更します。  
  ただし、`WRITE_SECURE_SETTINGS` の権限が必要です。  
  CT3 のみ存在します。

### 特定変数一覧

この **BenesseExtension** で使用可能な変数一覧です｡  
これらの変数は CTZ を参照しており､ CT3/CTX では使えない可能性があります｡

- bc:**compatscreen**  
  画面の密度と比率を変更できます。  
  **0**: h(240)dpi 1920x1200  
  **1**: m(160)dpi 1024x768  
  **2**: m(160)dpi 1200x800
- bc:**digitizer:fw_update**
- bc:**digitizer:fw_version**
- bc:**touchpanel\:palmreject:size**
- bc:**pen:battery**
- bc:**touchpanel\:fts:fw_update**
- bc:**touchpanel\:fts:fw_version**
- bc:**mac_address**  
  Wi-FiのMACアドレス
- bc:**nightcolor:current**  
  読書灯(夜間モード)の現在の輝度  
  この値が小さい程、輝度が高くなります。
- bc:**nightcolor:max**  
  読書灯の輝度の最大値 : `4082`
- bc:**nightcolor:min**  
  読書灯の輝度の最小値 : `2596`
- bc:**nightmode:active**  
  読書灯の状態  
  **0** : 無効  
  **1** : 有効
- bc:**touchpanel\:palmreject:size**
- bc:**pen:battery**
- bc:**touchpanel\:nvt:fw_update**
- bc:**touchpanel\:nvt:fw_version**
- **bc_password_hit**  
  端末再起動時に ADB が無効化されるのを阻止する。  
  値が **0 以外** だと阻止される｡  
  また､ 設定アプリから開発者向けオプションのパスワードの入力に成功した場合は､ **1** に設定される｡
- bc:**serial_no**  
  本体の製造番号
- bc:**touchpanel:fw_update**
- bc:**touchpanel:fw_version**
- bc:**touchpanel:lcd_type**
