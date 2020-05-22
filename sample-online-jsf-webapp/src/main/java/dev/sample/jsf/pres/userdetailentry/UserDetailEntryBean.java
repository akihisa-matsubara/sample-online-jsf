package dev.sample.jsf.pres.userdetailentry;

import java.io.Serializable;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import dev.sample.framework.core.interceptor.DebugLog;
import dev.sample.framework.core.interceptor.OutputTiming;
import dev.sample.jsf.common.code.ViewName;
import dev.sample.jsf.common.code.ViewName.ViewNameVo;
import dev.sample.jsf.common.constant.ProcessName;
import dev.sample.jsf.pres.BackingBeanBase;

/**
 * ユーザー詳細情報登録 BackingBean.
 */
@ViewScoped
@Named
public class UserDetailEntryBean extends BackingBeanBase implements Serializable {

  /** serialVersionUID. */
  private static final long serialVersionUID = 1L;

  /** ユーザー詳細情報登録 編集. */
  @Inject
  private UserDetailEntryEdit edit;

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
    return redirect(ViewNameVo.USER_INFO_ENTRY);
  }

  /**
   * NEXTボタンのアクションメソッド.
   * ユーザー入力情報確認ページへ遷移します.
   *
   * @return ユーザー入力情報確認ページのURL
   */
  @DebugLog(outputTiming = OutputTiming.BEGIN, processName = ProcessName.ACTION_NEXT, viewName = ViewName.USER_DETAIL_ENTRY_VIEW,
      dtoClass = UserDetailEntryDto.class)
  public String pushNext() {
    edit.write();
    return redirect(ViewNameVo.USER_ENTRY_INFO_CONFIRM);
  }

}
