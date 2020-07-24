package com.xyz.app_testbook.custom_view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.TextView;

import com.xyz.app_testbook.R;

@SuppressLint("AppCompatCustomView")
public class CircularTextView extends TextView
{
    private float strokeWidth;
    int strokeColor,solidColor;

    public CircularTextView(Context context) {
        super(context);
    }

    public CircularTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CircularTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    public void draw(Canvas canvas) {

        Paint circlePaint = new Paint();
        circlePaint.setColor(getResources().getColor(R.color.colorRect));
        circlePaint.setFlags(Paint.ANTI_ALIAS_FLAG);

        Paint strokePaint = new Paint();
        strokePaint.setColor(getResources().getColor(R.color.colorRect));
        strokePaint.setFlags(Paint.ANTI_ALIAS_FLAG);
//
//        int  h = this.getHeight();
//        int  w = this.getWidth();
//
//        int diameter = ((h > w) ? h : w);
//        int radius = diameter/2;
//
//        this.setHeight(diameter);
//        this.setWidth(diameter);

        // Initialize a new Canvas instance
//        Canvas canvas = new Canvas(bitmap);

        // Draw a solid color to the canvas background
        canvas.drawColor(getResources().getColor(R.color.colorRect));

        // Initialize a new Paint instance to draw the Circle
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(getResources().getColor(R.color.colorGreen));
        paint.setAntiAlias(true);

        // Calculate the available radius of canvas
        int radius = Math.min(canvas.getWidth(),canvas.getHeight()/2);

        // Set a pixels value to padding around the circle
        int padding = 5;

                /*
                    public void drawCircle (float cx, float cy, float radius, Paint paint)
                        Draw the specified circle using the specified paint. If radius is <= 0, then
                        nothing will be drawn. The circle will be filled or framed based on the
                        Style in the paint.

                    Parameters
                        cx : The x-coordinate of the center of the circle to be drawn
                        cy : The y-coordinate of the center of the circle to be drawn
                        radius : The radius of the cirle to be drawn
                        paint : The paint used to draw the circle
                */
        // Finally, draw the circle on the canvas
        canvas.drawArc(
                canvas.getWidth() / 3, // cx
                canvas.getWidth() / 3, // cx
                canvas.getWidth() / 3, // cx
                canvas.getWidth() / 3, // cx
                45, // cy
                90, // cy
                true, // Radius
                paint // Paint
        );


        super.draw(canvas);
    }

    public void setStrokeWidth(int dp)
    {
        float scale = getContext().getResources().getDisplayMetrics().density;
        strokeWidth = dp*scale;

    }

    public void setStrokeColor(String color)
    {
        strokeColor = Color.parseColor(color);
    }

    public void setSolidColor(String color)
    {
        solidColor = Color.parseColor(color);

    }
}
