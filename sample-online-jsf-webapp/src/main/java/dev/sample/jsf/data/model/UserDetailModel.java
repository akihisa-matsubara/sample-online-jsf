package dev.sample.jsf.data.model;

import java.io.Serializable;
import java.time.LocalDate;
import lombok.Data;
import dev.sample.common.code.GenderVo;

/**
 * ユーザー詳細情報Model.
 */
@Data
public class UserDetailModel implements Serializable {

  /** serialVersionUID. */
  private static final long serialVersionUID = 1L;

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

}
