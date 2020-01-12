package jp.co.sample.jsf.pres;

import jp.co.sample.jsf.data.dto.DialogDto;
import java.util.List;

/**
 * ダイアログページ・インターフェース.
 */
public interface DialogPage {

  /**
   * ダイアログDtoのリストを取得します.
   *
   * @return ダイアログDtoのリスト
   */
  List<DialogDto> getDialogs();

}
