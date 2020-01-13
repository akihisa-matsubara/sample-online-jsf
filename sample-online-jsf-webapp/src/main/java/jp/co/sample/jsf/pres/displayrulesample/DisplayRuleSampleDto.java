package jp.co.sample.jsf.pres.displayrulesample;

import jp.co.sample.jsf.common.constant.ValidationMessageId;
import java.io.Serializable;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.validation.constraints.Size;
import lombok.Data;

/**
 * 表示ルールサンプル 画面DTO.
 */
@ViewScoped
@Named
@Data
public class DisplayRuleSampleDto implements Serializable {

  /** serialVersionUID. */
  private static final long serialVersionUID = 1L;

  /** 項目1. */
  @Size(max = 10, message = ValidationMessageId.V0001E)
  private String item1;

  /** 項目2. */
  @Size(max = 10, message = ValidationMessageId.V0001E)
  private String item2;

  /** 項目3. */
  @Size(max = 10, message = ValidationMessageId.V0001E)
  private String item3;

  /** 項目4. */
  @Size(max = 10, message = ValidationMessageId.V0001E)
  private String item4;

  /** 項目5. */
  @Size(max = 10, message = ValidationMessageId.V0001E)
  private String item5;

}
