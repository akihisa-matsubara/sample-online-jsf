package dev.sample.jsf.pres.switchitem;

import java.io.Serializable;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import dev.sample.jsf.pres.BackingBeanBase;
import dev.sample.jsf.pres.ui.codesearch.CodeSearchParameterDto;
import dev.sample.jsf.pres.ui.codesearch.CodeSearchSelectedCallback;

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
