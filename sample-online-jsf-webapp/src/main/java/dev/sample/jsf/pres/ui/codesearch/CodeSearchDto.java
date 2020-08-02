package dev.sample.jsf.pres.ui.codesearch;

import dev.sample.common.code.GenericCodeVo;
import java.io.Serializable;
import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import lombok.Data;

/**
 * コード検索 画面DTO.
 */
@ViewScoped
@Named
@Data
public class CodeSearchDto implements Serializable {

  /** serialVersionUID. */
  private static final long serialVersionUID = 1L;

  /** コードリスト. */
  private List<GenericCodeVo> codeVos;

}
