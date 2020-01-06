package jp.co.sample.jsf.common.code;

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
  /** userDetailEntry.xhtml. */
  USER_ENTRY_INFO_CONFIRM("userEntryInfoConfirm", "userEntryInfoConfirm.xhtml"),
  /** userEntryComplete.xhtml. */
  USER_ENTRY_COMPLETE("userEntryComplete", "userEntryComplete.xhtml"),
  /** logIn.xhtml. */
  LOG_IN("logIn", "logIn.xhtml"),
  ;

  /** -- annotation利用のため定数としても同一内容を定義 --. */
  /** topPage.xhtml. */
  public static final String TOP_PAGE_VIEW = "topPage.xhtml";
  /** userInfoEntry.xhtml. */
  public static final String USER_INFO_ENTRY_VIEW = "userInfoEntry.xhtml";
  /** userDetailEntry.xhtml. */
  public static final String USER_DETAIL_ENTRY_VIEW = "userDetailEntry.xhtml";
  /** userEntryInfoConfirm.xhtml. */
  public static final String USER_ENTRY_INFO_CONFIRM_VIEW = "userEntryInfoConfirm.xhtml";
  /** userEntryComplete.xhtml. */
  public static final String USER_ENTRY_COMPLETE_VIEW = "userEntryComplete.xhtml";
  /** logIn.xhtml. */
  public static final String LOG_IN_VIEW = "logIn.xhtml";

  /** コード. */
  private String code;

  /** デコード. */
  private String decode;

}
