package jp.co.sample.jsf.pres;

import jp.co.sample.jsf.pres.code.ViewNameVo;

public abstract class BackingBeanBase {

  protected String redirect(ViewNameVo vo) {
    return String.format("/pages/%s?faces-redirect=true", vo.getDecode());
  }

  public String goToTopPage() {
    return redirect(ViewNameVo.TOP_PAGE);
  }

  public String pushLoginPage() {
    return redirect(ViewNameVo.LOGIN);
  }

}
