package jp.co.sample.jsf.pres.userdetailentry;

import jp.co.sample.framework.core.conversation.ConversationSharedDto;
import jp.co.sample.jsf.common.util.SampleBeanUtils;
import jp.co.sample.jsf.data.model.UserDetailModel;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * ユーザー詳細情報登録 編集.
 */
@RequestScoped
@Named
public class UserDetailEntryEdit implements Serializable {

  /** serialVersionUID. */
  private static final long serialVersionUID = 1L;

  /** 画面間共有データ. */
  @Inject
  private ConversationSharedDto sharedDto;

  /** ユーザー詳細情報登録 画面DTO. */
  @Inject
  private UserDetailEntryDto dto;

  /**
   * 読込処理.
   * 画面間共有データから画面DTOへ設定します.
   */
  public void read() {
    UserDetailModel userDetail = sharedDto.get(UserDetailModel.class);
    if (userDetail != null) {
      SampleBeanUtils.copyProperties(dto, userDetail);
    }
  }

  /**
   * 書込処理.
   * 画面DTOから画面間共有データへ設定します.
   */
  public void write() {
    UserDetailModel userDetail = sharedDto.get(UserDetailModel.class);
    if (userDetail == null) {
      userDetail = new UserDetailModel();
    }
    SampleBeanUtils.copyProperties(userDetail, dto);
    sharedDto.put(userDetail);
  }

}
