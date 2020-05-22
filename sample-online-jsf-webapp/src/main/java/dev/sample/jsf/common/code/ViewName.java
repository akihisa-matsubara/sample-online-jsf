package dev.sample.jsf.common.code;

import lombok.AllArgsConstructor;
import lombok.Getter;
import dev.sample.common.code.CodeVo;

/**
 * 画面VIew名定数.
 * アノテーション属性のようにenumが利用できない定数式にのみ利用する.
 * 原則用意されたVoを利用する.
 *
 * @see ViewNameVo
 */
public final class ViewName {

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

  /**
   * デフォルトコンストラクタ.
   */
  private ViewName() {
    // do nothing
  }

  /**
   * 画面VIew名Vo.
   */
  @AllArgsConstructor
  @Getter
  public enum ViewNameVo implements CodeVo {

    /** topPage.xhtml. */
    TOP_PAGE("topPage", TOP_PAGE_VIEW),
    /** userInfoEntry.xhtml. */
    USER_INFO_ENTRY("userInfoEntry", USER_INFO_ENTRY_VIEW),
    /** userDetailEntry.xhtml. */
    USER_DETAIL_ENTRY("userDetailEntry", USER_DETAIL_ENTRY_VIEW),
    /** userDetailEntry.xhtml. */
    USER_ENTRY_INFO_CONFIRM("userEntryInfoConfirm", USER_ENTRY_INFO_CONFIRM_VIEW),
    /** userEntryComplete.xhtml. */
    USER_ENTRY_COMPLETE("userEntryComplete", USER_ENTRY_COMPLETE_VIEW),
    /** logIn.xhtml. */
    LOG_IN("logIn", LOG_IN_VIEW),
    ;

    /** コード. */
    private String code;

    /** デコード. */
    private String decode;

  }
}
