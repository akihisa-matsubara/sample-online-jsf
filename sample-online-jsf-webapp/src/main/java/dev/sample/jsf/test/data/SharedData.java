package dev.sample.jsf.test.data;

import dev.sample.jsf.common.model.UserDetailModel;
import dev.sample.jsf.common.model.UserInfoModel;
import java.io.Serializable;
import lombok.Data;

/**
 * Shared Data.
 */
@Data
public class SharedData implements Serializable {

  /** serialVersionUID. */
  private static final long serialVersionUID = 1L;

  /** ユーザー情報Model. */
  private UserInfoModel userInfoModel;

  /** ユーザー詳細情報Model. */
  private UserDetailModel userDetailModel;

}
