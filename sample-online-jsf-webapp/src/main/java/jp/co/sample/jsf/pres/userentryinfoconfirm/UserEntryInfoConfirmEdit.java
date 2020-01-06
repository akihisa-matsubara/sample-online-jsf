package jp.co.sample.jsf.pres.userentryinfoconfirm;

import jp.co.sample.framework.core.conversation.ConversationSharedDto;
import jp.co.sample.jsf.common.util.SampleBeanUtils;
import jp.co.sample.jsf.data.entity.UserDetailEntity;
import jp.co.sample.jsf.data.entity.UserInfoEntity;
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
    UserInfoEntity userInfo = sharedDto.get(UserInfoEntity.class);
    SampleBeanUtils.copyProperties(dto, userInfo);

    UserDetailEntity userDetail = sharedDto.get(UserDetailEntity.class);
    SampleBeanUtils.copyProperties(dto, userDetail);
  }

}
