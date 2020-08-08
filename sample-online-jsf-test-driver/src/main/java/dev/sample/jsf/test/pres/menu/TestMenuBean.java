package dev.sample.jsf.test.pres.menu;

import dev.sample.framework.core.config.ConfigUtils;
import dev.sample.framework.core.interceptor.InvokeConversation;
import dev.sample.framework.core.interceptor.InvokeConversation.Type;
import dev.sample.framework.core.util.FileUtils;
import dev.sample.framework.jsf.constant.FacesConstant;
import dev.sample.framework.jsf.ui.upload.FileUploadCallback;
import dev.sample.framework.jsf.ui.upload.FileUploadParameterDto;
import java.io.Serializable;
import java.util.ArrayList;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.event.AjaxBehaviorListener;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * テスト・メニュー BackingBean.
 */
@ViewScoped
@Named
public class TestMenuBean implements Serializable, FileUploadCallback {

  /** serialVersionUID. */
  private static final long serialVersionUID = 1L;

  /** キー情報：JSON path. */
  private static final String KEY_JSON_PATH = "sample.testDriver.jsonPath";

  /** テスト・メニュー 画面DTO. */
  @Inject
  private TestMenuDto dto;

  /** テスト・メニュー 編集. */
  @Inject
  private TestMenuEdit edit;

  /**
   * 初期化.
   */
  @InvokeConversation(type = Type.START)
  public void init() {
    edit.read();
  }

  /**
   * SUBMITボタンのアクションメソッド.
   * 指定したページへ遷移します.
   *
   * @return 指定したページのURL
   */
  public String pushSubmit() {
    edit.write();
    return dto.getUrl() + FacesConstant.REDIRECT;
  }

  /**
   * ビュー名変更時のAjaxリスナー.
   *
   * @param event {@link AjaxBehaviorListener}
   */
  public void onChangeViewName(AjaxBehaviorEvent event) {
    dto.getJsonFiles().clear();
    dto.setJsonFileName(null);
    dto.setJsonValue(null);

    dto.getViewItems().stream()
        .filter(viewItem -> viewItem.getUrl().equals(dto.getUrl()))
        .findFirst()
        .ifPresent(viewItem -> dto.setJsonFiles(new ArrayList<>(viewItem.getJsonFiles())));
  }

  /**
   * JSONファイル名変更時のAjaxリスナー.
   *
   * @param event {@link AjaxBehaviorListener}
   */
  public void onChangeJsonFileName(AjaxBehaviorEvent event) {
    dto.setJsonValue(FileUtils.readResourceToString(ConfigUtils.getAsString(KEY_JSON_PATH) + dto.getJsonFileName()));
  }

  /**
   * JSONファイル アップロード後処理.
   *
   * @param parameterDto ファイルアップロードパラメーターDTO
   */
  @Override
  public void uploadedFile(FileUploadParameterDto parameterDto) {
    dto.setJsonValue(parameterDto.getFileContents());
  }

  /**
   * JSONファイル アップロードキャンセル処理.
   *
   * @param clientId ID
   */
  @Override
  public void cancelUploadFile(String clientId) {
    dto.setJsonValue(null);
  }

}
