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
  `com.mediatek.server.BenesseExtensionService.DEFAULT_HASH` もしくは `/factory/dcha_hash` の値と比較検証し､ 一致する場合は true を返します｡  
  `/factory/dcha_hash` の方が優先度が高いです｡  
  また､ CT3の場合､ 成功時は **SerurityException** が発生します｡

- **getDchaState** : (void), (int)  
  system テーブルの "**dcha_state**" の値を返します｡

- **getInt** : (String), (int)  
  **bc** から始まる system テーブルの変数の値を返します｡  
  CT3 には存在しません｡

- **getString** : (String), (String)  
  **bc** から始まる system テーブルの変数の値を返します｡  
  CT3 では **SecurityException** が発生します｡

- **putInt** : (String, int), (boolean)  
  **bc** から始まる system テーブルの変数の値を変更します｡  
  CT3 には存在しません｡

- **putString** : (String, String), (boolean)  
  **bc** から始まる system テーブルの変数の値を変更します｡  
  CT3 及び CTX には存在しません｡

- **setDchaState** : (int), (void)  
  system テーブルの "**dcha_state**" の値を変更します｡  
  CT3 では **SecurityException** が発生します｡

### 特定変数一覧

この BenesseExtension で取得可能な変数一覧です｡  
これらの変数はCTZを参照しており､ CT3/X では使えない可能性があります｡

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
  夜間モードの輝度
- bc:**nightcolor:max**  
  <!--夜間モードの開始/終了時間-->
- bc:**nightcolor:min**  
  <!--夜間モードの開始/終了時間-->
- bc:**nightmode:active**  
  夜間モードの状態  
  **0**: 無効  
  **1**: 有効
- bc:**touchpanel\:palmreject:size**
- bc:**pen:battery**
- bc:**touchpanel\:nvt:fw_update**
- bc:**touchpanel\:nvt:fw_version**
- **bc_password_hit**  
  端末再起動時にADBの有効状態を保持する｡  
  値が **0 以外** だと保持される｡  
  また､ 設定アプリから開発者向けオプションのパスワードの入力に成功した場合は､ **1** に設定される｡
- bc:**serial_no**  
  本体の製造番号
- bc:**touchpanel:fw_update**
- bc:**touchpanel:fw_version**
- bc:**touchpanel:lcd_type**
