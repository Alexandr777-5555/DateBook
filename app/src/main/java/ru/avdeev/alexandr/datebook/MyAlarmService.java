package ru.avdeev.alexandr.datebook;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import android.util.Log;
import android.widget.Toast;


/*

Сервис запускает в строке состояния уведомление



 */

public class MyAlarmService extends Service {


    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Toast.makeText(this, "Служба запущена", Toast.LENGTH_SHORT).show();

        Log.d("vip", "HELLO");

        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(this)
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setAutoCancel(true)     // по нажатию удаляем из строки состояния уведомление
                        .setContentTitle("My notification")
                        .setContentText("Будильник сработал!");

// создаем явное намерение для вызова в строке состояния
        Intent resultIntent = new Intent(this, ResultActivity.class);

// The stack builder object will contain an artificial back stack for the
// started Activity.
// This ensures that navigating backward from the Activity leads out of
// your application to the Home screen.

        // объект построителя будет содержать обратный вызов для активности
        // это гарантируте что объект перейдет назад
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
// добавляем обратный вызов для намерения
        stackBuilder.addParentStack(ResultActivity.class);

// добавляем намерение которое стартует активности
        stackBuilder.addNextIntent(resultIntent);

        PendingIntent resultPendingIntent = stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);

        mBuilder.setContentIntent(resultPendingIntent);

        NotificationManager mNotificationManager = (NotificationManager) this.getSystemService(Context.NOTIFICATION_SERVICE);
//
        mNotificationManager.notify(1, mBuilder.build());

        stopService(intent);
        //    stopSelf();

        return super.onStartCommand(intent, flags, startId);


    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("vip", "удалился");
    }
}
