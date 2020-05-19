package jp.co.sample.jsf.pres.userentryinfoconfirm;

import jp.co.sample.common.util.CodeUtils;
import jp.co.sample.framework.core.logger.UsageStatisticsLogger;
import jp.co.sample.jsf.common.code.ViewName.ViewNameVo;
import jp.co.sample.jsf.common.constant.ProcessName;
import jp.co.sample.jsf.pres.BackingBeanBase;
import java.io.Serializable;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * ユーザー入力情報確認 BackingBean.
 */
@ViewScoped
@Named
public class UserEntryInfoConfirmBean extends BackingBeanBase implements Serializable {

  /** serialVersionUID. */
  private static final long serialVersionUID = 1L;

  /** ユーザー入力情報確認 画面DTO. */
  @Inject
  private UserEntryInfoConfirmDto dto;

  /** ユーザー入力情報確認 編集. */
  @Inject
  private UserEntryInfoConfirmEdit edit;

  /**
   * 初期化.
   */
  public void init() {
    edit.read();
  }

  /**
   * BACKボタンのアクションメソッド.
   * 遷移元ページへ遷移します.
   *
   * @return 遷移元ページのURL
   */
  public String pushBack() {
    return redirect(ViewNameVo.USER_DETAIL_ENTRY);
  }

  /**
   * EDITボタンのアクションメソッド.
   * 指定したページへ遷移します.
   *
   * @param viewName 画面View名
   * @return 指定したページのURL
   */
  public String pushEdit(String viewName) {
    return redirect(CodeUtils.decode(viewName, ViewNameVo.class));
  }

  /**
   * CONFIRMEDボタンのアクションメソッド.
   * ユーザー登録完了ページへ遷移します.
   *
   * @return ユーザー登録完了ページのURL
   */
  public String pushConfirmed() {
    // TODO 永続化処理

    // 利用統計ログ出力
    UsageStatisticsLogger.complete(ProcessName.STATISTICS_USER_ENTRY, dto.getUsername());

    return redirect(ViewNameVo.USER_ENTRY_COMPLETE);
  }

}
