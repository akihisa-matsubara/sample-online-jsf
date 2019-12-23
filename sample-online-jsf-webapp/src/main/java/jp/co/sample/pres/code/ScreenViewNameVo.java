package jp.co.sample.pres.code;

import jp.co.sample.common.code.CodeVo;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 画面VIew名Vo.
 */
@AllArgsConstructor
@Getter
public enum ScreenViewNameVo implements CodeVo {

  /** topPage.xhtml. */
  TOP_PAGE("login", "topPage.xhtml"),
  /** login.xhtml. */
  LOGIN("login", "login.xhtml"),
  /** simple.xhtml. */
  SIMPLE("simple", "simple.xhtml"),
  ;

  /** コード. */
  private String code;

  /** デコード. */
  private String decode;

}
