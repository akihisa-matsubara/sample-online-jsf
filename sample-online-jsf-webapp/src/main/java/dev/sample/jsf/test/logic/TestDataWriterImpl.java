package dev.sample.jsf.test.logic;

import dev.sample.framework.core.conversation.ConversationSharedDto;
import dev.sample.framework.core.util.CdiUtils;
import dev.sample.jsf.common.model.UserDetailModel;
import dev.sample.jsf.common.model.UserInfoModel;
import dev.sample.jsf.test.data.SharedData;
import dev.sample.jsf.test.pres.menu.TestDataWriter;
import java.util.Optional;
import javax.enterprise.context.ApplicationScoped;

/**
 * テスト・データ 編集.
 */
@ApplicationScoped
public class TestDataWriterImpl implements TestDataWriter {

  /**
   * {@inheritDoc}
   */
  @Override
  public void write(Object readValue) {
    ConversationSharedDto sharedData = CdiUtils.getBean(ConversationSharedDto.class);
    SharedData inputData = (SharedData) readValue;
    Optional<UserInfoModel> userInfoModel = Optional.ofNullable(inputData.getUserInfoModel());
    userInfoModel.ifPresent(sharedData::put);
    Optional<UserDetailModel> userDetailModel = Optional.ofNullable(inputData.getUserDetailModel());
    userDetailModel.ifPresent(sharedData::put);
  }

}
