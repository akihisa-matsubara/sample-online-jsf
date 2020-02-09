package jp.co.sample.jsf.pres.switchitem;

import jp.co.sample.jsf.pres.BackingBeanBase;
import jp.co.sample.jsf.pres.ui.codesearch.CodeSearchSelectedCallback;
import jp.co.sample.jsf.pres.ui.codesearch.CodeSearchParameterDto;
import java.io.Serializable;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * 画面項目切替 BackingBean.
 */
@ViewScoped
@Named
public class SwitchItemBean extends BackingBeanBase implements CodeSearchSelectedCallback, Serializable {

  /** serialVersionUID. */
  private static final long serialVersionUID = 1L;

  /** 画面項目切替 編集. */
  @Inject
  private SwitchItemEdit edit;

  /**
   * 初期化.
   */
  public void init() {
    edit.read();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void selectedCodeValues(CodeSearchParameterDto parameterDto) {
    edit.selectedCodeValues(parameterDto);
  }

}
