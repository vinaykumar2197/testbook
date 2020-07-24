package com.xyz.app_testbook.custom_view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;


class CustomView extends View {
    Paint paint = new Paint();

    public CustomView(Context context) {
        super(context);
    }

    @Override
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawRect(30, 50, 200, 350, paint);
        canvas.drawRect(100, 100, 300, 400, paint);

    }

}