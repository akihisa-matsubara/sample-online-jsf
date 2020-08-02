package dev.sample.jsf.pres.displayrulesample;

import dev.sample.framework.jsf.rule.DisplayController;
import dev.sample.jsf.pres.BackingBeanBase;
import java.io.Serializable;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.event.AjaxBehaviorListener;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * 表示ルールサンプル BackingBean.
 */
@ViewScoped
@Named
public class DisplayRuleSampleBean extends BackingBeanBase implements Serializable {

  /** serialVersionUID. */
  private static final long serialVersionUID = 1L;

  /** 表示ルールサンプル 編集. */
  @Inject
  private DisplayRuleSampleEdit edit;

  /** 表示制御. */
  @Inject
  private DisplayController displayController;

  /**
   * 初期化.
   */
  public void init() {
    edit.read();
    displayController.init(DisplayRuleSampleRule.class);
  }

  /**
   * 項目1～4 onChange Ajaxリスナー.
   * 表示制御を実行します.
   *
   * @param event {@link AjaxBehaviorListener}
   */
  public void onChangeValue(AjaxBehaviorEvent event) {
    displayController.doControl("init");
  }

}
