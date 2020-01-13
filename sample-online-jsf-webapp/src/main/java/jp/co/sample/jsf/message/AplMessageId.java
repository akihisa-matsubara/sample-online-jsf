package jp.co.sample.jsf.message;

import jp.co.sample.framework.core.message.MessageId;

/**
 * メッセージID.
 */
public enum AplMessageId implements MessageId {

  // B～ BUSINESS LOGIC
  // P～ PRESENTATION
  /** 本人確認が必要です. */
  P0001I,
  /** 登録済みのメールアドレスにセキュリティ コードを送信します。&lt;br /&gt;所定の手順に従ってログインしてください。. */
  P0002I,
  /** セキュリティ コードを送信しました. */
  P0003I,
  /** ネットワークエラーが発生しました. */
  P0004I,
  /** サーバーサイドでエラーが発生しました. */
  P0005I,
  ;

}
