package com.indieweb.indigenous.micropub.post;

import android.os.Bundle;
import android.view.MenuItem;

import com.indieweb.indigenous.R;
import com.indieweb.indigenous.model.Draft;

public class GeocacheActivity extends BaseCreateActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        canAddImage = true;
        canAddLocation = true;
        postType = "Geocache";
        isCheckin = true;
        addCounter = true;
        setContentView(R.layout.activity_geocache);
        geocacheLogType = findViewById(R.id.geocacheLogType);
        super.onCreate(savedInstanceState);
        if (!preparedDraft) {
            startLocationUpdates();
        }
    }

    @Override
    public void onPostButtonClick(MenuItem item) {

        if (saveAsDraft != null && saveAsDraft.isChecked()) {
            Draft draft = new Draft();
            draft.setSpinner(geocacheLogType.getSelectedItem().toString());
            saveDraft("geocache", draft);
            return;
        }

        bodyParams.put("geocache-log-type", geocacheLogType.getSelectedItem().toString());
        sendBasePost(item);
    }

}