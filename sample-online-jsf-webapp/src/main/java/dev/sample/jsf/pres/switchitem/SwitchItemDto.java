package dev.sample.jsf.pres.switchitem;

import dev.sample.common.util.CodeUtils;
import dev.sample.jsf.common.code.IndividualCorporationVo;
import java.io.Serializable;
import java.time.LocalDate;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.validation.Valid;
import lombok.Data;

/**
 * 画面項目切替 画面DTO.
 */
@ViewScoped
@Named
@Data
public class SwitchItemDto implements Serializable {

  /** serialVersionUID. */
  private static final long serialVersionUID = 1L;

  /** お申込日. */
  private LocalDate applicationDate;

  /** 個人法人区分. */
  private IndividualCorporationVo individualCorporation;

  /** 個人DTO. */
  @Valid
  private IndividualDto individualDto = new IndividualDto();

  /** 法人DTO. */
  @Valid
  private CorporationDto corporationDto = new CorporationDto();

  /**
   * 個人法人区分コードを取得します.
   *
   * @return 個人法人区分コード
   */
  public String getIndividualCorporationCode() {
    return individualCorporation == null ? null : individualCorporation.getCode();
  }

  /**
   * 個人法人区分コードを設定します.
   *
   * @param individualCorporationCode 個人法人区分コード
   */

  public void setIndividualCorporationCode(String individualCorporationCode) {
    this.individualCorporation = CodeUtils.decode(individualCorporationCode, IndividualCorporationVo.class);
  }

  /**
   * 個人法人区分Itemを取得します.
   *
   * @return 個人法人区分Item
   */
  public IndividualCorporationVo[] getIndividualCorporationItems() {
    return IndividualCorporationVo.values();
  }

}
