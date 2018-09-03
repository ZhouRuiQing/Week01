package com.bwie.week01.weight;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class MyView extends View {

    private int wmode;
    private int hmode;
    private int wsice;
    private int hsice;
    private Paint mpaint;
    private Paint hpaint;

    public MyView(Context context) {
        super(context);
    }

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    //测量
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        wmode = MeasureSpec.getMode(widthMeasureSpec);
        hmode = MeasureSpec.getMode(heightMeasureSpec);

        wsice = MeasureSpec.getSize(widthMeasureSpec);
        hsice = MeasureSpec.getSize(heightMeasureSpec);

        if(wmode==MeasureSpec.AT_MOST && hmode==MeasureSpec.AT_MOST){

            setMeasuredDimension(wsice,hsice);
        }else if(wsice==MeasureSpec.AT_MOST){

            setMeasuredDimension(wsice,450);
        }else if(hsice==MeasureSpec.AT_MOST){
            setMeasuredDimension(450,hsice);
        }

    }

    //绘制柱形图


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //创建画笔
        mpaint = new Paint();
        //画图
        hpaint = new Paint();

        mpaint.setColor(Color.BLACK);
        hpaint.setColor(Color.BLUE);

        mpaint.setTextSize(40);
        canvas.drawText("成本费用占比",150,50,mpaint);

        /*for (int i=0;i<6;i++){

            canvas.drawLine(20,80*i,wsice,80*i,mpaint);
        }
        for (int i=0;i<9;i++){

            canvas.drawLine(20+(100*i),0,20+(100*i),400,mpaint);
        }*/

        canvas.drawRect(40,100,100,400,hpaint);
        canvas.drawRect(140,90,200,400,hpaint);
        canvas.drawRect(240,150,300,400,hpaint);
        canvas.drawRect(340,140,400,400,hpaint);


        Paint  paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.BLUE);
        paint.setStrokeWidth(2);
        paint.setTextSize(20);
        paint.setColor(Color.BLACK);

        canvas.drawText("27.64%",40,90,paint);
        canvas.drawText("28.17%",160,90,paint);
        canvas.drawText("21.48%",270,140,paint);
        canvas.drawText("22.70%",350,130,paint);


        canvas.drawText("管理成本",40,420,paint);
        canvas.drawText("劳务成本",140,420,paint);
        canvas.drawText("销售成本",240,420,paint);
        canvas.drawText("资产盘亏",340,420,paint);


        canvas.drawText("5%",0,320,paint);
        canvas.drawText("10%",0,240,paint);
        canvas.drawText("20%",0,160,paint);
        canvas.drawText("30%",0,80,paint);
      //  canvas.drawText("15%",0,160,paint);



    }






}
