package jp.co.sample.jsf.pres.userdetailentry;

import jp.co.sample.common.code.GenderVo;
import jp.co.sample.common.util.CodeUtils;
import jp.co.sample.jsf.common.constant.ValidationMessageId;
import java.io.Serializable;
import java.time.LocalDate;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.validation.constraints.Size;
import lombok.Data;

/**
 * ユーザー詳細情報登録 画面DTO.
 */
@ViewScoped
@Named
@Data
public class UserDetailEntryDto implements Serializable {

  /** serialVersionUID. */
  private static final long serialVersionUID = 1L;

  /** 名前（漢字）. */
  @Size(max = 20, message = ValidationMessageId.V0001E)
  private String nameKanji;

  /** 名前（カナ）. */
  @Size(max = 20, message = ValidationMessageId.V0001E)
  private String nameKana;

  /** 性別. */
  private GenderVo gender;

  /** 生年月日. */
  private LocalDate birthday;

  /** 郵便番号. */
  @Size(max = 7, message = ValidationMessageId.V0001E)
  private String addressZip;

  /** 住所. */
  @Size(max = 60, message = ValidationMessageId.V0001E)
  private String address;

  /**
   * 性別コードを取得します.
   *
   * @return 性別コード
   */
  public String getGenderCode() {
    return gender == null ? null : gender.getCode();
  }

  /**
   * 性別コードを設定します.
   *
   * @param genderCode 性別コード
   */

  public void setGenderCode(String genderCode) {
    this.gender = CodeUtils.decode(genderCode, GenderVo.class);
  }

  /**
   * 性別Itemを取得します.
   *
   * @return 性別Item
   */
  public GenderVo[] getGenderItems() {
    return GenderVo.values();
  }

}
