package dev.sample.jsf.pres;

import dev.sample.framework.jsf.constant.FacesConstant;
import dev.sample.jsf.common.code.ViewName.ViewNameVo;

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
    return "/pages/" + vo.getDecode() + FacesConstant.REDIRECT;
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
