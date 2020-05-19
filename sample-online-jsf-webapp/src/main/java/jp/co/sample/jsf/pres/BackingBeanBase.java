package jp.co.sample.jsf.pres;

import jp.co.sample.framework.jsf.constant.FacesConstant;
import jp.co.sample.jsf.common.code.ViewName.ViewNameVo;

/**
 * 基底 BackingBean.
 */
public abstract class BackingBeanBase {

  /**
   * リダイレクトURLを取得します.
   *
   * @param vo ViewNameVo
   * @return リダイレクトURL
   */
  protected String redirect(ViewNameVo vo) {
    return String.format("/pages/%s%s", vo.getDecode(), FacesConstant.REDIRECT);
  }

  /**
   * トップページのURLを取得します.
   *
   * @return トップページのURL
   */
  protected String goToTopPage() {
    return redirect(ViewNameVo.TOP_PAGE);
  }

}
