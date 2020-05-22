package dev.sample.jsf.pres;

import java.util.List;
import dev.sample.jsf.data.dto.DialogDto;

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
