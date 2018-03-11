package tw.org.iii.thread2;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by Administrator on 2018/3/11.
 */

public class GameView extends View {
    private Context context;
    private Resources res;
    private float viewW, viewH, ballW, ballH;
    private boolean isInit;
    private Bitmap ballBmp;

    public GameView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        res = context.getResources();
        setBackgroundResource(R.drawable.bg2);
    }

    private void init(){
        viewW = getWidth();
        viewH = getHeight();
        ballW = viewW / 12; ballH = ballW;

        ballBmp = BitmapFactory.decodeResource(res, R.drawable.ball);
        float ow = ballBmp.getWidth(), oh = ballBmp.getHeight();

        Matrix matrix = new Matrix();

        matrix.reset();
        matrix.postScale(ballW / ow, ballH / oh);
        ballBmp = Bitmap.createBitmap(ballBmp,0,0,(int)ow,(int)oh,matrix,false);


    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!isInit) init();

        canvas.drawBitmap(ballBmp,0,0,null);

    }
}
