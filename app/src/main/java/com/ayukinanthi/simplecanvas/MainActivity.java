package com.ayukinanthi.simplecanvas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private Canvas mCanvas;
    private Paint mPaint=new Paint();
    private Paint mPaintText=new Paint(Paint.UNDERLINE_TEXT_FLAG);
    private Bitmap mBitmap;
    private ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mImageView=findViewById(R.id.my_imageview);
        mPaint.setColor(Color.RED);
        mPaintText.setColor(ResourcesCompat.getColor(getResources(), R.color.blue, null));
        mPaintText.setTextSize(50);
    }

    public void drawSomething(View view) {
        //background
        int vWidth=view.getWidth();
        int vHeight=view.getHeight();
        mBitmap=Bitmap.createBitmap(vWidth, vHeight, Bitmap.Config.ARGB_8888);
        mImageView.setImageBitmap(mBitmap);
        mCanvas=new Canvas(mBitmap);
        mCanvas.drawColor(Color.WHITE);

       mCanvas.drawText(getString(R.string.tugas_canvas), 100,100,mPaintText);
        mPaint.setColor(Color.BLUE);
       /* mPaint.setStrokeWidth(10);
        mCanvas.drawLine(100,150,400,150, mPaint);
        mPaint.setColor(Color.RED);
        Rect mRect=new Rect();
        mRect.set(100,200,600,400);
        mCanvas.drawRect(mRect,mPaint);*/

        //matahari
        mPaint.setColor(Color.YELLOW);
        mCanvas.drawCircle(250,500,100,mPaint);

        /*Path path=new Path();
        path.moveTo(100,700);
        path.lineTo(300, 800);
        path.lineTo(500,700);
        path.lineTo(700,800);
        mPaint.setColor(Color.MAGENTA);
        mCanvas.drawPath(path,mPaint);*/

        // menggambar dinding
        mPaint.setColor(ResourcesCompat.getColor(getResources(), R.color.blue, null));
        Rect mRect1=new Rect();
        mRect1.set(350,850, 850, 1100);
        mCanvas.drawRect(mRect1,mPaint);

        //menggambar atap rumah (segitiga)
        mPaint.setColor(ResourcesCompat.getColor(getResources(), R.color.pink, null));
        Path path1 = new Path();
        path1.moveTo(600, 600);
        path1.lineTo(300, 850);
        path1.lineTo(900, 850);
        path1.close();
        mCanvas.drawPath(path1, mPaint);

        //menggambar pintu
        mPaint.setColor(ResourcesCompat.getColor(getResources(), R.color.brown, null));
        Rect rect=new Rect();
        rect.set(500,930,900,1100);
        mCanvas.drawRect(rect,mPaint);

        //nama
        mCanvas.drawText("Ayu Kinanthi Putri",150,150,mPaintText);
        mPaint.setColor(Color.BLUE);


        //untuk oval
       /* RectF rectf=new RectF();
        rectf.set(100,200,600,400);
        mCanvas.drawOval(rectf,mPaint);*/

        view.invalidate();
    }
}