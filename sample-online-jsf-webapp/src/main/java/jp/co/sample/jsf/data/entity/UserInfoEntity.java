package jp.co.sample.jsf.data.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * ユーザー情報Entity.
 */
@Data
public class UserInfoEntity implements Serializable {

  /** serialVersionUID. */
  private static final long serialVersionUID = 1L;

  /** Username. */
  private String username;

  /** Password. */
  private String password;

}
