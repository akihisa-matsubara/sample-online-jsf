package jp.co.sample.jsf.pres.login;

import jp.co.sample.framework.core.interceptor.DebugLog;
import jp.co.sample.framework.core.interceptor.InvokeConversation;
import jp.co.sample.framework.core.interceptor.InvokeConversation.Type;
import jp.co.sample.framework.core.interceptor.OutputTiming;
import jp.co.sample.jsf.common.code.ButtonTypeVo;
import jp.co.sample.jsf.common.code.ViewName;
import jp.co.sample.jsf.common.code.ViewName.ViewNameVo;
import jp.co.sample.jsf.common.constant.ProcessName;
import jp.co.sample.jsf.common.util.JavaScriptSupport;
import jp.co.sample.jsf.data.dto.DialogDto;
import jp.co.sample.jsf.message.AplMessageId;
import jp.co.sample.jsf.pres.BackingBeanBase;
import jp.co.sample.jsf.pres.DialogPage;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 * ログイン BackingBean.
 */
@ViewScoped
@Named
public class LogInBean extends BackingBeanBase implements Serializable, DialogPage {

  /** serialVersionUID. */
  private static final long serialVersionUID = 1L;

  /**
   * 初期化.
   */
  @InvokeConversation(type = Type.START)
  public void init() {
    // do nothing.
  }

  /**
   * LOG INボタンのアクションメソッド.
   * ●●ページへ遷移します.
   *
   * @return ●●ページのURL
   */
  @DebugLog(outputTiming = OutputTiming.BEGIN, processName = ProcessName.ACTION_LOG_IN, viewName = ViewName.LOG_IN_VIEW,
      dtoClass = LogInDto.class)
  public String pushLogIn() {
    // TODO 一旦トップページへ
    return redirect(ViewNameVo.TOP_PAGE);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public List<DialogDto> getDialogs() {
    List<DialogDto> dialogList = new ArrayList<>();
    dialogList.add(DialogDto.builder().headerMessageId(AplMessageId.P0001I).messageId(AplMessageId.P0002I).buttonType(ButtonTypeVo.OK_CANCEL)
        .okCallback(JavaScriptSupport.toast(AplMessageId.P0003I)).build());
    return dialogList;
  }

}
