package dev.sample.jsf.test.pres.menu;

import dev.sample.framework.core.config.ConfigUtils;
import dev.sample.framework.core.exception.SystemException;
import dev.sample.framework.core.mapper.JsonObjectMapper;
import dev.sample.jsf.test.pres.config.ViewItem;
import java.io.IOException;
import java.io.Serializable;
import java.util.Optional;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * テスト・メニュー 編集.
 */
@RequestScoped
@Named
public class TestMenuEdit implements Serializable {

  /** serialVersionUID. */
  private static final long serialVersionUID = 1L;

  /** キー情報：view items. */
  private static final String KEY_VIEW_ITEMS = "sample.testDriver.viewItems";
  /** キー情報：data class. */
  private static final String KEY_DATA_CLASS = "sample.testDriver.dataClass";

  /** テスト・データ 編集. */
  @Inject
  private TestDataWriter writer;

  /** テスト・メニュー 画面DTO. */
  @Inject
  private TestMenuDto dto;

  /**
   * 読込処理.
   */
  public void read() {
    dto.setViewItems(ConfigUtils.getAsBeanList(KEY_VIEW_ITEMS, ViewItem.class));
  }

  /**
   * 書込処理.
   * confから画面間共有データへ設定します.
   */
  public void write() {
    ObjectMapper mapper = JsonObjectMapper.create();
    String beanName = ConfigUtils.getAsString(KEY_DATA_CLASS);
    Optional.ofNullable(dto.getJsonValue()).ifPresent(jsonValue -> {
      try {
        Object readValue = mapper.readValue(dto.getJsonValue(), Class.forName(beanName));
        writer.write(readValue);

      } catch (ClassNotFoundException | IOException e) {
        throw new SystemException(e);

      }
    });
  }

}
