package jp.co.sample.jsf.pres;

import jp.co.sample.jsf.code.ViewNameVo;

/**
 * 基底BackingBean.
 */
public abstract class BackingBeanBase {

  /**
   * リダイレクトURLを取得します.
   *
   * @param vo ViewNameVo
   * @return リダイレクトURL
   */
  protected String redirect(ViewNameVo vo) {
    return String.format("/pages/%s?faces-redirect=true", vo.getDecode());
  }

  /**
   * トップページのURLを取得します.
   *
   * @return トップページのURL
   */
  public String goToTopPage() {
    return redirect(ViewNameVo.TOP_PAGE);
  }

  /**
   * ユーザー情報登録ページのURLを取得します.
   *
   * @return トップページのURL
   */
  public String pushSignUp() {
    return redirect(ViewNameVo.USER_INFO_ENTRY);
  }

  /**
   * ユーザーログインページのURLを取得します.
   *
   * @return ユーザーログインページのURL
   */
  public String pushLogIn() {
    return redirect(ViewNameVo.LOG_IN);
  }

}
