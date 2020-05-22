package dev.sample.test.online.scenario.signup;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import com.codeborne.selenide.junit5.ScreenShooterExtension;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import dev.sample.test.online.extention.SelenideExtension;
import dev.sample.test.online.page.signup.UserDetailEntry;
import dev.sample.test.online.page.signup.UserEntryInfoConfirm;
import dev.sample.test.online.page.signup.UserInfoEntry;
import dev.sample.test.online.page.top.TopPage;
import dev.sample.test.online.scenario.AbstractSelenideTest;

@ExtendWith({ScreenShooterExtension.class, SelenideExtension.class})
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class SignUpTest extends AbstractSelenideTest {

  @DisplayName("ユーザー登録シナリオテスト")
  @Nested
  class SignUpScenario {
    @DisplayName("画面レイアウト確認・単項目チェックOK")
    @ParameterizedTest
    @CsvFileSource(resources = "/data/SignUpScenario.csv", numLinesToSkip = 1)
    void test(String testNo, String desc, String username, String email, String password, String nameKanji, String nameKana, String gender, String birthday,
        String addressZip, String address) {
      // スクリーンショットの出力先変更
      setReportsFolder(testNo, desc);

      // -- top page ---------------------------
      TopPage topPage = open("/", TopPage.class);
      takeScreenshotInit();
      topPage.signUp.click();

      // -- user info entry --------------------
      UserInfoEntry userInfoEntry = page(UserInfoEntry.class);
      takeScreenshotInit();
      userInfoEntry.username.val(username);
      userInfoEntry.email.val(email);
      userInfoEntry.password.val(password);
      userInfoEntry.passwordConfirm.val(password);
      blur();
      userInfoEntry.username.should(cssClass(VALID));
      userInfoEntry.password.should(cssClass(VALID));
      takeScreenshotActionBefore(NEXT);
      userInfoEntry.next.click();

      // -- user detail entry ------------------
      UserDetailEntry userDetailEntry = page(UserDetailEntry.class);
      takeScreenshotInit();
      userDetailEntry.nameKanji.val(nameKanji);
      userDetailEntry.nameKana.val(nameKana);
      userDetailEntry.gender.get(UserDetailEntry.genderOrderMap.get(gender)).parent().click();
      userDetailEntry.birthday.val(birthday);
      userDetailEntry.addressZip.val(addressZip);
      userDetailEntry.address.val(address);
      blur();
      userDetailEntry.nameKanji.should(cssClass(VALID));
      userDetailEntry.nameKana.should(cssClass(VALID));
      userDetailEntry.birthday.should(cssClass(VALID));
      userDetailEntry.addressZip.should(cssClass(VALID));
      userDetailEntry.address.should(cssClass(VALID));
      takeScreenshotActionBefore(NEXT);
      userDetailEntry.next.click();

      // -- user entry info confirm ------------
      UserEntryInfoConfirm userEntryInfoConfirm = page(UserEntryInfoConfirm.class);
      takeScreenshotInit();
      userEntryInfoConfirm.confirmed.click();

      // -- user entry complete ----------------
      takeScreenshotInit();
      $("h5").shouldHave(text("Created your account!!"));
    }
  }

  @DisplayName("ユーザー登録（単項目チェックNG）シナリオテスト")
  @Nested
  class SignUpValidationScenario {
    @DisplayName("単項目チェックNGメッセージ確認")
    @ParameterizedTest
    @CsvFileSource(resources = "/data/SignUpValidationScenario.csv", numLinesToSkip = 1)
    void test(String testNo, String desc, String username, String email, String password, String nameKanji, String nameKana, String addressZip,
        String address) {
      // スクリーンショットの出力先変更
      setReportsFolder(testNo, desc);

      // -- top page ---------------------------
      TopPage topPage = open("/", TopPage.class);
      takeScreenshotInit();
      topPage.signUp.click();

      // -- user info entry --------------------
      UserInfoEntry userInfoEntry = page(UserInfoEntry.class);
      takeScreenshotInit();
      userInfoEntry.username.val(username);
      userInfoEntry.email.val(email);
      userInfoEntry.password.val(password);
      userInfoEntry.passwordConfirm.val(password);
      blur();
      userInfoEntry.username.should(cssClass(INVALID));
      userInfoEntry.email.should(cssClass(INVALID));
      userInfoEntry.password.should(cssClass(INVALID));
      userInfoEntry.passwordConfirm.should(cssClass(INVALID));
      takeScreenshotInvalidAfter();

      userInfoEntry.username.val(BLANK);
      userInfoEntry.email.val(BLANK);
      userInfoEntry.password.val(BLANK);
      userInfoEntry.passwordConfirm.val(BLANK);
      blur();
      takeScreenshotActionBefore(NEXT);
      userInfoEntry.next.click();

      // -- user detail entry ------------------
      UserDetailEntry userDetailEntry = page(UserDetailEntry.class);
      takeScreenshotInit();
      userDetailEntry.nameKanji.val(nameKanji);
      userDetailEntry.nameKana.val(nameKana);
      userDetailEntry.addressZip.val(addressZip);
      userDetailEntry.address.val(address);
      blur();
      userDetailEntry.nameKanji.should(cssClass(INVALID));
      userDetailEntry.nameKana.should(cssClass(INVALID));
      userDetailEntry.addressZip.should(cssClass(INVALID));
      userDetailEntry.address.should(cssClass(INVALID));
      takeScreenshotInvalidAfter();

      userDetailEntry.nameKanji.val(BLANK);
      userDetailEntry.nameKana.val(BLANK);
      userDetailEntry.addressZip.val(BLANK);
      userDetailEntry.address.val(BLANK);
      blur();
      takeScreenshotActionBefore(NEXT);
      userDetailEntry.next.click();

      // -- user entry info confirm ------------
      UserEntryInfoConfirm userEntryInfoConfirm = page(UserEntryInfoConfirm.class);
      takeScreenshotInit();
      userEntryInfoConfirm.confirmed.click();

      // -- user entry complete ----------------
      takeScreenshotInit();
      $("h5").shouldHave(text("Created your account!!"));
    }
  }
}
