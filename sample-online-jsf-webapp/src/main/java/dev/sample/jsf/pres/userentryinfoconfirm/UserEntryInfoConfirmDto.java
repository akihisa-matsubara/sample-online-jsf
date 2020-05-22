package dev.sample.jsf.pres.userentryinfoconfirm;

import java.io.Serializable;
import java.time.LocalDate;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import lombok.Data;
import dev.sample.common.code.GenderVo;

/**
 * ユーザー入力情報確認 画面DTO.
 */
@ViewScoped
@Named
@Data
public class UserEntryInfoConfirmDto implements Serializable {

  /** serialVersionUID. */
  private static final long serialVersionUID = 1L;

  /** Username. */
  private String username;

  /** Email. */
  private String email;

  /** 名前（漢字）. */
  private String nameKanji;

  /** 名前（カナ）. */
  private String nameKana;

  /** 性別. */
  private GenderVo gender;

  /** 生年月日. */
  private LocalDate birthday;

  /** 郵便番号. */
  private String addressZip;

  /** 住所. */
  private String address;

  /**
   * 性別Itemを取得します.
   *
   * @return 性別Item
   */
  public GenderVo[] getGenderItems() {
    return GenderVo.values();
  }

}
