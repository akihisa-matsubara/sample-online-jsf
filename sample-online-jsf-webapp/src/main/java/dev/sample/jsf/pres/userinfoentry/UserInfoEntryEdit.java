package dev.sample.jsf.pres.userinfoentry;

import dev.sample.framework.core.conversation.ConversationSharedDto;
import dev.sample.framework.core.util.BeanUtilsExt;
import dev.sample.jsf.data.model.UserInfoModel;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * ユーザー情報登録 編集.
 */
@RequestScoped
@Named
public class UserInfoEntryEdit implements Serializable {

  /** serialVersionUID. */
  private static final long serialVersionUID = 1L;

  /** 画面間共有データ. */
  @Inject
  private ConversationSharedDto sharedDto;

  /** ユーザー情報登録 画面DTO. */
  @Inject
  private UserInfoEntryDto dto;

  /**
   * 読込処理.
   * 画面間共有データから画面DTOへ設定します.
   */
  public void read() {
    UserInfoModel userInfo = sharedDto.get(UserInfoModel.class);
    if (userInfo != null) {
      BeanUtilsExt.copyProperties(dto, userInfo);
    }
  }

  /**
   * 書込処理.
   * 画面DTOから画面間共有データへ設定します.
   */
  public void write() {
    UserInfoModel userInfo = sharedDto.get(UserInfoModel.class);
    if (userInfo == null) {
      userInfo = new UserInfoModel();
    }
    BeanUtilsExt.copyProperties(userInfo, dto);
    sharedDto.put(userInfo);
  }

}
