package jp.co.sample.jsf.pres.displayrulesample;

import jp.co.sample.framework.jsf.rule.DisplayController;
import jp.co.sample.jsf.common.code.ViewNameVo;
import jp.co.sample.jsf.pres.BackingBeanBase;
import java.io.Serializable;
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
   * トップページへ遷移します.
   *
   * @return トップページのURL
   */
  public String pushNext() {
    return redirect(ViewNameVo.TOP_PAGE);
  }

}
