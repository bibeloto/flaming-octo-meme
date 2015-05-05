package test.flamingoctomeme;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;

/**
 * Created by renan on 05/05/15.
 */
public class AppWidget extends AppWidgetProvider{
    @Override
    public void onUpdate(Context ctxt, AppWidgetManager mgr, int[] appWidgetIds) {
        ComponentName me = new ComponentName(ctxt, AppWidget.class);
        mgr.updateAppWidget(me, buildUpdate(ctxt, appWidgetIds));
    }

    private RemoteViews buildUpdate(Context ctxt, int[] appWidgetIds) {
        RemoteViews updateViews = new RemoteViews(ctxt.getPackageName(), R.layout.widget);

        Intent i = new Intent(ctxt, AppWidget.class);
        i.setAction(AppWidgetManager.ACTION_APPWIDGET_UPDATE);
        i.putExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS, appWidgetIds);

        PendingIntent pi = PendingIntent.getBroadcast(ctxt, 0, i, PendingIntent.FLAG_UPDATE_CURRENT);
        updateViews.setImageViewResource(R.id.iv_widget, android.R.drawable.btn_star_big_on);
        updateViews.setOnClickPendingIntent(R.id.iv_widget, pi);


        return updateViews;
    }
}
