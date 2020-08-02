package dev.sample.jsf.pres.login;

import dev.sample.framework.core.interceptor.DebugLog;
import dev.sample.framework.core.interceptor.InvokeConversation;
import dev.sample.framework.core.interceptor.InvokeConversation.Type;
import dev.sample.framework.core.interceptor.OutputTiming;
import dev.sample.jsf.common.code.ButtonTypeVo;
import dev.sample.jsf.common.code.ViewName;
import dev.sample.jsf.common.code.ViewName.ViewNameVo;
import dev.sample.jsf.common.constant.ProcessName;
import dev.sample.jsf.common.util.JavaScriptSupport;
import dev.sample.jsf.data.dto.DialogDto;
import dev.sample.jsf.message.AplMessageId;
import dev.sample.jsf.pres.BackingBeanBase;
import dev.sample.jsf.pres.DialogPage;
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
