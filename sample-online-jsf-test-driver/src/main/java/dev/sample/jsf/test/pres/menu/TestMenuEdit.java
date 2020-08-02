package dev.sample.jsf.test.pres.menu;

import dev.sample.framework.core.config.ConfigUtils;
import dev.sample.framework.core.conversation.ConversationSharedDto;
import dev.sample.framework.core.exception.SystemException;
import java.io.Serializable;
import java.util.Map.Entry;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigBeanFactory;
import com.typesafe.config.ConfigFactory;
import com.typesafe.config.ConfigValue;

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

  /** テスト・メニュー 画面DTO. */
  @Inject
  private TestMenuDto dto;

  /** Conversation共有データ. */
  @Inject
  private ConversationSharedDto sharedDto;

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
  @SuppressWarnings("unchecked")
  public <T extends Serializable> void write() {
    Config config = ConfigFactory.parseString(dto.getConfValue());
    for (Entry<String, ConfigValue> entrySet : config.root().entrySet()) {
      String beanName = entrySet.getKey();
      String key = "\"" + beanName + "\"";
      try {
        sharedDto.put((T) ConfigBeanFactory.create(config.getConfig(key), Class.forName(beanName)));

      } catch (ClassNotFoundException e) {
        throw new SystemException(e);
      }

    }
  }

}
