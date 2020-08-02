package dev.sample.jsf.common.util;

import dev.sample.framework.core.message.MessageId;
import dev.sample.framework.core.util.MessageUtils;
import lombok.experimental.UtilityClass;

/**
 * JavaScriptサポート.
 */
@UtilityClass
public class JavaScriptSupport {

  /** toast実行スクリプト. */
  private static final String TOAST = "M.toast({html: '%s'})";

  /**
   * toast実行スクリプトを取得します.
   *
   * @param messageId メッセージID
   * @param params 引数
   * @return toast実行スクリプト
   */
  public static final String toast(MessageId messageId, String... params) {
    return String.format(TOAST, MessageUtils.getMessage(messageId, params));
  }

}
