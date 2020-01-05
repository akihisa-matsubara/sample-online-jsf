package jp.co.sample.jsf.pres.userdetailentry;

import jp.co.sample.framework.core.interceptor.DebugLog;
import jp.co.sample.framework.core.interceptor.OutputTiming;
import jp.co.sample.jsf.code.ViewNameVo;
import jp.co.sample.jsf.constant.ProcessName;
import jp.co.sample.jsf.pres.BackingBeanBase;
import java.io.Serializable;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 * ユーザー情報詳細登録ページBackingBean.
 */
@ViewScoped
@Named
public class UserDetailEntryBean extends BackingBeanBase implements Serializable {

  /** serialVersionUID. */
  private static final long serialVersionUID = 1L;

  /**
   * 初期化.
   */
  public void init() {
    // do nothing.
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
   * ●●ページへ遷移します.
   *
   * @return ●●ページのURL
   */
  @DebugLog(outputTiming = OutputTiming.BEGIN, processName = ProcessName.ACTION_NEXT, viewName = ViewNameVo.USER_DETAIL_VIEW,
      dtoClass = UserDetailEntryDto.class)
  public String pushNext() {
    // TODO 一旦トップページへ
    return redirect(ViewNameVo.TOP_PAGE);
  }

}
