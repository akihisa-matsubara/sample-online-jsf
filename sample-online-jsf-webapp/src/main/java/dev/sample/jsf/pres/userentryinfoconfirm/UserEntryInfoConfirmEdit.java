package dev.sample.jsf.pres.userentryinfoconfirm;

import dev.sample.framework.core.conversation.ConversationSharedDto;
import dev.sample.framework.core.util.BeanUtilsExt;
import dev.sample.jsf.data.model.UserDetailModel;
import dev.sample.jsf.data.model.UserInfoModel;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * ユーザー入力情報確認 編集.
 */
@RequestScoped
@Named
public class UserEntryInfoConfirmEdit implements Serializable {

  /** serialVersionUID. */
  private static final long serialVersionUID = 1L;

  /** 画面間共有データ. */
  @Inject
  private ConversationSharedDto sharedDto;

  /** ユーザー入力情報確認 画面DTO. */
  @Inject
  private UserEntryInfoConfirmDto dto;

  /**
   * 読込処理.
   * 画面間共有データから画面DTOへ設定します.
   */
  public void read() {
    UserInfoModel userInfo = sharedDto.get(UserInfoModel.class);
    BeanUtilsExt.copyProperties(dto, userInfo);

    UserDetailModel userDetail = sharedDto.get(UserDetailModel.class);
    BeanUtilsExt.copyProperties(dto, userDetail);
  }

}
