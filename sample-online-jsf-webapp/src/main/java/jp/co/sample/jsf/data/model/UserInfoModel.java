package jp.co.sample.jsf.data.model;

import java.io.Serializable;
import lombok.Data;

/**
 * ユーザー情報Model.
 */
@Data
public class UserInfoModel implements Serializable {

  /** serialVersionUID. */
  private static final long serialVersionUID = 1L;

  /** Username. */
  private String username;

  /** Password. */
  private String password;

}
