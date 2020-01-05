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

  /** topPage.xhtml. */
  public static final String TOP_PAGE_VIEW = "topPage.xhtml";
  /** userInfoEntry.xhtml. */
  public static final String USER_INFO_ENTRY_VIEW = "userInfoEntry.xhtml";
  /** userDetailEntry.xhtml. */
  public static final String USER_DETAIL_VIEW = "userDetailEntry.xhtml";
  /** logIn.xhtml. */
  public static final String LOG_IN_VIEW = "logIn.xhtml";

  /** コード. */
  private String code;

  /** デコード. */
  private String decode;

}
