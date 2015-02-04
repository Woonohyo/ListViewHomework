package woonohyo.net.listviewhomework;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Woonohyo on 15. 2. 4..
 */
public class ContactAdapter extends ArrayAdapter<Contact> {
    Context context;
    int resource;
    ArrayList<Contact> contactData;
    ArrayList<Integer> profilePhotoList;

    public ContactAdapter(Context context, int resource, ArrayList<Contact> contactData) {
        super(context, resource, contactData);
        this.context = context;
        this.resource = resource;
        this.contactData = contactData;
        profilePhotoList = new ArrayList<>();
        profilePhotoList.add(R.drawable.profile_1);
        profilePhotoList.add(R.drawable.profile_2);
        profilePhotoList.add(R.drawable.profile_3);
        profilePhotoList.add(R.drawable.profile_4);
        profilePhotoList.add(R.drawable.profile_5);
        profilePhotoList.add(R.drawable.profile_6);
        profilePhotoList.add(R.drawable.profile_7);
        profilePhotoList.add(R.drawable.profile_8);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = View.inflate(context, resource, null);
        }

        Contact data = contactData.get(position);
        ImageView imageViewPhoto = (ImageView) convertView.findViewById(R.id.imageView_photo);
        Random rand = new Random();
        int randomNum = rand.nextInt(8);
        imageViewPhoto.setImageResource(profilePhotoList.get(randomNum));
        TextView textViewName = (TextView) convertView.findViewById(R.id.textView_name);
        TextView textViewAge = (TextView) convertView.findViewById(R.id.textView_age);
        textViewName.setText(data.getName());
        textViewAge.setText(data.getAge()+"");


        return convertView;
    }
}
