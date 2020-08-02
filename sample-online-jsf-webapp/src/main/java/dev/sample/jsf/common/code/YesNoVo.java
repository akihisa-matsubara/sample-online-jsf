package dev.sample.jsf.common.code;

import dev.sample.common.code.CodeVo;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 有無Vo.
 */
@AllArgsConstructor
@Getter
public enum YesNoVo implements CodeVo {

  /** あり. */
  YES("1", "あり"),
  /** なし. */
  NO("0", "なし"),
  ;

  /** コード. */
  private String code;

  /** デコード. */
  private String decode;

}
