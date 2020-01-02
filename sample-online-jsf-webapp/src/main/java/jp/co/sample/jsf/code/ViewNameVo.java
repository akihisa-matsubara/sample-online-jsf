package jp.co.sample.jsf.code;

import jp.co.sample.common.code.CodeVo;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 画面VIew名Vo.
 */
@AllArgsConstructor
@Getter
public enum ViewNameVo implements CodeVo {

  /** topPage.xhtml. */
  TOP_PAGE("topPage", "topPage.xhtml"),
  /** userInfoEntry.xhtml. */
  USER_INFO_ENTRY("userInfoEntry", "userInfoEntry.xhtml"),
  /** userDetailEntry.xhtml. */
  USER_DETAIL_ENTRY("userDetailEntry", "userDetailEntry.xhtml"),
  /** logIn.xhtml. */
  LOG_IN("logIn", "logIn.xhtml"),
  ;

  /** コード. */
  private String code;

  /** デコード. */
  private String decode;

}
