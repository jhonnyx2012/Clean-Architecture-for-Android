package jhonnyx.clean.marvel.presentation.ui.widget;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

import jhonnyx.clean.marvel.util.FontCache;

public class TradeTextView extends AppCompatTextView {

    public static final String ANDROID_SCHEMA = "http://schemas.android.com/apk/res/android";

    public TradeTextView(Context context, AttributeSet attrs) {
        super(context, attrs);

        applyCustomFont(context, attrs);
    }

    public TradeTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        applyCustomFont(context, attrs);
    }

    private void applyCustomFont(Context context, AttributeSet attrs) {
        int textStyle = attrs.getAttributeIntValue(ANDROID_SCHEMA, "textStyle", Typeface.NORMAL);

        Typeface customFont = selectTypeface(context, textStyle);
        setTypeface(customFont);
    }

    private Typeface selectTypeface(Context context, int textStyle) {
        switch (textStyle) {
            case Typeface.BOLD: // bold
                return FontCache.getTypeface("font/TradeGothic_BOLD.otf", context);
            case Typeface.ITALIC: // italic
                return FontCache.getTypeface("font/TradeGothic_ITALIC.otf", context);
            case Typeface.NORMAL: // regular
            default:
                return FontCache.getTypeface("font/TradeGothic_NORMAL.otf", context);
        }
    }
}