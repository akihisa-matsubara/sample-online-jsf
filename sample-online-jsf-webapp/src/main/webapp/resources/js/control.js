;
var sampleRoot = sampleRoot || {};

//Note: selector is not escqpe.

/**
 * 初期処理
 */
$(function() {
  // Materialize初期化
  sampleRoot.ajax.init();
});

/**
 * Ajax制御
 */
sampleRoot.ajax = function() {
  let init, eventHandler, errorHandler, initMaterialize;

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
   *
   * @param {Object} e AjaxEvent
   */
  eventHandler = function(e) {
    switch (e.status) {
    case 'begin':
      console.log('ajax begin. source id=' + e.source.id);
      break;
    case 'complete':
      console.log('ajax complete. source id=' + e.source.id);
      break;
    case 'success':
      console.log('ajax success. source id=' + e.source.id);
      M.AutoInit();
      sampleRoot.message.showErrMsg(e.source.id);
      break;
    }
  };

  /**
   * Ajax通信エラー時にモーダルを表示する
   *
   * @param {Object} e AjaxEvent
   */
  errorHandler = function(e) {
    if (e.status === 'httpError' && e.responseCode === 0) {
      $('#networkErrorModal').modal('open');
    } else {
      $('#serverErrorModal').modal('open');
    }
  };

  // TODO 削除
  /**
   * Materializeを初期化する
   *
   * @param {Object} e AjaxEvent
   */
  initMaterialize = function(e) {
    if (e.status === 'success') {
      sampleRoot.materialize.init();
    }
  };

  return {
    init : init,
    initMaterialize : initMaterialize
  };
}();
