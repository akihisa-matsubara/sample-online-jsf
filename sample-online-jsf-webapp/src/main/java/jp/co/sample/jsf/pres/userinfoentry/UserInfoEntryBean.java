package jp.co.sample.jsf.pres.userinfoentry;

import jp.co.sample.framework.core.interceptor.DebugLog;
import jp.co.sample.framework.core.interceptor.InvokeConversation;
import jp.co.sample.framework.core.interceptor.InvokeConversation.Type;
import jp.co.sample.framework.core.interceptor.OutputTiming;
import jp.co.sample.jsf.common.code.ViewNameVo;
import jp.co.sample.jsf.common.constant.ProcessName;
import jp.co.sample.jsf.pres.BackingBeanBase;
import java.io.Serializable;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * ユーザー情報登録 BackingBean.
 */
@ViewScoped
@Named
public class UserInfoEntryBean extends BackingBeanBase implements Serializable {

  /** serialVersionUID. */
  private static final long serialVersionUID = 1L;

  /** ユーザー情報登録 編集. */
  @Inject
  private UserInfoEntryEdit edit;

  /**
   * 初期化.
   */
  @DebugLog(outputTiming = OutputTiming.COMPLETE, processName = ProcessName.INIT, viewName = ViewNameVo.USER_INFO_ENTRY_VIEW,
      dtoClass = UserInfoEntryDto.class)
  @InvokeConversation(type = Type.START)
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
    return redirect(ViewNameVo.TOP_PAGE);
  }

  /**
   * NEXTボタンのアクションメソッド.
   * ユーザー詳細情報登録ページへ遷移します.
   *
   * @return ユーザー詳細情報登録ページのURL
   */
  @DebugLog(outputTiming = OutputTiming.BEGIN, processName = ProcessName.ACTION_NEXT, viewName = ViewNameVo.USER_INFO_ENTRY_VIEW,
      dtoClass = UserInfoEntryDto.class)
  public String pushNext() {
    edit.write();
    return redirect(ViewNameVo.USER_DETAIL_ENTRY);
  }

}
