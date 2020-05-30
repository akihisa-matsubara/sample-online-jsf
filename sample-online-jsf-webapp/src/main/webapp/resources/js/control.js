/*
  Note: selector is not escape.
        If ProductionStage is Production, the alert and console logging will be removed.
 */
/* global jsf, M */

/**
 * Sampleアプリが使用するオブジェクトのルート
 * @namespace sampleRoot
 */
const sampleRoot = {};

/**
 * 初期処理
 */
$(() => {
  // Ajax制御設定
  sampleRoot.ajax.init();
});

/**
 * Ajax制御
 */
sampleRoot.ajax = (function () {
  let eventHandler;
  let errorHandler;
  let proxyRequest;
  let preProcess;

  /**
   * 初期化
   */
  const init = () => {
    if (typeof jsf !== 'undefined') {
      jsf.ajax.addOnEvent(eventHandler);
      jsf.ajax.addOnError(errorHandler);
      proxyRequest();
    }

    $(document).off('ajaxPreProcess');
    $(document).on('ajaxPreProcess', (e, param) => preProcess(e, param));
  };

  /**
   * Ajax通信（正常）時にログを出力する
   * レンダリング後にコンポーネントの設定を更新する
   *
   * @param {Object} e AjaxEvent
   */
  eventHandler = (e) => {
    console.log(`ajax ${e.status}. source id=${e.source.id}`);
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
  errorHandler = (e) => {
    if (e.status === 'httpError' && e.responseCode === 0) {
      console.error(e);
      sampleRoot.dialog.modal.open('networkErrorDialog');
    } else {
      console.error(e);
      sampleRoot.dialog.modal.open('internalErrorDialog');
    }
  };

  /**
   * Ajax 前処理を実施する
   */
  proxyRequest = () => {
    const originalRequest = jsf.ajax.request;
    jsf.ajax.request = (source, oevent, options) => {
      const event = $.Event('ajaxPreProcess');
      const formId = $(`#${source}`).closest('form').attr('id');

      // Ajax 前処理を実行
      $(`#${source}`).trigger(event, {
        formId,
        firedId: source,
      });

      if (event.isDefaultPrevented()) {
        // Ajax キャンセル
        console.warn(`Ajax Request has been aborted. {form id: ${formId}, source id: ${source}}`, oevent, options);
      } else {
        // Ajax 送信
        originalRequest(source, oevent, options);
      }
    };
  };

  /**
   * Ajax 前処理
   *
   * @param {Object} e ajaxPreProcessイベント
   * @param {Object} param パラメータ
   * @property {string} formId フォームID
   * @property {string} firedId イベント発火元エレメントのID
   */
  preProcess = (e, { formId, firedId }) => {
    // Ajax キャンセル処理を実装可
    // 例：クライアント側のバリデーション機能 検証NGでAjax通信を取り消す場合
    // e.preventDefault();
  };

  return {
    init,
  };
}());
