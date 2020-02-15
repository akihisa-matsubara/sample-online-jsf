;
var sampleRoot = sampleRoot || {};

//Note: selector is not escqpe.

/**
 * 初期処理
 */
$(function() {
  // Ajax制御設定
  sampleRoot.ajax.init();
});

/**
 * Ajax制御
 */
sampleRoot.ajax = function() {
  let init, eventHandler, errorHandler;

  /**
   * 初期化
   */
  init = function() {
    if (typeof jsf !== 'undefined') {
      jsf.ajax.addOnEvent(eventHandler);
      jsf.ajax.addOnError(errorHandler);
    }
  };

  /**
   * Ajax通信（正常）時にログを出力する
   * レンダリング後にコンポーネントの設定を更新する
   *
   * @param {Object} e AjaxEvent
   */
  eventHandler = function(e) {
    console.log('ajax ' + e.status + '. source id=' + e.source.id);
    if (e.status === 'success') {
      // ラベル、エラーメッセージ設定
      M.updateTextFields();
      sampleRoot.message.showErrMsg(e.source.id);
    }
  };

  /**
   * Ajax通信エラー時にモーダルを表示する
   *
   * @param {Object} e AjaxEvent
   */
  errorHandler = function(e) {
    if (e.status === 'httpError' && e.responseCode === 0) {
      console.error(e);
      sampleRoot.dialog.modal.open('networkErrorDialog');
    } else {
      console.error(e);
      sampleRoot.dialog.modal.open('internalErrorDialog');
    }
  };

  return {
    init : init
  };
}();
