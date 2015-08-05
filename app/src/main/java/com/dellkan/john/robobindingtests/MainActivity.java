package com.dellkan.john.robobindingtests;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;

import com.dellkan.john.robobindingtests.models.Test2;
import com.dellkan.john.robobindingtests.viewattributes.TextInputLayoutExtensions;
import com.dellkan.john.robobindingtests.viewattributes.ViewExtensions;

import org.robobinding.ViewBinder;
import org.robobinding.binder.BinderFactory;
import org.robobinding.binder.BinderFactoryBuilder;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        BinderFactoryBuilder binderFactoryBuilder = new BinderFactoryBuilder();
        binderFactoryBuilder.add(new ViewExtensions().extend(View.class));
        binderFactoryBuilder.add(new TextInputLayoutExtensions().extend(TextInputLayout.class));
        BinderFactory binderFactory = binderFactoryBuilder.build();
        ViewBinder binder = binderFactory.createViewBinder(this);

        setContentView(binder.inflateAndBind(R.layout.activity_main_copy, new Test2().getPresentationModel()));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
