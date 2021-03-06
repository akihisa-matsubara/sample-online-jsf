package dev.sample.jsf.common.code;

import dev.sample.common.code.CodeVo;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 個人法人区分Vo.
 */
@AllArgsConstructor
@Getter
public enum IndividualCorporationVo implements CodeVo {

  /** 個人. */
  INDIVIDUAL("1", "個人"),
  /** 法人. */
  CORPORATION("2", "法人"),
  ;

  /** コード. */
  private String code;

  /** デコード. */
  private String decode;

}
