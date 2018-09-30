package project.ap.com.androiddevelopmentbeginnertoadvance;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class WebViewActivity extends Activity {
    WebView wb;
    String tutorial, url;
    ProgressDialog progressDialog;

    private class HelloWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            return false;
        }
        @Override
        public void onPageFinished(WebView view, String url) {
        progressDialog.cancel();        }

        @Override
        public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
            Toast.makeText(getApplicationContext(), "Error: " + description, Toast.LENGTH_SHORT).show();

        }
    }
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);

        //get the selected tutorial name from Main Activity
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        tutorial = prefs.getString("string_id", "null"); //no id: default value
        
        Toast.makeText(getApplicationContext(), tutorial + " Theory", Toast.LENGTH_SHORT).show();

        switch (tutorial) {

            //update url string with document
            case "TextView":
                //google documentation url
                url = "https://developer.android.com/reference/android/widget/TextView";
                break;
            case "EditText":
                url = "https://developer.android.com/reference/android/widget/EditText";
                break;
            case "Auto Complete TextView":
                url = "https://developer.android.com/reference/android/widget/AutoCompleteTextView";
                break;
            case "ImageView":
                url = "https://developer.android.com/reference/android/widget/ImageView";
                break;
            case "Button":
                url = "https://developer.android.com/reference/android/widget/Button";
                break;
            case "RadioButton and RadioGroup":
                url = "https://developer.android.com/guide/topics/ui/controls/radiobutton";
                break;
            case "CheckBox":
                url = "https://developer.android.com/guide/topics/ui/controls/checkbox";
                break;
            case "Switch":
                url = "https://developer.android.com/reference/android/widget/Switch";
                break;
            case "ToggleButton":
                url = "https://developer.android.com/reference/android/widget/ToggleButton";
                break;
            case "RatingBar":
                url = "https://developer.android.com/reference/android/widget/RatingBar";
                break;
            case "SeekBar":
                url = "https://developer.android.com/reference/android/widget/SeekBar";
                break;
            case "ProgressBar":
                url = "https://developer.android.com/reference/android/widget/ProgressBar";
                break;
            case "TimePicker":
                url = "https://developer.android.com/reference/android/widget/TimePicker";
                break;
            case "DatePicker":
                url = "https://developer.android.com/reference/android/widget/DatePicker";
                break;
            case "Toast Message":
                url = "https://developer.android.com/guide/topics/ui/notifiers/toasts";
                break;
            case "Alert Dialog":
                url = "https://developer.android.com/guide/topics/ui/dialogs";
                break;

        }

        progressDialog = new ProgressDialog(WebViewActivity.this);
        progressDialog.setMessage("Please wait Loading...");
        progressDialog.show();
        progressDialog.setCancelable(false);

        wb = (WebView) findViewById(R.id.webView1);
        wb.clearCache(true);
        wb.getSettings().setJavaScriptEnabled(true);
        wb.getSettings().setLoadWithOverviewMode(true);
        wb.getSettings().setUseWideViewPort(true);
        wb.getSettings().setBuiltInZoomControls(true);
        wb.getSettings().setPluginState(WebSettings.PluginState.ON);
        wb.loadUrl(url);
        wb.setWebViewClient(new HelloWebViewClient());

        //set title in toolbar
        setTitle(tutorial);
    }
}
