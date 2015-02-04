package woonohyo.net.listviewhomework;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity implements View.OnClickListener, DialogInterface.OnClickListener {
    Button buttonNewContact;
    EditText editTextAge;
    EditText editTextName;
    ListView contactListView;
    ArrayList<Contact> contactData;
    ContactAdapter contactAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        contactData = new ArrayList<>();
        contactData.add(new Contact("Wonhyo", 28));
        contactData.add(new Contact("Soojin", 26));
        contactData.add(new Contact("Sangeun", 27));
        contactData.add(new Contact("Seongyeol", 27));
        contactListView = (ListView) findViewById(R.id.listView);
        contactAdapter = new ContactAdapter(this, R.layout.contact_list_view_row, contactData);
        contactListView.setAdapter(contactAdapter);
        buttonNewContact = (Button) findViewById(R.id.button_new_contact);
        buttonNewContact.setOnClickListener(this);
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

    @Override
    public void onClick(View v) {
        LinearLayout lay = (LinearLayout) View.inflate(this, R.layout.contact_dialog, null);
        editTextAge = (EditText) lay.findViewById(R.id.editText_age);
        editTextName = (EditText) lay.findViewById(R.id.editText_name);
        AlertDialog.Builder dlg = new AlertDialog.Builder(this);
        dlg.setTitle("New Contact");
        dlg.setView(lay);
        dlg.setPositiveButton("Create", this);
        dlg.setNegativeButton("Cancel", this);
        dlg.show();
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {
        switch (which) {
            case DialogInterface.BUTTON_POSITIVE: {
                Contact contact = new Contact(editTextName.getText().toString(), Integer.parseInt(editTextAge.getText().toString()));
                contactData.add(contact);
                contactAdapter.notifyDataSetChanged();
                break;
            }
            case DialogInterface.BUTTON_NEGATIVE: {
                break;
            }
        }


    }
}
