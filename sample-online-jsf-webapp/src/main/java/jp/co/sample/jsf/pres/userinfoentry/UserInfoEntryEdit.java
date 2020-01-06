package jp.co.sample.jsf.pres.userinfoentry;

import jp.co.sample.framework.core.conversation.ConversationSharedDto;
import jp.co.sample.jsf.common.util.SampleBeanUtils;
import jp.co.sample.jsf.data.entity.UserInfoEntity;
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
    UserInfoEntity userInfo = sharedDto.get(UserInfoEntity.class);
    if (userInfo != null) {
      SampleBeanUtils.copyProperties(dto, userInfo);
    }
  }

  /**
   * 書込処理.
   * 画面DTOから画面間共有データへ設定します.
   */
  public void write() {
    UserInfoEntity userInfo = sharedDto.get(UserInfoEntity.class);
    if (userInfo == null) {
      userInfo = new UserInfoEntity();
    }
    SampleBeanUtils.copyProperties(userInfo, dto);
    sharedDto.put(userInfo);
  }

}
