package mykeyboard.p9yp9y.mykeyboard;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.inputmethodservice.Keyboard;
import android.inputmethodservice.KeyboardView;
import android.util.AttributeSet;

import java.util.List;

public class MyKeyboardView extends KeyboardView {
    private final Context context;

    public MyKeyboardView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
    }

    @Override
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        List<Keyboard.Key> keys = getKeyboard().getKeys();
        for (Keyboard.Key key : keys) {
            if (key.codes[0] == 49) {

                Drawable dr = (Drawable) context.getResources().getDrawable(R.color.red);
                dr.setBounds(key.x, key.y, key.x + key.width, key.y + key.height);
                dr.draw(canvas);

            } else {
                Drawable dr = (Drawable) context.getResources().getDrawable(R.color.blue);
                dr.setBounds(key.x, key.y, key.x + key.width, key.y + key.height);
                dr.draw(canvas);
            }
            Paint paint = new Paint();
            paint.setTextAlign(Paint.Align.CENTER);
            paint.setTextSize(48);
            paint.setColor(Color.GRAY);
            if(key.label != null)
            canvas.drawText(key.label.toString(), key.x + (key.width / 2),
                    key.y + (key.height / 2), paint);

            paint.setTextSize(24);
            canvas.drawText(key.label.toString(), key.x + (key.width / 2) + 5,
                    key.y + (key.height / 2) + 5, paint);
        }
    }
}
