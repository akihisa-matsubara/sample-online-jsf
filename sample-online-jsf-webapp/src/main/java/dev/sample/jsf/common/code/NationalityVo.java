package dev.sample.jsf.common.code;

import dev.sample.common.code.CodeVo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 国籍Vo.
 */
@AllArgsConstructor
@Getter
public enum NationalityVo implements CodeVo {

  /** アフガニスタン. */
  AFGHANISTAN("0004", "アフガニスタン"),
  /** アルバニア. */
  ALBANIA("0008", "アルバニア"),
  /** アルジェリア. */
  ALGERIA("0012", "アルジェリア"),
  /** アメリカ領サモア. */
  AMERICAN_SAMOA("0016", "アメリカ領サモア"),
  /** アンドラ. */
  ANDORRA("0020", "アンドラ"),
  /** アンゴラ. */
  ANGOLA("0024", "アンゴラ"),
  /** アンティグア・バーブーダ. */
  ANTIGUA_AND_BARBUDA("0028", "アンティグア・バーブーダ"),
  /** アゼルバイジャン. */
  AZERBAIJAN("0031", "アゼルバイジャン"),
  /** アルゼンチン. */
  ARGENTINA("0032", "アルゼンチン"),
  /** オーストラリア. */
  AUSTRALIA("0036", "オーストラリア"),
  /** オーストリア. */
  AUSTRIA("0040", "オーストリア"),
  /** バハマ. */
  BAHAMAS("0044", "バハマ"),
  /** バーレーン. */
  BAHRAIN("0048", "バーレーン"),
  /** バングラデシュ. */
  BANGLADESH("0050", "バングラデシュ"),
  /** アルメニア. */
  ARMENIA("0051", "アルメニア"),
  /** バルバドス. */
  BARBADOS("0052", "バルバドス"),
  /** ベルギー. */
  BELGIUM("0056", "ベルギー"),
  /** ブータン. */
  BHUTAN("0064", "ブータン"),
  /** ボリビア. */
  BOLIVIA("0068", "ボリビア"),
  /** ボスニア・ヘルツェゴビナ. */
  BOSNIA_HERZEGOVINA("0070", "ボスニア・ヘルツェゴビナ"),
  /** ボツワナ. */
  BOTSWANA("0072", "ボツワナ"),
  /** ブラジル. */
  BRAZIL("0076", "ブラジル"),
  /** ベリーズ. */
  BELIZE("0084", "ベリーズ"),
  /** ソロモン諸島. */
  SOLOMON_ISLANDS("0090", "ソロモン諸島"),
  /** ブルネイ. */
  BRUNEI("0096", "ブルネイ"),
  /** ブルガリア. */
  BULGARIA("0100", "ブルガリア"),
  /** ミャンマー. */
  MYANMAR("0104", "ミャンマー"),
  /** ブルンジ. */
  BURUNDI("0108", "ブルンジ"),
  /** ベラルーシ. */
  BELARUS("0112", "ベラルーシ"),
  /** カンボジア. */
  CAMBODIA("0116", "カンボジア"),
  /** カメルーン. */
  CAMEROON("0120", "カメルーン"),
  /** カナダ. */
  CANADA("0124", "カナダ"),
  /** カーボベルデ. */
  CAPE_VERDE("0132", "カーボベルデ"),
  /** 中央アフリカ. */
  CENTRAL_AFRICA("0140", "中央アフリカ"),
  /** スリランカ. */
  SRI_LANKA("0144", "スリランカ"),
  /** チャド. */
  CHAD("0148", "チャド"),
  /** チリ. */
  CHILE("0152", "チリ"),
  /** 中華人民共和国. */
  CHINA("0156", "中華人民共和国"),
  /** 台湾. */
  TAIWAN("0158", "台湾"),
  /** コロンビア. */
  COLUMBIA("0170", "コロンビア"),
  /** コモロ. */
  COMOROS("0174", "コモロ"),
  /** コンゴ共和国. */
  REPUBLIC_OF_THE_CONGO("0178", "コンゴ共和国"),
  /** コンゴ民主共和国. */
  DEMOCRATIC_REPUBLIC_OF_THE_CONGO("0180", "コンゴ民主共和国"),
  /** クック諸島. */
  COOK_ISLANDS("0184", "クック諸島"),
  /** コスタリカ. */
  COSTA_RICA("0188", "コスタリカ"),
  /** クロアチア. */
  CROATIA("0191", "クロアチア"),
  /** キューバ. */
  CUBA("0192", "キューバ"),
  /** キプロス. */
  CYPRUS("0196", "キプロス"),
  /** チェコ. */
  CZECH_REPUBLIC("0203", "チェコ"),
  /** ベナン. */
  BENIN("0204", "ベナン"),
  /** デンマーク. */
  DENMARK("0208", "デンマーク"),
  /** ドミニカ国. */
  DOMINICA("0212", "ドミニカ国"),
  /** ドミニカ共和国. */
  DOMINICAN_REPUBLIC("0214", "ドミニカ共和国"),
  /** エクアドル. */
  ECUADOR("0218", "エクアドル"),
  /** エルサルバドル. */
  EL_SALVADOR("0222", "エルサルバドル"),
  /** 赤道ギニア. */
  EQUATORIAL_GUINEA("0226", "赤道ギニア"),
  /** エチオピア. */
  ETHIOPIA("0231", "エチオピア"),
  /** エリトリア. */
  ERITREA("0232", "エリトリア"),
  /** エストニア. */
  ESTONIA("0233", "エストニア"),
  /** フィジー. */
  FIJI("0242", "フィジー"),
  /** フィンランド. */
  FINLAND("0246", "フィンランド"),
  /** フランス. */
  FRANCE("0250", "フランス"),
  /** ジブチ. */
  DJIBOUTI("0262", "ジブチ"),
  /** ガボン. */
  GABON("0266", "ガボン"),
  /** グルジア. */
  GEORGIA("0268", "グルジア"),
  /** ガンビア. */
  GAMBIA("0270", "ガンビア"),
  /** ドイツ. */
  GERMANY("0276", "ドイツ"),
  /** ガーナ. */
  GHANA("0288", "ガーナ"),
  /** キリバス. */
  KIRIBATI("0296", "キリバス"),
  /** ギリシャ. */
  GREECE("0300", "ギリシャ"),
  /** グレナダ. */
  GRENADA("0308", "グレナダ"),
  /** グアテマラ. */
  GUATEMALA("0320", "グアテマラ"),
  /** ギニア. */
  GUINEA("0324", "ギニア"),
  /** ガイアナ. */
  GUYANA("0328", "ガイアナ"),
  /** ハイチ. */
  HAITI("0332", "ハイチ"),
  /** バチカン市国. */
  VATICAN_CITY("0336", "バチカン市国"),
  /** ホンジュラス. */
  HONDURAS("0340", "ホンジュラス"),
  /** 香港. */
  HONG_KONG("0344", "香港"),
  /** ハンガリー. */
  HUNGARY("0348", "ハンガリー"),
  /** アイスランド. */
  ICELAND("0352", "アイスランド"),
  /** インド. */
  INDIA("0356", "インド"),
  /** インドネシア. */
  INDONESIA("0360", "インドネシア"),
  /** イラン. */
  IRAN("0364", "イラン"),
  /** イラク. */
  IRAQ("0368", "イラク"),
  /** アイルランド. */
  IRELAND("0372", "アイルランド"),
  /** イスラエル. */
  ISRAEL("0376", "イスラエル"),
  /** イタリア. */
  ITALY("0380", "イタリア"),
  /** コートジボワール. */
  IVORY_COAST("0384", "コートジボワール"),
  /** 日本. */
  JAPAN("0386", "日本"),
  /** ジャマイカ. */
  JAMAICA("0388", "ジャマイカ"),
  /** カザフスタン. */
  KAZAKHSTAN("0398", "カザフスタン"),
  /** ヨルダン. */
  JORDAN("0400", "ヨルダン"),
  /** ケニア. */
  KENYA("0404", "ケニア"),
  /** 北朝鮮. */
  NORTH_KOREA("0408", "北朝鮮"),
  /** 大韓民国. */
  SOUTH_KOREA("0410", "大韓民国"),
  /** クウェート. */
  KUWAIT("0414", "クウェート"),
  /** キルギス. */
  KYRGYZSTAN("0417", "キルギス"),
  /** ラオス. */
  LAOS("0418", "ラオス"),
  /** レバノン. */
  LEBANON("0422", "レバノン"),
  /** レソト. */
  LESOTHO("0426", "レソト"),
  /** ラトビア. */
  LATVIA("0428", "ラトビア"),
  /** リベリア. */
  LIBERIA("0430", "リベリア"),
  /** リビア. */
  LIBYA("0434", "リビア"),
  /** リヒテンシュタイン. */
  LIECHTENSTEIN("0438", "リヒテンシュタイン"),
  /** リトアニア. */
  LITHUANIA("0440", "リトアニア"),
  /** ルクセンブルク. */
  LUXEMBOURG("0442", "ルクセンブルク"),
  /** マカオ. */
  MACAU("0446", "マカオ"),
  /** マダガスカル. */
  MADAGASCAR("0450", "マダガスカル"),
  /** マラウイ. */
  MALAWI("0454", "マラウイ"),
  /** マレーシア. */
  MALAYSIA("0458", "マレーシア"),
  /** モルディブ. */
  MALDIVES("0462", "モルディブ"),
  /** マリ. */
  MALI("0466", "マリ"),
  /** マルタ. */
  MALTA("0470", "マルタ"),
  /** モーリタニア. */
  MAURITANIA("0478", "モーリタニア"),
  /** モーリシャス. */
  MAURITIUS("0480", "モーリシャス"),
  /** メキシコ. */
  MEXICO("0484", "メキシコ"),
  /** モナコ. */
  MONACO("0492", "モナコ"),
  /** モンゴル. */
  MONGOLIA("0496", "モンゴル"),
  /** モルドバ. */
  MOLDOVA("0498", "モルドバ"),
  /** モンテネグロ. */
  MONTENEGRO("0499", "モンテネグロ"),
  /** モロッコ. */
  MOROCCO("0504", "モロッコ"),
  /** モザンビーク. */
  MOZAMBIQUE("0508", "モザンビーク"),
  /** オマーン. */
  OMAN("0512", "オマーン"),
  /** ナミビア. */
  NAMIBIA("0516", "ナミビア"),
  /** ナウル. */
  NAURU("0520", "ナウル"),
  /** ネパール. */
  NEPAL("0524", "ネパール"),
  /** オランダ. */
  NETHERLANDS("0528", "オランダ"),
  /** バヌアツ. */
  VANUATU("0548", "バヌアツ"),
  /** ニュージーランド. */
  NEW_ZEALAND("0554", "ニュージーランド"),
  /** ニカラグア. */
  NICARAGUA("0558", "ニカラグア"),
  /** ニジェール. */
  NIGER("0562", "ニジェール"),
  /** ナイジェリア. */
  NIGERIA("0566", "ナイジェリア"),
  /** ニウエ. */
  NIUE("0570", "ニウエ"),
  /** ノルウェー. */
  NORWAY("0578", "ノルウェー"),
  /** ミクロネシア連邦. */
  FEDERATED_STATES_OF_MICRONESIA("0583", "ミクロネシア連邦"),
  /** マーシャル諸島. */
  MARSHALL_ISLANDS("0584", "マーシャル諸島"),
  /** パラオ. */
  PALAU("0585", "パラオ"),
  /** パキスタン. */
  PAKISTAN("0586", "パキスタン"),
  /** パナマ. */
  PANAMA("0591", "パナマ"),
  /** パプアニューギニア. */
  PAPUA_NEW_GUINEA("0598", "パプアニューギニア"),
  /** パラグアイ. */
  PARAGUAY("0600", "パラグアイ"),
  /** ペルー. */
  PERU("0604", "ペルー"),
  /** フィリピン. */
  PHILIPPINES("0608", "フィリピン"),
  /** ポーランド. */
  POLAND("0616", "ポーランド"),
  /** ポルトガル. */
  PORTUGAL("0620", "ポルトガル"),
  /** ギニアビサウ. */
  GUINEA_BISSAU("0624", "ギニアビサウ"),
  /** 東ティモール. */
  EAST_TIMOR("0626", "東ティモール"),
  /** カタール. */
  QATAR("0634", "カタール"),
  /** ルーマニア. */
  ROMANIA("0642", "ルーマニア"),
  /** ロシア. */
  RUSSIA("0643", "ロシア"),
  /** ルワンダ. */
  RWANDA("0646", "ルワンダ"),
  /** セントクリストファーネイビス. */
  SAINT_KITTS_AND_NEVIS("0659", "セントクリストファーネイビス"),
  /** セントルシア. */
  SAINT_LUCIA("0662", "セントルシア"),
  /** セントビンセント他. */
  ST_VINCENT_AND_OTHERS("0670", "セントビンセント他"),
  /** サンマリノ. */
  SAN_MARINO("0674", "サンマリノ"),
  /** サントメ・プリンシペ. */
  SAO_TOME_AND_PRINCIPE("0678", "サントメ・プリンシペ"),
  /** サウジアラビア. */
  SAUDI_ARABIA("0682", "サウジアラビア"),
  /** セネガル. */
  SENEGAL("0686", "セネガル"),
  /** セルビア. */
  SERBIA("0688", "セルビア"),
  /** セーシェル. */
  SEYCHELLES("0690", "セーシェル"),
  /** シエラレオネ. */
  SIERRA_LEONE("0694", "シエラレオネ"),
  /** シンガポール. */
  SINGAPORE("0702", "シンガポール"),
  /** スロバキア. */
  SLOVAKIA("0703", "スロバキア"),
  /** ベトナム. */
  VIETNAM("0704", "ベトナム"),
  /** スロベニア. */
  SLOVENIA("0705", "スロベニア"),
  /** ソマリア. */
  SOMALIA("0706", "ソマリア"),
  /** 南アフリカ. */
  SOUTH_AFRICA("0710", "南アフリカ"),
  /** ジンバブエ. */
  ZIMBABWE("0716", "ジンバブエ"),
  /** スペイン. */
  SPAIN("0724", "スペイン"),
  /** 南スーダン. */
  SOUTH_SUDAN("0728", "南スーダン"),
  /** スーダン. */
  SUDAN("0729", "スーダン"),
  /** スリナム. */
  SURINAME("0740", "スリナム"),
  /** スウェーデン. */
  SWEDEN("0752", "スウェーデン"),
  /** スイス. */
  SWITZERLAND("0756", "スイス"),
  /** シリア. */
  SYRIA("0760", "シリア"),
  /** タジキスタン. */
  TAJIKISTAN("0762", "タジキスタン"),
  /** タイ. */
  THAILAND("0764", "タイ"),
  /** トーゴ. */
  TOGO("0768", "トーゴ"),
  /** トンガ. */
  TONGA("0776", "トンガ"),
  /** トリニダード・トバゴ. */
  REPUBLIC_OF_TRINIDAD_AND_TOBAGO("0780", "トリニダード・トバゴ"),
  /** アラブ首長国連邦. */
  UNITED_ARAB_EMIRATES("0784", "アラブ首長国連邦"),
  /** チュニジア. */
  TUNISIA("0788", "チュニジア"),
  /** トルコ. */
  TURKEY("0792", "トルコ"),
  /** トルクメニスタン. */
  TURKMENISTAN("0795", "トルクメニスタン"),
  /** ツバル. */
  TUVALU("0798", "ツバル"),
  /** ウガンダ. */
  UGANDA("0800", "ウガンダ"),
  /** ウクライナ. */
  UKRAINE("0804", "ウクライナ"),
  /** エジプト. */
  EGYPT("0818", "エジプト"),
  /** イギリス. */
  ENGLAND("0826", "イギリス"),
  /** タンザニア. */
  TANZANIA("0834", "タンザニア"),
  /** アメリカ合衆国. */
  UNITED_STATES_OF_AMERICA("0840", "アメリカ合衆国"),
  /** ブルキナファソ. */
  BURKINA_FASO("0854", "ブルキナファソ"),
  /** ウルグアイ. */
  URUGUAY("0858", "ウルグアイ"),
  /** ウズベキスタン. */
  UZBEKISTAN("0860", "ウズベキスタン"),
  /** ベネズエラ. */
  VENEZUELA("0862", "ベネズエラ"),
  /** サモア. */
  SAMOA("0882", "サモア"),
  /** イエメン. */
  YEMEN("0887", "イエメン"),
  /** ザンビア. */
  ZAMBIA("0894", "ザンビア"),
  /** その他. */
  OTHER("9999", "その他"),
  ;

  /** グループ：日本. */
  private static final List<NationalityVo> NATIONALITY_JAPAN_GROUP;
  /** グループ：日本以外. */
  private static final List<NationalityVo> NATIONALITY_BESIDES_JAPAN_GROUP;

  static {
    List<NationalityVo> tmp = new ArrayList<>();
    tmp.add(JAPAN);
    NATIONALITY_JAPAN_GROUP = Collections.unmodifiableList(tmp);

    tmp = new ArrayList<>();
    tmp.addAll(Arrays.asList(NationalityVo.values()));
    tmp.remove(NationalityVo.JAPAN);
    NATIONALITY_BESIDES_JAPAN_GROUP = Collections.unmodifiableList(tmp);
  }

  /** コード. */
  private String code;

  /** デコード. */
  private String decode;

  /**
   * 日本グループを取得します.
   *
   * @return 日本グループ
   */
  public static NationalityVo[] getNationalityJapanGroup() {
    return NATIONALITY_JAPAN_GROUP.toArray(new NationalityVo[NATIONALITY_JAPAN_GROUP.size()]);
  }

  /**
   * 日本以外グループを取得します.
   *
   * @return 日本以外グループ
   */
  public static NationalityVo[] getNationalityBesidesJapanGroup() {
    return NATIONALITY_BESIDES_JAPAN_GROUP.toArray(new NationalityVo[NATIONALITY_BESIDES_JAPAN_GROUP.size()]);
  }

}
