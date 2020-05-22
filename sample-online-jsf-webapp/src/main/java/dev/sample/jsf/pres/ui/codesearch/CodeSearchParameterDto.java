package dev.sample.jsf.pres.ui.codesearch;

import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import lombok.Data;
import dev.sample.common.code.GenericCodeVo;

/**
 * コード検索パラメーターDTO（外部公開DTO）.
 */
@RequestScoped
@Named
@Data
public class CodeSearchParameterDto implements Serializable {

  /** serialVersionUID. */
  private static final long serialVersionUID = 1L;

  /** 汎用コードVO. */
  private GenericCodeVo codeVo = new GenericCodeVo();

  /** 検索結果件数. */
  private int searchResultCount;

}
