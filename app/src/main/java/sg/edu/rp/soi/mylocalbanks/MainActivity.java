package sg.edu.rp.soi.mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView DBS, OCBC, UOB;

    int bank = 0;


    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);


        DBS = findViewById(R.id.tvDBS);

        OCBC = findViewById(R.id.tvOCBC);

        UOB = findViewById(R.id.tvUOB);


        registerForContextMenu(DBS);

        registerForContextMenu(OCBC);

        registerForContextMenu(UOB);


    }

    @Override

    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        super.onCreateContextMenu(menu, v, menuInfo);

        menu.add(0, 0, 0, "Website");

        menu.add(0, 1, 1, "Contact The Bank");


        if (v.getId() == R.id.tvDBS) {

            bank = 1;

        } else if (v.getId() == R.id.tvOCBC) {

            bank = 2;

        } else {

            bank = 3;

        }

        Log.d("Test", "v.getId()" + " " + bank);


    }

    @Override

    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.

        getMenuInflater().inflate(R.menu.menu, menu);

        return true;

    }


    @Override

    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.EnglishSelection) {

            UOB.setText("UOB");

            OCBC.setText("OCBC");
            DBS.setText("DBS");

            return true;

        } else if (id == R.id.ChineseSelection) {

            DBS.setText("星展银行");

           OCBC.setText("华侨银行");

            UOB.setText("大华银行");

            return true;

        } else {

            DBS.setText("ERROR");
            OCBC.setText("ERROR");
            UOB.setText("ERROR");


        }

        return super.onOptionsItemSelected(item);

    }


    @Override

    public boolean onContextItemSelected(MenuItem item) {

        if (bank == 1) {

            if (item.getItemId() == 0) {

                Intent intentWeb1 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.dbs.com.sg"));

                startActivity(intentWeb1);

            } else if (item.getItemId() == 1) {

                Intent intent1 = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + 1800 + 1111111));

                startActivity(intent1);

            }


        } else if (bank == 2) {

            if (item.getItemId() == 0) {

                Intent intentWeb2 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ocbc.com"));

                startActivity(intentWeb2);

            } else if (item.getItemId() == 1) {

                Intent intent2 = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + 1800 + 3633333));

                startActivity(intent2);

            }


        } else {

            if (item.getItemId() == 0) {

                Intent intentWeb3 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.uob.com.sg"));

                startActivity(intentWeb3);

            } else if (item.getItemId() == 1) {

                Intent intent3 = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + 1800 + 2222121));

                startActivity(intent3);

            }


        }

        return super.onContextItemSelected(item);

    }

}