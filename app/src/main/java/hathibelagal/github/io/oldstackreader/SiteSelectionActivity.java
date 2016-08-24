package hathibelagal.github.io.oldstackreader;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

public class SiteSelectionActivity extends Activity {

    private ListView lvSites;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_site_selection);

        lvSites = (ListView)findViewById(R.id.lv_sites);
        lvSites.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                TextView current = (TextView)view;
                Intent intent = new Intent(SiteSelectionActivity.this, MainActivity.class);
                intent.putExtra("SITE", current.getText());
                startActivity(intent);
                finish();
            }
        });
    }
}
