package jp.co.sample.jsf.pres;

import jp.co.sample.jsf.common.code.ButtonTypeVo;
import jp.co.sample.jsf.data.dto.DialogDto;
import jp.co.sample.jsf.message.AplMessageId;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 * UI共通 BackingBean.
 */
@ViewScoped
@Named
public class UiCommonBean implements Serializable, DialogPage {

  /** serialVersionUID. */
  private static final long serialVersionUID = 1L;

  /**
   * {@inheritDoc}
   */
  @Override
  public List<DialogDto> getDialogs() {
    List<DialogDto> dialogList = new ArrayList<>();
    dialogList.add(DialogDto.builder().messageId(AplMessageId.P0004I).buttonType(ButtonTypeVo.OK).build());
    dialogList.add(DialogDto.builder().messageId(AplMessageId.P0005I).buttonType(ButtonTypeVo.OK).build());
    return dialogList;
  }
}
